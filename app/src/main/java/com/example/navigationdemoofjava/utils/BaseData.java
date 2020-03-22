package com.example.navigationdemoofjava.utils;

import java.util.ArrayList;
import java.util.List;

public class BaseData {

    /**
     * 模拟数据
     * @return
     */
    public static List<String> getDatas(){
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        return list;
    }

}
