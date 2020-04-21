package com.example.myapplicationprimenumbertest.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.example.myapplicationprimenumbertest.R;
import com.example.myapplicationprimenumbertest.adapter.PrimeResultAdapter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private Activity activity = null;
    private static final String TAG = "SecondActivity";
    private Toolbar toolbar;
    private ArrayList<Integer> myList = null;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager = null;
    private PrimeResultAdapter primeResultAdapter;
    private ArrayList<Integer> myPrimeList;
    private ArrayList<Integer> mylist2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        myList = (ArrayList<Integer>) getIntent().getSerializableExtra("mylist");
        activity = SecondActivity.this;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_back);
        upArrow.setColorFilter(getResources().getColor(R.color.golden), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
            }
        });

        myPrimeList = new ArrayList<>();
       mylist2 =new ArrayList<>();
        AppCompatTextView txtHeaderNname = (AppCompatTextView) toolbar.findViewById(R.id.actv_header_name);
        txtHeaderNname.setText(getString(R.string.screen_second));

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(activity, layoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        setRecyclerViewData();
        getPrimeValue();
    }

    private void getPrimeValue() {
        int count = 0;
        myPrimeList.clear();
        for (int i = 1; i <= myList.size(); i++) {
            boolean isPrimeNumber = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
            if (isPrimeNumber) {
                myPrimeList.add(i);
            }
        }
    }

     @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(activity, MainActivity.class));
        finish();
    }

    private void setRecyclerViewData() {

        primeResultAdapter = new PrimeResultAdapter(new WeakReference<Context>(activity),myPrimeList);
        recyclerView.setAdapter(primeResultAdapter);
    }
}
