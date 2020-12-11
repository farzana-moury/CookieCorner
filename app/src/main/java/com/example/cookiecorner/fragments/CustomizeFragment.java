package com.example.cookiecorner.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.cookiecorner.R;
import com.example.cookiecorner.pojo.CookieMenuItem;
import com.example.cookiecorner.singleton.ShoppingCart;

import static com.example.cookiecorner.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomizeFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Dec 10th 2020
 */
public class CustomizeFragment extends Fragment {
    // properties that will hold the custom cookie info
    EditText name;
    EditText flavour;
    EditText quantity;
    EditText topping;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CustomizeFragment.
     */
    public static CustomizeFragment newInstance(String param1, String param2) {
        CustomizeFragment fragment = new CustomizeFragment();
        return fragment;
    }

    /**
     * This method is used to draw the Fragment UI -- the things to be viewed on screen
     *
     * @param inflater a system service that converts xml files into view objects
     * @param container the invisible container that holds View and ViewGroup
     * @param savedInstanceState a reference to a bundle object passed into the onCreate method
     * @return the view that holds all the viewable objects
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fab.hide();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customize, container, false);

        // set the properties to the editTexts located in the custom cookie fragment
        name = view.findViewById(R.id.cust_name);
        flavour = view.findViewById(R.id.cust_flavour);
        quantity = view.findViewById(R.id.cust_quantity);
        topping = view.findViewById(R.id.cust_topping);

        Button submitButton = view.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // for the quantity that the user has entered....
                for (int i = 0; i <Integer.parseInt(quantity.getText().toString()); i++){

                    // add the user's customized cookie to the shopping list
                    CookieMenuItem customCookie = new CookieMenuItem(name.getText().toString(),
                            1 * Integer.parseInt(quantity.getText().toString()), R.drawable.logo,
                            "" + flavour.getText().toString() + " flavoured cookie topped with " +
                                    topping.getText().toString());

                    ShoppingCart.getInstance().getShoppingList().add(customCookie);


                }


            }
        });


        return view;
    }
}