package com.github.zcmee.mailapi.api;

public interface Converter<T,R> {
    R convert(T input);
}