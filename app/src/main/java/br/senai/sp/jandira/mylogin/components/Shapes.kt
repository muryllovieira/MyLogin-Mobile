package br.senai.sp.jandira.mylogin.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopShape() {

    Card(
        modifier = Modifier
            .width(120.dp)
            .height(40.dp),
        backgroundColor = Color(207, 6, 240),
        shape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 15.dp)
    ) {
    }

}

@Preview
@Composable
fun TopShapePreview() {
    TopShape()
}

@Composable
fun BottomShape() {

    Card(
        modifier = Modifier
            .width(120.dp)
            .height(40.dp),
        backgroundColor = Color(207, 6, 240),
        shape = RoundedCornerShape(0.dp, 15.dp, 0.dp, 0.dp)
    ) {

    }


}

@Preview
@Composable
fun BottomShapePreview() {
    BottomShape()
}