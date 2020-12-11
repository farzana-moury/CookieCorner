package com.example.cookiecorner.pojo;

/**
 * Represents a pretty ordinary java object -- a gallery item that has its set of information
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 28th 2020
 */
public class GalleryItem {
    // property
    private int image;

    /**
     * constructor
     * @param image the gallery picture
     */
    public GalleryItem(int image) {
        this.image = image;
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
     * @param image the gallery picture
     */
    public void setImage(int image) {
        this.image = image;
    }
}
