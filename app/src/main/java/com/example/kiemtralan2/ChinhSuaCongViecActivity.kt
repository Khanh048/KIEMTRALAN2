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

        val edtTenMoi = findViewById<EditText>(R.id.edtTenMoi)
        val edtMoTaMoi = findViewById<EditText>(R.id.edtMoTaMoi)
        edtTenMoi.setText(intent.getStringExtra("ten_cong_viec"))
        edtMoTaMoi.setText(intent.getStringExtra("mo_ta"))

        findViewById<Button>(R.id.btnLuu).setOnClickListener {
            val ketQua = Intent()
            ketQua.putExtra("ten_cong_viec", edtTenMoi.text.toString())
            ketQua.putExtra("mo_ta", edtMoTaMoi.text.toString())
            setResult(RESULT_OK, ketQua)
            finish()
        }
    }
}
