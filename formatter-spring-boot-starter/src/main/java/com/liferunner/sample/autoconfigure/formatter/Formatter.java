package com.liferunner.sample.autoconfigure.formatter;

/**
 * Formatter for 格式化接口
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/12
 **/
public interface Formatter {

    /**
     * 格式化操作
     *
     * @param obj 待格式化对象
     * @return 返回格式化后的内容
     */
    String format(Object obj);
}
