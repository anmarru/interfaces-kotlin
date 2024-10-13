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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ejerciciostema1.tema2.ui.theme.Tema2Theme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface {
                    CatalogoPizzas()
                    //Calculadora()
                }
            }
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


//EJERCICIO 1
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

// EJERCICIO 2 funcion para detalle del pedido
@Composable
fun DetallePedido(pedidoId: Int = 2, fecha: Date= Date(), precioTotal: Float = 254.0f){
    Column (
        modifier = Modifier.padding(35.dp)

    ){
        Spacer(modifier = Modifier.height(32.dp))

        TextoCentrado(text="Detalle pedido")//llamo a la funcion auxiliar q centra el texto
        /*Text(
            text ="Detalle de pedido",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )*/
        Spacer(modifier = Modifier.height(32.dp))

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
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Button(onClick = {},
                modifier = Modifier
                    .weight(1f)//el boton ocupa la mitad del ancho disponible
                    .padding(end= 8.dp)
            ) {
                TextoCentrado(text = "Cancelar pedido")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {},
            modifier= Modifier
                .weight(1f)
                .padding(start = 8.dp)) {
                //utilizo la funcion auxiliar
                TextoCentrado(text= "confirmar pedido")
            }

        }
    }
}


//EJERCICIO 3
@Composable
fun TextoCentrado(text: String){
    Column (
        modifier= Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center, //centro verticalmente
        horizontalAlignment = Alignment.CenterHorizontally//centro horizontalmente
    ){
        Text(
            text=text,
            textAlign = TextAlign.Center
        )
    }

}

//EJERCICIO 4
@Composable
fun CatalogoPizzas(){
    var pizzas by remember { mutableStateOf(listOf("Margarita", "4 quesos", "Barbacoa")) }

    //layout principal
    Column(
        modifier = Modifier
            //.padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        //lista de las pizzas
        for (pizza in pizzas){
            Text(text= pizza)
        }

        Spacer(modifier =Modifier.height(2.dp))

        //boton para agregar la pizza
        Button(onClick = {
            //generar nombre de pizza aleatorio
            val nuevoNombrePizza= "pizza ${Random.nextInt(100,999)}"
            pizzas = pizzas+ nuevoNombrePizza// agregar nueva pizza a la lista
        }) {
            Text(text= "Agregar Pizza ")
        }
    }
}

//EJERCICIO 5
@Composable
fun Calculadora(){
    Column (modifier = Modifier.fillMaxSize().padding(35.dp),
        //esto hace que los botones esten abajo
        verticalArrangement = Arrangement.SpaceBetween,
    ){
        Text(
            text = "0",
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth()
        )

        Column (){
                filaBotones(listOf("1","2","3","+"))
                filaBotones(listOf("4","5","6","-"))
                filaBotones(listOf("7","8","9","*"))
                filaBotones(listOf("c","0","=","/"))
        }
    }
}

@Composable
fun filaBotones(botones: List<String>){
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            botones.forEach{
                Button(onClick = {}, modifier = Modifier.weight(1f)) {
                    Text(
                        text= it
                    )
                }
            }
        }
}


@Preview(showBackground = true)//lo que se ve en el preview
@Composable
fun GreetingPreview() {
    //MesajeBienvenida()
    //DetallePedido()
   // campoRelleneble()
    //Calculadora()
    //CatalogoPizzas()
}