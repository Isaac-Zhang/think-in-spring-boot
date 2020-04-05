package com.liferunner.thinking.in.springboot;

import java.util.Arrays;
import java.util.List;

/**
 * ChineseNamingRepository for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/5
 **/
@CustomNamingRepository("chineseNamingRepository")
public class ChineseNamingRepository {

    public List<String> findAll() {
        return Arrays.asList("zp", "dy", "isaac");
    }
}
