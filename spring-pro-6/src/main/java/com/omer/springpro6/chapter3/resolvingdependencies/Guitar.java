package com.omer.springpro6.chapter3.resolvingdependencies;

import org.springframework.stereotype.Component;

@Component("gopher")
public class Guitar {

    public void sing() {
        System.out.println("Cm Eb Fm Ab Bb");
    }

}
