package com.sinau.masrobot.dicodingintent

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * File hasil belajar dari materi Dicoding "Belajar Membuat Aplikasi Android untuk Pemula"
     * Topik yang dipelajari adalah "Intent"
     * Link Kelas Dicoding s.id/LgC
     */

    var REQUEST_CODE: Int = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_move_activity.setOnClickListener {
            val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
            startActivity(moveIntent)
        }

        btn_move_activity_data.setOnClickListener {
            val moveWithDataIntent = Intent(this@MainActivity,
                    MoveWithDataActivity::class.java)
            moveWithDataIntent.putExtra(MoveWithDataActivity().EXTRA_NAME,
                    "DicodingAcademy Gan!!")
            moveWithDataIntent.putExtra(MoveWithDataActivity().EXTRA_AGE, 5)
            startActivity(moveWithDataIntent)
        }

        btn_dial_number.setOnClickListener {
            val phoneNumber: String = "123"
            val dialPhoneIntent = Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel: ${phoneNumber}"))
            startActivity(dialPhoneIntent)
        }

        btn_move_activity_object.setOnClickListener {
            val mPerson = Person("DicodingAcademy", 5, "Academy@dicoding.com",
                    "Bandung")
            val moveWithObjectIntent = Intent(this@MainActivity,
                    MoveWithObjectActivity::class.java)
            moveWithObjectIntent.putExtra(MoveWithObjectActivity().EXTRA_PERSON, mPerson)
            startActivity(moveWithObjectIntent)
        }
        btn_move_for_result.setOnClickListener {
            val moveForResultIntent = Intent(this@MainActivity,
                    MoveForResultActivity::class.java)

            startActivityForResult(moveForResultIntent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity().RESULT_CODE) {
                val selectedValue = data?.getIntExtra(MoveForResultActivity().EXTRA_SELECTED_VALUE, 0)
                tv_result.text = "Hasil ${selectedValue}"
            }
        }
    }
}
