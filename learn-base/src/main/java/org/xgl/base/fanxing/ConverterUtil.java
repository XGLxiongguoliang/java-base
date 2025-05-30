package org.xgl.base.fanxing;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

/**
 * 实现一个通用的类型安全的数据转换器
 */
public class ConverterUtil {
    public static <T, K ,V> Map<K, V> listToMapByField(List<T> list, Function<?  super T, ? extends K> keyExtractor, Function<?  super T, ? extends V> valueExtractor) {
        Map<K, V> resultMap = new HashMap<>();
        list.forEach(t -> resultMap.put(keyExtractor.apply(t), valueExtractor.apply(t)));
        return resultMap;
    }

    public static <T, K> Map<K, T> listToMapByField(List<T> list, Function<?  super T, ? extends K> keyExtractor) {
        Map<K, T> resultMap = new HashMap<>();
        list.forEach(t -> resultMap.put(keyExtractor.apply(t), t));
        return resultMap;
    }

    public static <T, K> Map<K, List<T>> group(List<T> list, Function<?  super T, ? extends K> keyExtractor) {
        Map<K, List<T>> resultMap = new HashMap<>();
        list.forEach(t -> {
            K key = keyExtractor.apply(t);
            resultMap.computeIfAbsent(key, k -> new CopyOnWriteArrayList<>()).add(t);
        });
        return resultMap;
    }

    public static void main(String[] args) {
        List<ChengXuYuan> chengXuYuanList = List.of(new ChengXuYuan("中文", "程序员"),
                new ChengXuYuan("English", "Developer"),
                new ChengXuYuan("한국어", "개발자")
        );
        Map<String, String> chengXuYuanMap = ConverterUtil.listToMapByField(chengXuYuanList, ChengXuYuan::getYuYan, ChengXuYuan::getXiangMu);
        System.out.println(chengXuYuanMap);
        System.out.println("--------------------------");

        Map<String, ChengXuYuan> chengXuYuanMap2 = ConverterUtil.listToMapByField(chengXuYuanList, ChengXuYuan::getYuYan);
        System.out.println(JSON.toJSONString(chengXuYuanMap2));
        System.out.println("--------------------------");


        Map<String, List<ChengXuYuan>> chengXuYuanMap3 = ConverterUtil.group(chengXuYuanList, ChengXuYuan::getYuYan);
        System.out.println(JSON.toJSONString(chengXuYuanMap3));
        System.out.println("--------------------------");
    }
}
