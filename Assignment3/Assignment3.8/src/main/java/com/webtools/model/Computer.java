/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webtools.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sparshramchandani
 */
public class Computer {
    List<Base> computer = new ArrayList<>();

    public Computer() {
        this.computer = new ArrayList<>();
        computer.add(new Base("Apple MacBook Pro with 13.3 Inch Display", 1299.99f));
        computer.add(new Base("Asus Laptop with Centrino 2 Black", 949.95f));
        computer.add(new Base("HP Pavilion Laptop with Centrino 2 DV7", 1199.95f));
        computer.add(new Base("Toshiba Satellite Laptop with Centrino 2 Copper", 899.99f));
        computer.add(new Base("Sony VADO Laptop with Core 2 Duo Cosmopolitan Pink", 779.99f));
    }

    public List<Base> getComputer() {
        return computer;
    }

    public void setComputer(List<Base> computer) {
        this.computer = computer;
    }
}
