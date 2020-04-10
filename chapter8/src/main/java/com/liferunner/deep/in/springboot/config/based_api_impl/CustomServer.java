package com.liferunner.deep.in.springboot.config.based_api_impl;

/**
 * CustomServer for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/10
 **/
public interface CustomServer {

    void start();

    void stop();

    String getStatus(String status);

    enum Type{
        HTTP,
        FTP
    }
}
