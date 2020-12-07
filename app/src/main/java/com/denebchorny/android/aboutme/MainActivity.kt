package com.denebchorny.android.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.denebchorny.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Deneb Chorny")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.btnDone.setOnClickListener { onDoneClicked(it) }
    }

    private fun onDoneClicked(view: View) {
        if (binding.etNickName.text.isNullOrEmpty()) return

        binding.apply {
            //tvNickname.text = binding.etNickName.text

            myName?.nickname = etNickName.text.toString()

            invalidateAll()

            btnDone.visibility = GONE
            etNickName.visibility = GONE
            tvNickname.visibility = VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}