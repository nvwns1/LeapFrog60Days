package org.suman.firstproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dev {
    // Tradional way
    // Laptop laptop = new Laptop();

    // Field Injection
//    @Autowired
//    private Laptop laptop;

    // Constructor Injection
//    private Laptop laptop;
//    public Dev(Laptop laptop){
//        this.laptop = laptop;
//    }

    // Setter Injection
    private Laptop laptop;
    @Autowired
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }


    public void build() {
        laptop.compile();
        System.out.println("Working on Project....");
    }
}
