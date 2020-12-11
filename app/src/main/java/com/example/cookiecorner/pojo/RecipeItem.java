package com.example.cookiecorner.pojo;

/**
 * Represents a pretty ordinary java object -- a gallery item that has its set of information
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 27th 2020
 */
public class RecipeItem {
    // properties
    private String name;
    private int image;
    private String duration;
    private String calories;
    private String instructions;

    /**
     * constructor.
     * @param name the name of the recipe
     * @param image the picture of the recipe
     * @param duration the bake time and cook time duration
     * @param calories the total calories
     * @param instructions step by step recipe instructions
     */
    public RecipeItem(String name, int image, String duration, String calories, String instructions) {
        this.name = name;
        this.image = image;
        this.duration = duration;
        this.calories = calories;
        this.instructions = instructions;
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
     * @param name the name of the recipe
     */
    public void setName(String name) {
        this.name = name;
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
     * @param image the picture of the recipe
     */
    public void setImage(int image) {
        this.image = image;
    }

    /**
     * Getter for duration
     * @return duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Setter for duration
     * @param duration the bake time and cook time duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Getter for the calories
     * @return calories
     */
    public String getCalories() {
        return calories;
    }

    /**
     * Setter for the calories
     * @param calories the total calories
     */
    public void setCalories(String calories) {
        this.calories = calories;
    }

    /**
     * Getter for instructions
     * @return instructions
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * Setter for instructions
     * @param instructions step by step recipe instructions
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
