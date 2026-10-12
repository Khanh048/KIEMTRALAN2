package com.example.kiemtralan2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        val congViec = intent.getSerializableExtra("cong_viec") as? CongViec ?: CongViec("", "")
        val edtTenMoi = findViewById<EditText>(R.id.edtTenMoi)
        val edtMoTaMoi = findViewById<EditText>(R.id.edtMoTaMoi)
        edtTenMoi.setText(congViec.tenCongViec)
        edtMoTaMoi.setText(congViec.moTa)

        findViewById<Button>(R.id.btnLuu).setOnClickListener {
            val capNhat = CongViec(
                edtTenMoi.text.toString(),
                edtMoTaMoi.text.toString(),
                congViec.trangThai
            )
            val ketQua = Intent()
            ketQua.putExtra("cong_viec", capNhat)
            setResult(RESULT_OK, ketQua)
            finish()
        }
    }
}