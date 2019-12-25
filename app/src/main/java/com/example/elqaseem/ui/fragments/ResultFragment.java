package com.example.elqaseem.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elqaseem.R;
import com.example.elqaseem.dataModel.Item;
import com.example.elqaseem.ui.ChaletItemViewModel;
import com.example.elqaseem.ui.adapters.ChaletAdapter;

public class ResultFragment extends Fragment {

    String mStartDate;
    String mEndDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results, container, false);
        mStartDate = getArguments().getString("StartDate");
        mEndDate = getArguments().getString("EndDate");

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView mainRecyclerView = view.findViewById(R.id.mainRecyclerView);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mainRecyclerView.setHasFixedSize(true);


        ChaletItemViewModel itemViewModel = ViewModelProviders.of(getActivity()).get(ChaletItemViewModel.class);

        final ChaletAdapter adapter = new ChaletAdapter();

        itemViewModel.getItemPagedList(mStartDate, mEndDate).observe(getViewLifecycleOwner(), new Observer<PagedList<Item>>() {
            @Override
            public void onChanged(PagedList<Item> items) {
                adapter.submitList(items);
            }
        });

        mainRecyclerView.setAdapter(adapter);

        adapter.setmChaletOnItemClickListenr(new ChaletAdapter.ChaletOnItemClickListenr() {
            @Override
            public void onChaletItemClickListenerCallBack(Item item) {

                Toast.makeText(getActivity(), ""+item.getName()+"is clicked", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
