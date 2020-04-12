package com.liferunner.sample.autoconfigure.formatter;

/**
 * DefaultFormatter for 默认的格式化方式
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/12
 **/
public class DefaultFormatter implements Formatter {

    @Override
    public String format(Object obj) {
        System.out.println("DefaultFormatter#format parameter: " + obj);
        // null 可安全实现
        return String.valueOf(obj);
    }
}
