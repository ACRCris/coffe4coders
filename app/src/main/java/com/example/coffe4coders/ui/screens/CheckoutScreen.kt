package com.example.coffe4coders.ui.screens


import CountryISO
import ProductCard
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.components.CustomAppBar
import com.example.coffe4coders.ui.components.CustomButton
import com.example.coffe4coders.ui.components.CustomTextField
import com.example.coffe4coders.ui.components.DropdownTextField
import com.example.coffe4coders.ui.theme.Coffe4codersTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CheckoutScreen(navController: NavController, country: CountryISO) {
    val cities = listOf(
        "Mexico City, Mexico",
        "The Habana, Cuba",
        "Cancun, Mexico",
        "Medellin, Colombia",
        "Buenos Aires, Argentina",
        "Sao Paulo, Brasil",
        "Lima, Peru",
        "Montevideo, Uruguay",
        "Panama City, Panama")

    var name by remember { mutableStateOf("")}
    var email by remember { mutableStateOf("")}
    var phone by remember { mutableStateOf("")}
    var address by remember { mutableStateOf("")}
    var city by remember { mutableStateOf("")}

    Scaffold(topBar = {
        CustomAppBar(navigationIcon = Icons.Filled.ArrowBack){
            navController.navigate("detail/${country.iso}")
        }
    }, content = {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            ProductCard(name = "Café de colombia",
                summary ="Café de las montañas" ,
                price = 35.0,
                currency = "USD",
                country = country) {}

            Column(
                modifier =  Modifier.padding(16.dp)
            ) {
                CustomTextField(value = name, placeholder = "Nombre completo"){
                    name = it
                }
                CustomTextField(value = email, placeholder = "Correo electronico"){
                    email = it
                }
                CustomTextField(value = phone, placeholder = "Número telefonico"){
                    phone = it
                }
                CustomTextField(value = address, placeholder = "Dirección de recidencia"){
                    address = it
                }
                DropdownTextField(
                    suggestions = cities,
                    value = city,
                    placeholder = "Ciudad"){
                    city = it
                }
                Column{
                    Row{
                        Text("SubTotal", style = MaterialTheme.typography.caption)
                        Text("$ 35.0 USD",
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth())
                    }
                    Row{
                        Text("Envio", style = MaterialTheme.typography.caption)
                        Text("$ 10.0 USD",
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth())
                    }
                }

                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)){
                    Text(text = "$ 454.0 USD",
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.Start
                    )
                    CustomButton(label = "Finalizar pedido") {

                    }
                }
            }
        }
    })
}


@Preview
@Composable
fun CheckoutScreenPreview(){
    Coffe4codersTheme() {
        val navController = rememberNavController()
        CheckoutScreen(navController,CountryISO.BRA)
    }
}