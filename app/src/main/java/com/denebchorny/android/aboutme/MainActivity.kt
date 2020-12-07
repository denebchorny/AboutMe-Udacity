package com.denebchorny.android.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var btnDone: Button
    lateinit var etNickName: EditText
    lateinit var tvNickName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDone = findViewById(R.id.btnDone)
        etNickName = findViewById(R.id.etNickName)
        tvNickName = findViewById(R.id.tvNickname)

        btnDone.setOnClickListener { onDoneClicked(it) }
    }

    private fun onDoneClicked(view: View) {
        if(etNickName.text.isNullOrEmpty()) return

        view.visibility = GONE
        etNickName.visibility = GONE
        tvNickName.visibility = VISIBLE

        tvNickName.text = etNickName.text

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}