package com.abhitrio.maven.services.impl;

import com.abhitrio.maven.services.RedPrinter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class SpanishRedPrinter implements RedPrinter {


    @Override
    public String print() {
        return "rojo";
    }
}
