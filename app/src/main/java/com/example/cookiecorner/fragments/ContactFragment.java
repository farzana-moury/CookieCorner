package com.example.cookiecorner.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cookiecorner.R;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
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
        final View view = inflater.inflate(R.layout.fragment_contact, container, false);

        //Adding functionality to each button in fragment_contact.xml
        Button emailButton = view.findViewById(R.id.emailButton);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] supportEmail = {"customersupport@cookiecorner.ca"};

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, supportEmail);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Customer Support Inquiry");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello, I would like to know about the following: \n" +
                        "\n• Delivery Service" +
                        "\n• Menu Service" +
                        "\n• Office Hours" +
                        "\n• Booking Celebrations" +
                        "\n• Seasonal Discounts");

                //see if there is a software that can resolve this activity
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    //as long as it does not equal null, do this task
                    //display error message here
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }

            }
        });

        Button phoneButton = view.findViewById(R.id.phoneButton);
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri supportNumber = Uri.parse("tel:5192561128");

                Intent intent = new Intent(Intent.ACTION_DIAL, supportNumber);

                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }
            }
        });

        Button textButton = view.findViewById(R.id.textButton);
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:5192561128"));
                intent.putExtra("sms_body", "Hello, I would like to know about the following: \n"+
                        "\n• Delivery Service" +
                        "\n• Menu Service" +
                        "\n• Office Hours" +
                        "\n• Booking Celebrations" +
                        "\n• Seasonal Discounts");
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }
            }
        });

        Button locationButton = view.findViewById(R.id.locationButton);
        locationButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri cookieBakery = Uri.parse("geo:42.3151773152232, -83.03943388022972");

                Intent intent = new Intent(Intent.ACTION_VIEW, cookieBakery);

                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }
            }
        });

        Button websiteButton = view.findViewById(R.id.websiteButton);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri website = Uri.parse("http://www.cookiecorner.ca");
                Intent intent = new Intent(Intent.ACTION_VIEW, website);
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }
            }
        });

        Button instagramButton = view.findViewById(R.id.igButton);
        instagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri instagram = Uri.parse("http://www.instagram.com/cookiecorner");
                Intent intent = new Intent(Intent.ACTION_VIEW, instagram);
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }else {
                    startActivity(intent);
                }
            }
        });

        Button twitterButton = view.findViewById(R.id.twtButton);
        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri twitter = Uri.parse("http://www.twitter.com/cookiecorner");
                Intent intent = new Intent(Intent.ACTION_VIEW, twitter);
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                } else {
                    startActivity(intent);
                }
            }
        });


        return view;
    }
}