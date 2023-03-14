package br.senai.sp.jandira.mylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mylogin.ui.theme.MyLoginTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                SignUp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUp() {
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
                        .width(120.dp)
                        .height(40.dp),
                    color = Color.Magenta,
                    shape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 15.dp)
                ) {

                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            //Form
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(17.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up),
                    fontSize = 32.sp,
                    color = Color.Magenta,
                    fontWeight = FontWeight(700)
                )
                Text(
                    text = stringResource(id = R.string.create_new), fontSize = 14.sp, color = Color.Gray
                )
                Spacer(modifier = Modifier.height(31.dp))
                OutlinedTextField(
                    value = "Susanna Hoffs",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = stringResource(id = R.string.username)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "",
                            tint = Color(207, 6, 240)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(31.dp))
                OutlinedTextField(
                    value = "99999-9999",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = stringResource(id = R.string.phone)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_phone_android_24),
                            contentDescription = "",
                            tint = Color(207, 6, 240)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(31.dp))
                OutlinedTextField(
                    value = "TESTE@GMAIL.COM",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = stringResource(id = R.string.email)) },
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
                    label = { Text(text = stringResource(id = R.string.password)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_https_24),
                            contentDescription = "",
                            tint = Color(207, 6, 240)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(21.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row() {
                        Checkbox(checked = false, onCheckedChange = {})
                        Row(Modifier.padding(top = 14.dp)) {
                            Text(stringResource(id = R.string.over_18))
                        }
                    }

                }
                Spacer(modifier = Modifier.height(31.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) { 
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(Color(207, 6, 240))
                    ) {
                        Text(text = stringResource(id = R.string.create_account).uppercase(), color = Color.White)
                    }
                }
                Spacer(modifier = Modifier.height(31.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Row() {
                        Text(text = stringResource(id = R.string.already_have_account))
                        Row(
                            modifier = Modifier.padding(start = 3.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.sign_in),
                                color = Color(207, 6, 240)
                            )
                        }
                    }
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start
            ) {
                Surface(
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp),
                    color = Color.Magenta,
                    shape = RoundedCornerShape(0.dp, 15.dp, 0.dp, 0.dp)
                ) {

                }
            }

        }
    }
}