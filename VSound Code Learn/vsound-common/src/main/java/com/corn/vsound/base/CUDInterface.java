package com.corn.vsound.base;

import com.corn.boot.base.BaseOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public interface CUDInterface<T extends BaseOrder> {

    Logger log = LoggerFactory.getLogger(CUDInterface.class);

    default void cud(String type,String id,T t){

        switch (type){
            case "C":
                log.info("源码内容新增: 入参:{}",t);
                add(t);
                break;
            case "D":
                log.info("源码内容删除: 入参:{}",t);
                del(id);
                break;
            case "U":
                log.info("源码内容更新: 入参:{}",t);
                update(t);
                break;
        }
    };

    void add(T t);

    void del(String id);

    void update(T t);
}
