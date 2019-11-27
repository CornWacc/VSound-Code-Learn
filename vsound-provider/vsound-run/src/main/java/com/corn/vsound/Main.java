package com.corn.vsound;


import com.corn.boot.annotations.Runner;
import com.corn.boot.base.RunMain;
import org.springframework.context.annotation.ImportResource;

@Runner(port = "9051")
@ImportResource("classpath:dubbo-admin.xml")
public class Main {

    public static void main(String[] args) {
        RunMain.springRun(Main.class);
    }

}
