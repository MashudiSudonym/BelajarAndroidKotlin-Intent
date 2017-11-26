package com.sinau.masrobot.dicodingintent

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by masrobot on 26/11/17.
 */
class Person(
        var name: String,
        var age: Int,
        var email: String,
        var city: String) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int,
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeValue(age)
        writeString(email)
        writeString(city)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Person> = object : Parcelable.Creator<Person> {
            override fun createFromParcel(source: Parcel): Person = Person(source)
            override fun newArray(size: Int): Array<Person?> = arrayOfNulls(size)
        }
    }
}