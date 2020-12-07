package com.example.cookiecorner;

public class Credentials {
    private static String ACC_NAME;
    private static String ACC_LOCATION;
    private static int ACC_CARD;
    private static String ACC_HOLDER;
    private static String EXP_DATE;
    private static int ACC_CVC;

    private static Credentials credentials;

    private Credentials(){
        ACC_NAME = "";
        ACC_LOCATION = "";
    }

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

    public static int getAccCard() {
        return ACC_CARD;
    }

    public static void setAccCard(int accCard) {
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

    public static int getAccCvc() {
        return ACC_CVC;
    }

    public static void setAccCvc(int accCvc) {
        ACC_CVC = accCvc;
    }
}
