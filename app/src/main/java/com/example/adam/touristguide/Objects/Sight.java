package com.example.adam.touristguide.Objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.concurrent.atomic.AtomicInteger;

public class Sight implements Parcelable, Comparable<Sight> {

    //region Properties

    private static AtomicInteger uniqueId = new AtomicInteger();
    private int id;
    private int countryId;
    private int cityId;
    private String name;
    private int photo;
    private String desctiption;

    //endregion Properties

    //region Ctor

    public Sight(int countryId, int cityId, String name, int photo, String desctiption) {
        this.id = uniqueId.getAndIncrement();
        this.countryId = countryId;
        this.cityId = cityId;
        this.name = name;
        this.photo = photo;
        this.desctiption = desctiption;
    }

    protected Sight(Parcel in) {
        id = in.readInt();
        countryId = in.readInt();
        cityId = in.readInt();
        name = in.readString();
        photo = in.readInt();
        desctiption = in.readString();
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

    public int getCityId() {
        return cityId;
    }

    public String getName() {
        return name;
    }

    public int getPhoto() {
        return photo;
    }

    public String getDesctiption() {
        return desctiption;
    }

    //endregion Setters

    //region Parcelable

    public static final Creator<Sight> CREATOR = new Creator<Sight>() {
        @Override
        public Sight createFromParcel(Parcel in) {
            return new Sight(in);
        }

        @Override
        public Sight[] newArray(int size) {
            return new Sight[size];
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
        parcel.writeInt(getCityId());
        parcel.writeString(getName());
        parcel.writeInt(getPhoto());
        parcel.writeString(getDesctiption());
    }

    //endregion Parcelable

    @Override
    public int compareTo(@NonNull Sight sight) {
        return this.getName().compareTo(sight.getName());
    }

    //endregion Public methods

}
