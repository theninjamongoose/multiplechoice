package com.example.tank.testingfirstapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tank on 6/20/16.
 */
public class Answer implements Parcelable {
    private String text;
    private boolean isSelected;
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Answer(){}

    private Answer(Parcel in){
        this.text = in.readString();
        this.isSelected = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Answer> CREATOR
            = new Parcelable.Creator<Answer>() {
        public Answer createFromParcel(Parcel in) {
            return new Answer(in);
        }

        public Answer[] newArray(int size) {
            return new Answer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}