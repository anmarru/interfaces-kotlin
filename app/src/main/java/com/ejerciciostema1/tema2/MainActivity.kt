package com.ejerciciostema1.tema2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ejerciciostema1.tema2.ui.theme.Tema2Theme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
       Text(
           text= "hola $name",
           textAlign = TextAlign.Right,
           modifier = Modifier.fillMaxWidth().padding(top= 16.dp )
       )
        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.SpaceAround,//dos o mas elementos
            modifier = Modifier.fillMaxWidth()) {
            Text(
                text= "Hello $name!",
            )
            Text(
                text= "Hello $name!!!",
            )
            Text(
                text= "Hello $name :::",
            )
        }
    }
}



//@Preview(showBackground = true)
@Composable
fun MesajeBienvenida(pizzaria: String = "pizzeria" , direccion: String= "C/ Mayor 64", descripccion: String= "Pizzas, Pasta y bebidas "){
    Column {
        Text(
            text= "Bienvenidos a la $pizzaria Pasarela ",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text=" $direccion",
            textAlign = TextAlign.Right,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text= "$descripccion",
            textAlign = TextAlign.Right,
            modifier = Modifier.fillMaxWidth()
        )
        Row(horizontalArrangement = Arrangement.Center) {

            Button(onClick = {}) {
                Text(
                    text= "REGÍSTRATE"
                )
            }
            Button(onClick = {}) {
                Text(
                    text= "Login "
                )
            }
        }
    }
}

//funcion para caja de campo rellenable con texto
@Composable
private fun campoRelleneble() {

    var texto by remember { mutableStateOf("") }

    TextField(

        modifier =  Modifier.padding(100.dp),
        value = texto,
        onValueChange = {newText -> texto = newText},
        label = { Text("Texto") }
    )
}

//funcion para detalle del pedido
@Composable
fun DetallePedido(pedidoId: Int = 2, fecha: Date= Date(), precioTotal: Float = 254.0f){
    Column (
        modifier = Modifier.padding(35.dp)

    ){
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text ="Detalle de pedido",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(32.dp))

    //Detalle del pedido
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text= "Pedido ID $pedidoId",
            textAlign =  TextAlign.Left,
        )
        Text(
            text = SimpleDateFormat("dd/mm/yyyy", Locale.getDefault()).format(fecha),
            textAlign = TextAlign.Right
        )
    }
     Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Precio total : $precioTotal",
            textAlign = TextAlign.Right,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Button(onClick = {}) {
                Text(
                    text = "Cancelar Pedido "
                )
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = {},
                    modifier = Modifier.padding(32.dp)) {
                    Text(
                        text = "Confirmar pedido "
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)//lo que se ve en el preview
@Composable
fun GreetingPreview() {
    MesajeBienvenida()
    DetallePedido()
    campoRelleneble()
}