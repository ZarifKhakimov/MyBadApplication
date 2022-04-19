package com.example.mybadapplication.lodem

import android.os.Parcel
import android.os.Parcelable

class Crush(private var version: Double, private var update: String?) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readString()
    ) {
    }

    override fun toString(): String {
        return "Crush{" +
                "version=" + version +
                ", update='" + update + '\'' +
                '}'
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(version)
        parcel.writeString(update)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Crush> {
        override fun createFromParcel(parcel: Parcel): Crush {
            return Crush(parcel)
        }

        override fun newArray(size: Int): Array<Crush?> {
            return arrayOfNulls(size)
        }
    }

}