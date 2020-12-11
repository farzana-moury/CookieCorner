package com.example.cookiecorner;

/**
 * Represents a Singleton class that contains credentials for Account Fragment
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Dec 7th 2020
 */
public class Credentials {
    // properties
    private static String ACC_NAME;
    private static String ACC_LOCATION;
    private static String ACC_CARD;
    private static String ACC_HOLDER;
    private static String EXP_DATE;
    private static String ACC_CVC;

    public static Credentials credentials;

    /**
     * getInstance method -- returns only one instance of the class throughout the entire app lifecycle
     * @return credentials
     */
    public static Credentials getInstance(){
        if(credentials == null){
            credentials = new Credentials();
        }
        return credentials;
    }

    /**
     * Getter for account name
     * @return account name
     */
    public static String getAccName() {
        return ACC_NAME;
    }

    /**
     * Setter for account name
     * @param accName account name
     */
    public static void setAccName(String accName) {
        ACC_NAME = accName;
    }

    /**
     * Getter for account location
     * @return account location
     */
    public static String getAccLocation() {
        return ACC_LOCATION;
    }

    /**
     * Setter for account location
     * @param accLocation account location
     */
    public static void setAccLocation(String accLocation) {
        ACC_LOCATION = accLocation;
    }

    /**
     * Getter for account card number
     * @return account card number
     */
    public static String getAccCard() {
        return ACC_CARD;
    }

    /**
     * Setter for account card number
     * @param accCard account card number
     */
    public static void setAccCard(String accCard) {
        ACC_CARD = accCard;
    }

    /**
     * Getter for account holder name
     * @return account holder name
     */
    public static String getAccHolder() {
        return ACC_HOLDER;
    }

    /**
     * Setter for account holder name
     * @param accHolder account holder name
     */
    public static void setAccHolder(String accHolder) {
        ACC_HOLDER = accHolder;
    }

    /**
     * Getter for expiry date
     * @return expiry date
     */
    public static String getExpDate() {
        return EXP_DATE;
    }

    /**
     * Setter for expiry date
     * @param expDate expiry date
     */
    public static void setExpDate(String expDate) {
        EXP_DATE = expDate;
    }

    /**
     * Getter for cvc
     * @return cvc
     */
    public static String getAccCvc() {
        return ACC_CVC;
    }

    /**
     * Setter for cvc
     * @param accCvc cvc
     */
    public static void setAccCvc(String accCvc) {
        ACC_CVC = accCvc;
    }
}
