package br.senai.sp.jandira.mylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mylogin.ui.theme.MyLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                Login()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Login() {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
            ) {
                Surface(
                    modifier = Modifier
                        .width(140.dp)
                        .height(50.dp),
                    color = Color.Magenta,
                    shape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 15.dp)
                ) {

                }
            }
            Spacer(modifier = Modifier.height(110.dp))

            //Form
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(17.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 48.sp,
                    color = Color.Magenta,
                    fontWeight = FontWeight(700)
                )
                Text(
                    text = "Please sign in to continue.", fontSize = 14.sp, color = Color.Gray
                )
                Spacer(modifier = Modifier.height(87.dp))
                OutlinedTextField(
                    value = "TESTE@GMAIL.COM",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = "Email") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = "",
                            tint = Color(207, 6, 240)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(31.dp))
                OutlinedTextField(
                    value = "*********",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = "Password") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_https_24),
                            contentDescription = "",
                            tint = Color(207, 6, 240)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(31.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .height(48.dp)
                            .width(134.dp),
                        colors = ButtonDefaults.buttonColors(Color(207, 6, 240))
                    ) {
                        Text(text = "SIGN IN", color = Color.White)
                        Icon(
                            painter = painterResource(
                                id = R.drawable.baseline_arrow_forward_24
                            ),
                            tint = Color.White,
                            contentDescription = ""
                        )
                    }
                }
                Spacer(modifier = Modifier.height(31.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Row() {
                        Text(text = "Don't have an account?")
                        Row() {
                            Text(
                                text = " Sign up",
                                color = Color(207, 6, 240)
                            )
                        }
                    }
                }

            }
            //Spacer(modifier = Modifier.height(140.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start
            ) {
                Surface(
                    modifier = Modifier
                        .width(140.dp)
                        .height(50.dp),
                    color = Color.Magenta,
                    shape = RoundedCornerShape(0.dp, 15.dp, 0.dp, 0.dp)
                ) {

                }
            }

        }
    }
}




