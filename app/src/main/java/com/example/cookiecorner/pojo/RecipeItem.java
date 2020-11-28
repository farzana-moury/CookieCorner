package com.example.cookiecorner.pojo;

public class RecipeItem {
    private String name;
    private int image;
    private String duration;
    private String calories;
    private String instructions;

    public RecipeItem(String name, int image, String duration, String calories, String instructions) {
        this.name = name;
        this.image = image;
        this.duration = duration;
        this.calories = calories;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
