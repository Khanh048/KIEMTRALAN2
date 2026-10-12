package com.example.kiemtralan2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvMaCongViec: TextView
    private lateinit var tvTenCongViec: TextView
    private lateinit var tvMoTaCongViec: TextView
    private lateinit var tvThongTin: TextView
    private lateinit var tvTrangThai: TextView
    private lateinit var congViec: CongViec

    private val trinhMoChinhSua = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { ketQua ->
        if (ketQua.resultCode == RESULT_OK) {
            val congViecMoi = ketQua.data?.getSerializableExtra("cong_viec") as? CongViec
            if (congViecMoi != null) {
                congViec = congViecMoi
                hienThi()
            }
        }
    }

    private fun hienThi() {
        tvMaCongViec.text = "Mã công việc: ${congViec.maCongViec}"
        tvTenCongViec.text = congViec.tenCongViec
        tvMoTaCongViec.text = congViec.moTa
        tvThongTin.text = congViec.layThongTin()
        tvTrangThai.text = if (congViec.laDaHoanThanh()) {
            "Trạng thái: Đã hoàn thành"
        } else {
            "Trạng thái: Chưa hoàn thành"
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

        tvMaCongViec = findViewById(R.id.tvMaCongViec)
        tvTenCongViec = findViewById(R.id.tvTenCongViec)
        tvMoTaCongViec = findViewById(R.id.tvMoTaCongViec)
        tvThongTin = findViewById(R.id.tvThongTin)
        tvTrangThai = findViewById(R.id.tvTrangThai)

        congViec = intent.getSerializableExtra("cong_viec") as? CongViec ?: CongViec("", "")
        hienThi()

        val btnHoanThanh = findViewById<Button>(R.id.btnHoanThanh)
        btnHoanThanh.setOnClickListener {
            if (congViec.laDaHoanThanh()) {
                Toast.makeText(this, "Công việc đã hoàn thành rồi", Toast.LENGTH_SHORT).show()
            } else {
                congViec.trangThai = true
                hienThi()
                Toast.makeText(this, "Đã cập nhật trạng thái hoàn thành", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btnChinhSua).setOnClickListener {
            val intentChinhSua = Intent(this, ChinhSuaCongViecActivity::class.java)
            intentChinhSua.putExtra("cong_viec", congViec)
            trinhMoChinhSua.launch(intentChinhSua)
        }
    }
}