package com.qiuxk.handler;

import com.qiuxk.annotation.ResponseResult;
import com.qiuxk.common.Result;
import org.apache.commons.fileupload.RequestContext;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author qiuxk
 * @Description: 自定义返回结果handler
 * @create 2019/9/27
 **/

public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    //标记名称
    public  static final String RESEPONSE_RESULT_ANN= "RESEPONSE_RESULT_ANN";


    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        ResponseResult attribute = (ResponseResult) request.getAttribute(RESEPONSE_RESULT_ANN);

        return attribute==null?false:true;
    }

    @Override
    public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType,
                                    Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
                                    ServerHttpResponse serverHttpResponse) {
        return Result.success(object);
    }
}
