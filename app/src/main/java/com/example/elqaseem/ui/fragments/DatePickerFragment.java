package com.example.elqaseem.ui.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
public class DatePickerFragment extends DialogFragment {

    DatePickerDialog.OnDateSetListener onDateSetListener;


    public void setCallBack(DatePickerDialog.OnDateSetListener onDateSet) {
        onDateSetListener = onDateSet;

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


        return new DatePickerDialog(getActivity(), onDateSetListener, year, month, day);
    }

}
