//package com.corn.vsound.spring;
//
//
//import com.corn.base.spring.DubboScanner;
//import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.util.ObjectUtils;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Proxy;
//import java.util.Map;
//
//@Configuration
//@PropertySource("classpath:application.properties")
//@Import(DubboScanner.class)
//public class BeanReadyBackOperator implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Autowired
//    private SpringUtil springUtil;
//
//    @Value("${dubbo.scan.package}")
//    private String dubboScanPackage;
//
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        DubboScanner dubboScanner = springUtil.getBean(DubboScanner.class);
//        if (!ObjectUtils.isEmpty(dubboScanner)) {
//            EnableDubbo enableDubbo = dubboScanner.getClass().getAnnotation(EnableDubbo.class);
//            InvocationHandler invocationHandler = Proxy.getInvocationHandler(enableDubbo);
//            try {
//                Field field = invocationHandler.getClass().getDeclaredField("memberValues");
//                field.setAccessible(true);
//                Map map = (Map) field.get(invocationHandler);
//                map.put("scanBasePackages", new String[]{dubboScanPackage});
//            } catch (NoSuchFieldException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//
//        } else {
//
//        }
//    }
//}
