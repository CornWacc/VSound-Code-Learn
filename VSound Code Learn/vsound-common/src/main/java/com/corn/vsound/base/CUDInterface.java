package com.corn.vsound.base;

import com.corn.boot.base.BaseOrder;


public interface CUDInterface<T extends BaseOrder> {

    default void cud(String type,String id,T t){

        switch (type){
            case "C":
                add(t);
                break;
            case "D":
                del(id);
                break;
            case "U":
                update(t);
                break;
        }
    };

    void add(T t);

    void del(String id);

    void update(T t);
}
