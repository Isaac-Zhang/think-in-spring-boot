package com.liferunner.deep.in.springboot.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * CalculateServiceForJava7 for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/11
 **/
@Service
@Profile("java7")
public class CalculateServiceForJava7 implements ICalculateService {

    @Override
    public Integer sum(Integer... num) {
        int count = 0;
        for (Integer i : num
        ) {
            count += i;
        }
        System.out.printf("java 7 sum = %s\n", count);
        return count;
    }
}
