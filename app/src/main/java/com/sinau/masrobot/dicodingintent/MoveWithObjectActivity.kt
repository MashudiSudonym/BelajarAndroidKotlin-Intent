package com.sinau.masrobot.dicodingintent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_move_with_object.*

class MoveWithObjectActivity : AppCompatActivity() {

    var EXTRA_PERSON: String = "extra_person"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        var mPerson = intent.getParcelableExtra<Person>(EXTRA_PERSON)
        val text: String = "Name : ${mPerson?.name}, Email : ${mPerson?.email}, Age : ${mPerson?.age}, " +
                "Location : ${mPerson?.city}"
        tv_object_received.text = text
    }
}
