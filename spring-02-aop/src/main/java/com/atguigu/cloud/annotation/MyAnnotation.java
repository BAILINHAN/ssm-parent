package com.atguigu.cloud.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.FIELD}) // 可以标注在参数 属性 上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
}
