package com.example.app_firebase.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app_firebase.viewmodel.AuthViewModel


@Composable
fun LoginScreen(
    onNavigateToHome: () -> Unit,
    onNavigateToRegister: () -> Unit,
    viewModel: AuthViewModel = viewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome",
            modifier = Modifier.padding(20.dp),
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email address*") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password*") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.signIn(email, password, onNavigateToHome)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continue")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Divider(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text("Don't have an account? ")
            Text(
                "Register",
                modifier = Modifier.clickable(onClick = onNavigateToRegister),
                color = Color(0xFF6650a4)
            )
        }
    }
}
