package com.example.elqaseem.ui.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.elqaseem.R;
import com.example.elqaseem.ui.ChaletItemViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class HomeFragment extends Fragment {
    String mWhichButton = null;
    Button startDate;
    Button endDate;
    String mStartDate;
    String mEndDate;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mStartDate = "";
        mEndDate = "";

        final DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.setCallBack(onDateSetListener);

        startDate = view.findViewById(R.id.btn_home_startDate);
        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager() != null) {
                    datePickerFragment.show(getFragmentManager(), "StartDatePicker");
                    mWhichButton = "startButton";
                }
            }
        });


        endDate = view.findViewById(R.id.btn_home_endDate);
        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager() != null) {
                    datePickerFragment.show(getFragmentManager(), "EndDatePicker");
                    mWhichButton = "endButton";
                }
            }
        });


        Button search = view.findViewById(R.id.btn_home_searchNow);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mStartDate.trim().equals("") || mEndDate.trim().equals("")) {

                } else {

                    Bundle bundle = new Bundle();
                    bundle.putString("StartDate", mStartDate);
                    bundle.putString("EndDate", mEndDate);
                    ResultFragment resultFragment = new ResultFragment();
                    resultFragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.frame_layout_home, resultFragment).addToBackStack("result").commit();


                }
            }
        });
        return view;
    }


    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            Calendar c = Calendar.getInstance();
            c.set(year, month, dayOfMonth);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            String formattedDate = sdf.format(c.getTime());

            if (mWhichButton.equals("startButton")) {
                startDate.setText(formattedDate);
                mStartDate = formattedDate;


            } else if (mWhichButton.equals("endButton")) {
                endDate.setText(formattedDate);
                mEndDate = formattedDate;
            }

        }
    };
}
