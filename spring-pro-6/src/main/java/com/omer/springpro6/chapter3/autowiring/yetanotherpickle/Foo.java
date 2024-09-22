package com.omer.springpro6.chapter3.autowiring.yetanotherpickle;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.UUID;

public interface Foo {

}

class FooImplOne implements Foo {
    String id = "one:" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).toString();
    }
}

class FooImplTwo implements Foo {
    String id = "two:" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).toString();
    }
}
