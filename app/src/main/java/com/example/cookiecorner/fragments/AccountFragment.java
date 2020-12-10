package com.example.cookiecorner.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.cookiecorner.Credentials;
import com.example.cookiecorner.R;

import static com.example.cookiecorner.Credentials.credentials;
import static com.example.cookiecorner.MainActivity.fab;
import static com.example.cookiecorner.MainActivity.preferences;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText name;
    private EditText location;
    private EditText cardNumber;
    private EditText cardHolder;
    private EditText expiryDate;
    private EditText cvc;

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fab.hide();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        name = view.findViewById(R.id.nameEditText);
        location = view.findViewById(R.id.addressEditText);
        cardNumber = view.findViewById(R.id.cardEditText);
        cardHolder = view.findViewById(R.id.accNameEditText);
        expiryDate = view.findViewById(R.id.expDateEditText);
        cvc = view.findViewById(R.id.cvcEditText);


        Button saveButton = view.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setting the account name
                credentials.setAccName(name.getText().toString());


                //setting the delivery location
                credentials.setAccLocation(location.getText().toString());


                //setting the payment information
                credentials.setAccCard(cardNumber.getText().toString());


                credentials.setAccHolder(cardHolder.getText().toString());


                credentials.setExpDate(expiryDate.getText().toString());


                credentials.setAccCvc(cvc.getText().toString());

            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        name.setText(preferences.getString("name", ""));
        location.setText(preferences.getString("location", ""));
        cardNumber.setText(preferences.getString("cardNumber", ""));
        cardHolder.setText(preferences.getString("accHolder", ""));
        expiryDate.setText((preferences.getString("expDate", ""));
        cvc.setText(preferences.getString("cvc", ""));

        Log.d("watchMe", "accountOnResume");
    }
}