package com.soplong;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        System.out.println("周瑜1".hashCode());
        System.out.println("周瑜".hashCode());

        Map<String,String> map = new HashMap<>();
        HashMap<String,String> map1 = new HashMap<>();
        map1.put("1","2");
    }
}
