package com.example.myapplicationprimenumbertest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationprimenumbertest.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class PrimeResultAdapter extends RecyclerView.Adapter<PrimeResultAdapter.MyViewHolder> {

    private ArrayList<Integer> myPrimeList;
    private Context context;

    public PrimeResultAdapter(WeakReference<Context> contextWeakReference, ArrayList<Integer> myPrimeList) {
        this.context = contextWeakReference.get();
        this.myPrimeList = myPrimeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.primlistlayout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textviewNumber.setText("Title : " + myPrimeList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return myPrimeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView textviewNumber, textviewNumCombination;

        public MyViewHolder(View view) {
            super(view);
            textviewNumber = view.findViewById(R.id.textviewNumber);
            textviewNumCombination = view.findViewById(R.id.textviewNumCombination);
        }
    }
}
