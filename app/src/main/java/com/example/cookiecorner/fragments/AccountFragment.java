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

    public static Credentials credentials;

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

                credentials = Credentials.getInstance();

                //setting the account name
                String nameToStore = name.getText().toString();
                credentials.setAccName(nameToStore);
                name.setText(credentials.getAccName());

                //setting the delivery location
                String addressToStore = location.getText().toString();
                credentials.setAccLocation(addressToStore);
                location.setText(credentials.getAccLocation());

                //setting the payment information
                String cardToStore = cardNumber.getText().toString();
                credentials.setAccCard(cardToStore);
                cardNumber.setText(credentials.getAccCard());

                String holderToStore = cardHolder.getText().toString();
                credentials.setAccHolder(holderToStore);
                cardHolder.setText(credentials.getAccHolder());

                String dateToStore = expiryDate.getText().toString();
                credentials.setExpDate(dateToStore);
                expiryDate.setText(credentials.getExpDate());

                String cvcToStore = cvc.getText().toString();
                credentials.setAccCvc(cvcToStore);
                cvc.setText(credentials.getAccCvc());

            }
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        name.setText(credentials.getAccName());
        location.setText(credentials.getAccLocation());
        cardNumber.setText(credentials.getAccCard());
        cardHolder.setText(credentials.getAccHolder());
        expiryDate.setText(credentials.getExpDate());
        cvc.setText(credentials.getAccCvc());

        Log.d("watchMe", "accountOnResume");
    }
}