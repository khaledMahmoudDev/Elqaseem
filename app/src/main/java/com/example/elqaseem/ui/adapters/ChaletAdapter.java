package com.example.elqaseem.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.elqaseem.R;
import com.example.elqaseem.dataModel.Item;

public class ChaletAdapter extends PagedListAdapter<Item, ChaletAdapter.ChaletViewHolder> {

    private Context mCtx;



    private ChaletOnItemClickListenr mChaletOnItemClickListenr;


    public ChaletAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ChaletViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_element_home, parent, false);
        mCtx = parent.getContext();

        return new ChaletViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChaletViewHolder holder, int position) {

        Item item = getItem(position);
        if (item != null) {
            if (item.getFaved()) {
                holder.mChaletFavImage.setVisibility(View.VISIBLE);
            }

            if (item.getAvailable() == null) {
                holder.mAvailableImg.setVisibility(View.INVISIBLE);


            }
            if (item.getOffer() == null)
            {
                holder.mSpecialOfferTxt.setVisibility(View.INVISIBLE);
            }

            Glide.with(mCtx).load(item.getImage()).into(holder.mChaletImage);
            holder.mChaletTitleTxt.setText(item.getName());
            holder.mChaletDetailsTxt.setText(item.getAddress());
            holder.mChaletRatingBar.setRating(item.getRate().floatValue());
            holder.mChaletRatingTxt.setText(item.getRateCount().toString());
            holder.mChaletWeekDaysPriceTxt.setText("" + item.getPrice() + "ريال");
            holder.mChaletWeekEndDaysPriceTxt.setText("" + item.getHolidayPrice() + "ريال");

        }

    }


    private static DiffUtil.ItemCallback<Item> DIFF_CALLBACK = new DiffUtil.ItemCallback<Item>() {
        @Override
        public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    };

    class ChaletViewHolder extends RecyclerView.ViewHolder {


        ImageView mChaletImage;
        ImageView mChaletFavImage;
        ImageView mAvailableImg;
        TextView mSpecialOfferTxt;
        TextView mChaletTitleTxt;
        TextView mChaletDetailsTxt;
        RatingBar mChaletRatingBar;
        TextView mChaletRatingTxt;
        TextView mChaletWeekDaysPriceTxt;
        TextView mChaletWeekDaysSpecialPriceTxt;
        TextView mChaletWeekEndDaysPriceTxt;
        TextView mChaletWeekEndDaysSpecialPriceTxt;


        public ChaletViewHolder(@NonNull View itemView) {
            super(itemView);
            mChaletImage = itemView.findViewById(R.id.img_black_overlay);
            mChaletFavImage = itemView.findViewById(R.id.img_fav_row_element);
            mAvailableImg = itemView.findViewById(R.id.img_available_row_element);
            mSpecialOfferTxt = itemView.findViewById(R.id.txt_special_offer_row_element);
            mChaletTitleTxt = itemView.findViewById(R.id.txt_tile_row_item);
            mChaletDetailsTxt = itemView.findViewById(R.id.txt_details_row_item);
            mChaletRatingBar = itemView.findViewById(R.id.rating_bar_row_element);
            mChaletRatingTxt = itemView.findViewById(R.id.txt_rating_row_element);
            mChaletWeekDaysPriceTxt = itemView.findViewById(R.id.txt_week_days_price_row_item);
            mChaletWeekDaysSpecialPriceTxt = itemView.findViewById(R.id.txt_week_days_price_special_row_item);
            mChaletWeekEndDaysPriceTxt = itemView.findViewById(R.id.txt_week_end_days_price_row_item);
            mChaletWeekEndDaysSpecialPriceTxt = itemView.findViewById(R.id.txt_week_end_days_price_special_row_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (mChaletOnItemClickListenr != null && position != RecyclerView.NO_POSITION)
                    {
                        mChaletOnItemClickListenr.onChaletItemClickListenerCallBack(getItem(position));

                    }

                }
            });


        }
    }

    public interface ChaletOnItemClickListenr {

        void onChaletItemClickListenerCallBack(Item item);
    }

    public void setmChaletOnItemClickListenr(ChaletOnItemClickListenr mChaletOnItemClickListenr) {
        this.mChaletOnItemClickListenr = mChaletOnItemClickListenr;
    }
}

