package br.senai.sp.jandira.mylogin.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mylogin.R
import br.senai.sp.jandira.mylogin.model.Product

class ProductRepository {

    companion object {

        @Composable
        fun getProductList(): List<Product> {

            return listOf<Product>(
                Product(
                    id = 1,
                    name = "Montain",
                    image = painterResource(id = R.drawable.montain)
                ),
                Product(
                    id = 2,
                    name = "Snow",
                    image = painterResource(id = R.drawable.snow)
                ),
                Product(
                    id = 3,
                    name = "Beach",
                    image = painterResource(id = R.drawable.beach)
                ),
//               Product(
//                   id = 4,
//                   name = "Beach",
//                   image = painterResource(id = R.drawable.baseline_email_24)
//               )
            )
        }
    }
}