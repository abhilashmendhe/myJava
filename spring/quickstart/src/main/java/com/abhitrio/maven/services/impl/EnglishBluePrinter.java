package com.abhitrio.maven.services.impl;

import com.abhitrio.maven.services.BluePrinter;
import org.springframework.stereotype.Component;

@Component
public class EnglishBluePrinter implements BluePrinter {
    @Override
    public String print(){
        return "Blue";
    }
}
