package com.abhitrio.maven.services.impl;

import com.abhitrio.maven.services.GreenPrinter;
import org.springframework.stereotype.Component;

@Component
public class EnglishGreenPrinter implements GreenPrinter {

    @Override
    public String print(){
        return "Green";
    }
}
