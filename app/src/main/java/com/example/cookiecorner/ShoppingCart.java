package com.example.cookiecorner;
import com.example.cookiecorner.pojo.CookieMenuItem;
import java.util.ArrayList;

/**
 * The Singleton Class representing the Shopping Cart
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 23rd 2020
 */
public class ShoppingCart {
    // properties
    public static ArrayList<CookieMenuItem> menu = new ArrayList<>(); // the default menu that never changes
    private static ArrayList<CookieMenuItem> shoppingList = new ArrayList<>(); // the orders list
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

    /**
     * initializing the shopping list
     */
    private ShoppingCart(){
        shoppingList = new ArrayList<>();
    }

    /**
     * getInstance method -- returns only one instance of the class throughout the entire app lifecycle
     * @return shopping cart
     */
    public static ShoppingCart getInstance() {
        if(shoppingCart == null){
            shoppingCart = new ShoppingCart();
        }
        return shoppingCart;
    }

    /**
     * Retrieves the shopping list of orders
     * @return shopping list
     */
    public static ArrayList<CookieMenuItem> getShoppingList() {
        return shoppingList;
    }


}
