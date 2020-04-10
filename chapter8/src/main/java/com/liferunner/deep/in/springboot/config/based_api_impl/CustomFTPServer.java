package com.liferunner.deep.in.springboot.config.based_api_impl;

/**
 * CustomFTPServer for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/10
 **/
public class CustomFTPServer implements CustomServer {

    @Override
    public void start() {
        System.out.println("FTP server start...");
    }

    @Override
    public void stop() {
        System.out.println("FTP server stop...");
    }

    @Override
    public String getStatus(String status) {
        System.out.println(status);
        return status;
    }
}
