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
import static com.example.cookiecorner.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactFragment.
     */
    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
        return fragment;
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
        final View view = inflater.inflate(R.layout.fragment_contact, container, false);

        // Adding functionality to each button in fragment_contact.xml

        // when the email button is pressed, it will take you to the email application stored on the device
        Button emailButton = view.findViewById(R.id.emailButton);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] supportEmail = {"customersupport@cookiecorner.ca"};

                // Using common intents to store email data
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

                // see if there is a software that can resolve this activity
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    // as long as it does not equal null, do this task
                    // display error message here
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }

            }
        });

        // when the phone button is pressed, it will take you to the phone application stored on the device
        Button phoneButton = view.findViewById(R.id.phoneButton);
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // using common intents to store phone data
                Uri supportNumber = Uri.parse("tel:5192561128");

                Intent intent = new Intent(Intent.ACTION_DIAL, supportNumber);

                // see if there is a software that can resolve this activity
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    // as long as it does not equal null, do this task
                    // display error message here
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }
            }
        });

        // when the text button is pressed, it will take you to the text application stored on the device
        Button textButton = view.findViewById(R.id.textButton);
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // using common intents to store text data
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:5192561128"));
                intent.putExtra("sms_body", "Hello, I would like to know about the following: \n"+
                        "\n• Delivery Service" +
                        "\n• Menu Service" +
                        "\n• Office Hours" +
                        "\n• Booking Celebrations" +
                        "\n• Seasonal Discounts");

                // see if there is a software that can resolve this activity
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    // as long as it does not equal null, do this task
                    // display error message here
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }
            }
        });

        // when the location button is pressed, it will take you to the location application stored on the device
        Button locationButton = view.findViewById(R.id.locationButton);
        locationButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // using common intents to store location data
                Uri cookieBakery = Uri.parse("geo:42.3151773152232, -83.03943388022972");

                Intent intent = new Intent(Intent.ACTION_VIEW, cookieBakery);

                // see if there is a software that can resolve this activity
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    // as long as it does not equal null, do this task
                    // display error message here
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }
            }
        });

        // when the website button is pressed, it will take you to the web application stored on the device
        Button websiteButton = view.findViewById(R.id.websiteButton);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // using common intents to store web data
                Uri website = Uri.parse("http://www.cookiecorner.ca");
                Intent intent = new Intent(Intent.ACTION_VIEW, website);

                // see if there is a software that can resolve this activity
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    // as long as it does not equal null, do this task
                    // display error message here
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }
            }
        });

        // similar to website button, but here takes you to instagram.com
        Button instagramButton = view.findViewById(R.id.igButton);
        instagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // using common intents to store web data
                Uri instagram = Uri.parse("http://www.instagram.com/cookiecorner");
                Intent intent = new Intent(Intent.ACTION_VIEW, instagram);

                // see if there is a software that can resolve this activity
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    // as long as it does not equal null, do this task
                    // display error message here
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }
            }
        });

        // similar to website button, but here takes you to twitter.com
        Button twitterButton = view.findViewById(R.id.twtButton);
        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // using common intents to store web data
                Uri twitter = Uri.parse("http://www.twitter.com/cookiecorner");
                Intent intent = new Intent(Intent.ACTION_VIEW, twitter);

                // see if there is a software that can resolve this activity
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    // as long as it does not equal null, do this task
                    // display error message here
                    Snackbar.make(getView(), "No app installed", Snackbar.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }
            }
        });


        return view;
    }
}