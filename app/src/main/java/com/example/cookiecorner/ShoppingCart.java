package com.example.cookiecorner;

import com.example.cookiecorner.pojo.CookieMenuItem;

import java.util.ArrayList;

public class ShoppingCart {
    public static ArrayList<CookieMenuItem> menu = new ArrayList<>();
    private static ArrayList<CookieMenuItem> shoppingList = new ArrayList<>();
    private static ShoppingCart shoppingCart;

    //ShoppingCart.menu will contain every cookie carried by the app
    static {
        menu.add(new CookieMenuItem("cookie1", 1.00, R.drawable.logo, "cookie description goes here"));
        menu.add(new CookieMenuItem("cookie2", 1.50,  R.drawable.logo, "cookie description goes here"));
        menu.add(new CookieMenuItem("cookie3", 1.00, R.drawable.logo, "cookie description goes here"));
        menu.add(new CookieMenuItem("cookie4", 2.00, R.drawable.logo, "cookie description goes here"));
        menu.add(new CookieMenuItem("cookie5", 2.50, R.drawable.logo, "cookie description goes here"));
        menu.add(new CookieMenuItem("cookie6", 2.50, R.drawable.logo, "cookie description goes here"));
        menu.add(new CookieMenuItem("cookie7", 3.00, R.drawable.logo, "cookie description goes here"));
        menu.add(new CookieMenuItem("cookie8", 3.25, R.drawable.logo, "cookie description goes here"));
        menu.add(new CookieMenuItem("cookie9", 3.50, R.drawable.logo, "cookie description goes here"));
        menu.add(new CookieMenuItem("cookie10", 2.75, R.drawable.logo, "cookie description goes here"));
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
