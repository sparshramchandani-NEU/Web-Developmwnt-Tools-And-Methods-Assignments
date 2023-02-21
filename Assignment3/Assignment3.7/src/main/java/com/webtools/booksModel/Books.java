/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webtools.booksModel;

/**
 *
 * @author sparshramchandani
 */
public class Books {
    String ISBN;
    String bookTitle;
    String authors;
    String price;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    
    
    public Books(){
        
    }
    
    public Books(String ISBN, String bookTitle, String authors, String price){
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.authors = authors;
        this.price = price;        
    }
    
}
