package com.qiuxk.annotation;

import java.lang.annotation.*;

/**
 *
 * @author qiuxk
 * @Description: 返回结果注释类
 * @create 2019/9/27
 **/
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
