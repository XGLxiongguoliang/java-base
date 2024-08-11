package org.xgl.base1.jvm;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OOMTest {
    public static void main(String[] args) {
        //createMapNoStop();
        createObjectNoStop();
    }

    public static void  createMapNoStop() {
        Map map = new HashMap();
        while (true) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
            map.put(uuid, null);

        }
    }

    public static void  createObjectNoStop() {
        Map mapxxx = new HashMap();
        Integer count = 1;
        while (true) {
            Map map = new HashMap();
            String uuid = UUID.randomUUID().toString();
            System.out.println("个数---" + count + "-----" + uuid);
            map.put(uuid, new byte[1024*2]);
            count = count + 1;
            mapxxx.put(uuid, map);
        }
    }
}

