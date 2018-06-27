package com.example.adam.touristguide.Objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.concurrent.atomic.AtomicInteger;

public class City implements Parcelable, Comparable<City> {

    //region Properties

    private static AtomicInteger uniqueId = new AtomicInteger();
    private int id;
    private int countryId;
    private String name;
    private  int photo;
    private String description;

    //endregion Properties

    //region Ctor

    public City(int countryId, String name, int sign, String description) {
        this.id = uniqueId.getAndIncrement();
        this.countryId = countryId;
        this.name = name;
        this.photo = sign;
        this.description = description;
    }

    protected City(Parcel in) {
        id = in.readInt();
        countryId = in.readInt();
        name = in.readString();
        photo = in.readInt();
        description = in.readString();
    }

    //endregion Ctor

    //region Public methods

    //region Getters

    public int getId() {
        return id;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getName() {
        return name;
    }

    public int getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    //endregion Getters


    //region Parcelable

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getId());
        parcel.writeInt(getCountryId());
        parcel.writeString(getName());
        parcel.writeInt(getPhoto());
        parcel.writeString(getDescription());
    }

    //endregion Parcelable

    @Override
    public int compareTo(@NonNull City o) {
        return this.getName().compareTo(o.getName());
    }

    //endregion Public methods
}
