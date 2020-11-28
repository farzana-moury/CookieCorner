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

public class FAQRecyclerViewAdapter extends RecyclerView.Adapter<FAQRecyclerViewAdapter.CustomViewHolder> {
    private ArrayList<FAQItem> faqList = new ArrayList<>();

    public FAQRecyclerViewAdapter(ArrayList<FAQItem> faq) {
        this.faqList = faq;
    }

    @NonNull
    @Override
    public FAQRecyclerViewAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.faq_recyclerview, null);

        return new FAQRecyclerViewAdapter.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        FAQItem faqItem = faqList.get(position);
        holder.question.setText(faqItem.getQuestion());
        holder.answer.setText(faqItem.getAnswer());
    }

    @Override
    public int getItemCount() {
        if(faqList != null){
            return faqList.size();
        }
        return 0;
    }

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

