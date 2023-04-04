package br.senai.sp.jandira.mylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mylogin.ui.theme.ui.theme.MyLoginTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                Home()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Home() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.paris),
                    contentDescription = ""
                )
                Column(
                    modifier = Modifier
                        .height(220.dp)
                        .padding(15.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.susanna_profile),
                            contentDescription = "",
                            modifier = Modifier
                                .size(61.dp)
                                .border(BorderStroke(4.dp, Color.White), CircleShape)
                                .padding(4.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Text(text = "Susanna Hoffs", color = Color.White)
                    Spacer(modifier = Modifier.height(51.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Row() {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_location_on_24),
                                contentDescription = "",
                                tint = Color.White
                            )
                            Text(text = "You're in Paris", color = Color.White)
                        }
                        Column(modifier = Modifier.padding(start = 24.dp)) {
                            Text(
                                text = "My Trips",
                                color = Color.White,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }


                    }
                }
                Spacer(modifier = Modifier.height(13.dp))

                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column() {
                                Text(
                                    text = "Categories:",
                                    modifier = Modifier
                                        .padding(start = 17.dp)
                                )
                                Spacer(modifier = Modifier.height(7.dp))
                                LazyRow(
                                    modifier = Modifier
                                        .padding(start = 19.dp)
                                ) {
                                    items(products) { product ->
                                        Card(
                                            modifier = Modifier
                                                .width(109.dp) //width 125 e height 75 modificados para se adequar a tela(tamanho não está igual do figma)
                                                .height(64.dp),
                                            backgroundColor = colorResource(id = R.color.pink_login)

                                        ) {
                                            Column(
                                                modifier = Modifier.fillMaxSize().padding(8.dp),
                                                verticalArrangement = Arrangement.Center,
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                Icon(
                                                    painter = product.image ?: painterResource(
                                                        id = R.drawable.baseline_lock_24
                                                    ),
                                                    contentDescription = "",
                                                    modifier = Modifier
                                                        .width(32.dp)
                                                        .height(32.dp),
                                                    tint = Color.White
                                                )
                                                Text(
                                                    text = product.name,
                                                    color = Color.White,
                                                    fontSize = 14.sp
                                                )
                                            }
                                        }
                                        Spacer(modifier = Modifier.width(8.dp))
                                    }
                                }

                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            OutlinedTextField(
                                value = "",
                                onValueChange = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 16.dp,
                                        end = 17.dp
                                    ),
                                shape = RoundedCornerShape(16.dp),
                                label = {
                                    Text(text = "Search your destinity")
                                },
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(
                                            id = R.drawable.baseline_search_24
                                        ),
                                        contentDescription = "",
                                        tint = Color.Gray
                                    )
                                }


                            )
                        }
            }
        }
    }
}