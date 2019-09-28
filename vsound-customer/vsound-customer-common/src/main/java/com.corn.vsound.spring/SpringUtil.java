package com.corn.vsound.spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private static final Logger log = LoggerFactory.getLogger(SpringUtil.class);

    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        if(ObjectUtils.isEmpty(SpringUtil.applicationContext)){
            SpringUtil.applicationContext = applicationContext;
        }
        log.info("--------------- Spring容器配置完成，可直接依赖SpringUtil进行获取Bean ----------------");
    }

    /**
     * 通过BeanName获取Bean
     * */
    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    /**
     * 通过BeanClass获取Bean
     * */
    public static <T> T getBean(Class<T> tClass){
        return applicationContext.getBean(tClass);
    }
}
