package com.example.adam.touristguide.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adam.touristguide.Objects.Country;
import com.example.adam.touristguide.DetailActivity;
import com.example.adam.touristguide.R;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryVH> {

    //region Fields

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Country> mData;

    //endregion Fields

    //region Ctor

    public CountryAdapter(Context context, List<Country> data) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mData = data;
    }

    //endregion Ctor

    //region Overrides

    @NonNull
    @Override
    public CountryVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.activity_recycler_item, viewGroup, false);
        return new CountryAdapter.CountryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryVH countryVH, int i) {
        final Country current = mData.get(i);
        countryVH.recyclerItem.setText((current.getName()));
        countryVH.recyclerItem.setCompoundDrawablesWithIntrinsicBounds(current.getFlag(),0,0,0);

        countryVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showDetail = new Intent(mContext, DetailActivity.class)
                        .putExtra("country", current);
                mContext.startActivity(showDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();

    }

    //endregion Overrides

    //region ViewHolder

    class CountryVH extends RecyclerView.ViewHolder {

        TextView recyclerItem;

        CountryVH(@NonNull View itemView) {
            super(itemView);
            recyclerItem = itemView.findViewById(R.id.recycler_item);
        }
    }

    //endregion ViewHolder
}

