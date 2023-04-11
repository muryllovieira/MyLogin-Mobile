package br.senai.sp.jandira.mylogin

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mylogin.components.BottomShape
import br.senai.sp.jandira.mylogin.components.TopShape
import br.senai.sp.jandira.mylogin.model.User
import br.senai.sp.jandira.mylogin.repository.UserRepository
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

    var userNameState by remember {
        mutableStateOf("")
    }

    var phoneState by remember {
        mutableStateOf("")
    }

    var emailState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    var over18State by remember {
        mutableStateOf(false)
    }

    var context = LocalContext.current

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
            Spacer(modifier = Modifier.height(10.dp))

            //Form
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 17.dp, end = 17.dp)
                    .verticalScroll(rememberScrollState())
                    .weight(weight = 1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up),
                    fontSize = 32.sp,
                    color = Color(207, 6, 240),
                    fontWeight = FontWeight(700)
                )
                Text(
                    text = stringResource(id = R.string.create_new),
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier.size(100.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .align(alignment = Alignment.TopEnd),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 1.dp,
                            Brush.horizontalGradient(
                                colors = listOf(Color(207, 6, 240), Color.White)
                            )
                        )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            colorFilter = ColorFilter.tint(color = Color(207, 6, 240))
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.photo_camera),
                        contentDescription = null,
                        modifier = Modifier
                            .align(alignment = Alignment.BottomEnd)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = userNameState,
                    onValueChange = { userNameState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = stringResource(id = R.string.username)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "",
                            tint = Color(207, 6, 240)
                        )
                    })
                Spacer(modifier = Modifier.height(31.dp))
                OutlinedTextField(value = phoneState,
                    onValueChange = { phoneState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(text = stringResource(id = R.string.phone)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_phone_android_24),
                            contentDescription = "",
                            tint = Color(207, 6, 240)
                        )
                    })
                Spacer(modifier = Modifier.height(31.dp))
                OutlinedTextField(value = emailState,
                    onValueChange = { emailState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
                    visualTransformation = PasswordVisualTransformation(),
                    label = { Text(text = stringResource(id = R.string.password)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_https_24),
                            contentDescription = "",
                            tint = Color(207, 6, 240)
                        )
                    })
                Spacer(modifier = Modifier.height(21.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start
                ) {
                    Row() {
                        Checkbox(checked = over18State, onCheckedChange = { over18State = it })
                        Row(Modifier.padding(top = 14.dp)) {
                            Text(stringResource(id = R.string.over_18))
                        }
                    }

                }
                Spacer(modifier = Modifier.height(31.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End
                ) {
                    Button(
                        onClick = {
                            userSave(
                                context,
                                emailState,
                                userNameState,
                                phoneState,
                                passwordState,
                                over18State
                            )
                        },
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(Color(207, 6, 240))
                    ) {
                        Text(
                            text = stringResource(id = R.string.create_account).uppercase(),
                            color = Color.White
                        )
                    }
                }
                Spacer(modifier = Modifier.height(31.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End
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
                BottomShape()
            }

        }
    }
}

fun userSave(
    context: Context,
    email: String,
    userName: String,
    phone: String,
    password: String,
    isOver: Boolean
) {
    val userRepository = UserRepository(context)

    //Recuperando no banco um usuario que tenha o email informado
    var user = userRepository.findUserByEmail(email)

    // Se user for null, gravamos o novo usuario
    // senão avisamos que o usuario já existe.
    if (user == null) {
        val newUser = User(
            userName = userName,
            phone = phone,
            email = email,
            password = password,
            isOver18 = isOver
        )
        val id = userRepository.save(newUser)
        Toast.makeText(
            context,
            "User created #$id",
            Toast.LENGTH_LONG
        ).show()
    } else {
        Toast.makeText(
            context,
            "User already exists!!",
            Toast.LENGTH_SHORT
        ).show()
    }
}
