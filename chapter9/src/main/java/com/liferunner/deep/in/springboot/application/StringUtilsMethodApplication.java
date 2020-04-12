package com.liferunner.deep.in.springboot.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

/**
 * StringUtilsMethodApplication for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/12
 **/
public class StringUtilsMethodApplication {

    public static void main(String[] args) {

        // 测试 StringUtils#delimitedListToStringArray(String)
        String a1 = String.join(",", new ArrayList<String>(Arrays.asList("aa", "rr", "ss", "xx")));
        String a2 = String.join("|", new ArrayList<String>(Collections.nCopies(20, " isaac ")));
        System.out.println("原始a1:" + a1);
        System.out.println("原始a2:" + a2);
        String[] a1Arr = StringUtils.delimitedListToStringArray(a1, ",");
        String[] a2Arr = StringUtils.delimitedListToStringArray(a2, "|");
        for (String i : a1Arr
        ) {
            System.out.println("foreach a1Arr:" + i);
        }
        System.out.println("foreach a1Arr end");

        for (String i : a2Arr
        ) {
            System.out.println("foreach a2Arr:" + i);
        }
        System.out.println("foreach a2Arr end");

        String a3 = StringUtils.arrayToCommaDelimitedString(a1Arr);
        System.out.println("a3 :" + a3);
    }

}
