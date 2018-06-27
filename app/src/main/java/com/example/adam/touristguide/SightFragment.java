package com.example.adam.touristguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adam.touristguide.Adapters.CityAdapter;
import com.example.adam.touristguide.Adapters.CountryAdapter;
import com.example.adam.touristguide.Adapters.SightAdapter;
import com.example.adam.touristguide.Objects.City;
import com.example.adam.touristguide.Objects.Country;
import com.example.adam.touristguide.Objects.Sight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SightFragment extends android.support.v4.app.Fragment {

    //region Fields

    private int mId;
    private List<Country> countries;
    private List<City> cities;
    private List<Sight> sights;

    //endregion Fields

    //region Overrides

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_main, container, false);
        mId = getArguments() != null ? getArguments().getInt("position") : 0;   //Retrieves the info which tab is currently loaded
        setFragment(layout);
        return layout;
    }

    //endregion Overrides

    //region Private methods

    //Assigns only needed lists according to currently loaded tab
    private void setFragment(View layout) {
        RecyclerView recyclerView = layout.findViewById(R.id.recycler_view);
        switch (mId) {
            case 0:
                addCountries();
                CountryAdapter countryAdapter = new CountryAdapter(getActivity(), countries);
                recyclerView.setAdapter(countryAdapter);
                break;
            case 1:
                addCountries();
                addCities();
                CityAdapter cityAdapter = new CityAdapter(getActivity(), cities, countries);
                recyclerView.setAdapter(cityAdapter);
                break;
            case 2:
                addCountries();
                addSights();
                SightAdapter sightAdapter = new SightAdapter(getActivity(), sights, countries);
                recyclerView.setAdapter(sightAdapter);
                break;
            default:
                Log.e("My error: ", "Something went wrong " +
                        "during switch statement in setFragment() at SightFragment.class");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    //region Lists

    /**
     * I have decided to reference every string resource separately
     * instead of using string-array to make the code more readable.
     * Not sure how it affects performance tho? Loading one string
     * array seems faster than opening strings.xml about thousand times.
     */
    private void addCountries() {
        countries = new ArrayList<>();
        countries.add(new Country(getResources().getString(R.string.austria), R.drawable.austria, getResources().getString(R.string.universal_description)));
        countries.add(new Country(getResources().getString(R.string.belgium), R.drawable.belgium, getResources().getString(R.string.universal_description)));
        countries.add(new Country(getResources().getString(R.string.czech_republic), R.drawable.czech_republic, getResources().getString(R.string.universal_description)));
        countries.add(new Country(getResources().getString(R.string.germany), R.drawable.germany, getResources().getString(R.string.universal_description)));
        countries.add(new Country(getResources().getString(R.string.hungary), R.drawable.hungary, getResources().getString(R.string.universal_description)));
        countries.add(new Country(getResources().getString(R.string.luxembourg), R.drawable.luxembourg, getResources().getString(R.string.universal_description)));
        countries.add(new Country(getResources().getString(R.string.poland), R.drawable.poland, getResources().getString(R.string.universal_description)));
        countries.add(new Country(getResources().getString(R.string.romania), R.drawable.romania, getResources().getString(R.string.universal_description)));
        countries.add(new Country(getResources().getString(R.string.slovakia), R.drawable.slovakia, getResources().getString(R.string.universal_description)));
        countries.add(new Country(getResources().getString(R.string.slovenia), R.drawable.slovenia, getResources().getString(R.string.universal_description)));
        countries.add(new Country(getResources().getString(R.string.switzerland), R.drawable.switzerland, getResources().getString(R.string.universal_description)));
        Collections.sort(countries);
    }

    /**
     * Passing the same Universal description for every object just to show that I know how to set
     * the description for every individual object
     */
    private void addCities() {
        cities = new ArrayList<>();
        cities.add(new City(0, getResources().getString(R.string.vienna), R.drawable.vienna, getResources().getString(R.string.universal_description)));
        cities.add(new City(1, getResources().getString(R.string.brussels), R.drawable.brussel, getResources().getString(R.string.universal_description)));
        cities.add(new City(2, getResources().getString(R.string.prague), R.drawable.prague, getResources().getString(R.string.universal_description)));
        cities.add(new City(3, getResources().getString(R.string.berlin), R.drawable.berlin, getResources().getString(R.string.universal_description)));
        cities.add(new City(4, getResources().getString(R.string.budapest), R.drawable.budapest, getResources().getString(R.string.universal_description)));
        cities.add(new City(5, getResources().getString(R.string.luxembourg_capital), R.drawable.luxembourg_capital, getResources().getString(R.string.universal_description)));
        cities.add(new City(6, getResources().getString(R.string.krakow), R.drawable.krakow, getResources().getString(R.string.universal_description)));
        cities.add(new City(7, getResources().getString(R.string.bucharest), R.drawable.bucharest, getResources().getString(R.string.universal_description)));
        cities.add(new City(8, getResources().getString(R.string.bratislava), R.drawable.bratislava, getResources().getString(R.string.universal_description)));
        cities.add(new City(9, getResources().getString(R.string.ljubljana), R.drawable.ljubljana, getResources().getString(R.string.universal_description)));
        cities.add(new City(0, getResources().getString(R.string.bern), R.drawable.bern, getResources().getString(R.string.universal_description)));
        Collections.sort(cities);
    }

    private void addSights() {
        sights = new ArrayList<>();
        sights.add(new Sight(0, 0, getResources().getString(R.string.schonbrunn_palace), R.drawable.schonbrunn_palace, getResources().getString(R.string.universal_description)));
        sights.add(new Sight(1, 1, getResources().getString(R.string.saint_michael_cathedral), R.drawable.saint_michael_catherdral, getResources().getString(R.string.universal_description)));
        sights.add(new Sight(2, 2, getResources().getString(R.string.charles_bridge), R.drawable.charles_bridge, getResources().getString(R.string.universal_description)));
        sights.add(new Sight(3, 3, getResources().getString(R.string.berlin_wall), R.drawable.berlin_wall, getResources().getString(R.string.universal_description)));
        sights.add(new Sight(4, 4, getResources().getString(R.string.szechenyi_thermal_bath), R.drawable.schezenyi_thermal_bath, getResources().getString(R.string.universal_description)));
        sights.add(new Sight(5, 5, getResources().getString(R.string.notre_dame_cathedral), R.drawable.notre_dame_cathedral, getResources().getString(R.string.universal_description)));
        sights.add(new Sight(6, 6, getResources().getString(R.string.wawel), R.drawable.wawel, getResources().getString(R.string.universal_description)));
        Collections.sort(sights);
        }

    //endregion Lists

    //endregion Private methods

}
