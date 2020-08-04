package com.binar.cc_intent_fragment_permission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_halaman_menu.*
import java.time.Instant

class HalamanMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_menu)
        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        val bundle = intent.extras
        val name = bundle?.getString("name")
        tvSentNama.setText(name)

        ivLogo.setOnClickListener {
            val intent = Intent(this,PemainVsKomputer::class.java)
            startActivity(intent)
        }
    }
}