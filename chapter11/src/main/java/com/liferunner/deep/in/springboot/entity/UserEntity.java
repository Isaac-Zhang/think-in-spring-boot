package com.liferunner.deep.in.springboot.entity;

/**
 * UserEntity
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/27
 **/
public class UserEntity {

    private final String name;

    public UserEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User {name=" + name + "}";
    }
}
