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
 */
public class RatingsInfoFragment extends Fragment {

    //the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String NAME = "name";
    private static final String IMAGE = "image";
    private static final String REVIEW = "review";

    //types of parameters
    private String name;
    private int image;
    private String review;

    public RatingsInfoFragment() {
        // Required empty public constructor
    }

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
        Bundle args = new Bundle();
        args.putString(NAME, name);
        args.putInt(IMAGE, image);
        args.putString(REVIEW, review);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(NAME);
            image = getArguments().getInt(IMAGE);
            review = getArguments().getString(REVIEW);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fab.hide();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ratings_info, container, false);

        if(name != null) {
            TextView customerName = view.findViewById(R.id.customerName);
            customerName.setText(name);
        }
        if(image != 0) {
            ImageView customerImage = view.findViewById(R.id.customerPic);
            customerImage.setImageResource(image);
        }
        if(review != null) {
            TextView customerReview = view.findViewById(R.id.customerReview);
            customerReview.setText(review);
        }

        return view;
    }
}