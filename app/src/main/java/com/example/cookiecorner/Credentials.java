package com.example.cookiecorner;

public class Credentials {
    private static String ACC_NAME;
    private static String ACC_LOCATION;
    private static String ACC_CARD;
    private static String ACC_HOLDER;
    private static String EXP_DATE;
    private static String ACC_CVC;

    public static Credentials credentials;

    public static Credentials getInstance(){
        if(credentials == null){
            credentials = new Credentials();
        }
        return credentials;
    }

    public static String getAccName() {
        return ACC_NAME;
    }

    public static void setAccName(String accName) {
        ACC_NAME = accName;
    }

    public static String getAccLocation() {
        return ACC_LOCATION;
    }

    public static void setAccLocation(String accLocation) {
        ACC_LOCATION = accLocation;
    }

    public static String getAccCard() {
        return ACC_CARD;
    }

    public static void setAccCard(String accCard) {
        ACC_CARD = accCard;
    }

    public static String getAccHolder() {
        return ACC_HOLDER;
    }

    public static void setAccHolder(String accHolder) {
        ACC_HOLDER = accHolder;
    }

    public static String getExpDate() {
        return EXP_DATE;
    }

    public static void setExpDate(String expDate) {
        EXP_DATE = expDate;
    }

    public static String getAccCvc() {
        return ACC_CVC;
    }

    public static void setAccCvc(String accCvc) {
        ACC_CVC = accCvc;
    }
}
