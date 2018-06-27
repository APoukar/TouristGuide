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

import com.example.adam.touristguide.DetailActivity;
import com.example.adam.touristguide.Objects.Country;
import com.example.adam.touristguide.R;
import com.example.adam.touristguide.Objects.Sight;

import java.util.List;

public class SightAdapter extends RecyclerView.Adapter<SightAdapter.SightsVH> {

    //region Fields

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Sight> mData;
    private List<Country> mCountries;

    //endregion Fields

    //region Ctor

    public SightAdapter(Context context, List<Sight> data, List<Country> countries) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mData = data;
        mCountries = countries;
    }

    //endregion Ctor

    //region Overrides

    @NonNull
    @Override
    public SightsVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.activity_recycler_item, viewGroup, false);
        return new SightAdapter.SightsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SightsVH sightsVH, int i) {
        final Sight current = mData.get(i);
        final Country country = mCountries.get(current.getCountryId());
        sightsVH.recyclerItem.setText((current.getName()));
        sightsVH.recyclerItem.setCompoundDrawablesWithIntrinsicBounds(country.getFlag(),0,0,0);


        sightsVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showDetail = new Intent(mContext, DetailActivity.class)
                        .putExtra("sight", (Parcelable) current);
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

    class SightsVH extends RecyclerView.ViewHolder {

        TextView recyclerItem;

        SightsVH(@NonNull View itemView) {
            super(itemView);
            recyclerItem = itemView.findViewById(R.id.recycler_item);
        }
    }

    //endregion ViewHolder

}

