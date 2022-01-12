package com.emreozcan.telephonebookroom.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emreozcan.telephonebookroom.R;
import com.emreozcan.telephonebookroom.model.PhoneBook;

import java.util.List;

public class RecyclerCardAdapter extends RecyclerView.Adapter<RecyclerCardAdapter.CardViewHolder> {

    private List<PhoneBook> personList;

    public RecyclerCardAdapter(List<PhoneBook> personList) {
        this.personList = personList;
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        private TextView tvCardName, tvCardNumber;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCardName = itemView.findViewById(R.id.tvCardName);
            tvCardNumber = itemView.findViewById(R.id.tvCardNumber);
        }
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view,parent,false);

        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        PhoneBook phoneBook = personList.get(position);

        holder.tvCardName.setText(phoneBook.getPersonName());
        holder.tvCardNumber.setText(phoneBook.getPersonNumber());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }
}
