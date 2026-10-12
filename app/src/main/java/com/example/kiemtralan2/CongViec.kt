package com.example.kiemtralan2

import java.io.Serializable

class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false,
    var maCongViec: String = ""
) : Serializable {

    fun laDaHoanThanh(): Boolean {
        return trangThai
    }

    fun layThongTin(): String {
        val chuoiTrangThai = if (laDaHoanThanh()) "Đã hoàn thành" else "Chưa hoàn thành"
        return "Mã: $maCongViec\nCông việc: $tenCongViec\nMô tả: $moTa\nTrạng thái: $chuoiTrangThai"
    }
}