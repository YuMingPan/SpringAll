package com.springboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 元注解，修饰注解的注解
 * Target 目标对象：注解可以在变量,方法,类之上加载
 * Retention 作用阶段(源码,编译期间,运行期间)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
	// public 属性类型 属性名称() default 默认值;
	String value() default "";
}
