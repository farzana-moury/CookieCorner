package com.example.cookiecorner.viewFragments;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cookiecorner.R;
import com.example.cookiecorner.pojo.FAQItem;
import java.util.ArrayList;

/**
 * Adapter class that provides access to data items, making a View for each data item
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 28th 2020
 *
 */
public class FAQRecyclerViewAdapter extends RecyclerView.Adapter<FAQRecyclerViewAdapter.CustomViewHolder> {
    // property to hold the RecyclerView list
    private ArrayList<FAQItem> faqList = new ArrayList<>();

    /**
     * constructor.
     * @param faq the arraylist to be viewed
     */
    public FAQRecyclerViewAdapter(ArrayList<FAQItem> faq) {
        this.faqList = faq;
    }

    /**
     * @param parent represents the parent ViewGroup
     * @param viewType represents the view type
     * @return the view holder
     */
    @NonNull
    @Override
    public FAQRecyclerViewAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.faq_recyclerview, null);

        return new FAQRecyclerViewAdapter.CustomViewHolder(view);
    }

    /**
     * @param holder describes an item view and metadata about its place within the RecyclerView
     * @param position the position of the item
     */
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        // setting the item's dataset for question and answer
        FAQItem faqItem = faqList.get(position);
        holder.question.setText(faqItem.getQuestion());
        holder.answer.setText(faqItem.getAnswer());
    }

    /**
     * @return the size of the list
     */
    @Override
    public int getItemCount() {
        if(faqList != null){
            return faqList.size();
        }
        return 0;
    }

    /**
     * Making a Custom ViewHolder with RecyclerView and setting the UI objects to the data
     *
     * @author Farzana Moury
     * @version 1.0
     * @since Nov 28th 2020
     */
    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView question;
        protected TextView answer;

        public CustomViewHolder(@NonNull View itemView){
            super(itemView);

            this.question = itemView.findViewById(R.id.faqQuestion);
            this.answer = itemView.findViewById(R.id.faqAnswer);

        }
    }
}

