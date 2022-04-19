package com.example.mybadapplication.lodem

import android.os.Parcel
import android.os.Parcelable

class Rush(private var age: Int, private var name: String?) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun toString(): String {
        return "Rush{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}'
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(age)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Rush> {
        override fun createFromParcel(parcel: Parcel): Rush {
            return Rush(parcel)
        }

        override fun newArray(size: Int): Array<Rush?> {
            return arrayOfNulls(size)
        }
    }


}