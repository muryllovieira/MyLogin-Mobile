package br.senai.sp.jandira.mylogin.model

import android.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter

data class Location (
    var id: Int = 0,
    var image: Painter? = null,
    var name: String = "",
    var year: String = "",
    var description: String = "",
    var data_start_final: String = ""
        ){
}