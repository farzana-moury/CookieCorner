package com.example.cookiecorner.infoFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cookiecorner.R;
import com.example.cookiecorner.ShoppingCart;
import com.example.cookiecorner.viewFragments.MenuFragment;

import static com.example.cookiecorner.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CookieInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 27th 2020
 */
public class CookieInfoFragment extends Fragment {

    // variables to hold the bundled data taken from the Menu Fragment
    String title = "no_value";
    int image = R.drawable.logo;
    String desc = "no_value";
    double price = 0.00;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CookieInfoFragment.
     */
    public static CookieInfoFragment newInstance(String param1, String param2) {
        CookieInfoFragment fragment = new CookieInfoFragment();
        return fragment;
    }

    /**
     * This method is called when the Fragment is first created. Here we put initialization code.
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // taking the values from the bundle
        if (getArguments() != null) {
            title = getArguments().getString("TITLE");
            image = getArguments().getInt("IMAGE");
            price = getArguments().getDouble("PRICE");
            desc = getArguments().getString("DESC");
        }
    }

    /**
     * This method is used to draw the Fragment UI -- the things to be viewed on screen
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return the view that holds all the viewable objects
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fab.hide();

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_cookie_info, container, false);

        // setting the view elements to the values taken from the bundle
        TextView menuTitle = view.findViewById(R.id.menuTitle);
        menuTitle.setText(title);

        ImageView menuImage = view.findViewById(R.id.menuImage);
        menuImage.setImageResource(image);

        TextView menuDesc = view.findViewById(R.id.menuDescription);
        menuDesc.setText(desc);

        TextView menuPrice = view.findViewById(R.id.menuCost);
        menuPrice.setText("$ " + price);

        // when you click on the Place Order button
        Button placeOrder = view.findViewById(R.id.placeOrderButton);
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //adding the selected menu cookie to the orders shopping list
                ShoppingCart.getInstance().getShoppingList().add(ShoppingCart.menu.get(MenuFragment.cookiePosition));
            }
        });

        return view;
    }
}