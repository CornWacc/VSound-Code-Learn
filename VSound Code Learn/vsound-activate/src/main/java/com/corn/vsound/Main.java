package com.corn.vsound;


import com.corn.boot.annotations.Runner;
import com.corn.boot.base.RunMain;


/**
 * 启动类
 * */
@Runner(port = "9055",active = "mac")
public class Main{

    public static void main(String[] args) {

        RunMain.springRun(Main.class);
    }
}
