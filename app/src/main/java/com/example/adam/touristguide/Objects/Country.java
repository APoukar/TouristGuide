package com.example.adam.touristguide.Objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.concurrent.atomic.AtomicInteger;

public class Country implements Parcelable, Comparable<Country> {

    //region Properties

    private static AtomicInteger uniqueId = new AtomicInteger();
    private int id;
    private String name;
    private int flag;
    private String description;

    //endregion Properties

    //region Ctor

    public Country(String name, int flag, String description) {
        this.id = uniqueId.getAndIncrement();
        this.name = name;
        this.flag = flag;
        this.description = description;
    }

    protected Country(Parcel in) {
        id = in.readInt();
        name = in.readString();
        flag = in.readInt();
        description = in.readString();
    }

    //endregion Ctor

    //region Public Methods

    //region Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFlag() {
        return flag;
    }

    public String getDescription() {
        return description;
    }

    //endregion Getters

    //region Parcelable

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getId());
        parcel.writeString(getName());
        parcel.writeInt(getFlag());
        parcel.writeString(getDescription());
    }

    //endregion Parcelable

    @Override
    public int compareTo(@NonNull Country country) {
        return this.getName().compareTo(country.getName());
    }

    //endregion Public Methods

}
