package com.soplong;

import org.apache.shiro.crypto.hash.SimpleHash;

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


    @org.junit.Test
    public void generaMd5Password(){
        String hashAlgorithmName = "MD5";
        String credentials = "123456";
        int hashIterations = 1024;
//        Object obj = new SimpleHash(hashAlgorithmName, credentials, "Mark", hashIterations);
        Object obj = new SimpleHash(hashAlgorithmName, credentials,"", hashIterations);
        System.out.println(obj.toString());
    }
}
