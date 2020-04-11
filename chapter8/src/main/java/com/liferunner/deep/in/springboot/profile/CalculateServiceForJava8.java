package com.liferunner.deep.in.springboot.profile;

import java.util.Arrays;
import java.util.stream.Stream;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * CalculateServiceForJava8 for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/11
 **/
@Service
@Profile("java8")
public class CalculateServiceForJava8 implements ICalculateService {

    @Override
    public Integer sum(Integer... num) {
        int count = Stream.of(num).reduce(0, Integer::sum);
        int count2 = Arrays.stream(num).reduce(0, Integer::sum);
        System.out.printf("java 8 sum = %s,sum2 = %s\n", count, count2);
        return count;
    }
}
