package com.oreilly.demo;

import org.springframework.util.concurrent.ListenableFuture;

public interface EnhancedPrinterGateway {
    void print(Person person);

    //String uppercase(Person person);

    ListenableFuture<String> uppercase(Person person);
}
