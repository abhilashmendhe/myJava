package com.abhitrio.maven.services.impl;

import com.abhitrio.maven.services.RedPrinter;
import org.springframework.stereotype.Component;


public class EnglishRedPrinter implements RedPrinter {

    @Override
    public String print(){
        return "Red";
    }
}
