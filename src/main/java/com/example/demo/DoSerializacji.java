package com.example.demo;

import java.io.Serializable;
import java.util.function.Supplier;

public class DoSerializacji implements Serializable {
    private static final long serialVersionUID = 123;
    public String test = "test";

    //Supplier<String> f = () -> "test2";
    //Powoduje błąd serializacji
}
