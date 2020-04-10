package com.liferunner.deep.in.springboot.web_auto_config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * HelloworldController for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/10
 **/
@Controller
public class HelloworldController {

    @RequestMapping
    @ResponseBody
    public String helloworld(){
        return "hello,isaac";
    }
}
