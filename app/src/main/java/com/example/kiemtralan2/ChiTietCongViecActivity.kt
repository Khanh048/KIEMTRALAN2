package com.example.kiemtralan2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvTenCongViec: TextView
    private lateinit var tvMoTaCongViec: TextView

    private val trinhMoChinhSua = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { ketQua ->
        if (ketQua.resultCode == RESULT_OK) {
            tvTenCongViec.text = ketQua.data?.getStringExtra("ten_cong_viec") ?: ""
            tvMoTaCongViec.text = ketQua.data?.getStringExtra("mo_ta") ?: ""
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chi_tiet_cong_viec)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvTenCongViec = findViewById(R.id.tvTenCongViec)
        tvMoTaCongViec = findViewById(R.id.tvMoTaCongViec)

        tvTenCongViec.text = intent.getStringExtra("ten_cong_viec") ?: ""
        tvMoTaCongViec.text = intent.getStringExtra("mo_ta") ?: ""

        findViewById<Button>(R.id.btnChinhSua).setOnClickListener {
            val intentChinhSua = Intent(this, ChinhSuaCongViecActivity::class.java)
            intentChinhSua.putExtra("ten_cong_viec", tvTenCongViec.text.toString())
            intentChinhSua.putExtra("mo_ta", tvMoTaCongViec.text.toString())
            trinhMoChinhSua.launch(intentChinhSua)
        }
    }
}