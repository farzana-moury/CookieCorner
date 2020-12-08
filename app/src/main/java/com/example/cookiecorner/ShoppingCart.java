package com.example.cookiecorner;

import com.example.cookiecorner.pojo.CookieMenuItem;

import java.util.ArrayList;

public class ShoppingCart {
    public static ArrayList<CookieMenuItem> menu = new ArrayList<>();
    private static ArrayList<CookieMenuItem> shoppingList = new ArrayList<>();
    private static ShoppingCart shoppingCart;

    //ShoppingCart.menu will contain every cookie carried by the app
    static {
        menu.add(new CookieMenuItem("Strawberry Dream", 1.00, R.drawable.menu_cookie1, "A delicate cookie sandwich made with love. Perfect for Valentine's day!"));
        menu.add(new CookieMenuItem("Peanut Fudge", 1.50,  R.drawable.menu_cookie2, "cookie description goes here"));
        menu.add(new CookieMenuItem("Sugary Shortbread", 1.00, R.drawable.menu_cookie3, "cookie description goes here"));
        menu.add(new CookieMenuItem("Vegan Cookie", 2.00, R.drawable.menu_cookie4, "cookie description goes here"));
        menu.add(new CookieMenuItem("Jolly Jelly", 2.50, R.drawable.menu_cookie5, "cookie description goes here"));
        menu.add(new CookieMenuItem("Gingerbread Cookie", 2.50, R.drawable.menu_cookie6, "cookie description goes here"));
        menu.add(new CookieMenuItem("Berry Blast", 3.00, R.drawable.menu_cookie7, "cookie description goes here"));
        menu.add(new CookieMenuItem("Chocolate Drizzle", 3.25, R.drawable.menu_cookie8, "cookie description goes here"));
        menu.add(new CookieMenuItem("Crunchy Munch", 3.50, R.drawable.menu_cookie9, "cookie description goes here"));
    }

    private ShoppingCart(){
        shoppingList = new ArrayList<>();
    }
    public static ShoppingCart getInstance() {
        if(shoppingCart == null){
            shoppingCart = new ShoppingCart();
        }
        return shoppingCart;
    }
    public ArrayList<CookieMenuItem> getShoppingList() {
        return shoppingList;
    }


}
