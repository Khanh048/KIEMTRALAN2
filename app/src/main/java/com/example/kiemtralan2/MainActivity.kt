package com.example.kiemtralan2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
        val btnXemDanhSach = findViewById<Button>(R.id.btnXemDanhSach)

        btnTaoCongViec.setOnClickListener {
            val tenCongViec = edtTenCongViec.text.toString().trim()
            if (tenCongViec.isEmpty()) {
                edtTenCongViec.error = "Tên công việc không được để trống"
                return@setOnClickListener
            }
            val congViec = CongViec(tenCongViec, edtMoTaCongViec.text.toString())
            val intent = Intent(this, ChiTietCongViecActivity::class.java)
            intent.putExtra("cong_viec", congViec)
            startActivity(intent)
        }

        btnXemDanhSach.setOnClickListener {
            Toast.makeText(this, "Danh sách công việc đang được phát triển", Toast.LENGTH_SHORT).show()
        }
    }
}