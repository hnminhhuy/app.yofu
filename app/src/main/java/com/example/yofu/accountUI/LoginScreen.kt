package com.example.yofu.accountUI
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.yofu.R
import com.example.yofu.UserLogin

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginScreenViewModel = viewModel<LoginScreenViewModel>(),
)
{

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp),
        elevation = 50.dp,
        shape = RoundedCornerShape(20.dp)
    )
    {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp))
        {
            Spacer(modifier = Modifier.height(30.dp))
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(200.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
            BoldTextComponent(value = "Login to Your Account")
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldComponent(labelValue = "Email address",
                setValue =  { newEmail ->
                    loginViewModel.setEmail(newEmail)
                }
                )
            Spacer(modifier = Modifier.height(15.dp))
            PasswordTextFieldComponent(labelValue = "Password",
                    setValue = {
                        loginViewModel.setPassword(it)
                    }
                )
            Spacer(modifier = Modifier.height(15.dp))
            ButtonComponent(
                value = "Sign in",
                callback = {
                    loginViewModel.login(
                        navigateToHomepage = {
                            navController.navigate("createVacancyScreen")
                        }
                    )
                }
                )
            Spacer(modifier = Modifier.height(40.dp))
            DividerTextComponent()
            Spacer(modifier = Modifier.height(40.dp))
            ClickableLoginTextComponent(onTextSelected = {
                navController.navigate("ChooseRoleScreen")
            })
        }

    }
}