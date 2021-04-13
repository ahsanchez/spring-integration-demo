package com.oreilly.demo;

import org.springframework.stereotype.Component;

@Component
public class CustomHeaderEnricher {
    public String getHeaderValue() {
        return "This is the header value";
    }
}
