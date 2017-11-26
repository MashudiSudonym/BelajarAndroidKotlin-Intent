package com.sinau.masrobot.dicodingintent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_move_with_data.*


class MoveWithDataActivity : AppCompatActivity() {

    var EXTRA_AGE: String = "extra_age"
    var EXTRA_NAME: String = "extra_name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        val text = "Name : $name, Your Age : $age"
        tv_data_received.text = text
    }
}
