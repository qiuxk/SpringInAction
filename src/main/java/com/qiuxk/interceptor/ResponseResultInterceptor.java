package com.qiuxk.interceptor;

import com.qiuxk.annotation.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 *
 * @author qiuxk
 * @Description: 自定义返回结果拦截器
 * @create 2019/9/27
 **/

@Component
@Slf4j
public class ResponseResultInterceptor implements HandlerInterceptor {

    //标记名称
    public  static final String RESEPONSE_RESULT_ANN= "RESEPONSE_RESULT_ANN";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(handler instanceof HandlerMethod){
           final HandlerMethod handlerMethod = (HandlerMethod) handler;
           final Class<?> clazz = handlerMethod.getBeanType();
          final   Method method = handlerMethod.getMethod();

          /**判断请求 是否类上自定义的结果注释**/
          if(clazz.isAnnotationPresent(ResponseResult.class)){
              //设置请求的返回体 需要包装 在ReponseBobyAdvice接口进行判断
              request.setAttribute(RESEPONSE_RESULT_ANN,clazz.getAnnotation(ResponseResult.class));
          }else  if(method.isAnnotationPresent(ResponseResult.class)){
              //设置请求的返回体 需要包装 在ReponseBobyAdvice接口进行判断
              request.setAttribute(RESEPONSE_RESULT_ANN,clazz.getAnnotation(ResponseResult.class));
          }

        }


        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
