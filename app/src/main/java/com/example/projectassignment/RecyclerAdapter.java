package com.example.projectassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<Country> countries;

    public RecyclerAdapter(ArrayList<Country> countries){
        this.countries = countries;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView countryText;
        public TextView countryName;

        public MyViewHolder(final View view) {
            super(view);

            countryText = view.findViewById(R.id.countryText);
            countryName = view.findViewById(R.id.countryName);

        }
    }
    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {

        String name = countries.get(position).getName();
        String location = countries.get(position).getLocation();
        String company = countries.get(position).getCompany();
        //  int Size = countries.get(position).getSize();
        // int population = countries.get(position).getPopulation();

        holder.countryText.setText("name: " + name + "\nLocation: " + location + "\nCompany: " + company );
    }

    @Override
    public int getItemCount()
    {
        return countries.size();
    }


    public void addCountries(ArrayList<Country> countries){

        this.countries.addAll(countries);
        notifyDataSetChanged();
    }
}