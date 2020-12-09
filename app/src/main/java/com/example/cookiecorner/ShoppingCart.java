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
        menu.add(new CookieMenuItem("Peanut Fudge", 1.50,  R.drawable.menu_cookie2, "A complimentary duo. Both classic flavours peanut and chocolate combined."));
        menu.add(new CookieMenuItem("Sugary Shortbread", 1.00, R.drawable.menu_cookie3, "Classy and sweet. A worthwhile texture for your tastebuds!"));
        menu.add(new CookieMenuItem("Vegan Cookie", 2.00, R.drawable.menu_cookie4, "A Vegan's treat. Gluten-free, no bake oatmeal cookies."));
        menu.add(new CookieMenuItem("Jolly Jelly", 2.50, R.drawable.menu_cookie5, "A Christmas Special worth sharing with your family!"));
        menu.add(new CookieMenuItem("Gingerbread Cookie", 2.50, R.drawable.menu_cookie6, "Pair this with some cinammon and eggnog for extra pizzazz."));
        menu.add(new CookieMenuItem("Berry Blast", 3.00, R.drawable.menu_cookie7, "Taste the blue in this berry explosion of flavour!"));
        menu.add(new CookieMenuItem("Chocolate Drizzle", 3.25, R.drawable.menu_cookie8, "A heavenly bite for a chocoholic. Get yours today!"));
        menu.add(new CookieMenuItem("Crunchy Munch", 3.50, R.drawable.menu_cookie9, "Plain and simple...but packs quite the salty-sweet punch."));
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
    public static ArrayList<CookieMenuItem> getShoppingList() {
        return shoppingList;
    }


}
