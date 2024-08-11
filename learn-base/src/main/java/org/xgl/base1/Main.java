package org.xgl.base1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        bubbleSort();
        removeRepetWords("Java is certainly certainly  a good programming programming language. There is no doubt that");
    }

    public static void bubbleSort(){
        int[] a = {1,2,4,6,13,45,77};
        for (int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-i-1;j++){
                if (a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        for (int num : a){
            System.out.print(num+" ");
        }

    }


    static String removeRepetWords(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }
        Pattern pattern = Pattern.compile("(\\w+)(\\s+\\1)+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        StringBuilder sb = new StringBuilder();
        int start = 0, end = 0;
        while(matcher.find()) {
            start = matcher.start();
            sb.append(str.substring(end, start)).append(matcher.group(1));
            end = matcher.end();
        }
        sb.append(str.substring(end));
        System.out.println(sb.toString());
        return sb.toString();
    }
}
