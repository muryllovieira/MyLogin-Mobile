package br.senai.sp.jandira.mylogin

import android.location.LocationRequest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mylogin.model.Location
import br.senai.sp.jandira.mylogin.model.Product
import br.senai.sp.jandira.mylogin.repository.ProductRepository
import br.senai.sp.jandira.mylogin.ui.theme.ui.theme.MyLoginTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                Home(ProductRepository.getProductList())
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Home(
    product: List<Product>,
) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "", tint = Color.White)
        }
    }) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column() {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    backgroundColor = Color(207, 6, 240),
                    shape = RectangleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.paris),
                        contentDescription = "logo",
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    text = stringResource(id = R.string.categories),
                    modifier = Modifier.padding(top = 14.dp, start = 16.dp)
                )
                LazyRow() {
                    items(product) {
                        Card(
                            modifier = Modifier
                                .size(
                                    110.dp,
                                    80.dp,
                                )
                                .padding(4.dp), backgroundColor = Color(207, 6, 240)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Spacer(modifier = Modifier.height(8.dp))
                                Icon(
                                    painter = it.image!!,
                                    contentDescription = "",
                                    modifier = Modifier.size(32.dp),
                                    tint = Color.White
                                )
                                Text(text = "${it.name}", color = Color.White)

                            }
                        }

                    }

                }

            }
        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MyLoginTheme {
        Home(
            ProductRepository.getProductList()
        )
    }
}

