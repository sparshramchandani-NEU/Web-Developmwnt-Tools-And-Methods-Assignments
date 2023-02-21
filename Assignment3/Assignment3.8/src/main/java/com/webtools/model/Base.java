
package com.webtools.model;

/**
 *
 * @author sparshramchandani
 */
public class Base {
    String Title;
    float price;

    public Base(String title, float price) {
        Title = title;
        this.price = price;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}