package com.peter.changeactivity

import android.os.Parcel
import android.os.Parcelable

data class SimpleData(var number: Int, var message: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString()) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest!!.writeInt(number)
        dest.writeString(message)
    }

    companion object CREATOR : Parcelable.Creator<SimpleData> {
        override fun createFromParcel(parcel: Parcel): SimpleData {
            return SimpleData(parcel)
        }

        override fun newArray(size: Int): Array<SimpleData?> {
            return arrayOfNulls(size)
        }
    }
}