package com.example.adam.touristguide;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adam.touristguide.Objects.City;
import com.example.adam.touristguide.Objects.Country;
import com.example.adam.touristguide.Objects.Sight;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    //region Overrides

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setToolbar();
    }

    //endregion Overrides

    //region Private methods

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        whichOne();
    }


    private void whichOne() {
        Intent intent = getIntent();
        Country country = intent.getParcelableExtra("country");
        City city = intent.getParcelableExtra("city");
        Sight sight = intent.getParcelableExtra("sight");
        ImageView background = findViewById(R.id.toolbar_background);
        TextView heading = findViewById(R.id.detail_heading);
        TextView description = findViewById(R.id.detail_text);

        if (country != null) {
            getSupportActionBar().setTitle(country.getName());
            heading.setVisibility(View.GONE);
            description.setText(country.getDescription());
        } else if (city != null) {
            heading.setText(city.getName());
            background.setImageResource(city.getPhoto());
            description.setText(city.getDescription());
        } else if (sight != null) {
            heading.setText(sight.getName());
            background.setImageResource(sight.getPhoto());
            description.setText(sight.getDesctiption());
        } else {
            Log.e("My error: ", "Something went wrong during " +
                    "sending parcelable object to DetailActivity");
        }
    }

    //endregion Private methods

}
