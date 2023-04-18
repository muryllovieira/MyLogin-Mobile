package br.senai.sp.jandira.mylogin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mylogin.components.BottomShape
import br.senai.sp.jandira.mylogin.components.TopShape
import br.senai.sp.jandira.mylogin.repository.UserRepository
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

    val context = LocalContext.current

    var emailState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    var passwordVisibilityState by remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
            ) {
                TopShape()
            }
            Spacer(modifier = Modifier.height(110.dp))

            //Form
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(17.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.title_login),
                    fontSize = 48.sp,
                    color = Color.Magenta,
                    fontWeight = FontWeight(700)
                )
                Text(
                    text = stringResource(id = R.string.subtitle_login),
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(87.dp))
                OutlinedTextField(value = emailState,
                    onValueChange = { emailState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = stringResource(id = R.string.email)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = "",
                            tint = Color(207, 6, 240)
                        )
                    })
                Spacer(modifier = Modifier.height(31.dp))
                OutlinedTextField(value = passwordState,
                    onValueChange = { passwordState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    visualTransformation = if(!passwordVisibilityState) PasswordVisualTransformation() else VisualTransformation.None,
                    label = { Text(text = stringResource(id = R.string.password)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_https_24),
                            contentDescription = "",
                            tint = Color(207, 6, 240)
                        )
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                passwordVisibilityState = !passwordVisibilityState
                            }
                        ) {
                            Icon(
                                imageVector = if (passwordVisibilityState) {
                                    Icons.Default.VisibilityOff
                                } else {
                                    Icons.Default.Visibility
                                },
                                contentDescription = null
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(31.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End
                ) {
                    Button(
                        onClick = {
                            authenticate(emailState, passwordState, context)
                        },
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .height(48.dp)
                            .width(134.dp),
                        colors = ButtonDefaults.buttonColors(Color(207, 6, 240))
                    ) {
                        Text(
                            text = stringResource(id = R.string.sign_in).uppercase(),
                            color = Color.White
                        )
                        Icon(
                            painter = painterResource(
                                id = R.drawable.baseline_arrow_forward_24
                            ), tint = Color.White, contentDescription = ""
                        )
                    }
                }
                Spacer(modifier = Modifier.height(31.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = stringResource(id = R.string.have_account))
                        Row(
                            modifier = Modifier.padding(start = 3.dp)
                        ) {
                            TextButton(onClick = {
                                var openSignUp = Intent(context, SignUpActivity::class.java)
                                context.startActivity(openSignUp)
                            }) {
                                Text(
                                    text = stringResource(id = R.string.sign_up),
                                    color = Color(207, 6, 240)
                                )
                            }
                        }
                    }
                }

            }
            //Spacer(modifier = Modifier.height(140.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start
            ) {
                BottomShape()
            }

        }
    }
}

fun authenticate(email: String, password: String, context: Context) {
    val userRepository = UserRepository(context)
    val user = userRepository.authenticate(email, password)

    if (user != null) {
        val openHome = Intent(context, HomeActivity::class.java)
        context.startActivity(openHome)
    }
}




