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
public class Book {
    List<Base> book;

    public Book() {
        this.book = new ArrayList<>();
        book.add(new Base("Java Servlet Programming", 29.95f));
        book.add(new Base("Oracle Database Programming", 48.95f));
        book.add(new Base("System Analysis and Design With UML", 14.95f));
        book.add(new Base("Object Oriented Software Engineering", 35.99f));
        book.add(new Base("Java Web Services", 27.99f));
    }

    public List<Base> getBook() {
        return book;
    }

    public void setBook(List<Base> book) {
        this.book = book;
    }
}