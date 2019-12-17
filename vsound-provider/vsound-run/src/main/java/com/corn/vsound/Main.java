package com.corn.vsound;


import com.corn.boot.annotations.Runner;
import com.corn.boot.base.RunMain;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ImportResource;

@Runner(port = "9527",active = "test")
@ImportResource("classpath:dubbo-admin.xml")
@MapperScan("com.corn.vsound.dao.mapper")
public class Main {

    public static void main(String[] args) {
        RunMain.springRun(Main.class);
    }

}
