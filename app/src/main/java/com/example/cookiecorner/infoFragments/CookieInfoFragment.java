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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CookieInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CookieInfoFragment extends Fragment {

    String title = "no_value";
    int image = R.drawable.logo;
    String desc = "no_value";
    double price = 0.00;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CookieInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CookieInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CookieInfoFragment newInstance(String param1, String param2) {
        CookieInfoFragment fragment = new CookieInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

            title = getArguments().getString("TITLE");
            image = getArguments().getInt("IMAGE");
            price = getArguments().getDouble("PRICE");
            desc = getArguments().getString("DESC");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_cookie_info, container, false);

        TextView menuTitle = view.findViewById(R.id.menuTitle);
        menuTitle.setText(title);

        ImageView menuImage = view.findViewById(R.id.menuImage);
        menuImage.setImageResource(image);

        TextView menuDesc = view.findViewById(R.id.menuDescription);
        menuDesc.setText(desc);

        TextView menuPrice = view.findViewById(R.id.menuCost);
        menuPrice.setText("$ " + price);

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