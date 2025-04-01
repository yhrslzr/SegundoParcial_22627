package com.yso.segundoparcial_22627.parcial2_22627

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yso.segundoparcial_22627.R
import kotlinx.coroutines.launch

@Preview (showBackground = true)
@Composable
fun VistaAerolinea(){
    val context = LocalContext.current
    val preferencias = GuardaditosAerolineas(context)

    Aerolinea(preferencias, rememberNavController())
}


@Composable
fun Aerolinea(preferencias: GuardaditosAerolineas, navController: NavController){

    val corrutinita = rememberCoroutineScope()

    val savedName = preferencias.name.collectAsState(initial = "---")
    var name by remember { mutableStateOf("") }

    data class ModeloAerolinea(
        @DrawableRes val imagen: Int,
        val nombre: String?,
    )

    val aerolineas = listOf(
        ModeloAerolinea(
            imagen = R.drawable.aeromexico,
            nombre = "Aeroméxico"
        ),
        ModeloAerolinea(
            imagen = R.drawable.viva,
            nombre = "Viva Aerobus"
        ),
        ModeloAerolinea(
            imagen = R.drawable.volaris,
            nombre = "Volaris"
        )
    )

    Column(modifier = Modifier.fillMaxSize()) {

        Text("Seleccione su Aerolínea")

        TextField(modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = { name = it },
            label = { Text("Introduzca su Nombre") })

        LazyColumn(modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            items(aerolineas) { aerolinea ->
                Card(modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp))
                {

                    Card(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(id = aerolinea.imagen),
                            contentDescription = "",
                            modifier = Modifier.size(60.dp),
                            contentScale = ContentScale.Crop
                        )

                    }

                    Text(text = "${aerolinea.nombre}", fontSize = 30.sp)

                }



            }

        }

        Row(modifier = Modifier.fillMaxWidth()) {
            // Botones: 1 Regresar, 2 Reservar
        }
    }
}