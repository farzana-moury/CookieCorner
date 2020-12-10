package com.example.cookiecorner.pojo;

/**
 * Represents a pretty ordinary java object -- a cookie menu item that has its set of information
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 23rd 2020
 */
public class CookieMenuItem {
    // properties
    private String name;
    private double price;
    private int image;
    private String description;

    /**
     * constructor.
     * @param name the name of the cookie menu item
     * @param price the price of the cookie menu item
     * @param image the picture of the cookie menu item
     * @param description the description of the cookie menu item
     */
    public CookieMenuItem(String name, double price, int image, String description) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name the cookie name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for price
     * @param price the cookie price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter for image
     * @return image
     */
    public int getImage() {
        return image;
    }

    /**
     * Setter for image
     * @param image the cookie picture
     */
    public void setImage(int image) {
        this.image = image;
    }

    /**
     * Getter for description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description
     * @param description cookie description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
