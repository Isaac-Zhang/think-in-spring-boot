package com.liferunner.deep.in.springboot.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import javax.xml.ws.Holder;

/**
 * ListHelpTestApplication for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/12
 **/
public class ListHelpTestApplication {

    /**
     * 利用 LinkedHashSet，实现列表去重
     */
    protected static final <T> List<T> removeDuplicates(List<T> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "bbb", "aaa", "bbb", "aaa", "bbb", "aaa", "bbb", "aaa", "bbb");
        List<String> result = removeDuplicates(list);
        result.stream().forEach(System.out::println);

        List<Holder> list2 = Arrays.asList(new Holder<>("isaac"), new Holder<>("zp"), new Holder<>("dy"),
            new Holder<>("isaac"), new Holder<>("isaac"), new Holder<>("isaac"), new Holder<>("isaac"));

        List<Holder> result2 = removeDuplicates(list2);
        result2.stream().map(o->o.value).forEach(System.out::println);
    }
}
