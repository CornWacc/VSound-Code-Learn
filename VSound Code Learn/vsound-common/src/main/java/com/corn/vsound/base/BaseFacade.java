package com.corn.vsound.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;


/**
 * @author yyc
 * @apiNote 该facade暂时仅用于来记录装载bean的日志
 * */
public class BaseFacade {

    private static final Logger log = LoggerFactory.getLogger(BaseFacade.class);

    @PostConstruct
    protected void beanInit(){
        log.info(getClass().getName()+":装载完成");
    }
}
