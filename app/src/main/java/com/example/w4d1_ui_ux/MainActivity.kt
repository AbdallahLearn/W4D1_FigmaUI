package com.example.w4d1_ui_ux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.w4d1_ui_ux.ui.theme.W4D1_UI_UXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            W4D1_UI_UXTheme {
                setContent(){
                    Ui()
                }
            }
        }
    }
}

@Composable
fun Ui(){

    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier.background(Color.White)
            .fillMaxSize()

    ){
        Box( // Box wraps the navigation bar to apply background color
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black) // Set background to black
                .padding(vertical = 16.dp)
                .padding(top = 0.dp)

        )
        // Movie Image

        Image(
            painter = painterResource(id = R.drawable.elm), // Replace with your logo
            contentDescription = "App Logo",
            modifier = Modifier
                .fillMaxWidth(0.4f)  // Reduce the width to 40% of the screen
                .height(150.dp)      // Reduce the height
                .align(Alignment.CenterHorizontally)
                .padding(top = 14.dp),
            contentScale = ContentScale.Fit  // Ensures the image fits within the bounds
        )

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color(0xFF0070B8))) { append("E") }
                withStyle(style = SpanStyle(color = Color(0xFF92278F))) { append("l") }
                withStyle(style = SpanStyle(color = Color(0xFF10034B))) { append("m") }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 70.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Login Title
            Text(
                text = "Login",
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.Start) // Aligns text to the left
                    .padding(bottom = 16.dp) // Adds spacing below the text
            )

            // Email Input Field
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            // Password Input Field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Text(
                text="Forget your Password? ",
                modifier = Modifier.align(Alignment.Start),
                color= Color(0xFF0070B8)
            )

            Button(
                onClick = { /* Play button action */ },
                modifier = Modifier
                    .fillMaxWidth() // Full width of the Column
                    .padding(top=30.dp)
                    .height(70.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF92278F),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Login",
                    fontSize = 30.sp
                )
            }
            Text(
                text = buildAnnotatedString {
                    append("Do not have an account? ")
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("Sign In")
                    }
                },
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 10.dp)
            )

        }



    }

}