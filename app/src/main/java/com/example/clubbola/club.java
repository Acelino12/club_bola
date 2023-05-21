package com.example.clubbola;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class club implements Parcelable {

    private String name;
    private String detail;
    private int photo;

    public club(){

    }

    protected club(Parcel in) {
        name = in.readString();
        detail = in.readString();
        photo = in.readInt();
    }

    public static final Creator<club> CREATOR = new Creator<club>() {
        @Override
        public club createFromParcel(Parcel in) {
            return new club(in);
        }

        @Override
        public club[] newArray(int size) {
            return new club[size];
        }
    };

    public String getName() { return name; }

    public void setName(String name) { this.name = name;}

    public String getDetail() { return detail; }

    public void setDetail(String detail) { this.detail = detail; }

    public int getPhoto() { return photo; }

    public void setPhoto(int photo) { this.photo = photo;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(detail);
        dest.writeInt(photo);
    }
}
