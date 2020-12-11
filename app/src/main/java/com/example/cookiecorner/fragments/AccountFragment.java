package com.example.cookiecorner.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.example.cookiecorner.R;
import static com.example.cookiecorner.MainActivity.fab;
import static com.example.cookiecorner.MainActivity.preferences;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 8th 2020
 */
public class AccountFragment extends Fragment {

    // properties
    private EditText name;
    private EditText location;
    private EditText cardNumber;
    private EditText cardHolder;
    private EditText expiryDate;
    private EditText cvc;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
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
        fab.hide(); // hiding the fab button from view

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        name = view.findViewById(R.id.nameEditText);
        location = view.findViewById(R.id.addressEditText);
        cardNumber = view.findViewById(R.id.cardEditText);
        cardHolder = view.findViewById(R.id.accNameEditText);
        expiryDate = view.findViewById(R.id.expDateEditText);
        cvc = view.findViewById(R.id.cvcEditText);

        return view;
    }

    /**
     * When an fragment or activity enters back into its view -- it resumes its state
     */
    @Override
    public void onResume() {
        super.onResume();

        // Setting the EditTexts to whatever is in Account Settings EditTextPreferences
        name.setText(preferences.getString("name", ""));
        location.setText(preferences.getString("location", ""));
        cardNumber.setText(preferences.getString("cardNumber", ""));
        cardHolder.setText(preferences.getString("accHolder", ""));
        expiryDate.setText(preferences.getString("expDate", ""));
        cvc.setText(preferences.getString("cvc", ""));
    }
}