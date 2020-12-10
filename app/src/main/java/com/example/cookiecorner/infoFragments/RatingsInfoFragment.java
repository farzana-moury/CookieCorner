package com.example.cookiecorner.infoFragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.cookiecorner.R;
import static com.example.cookiecorner.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RatingsInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 28th 2020
 */
public class RatingsInfoFragment extends Fragment {

    // constants to represent each piece of information on a particular rating
    private static final String NAME = "name";
    private static final String IMAGE = "image";
    private static final String REVIEW = "review";

    // properties that will hold the information
    private String name;
    private int image;
    private String review;

    /**
     * Instance contains information to be displayed
     * in the Ratings page
     *
     * @param name Customer Name.
     * @param image Customer Picture.
     * @param review Customer Review.
     * @return A new instance of fragment RatingsInfoFragment.
     */
    public static RatingsInfoFragment newInstance(String name, int image, String review) {
        RatingsInfoFragment fragment = new RatingsInfoFragment();
        // putting data into the bundle to be transferred to another fragment
        Bundle args = new Bundle();
        args.putString(NAME, name);
        args.putInt(IMAGE, image);
        args.putString(REVIEW, review);
        fragment.setArguments(args);
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
            name = getArguments().getString(NAME);
            image = getArguments().getInt(IMAGE);
            review = getArguments().getString(REVIEW);
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
        View view = inflater.inflate(R.layout.fragment_ratings_info, container, false);

        // if there is a value within each information holder,
        if(name != null) {
            TextView customerName = view.findViewById(R.id.customerName); // then populate the view objects with it
            customerName.setText(name); // customer name
        }
        if(image != 0) {
            ImageView customerImage = view.findViewById(R.id.customerPic);
            customerImage.setImageResource(image); // customer profile pic
        }
        if(review != null) {
            TextView customerReview = view.findViewById(R.id.customerReview);
            customerReview.setText(review); // customer review
        }

        return view;
    }
}