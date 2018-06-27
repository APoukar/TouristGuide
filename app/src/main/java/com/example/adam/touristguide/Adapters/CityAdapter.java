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

import com.example.adam.touristguide.Objects.City;
import com.example.adam.touristguide.DetailActivity;
import com.example.adam.touristguide.Objects.Country;
import com.example.adam.touristguide.R;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CitiesVH> {

    //region Fields

    private Context mContext;
    private LayoutInflater mInflater;
    private List<City> mData;
    private List<Country> mCountries;

    //endregion Fields

    //region Ctor

    public CityAdapter(Context context, List<City> data, List<Country> countries) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mData = data;
        mCountries = countries;
    }

    //endregion Ctor

    //region Overrides

    @NonNull
    @Override
    public CitiesVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.activity_recycler_item, viewGroup, false);
        return new CityAdapter.CitiesVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesVH citiesVH, int i) {
        final City current = mData.get(i);
        final Country country = mCountries.get(current.getCountryId());
        citiesVH.recyclerItem.setText((current.getName()));
        citiesVH.recyclerItem.setCompoundDrawablesWithIntrinsicBounds(country.getFlag(),0,0,0);

        citiesVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showDetail = new Intent(mContext, DetailActivity.class)
                        .putExtra("city", current);
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

    class CitiesVH extends RecyclerView.ViewHolder {

        TextView recyclerItem;

        CitiesVH(@NonNull View itemView) {
            super(itemView);
            recyclerItem = itemView.findViewById(R.id.recycler_item);
        }
    }

    //endregion ViewHolder

}

