package com.example.kiemtralan2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtTenCongViec = findViewById<EditText>(R.id.edtTenCongViec)
        val edtMoTaCongViec = findViewById<EditText>(R.id.edtMoTaCongViec)
        val btnTaoCongViec = findViewById<Button>(R.id.btnTaoCongViec)

        btnTaoCongViec.setOnClickListener {
            val intent = Intent(this, ChiTietCongViecActivity::class.java)
            intent.putExtra("ten_cong_viec", edtTenCongViec.text.toString())
            intent.putExtra("mo_ta", edtMoTaCongViec.text.toString())
            startActivity(intent)
        }
    }
}