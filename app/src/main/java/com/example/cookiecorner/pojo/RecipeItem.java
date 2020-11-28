package com.example.cookiecorner.pojo;

public class RecipeItem {
    private String name;
    private int image;
    private String stats;
    private String ingredients;
    private String instructions;

    public RecipeItem(String name, int image, String stats, String ingredients, String instructions) {
        this.name = name;
        this.image = image;
        this.stats = stats;
        this.ingredients = ingredients;
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

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
