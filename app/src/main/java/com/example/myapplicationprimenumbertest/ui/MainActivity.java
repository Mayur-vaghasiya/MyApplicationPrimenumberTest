package com.example.myapplicationprimenumbertest.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplicationprimenumbertest.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Activity activity = null;
    private static final String TAG = "MainActivity";
    private Toolbar toolbar;
    private AppCompatEditText edittextNumber;
    private AppCompatTextView textviewSubmit;
    private ArrayList<Integer> numberList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = MainActivity.this;
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

        AppCompatTextView txtHeaderNname = (AppCompatTextView) toolbar.findViewById(R.id.actv_header_name);
        txtHeaderNname.setText(getString(R.string.screen_first));

        edittextNumber = (AppCompatEditText) findViewById(R.id.edittextNumber);
        textviewSubmit = (AppCompatTextView) findViewById(R.id.textviewSubmit);
        textviewSubmit.setOnClickListener(this);
        numberList = new ArrayList<>();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textviewSubmit:
                numberList.clear();
                String inputednumber = edittextNumber.getText().toString().trim();

                if (inputednumber != null && !inputednumber.isEmpty()) {
                    ArrayList<String> aList = new ArrayList(Arrays.asList(inputednumber.split(",")));
                    for (String fav : aList) {
                        numberList.add(Integer.parseInt(fav.trim()));
                    }

               /* for(int i=0;i<aList.size();i++)
                {
                    System.out.println(aList.get(i));
                }*/

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("mylist", numberList);
                    startActivity(intent);
                    edittextNumber.getText().clear();

                } else {
                    edittextNumber.setError("Enter valid input before press Submit!");
                }
                break;
        }
    }
}
