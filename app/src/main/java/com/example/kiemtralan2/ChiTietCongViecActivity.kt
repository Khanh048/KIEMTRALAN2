package com.example.kiemtralan2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChiTietCongViecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chi_tiet_cong_viec)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tenCongViec = intent.getStringExtra("ten_cong_viec") ?: ""
        val moTa = intent.getStringExtra("mo_ta") ?: ""

        findViewById<TextView>(R.id.tvTenCongViec).text = tenCongViec
        findViewById<TextView>(R.id.tvMoTaCongViec).text = moTa
    }
}