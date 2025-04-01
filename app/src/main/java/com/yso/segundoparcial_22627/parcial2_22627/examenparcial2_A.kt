package com.yso.segundoparcial_22627.parcial2_22627

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yso.segundoparcial_22627.R

@Preview (showBackground = true)
@Composable
fun NavViajecitos(){
    val navController = rememberNavController()
    val context = LocalContext.current
    val preferencias = GuardaditosAerolineas(context)

    // Configuración de las rutas para la navegación
    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            Viajecitos(navController,preferencias)
        }
        composable("aerolinea") {
            Aerolinea(preferencias,navController)
        }
    }
}

@Composable
fun Viajecitos(navController: NavController, preferencias: GuardaditosAerolineas){

    data class ModeloViajes(
        @DrawableRes val imagen: Int,
        val destino: String?,
        val tipo: String?,
        val extras: String?,
    )

    val vNacionales = listOf(
        ModeloViajes(
            imagen = R.drawable.cancun,
            destino = "Cancún",
            tipo = "Ida y Vuelta",
            extras = "No incluye algún extra",

        ),

        ModeloViajes(
            imagen = R.drawable.mexico,
            destino = "Ciudad de México",
            tipo = "Sencillo",
            extras = "Incluye Alojamiento"
        ),

        ModeloViajes(
            imagen = R.drawable.mty,
            destino = "Monterrey",
            tipo = "Ida y Vuelta",
            extras = "Alojamiento y Desayunos"
        ),
    )

    val vInternacionales = listOf(
        ModeloViajes(
            imagen = R.drawable.seul,
            destino = "Seul",
            tipo = "Ida y Vuelta",
            extras = "Incluye Alojamiento",
            ),

        ModeloViajes(
            imagen = R.drawable.usa,
            destino = "Nueva York",
            tipo = "Sencillo",
            extras = "Alojamiento y Desayunos"
        ),

        ModeloViajes(
            imagen = R.drawable.paris,
            destino = "París",
            tipo = "Sencillo",
            extras = "No incluye algún extra"
        ),
    )

    Column {

        Text("¿Adónde deseas viajar?", fontSize = 30.sp)

        LazyRow(modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Start)
        {

            items(vNacionales) { vNacional ->Text(text = "Vuelos Nacionales")}

            items(vNacionales) { vNacional ->

                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
                {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(id = vNacional.imagen),
                            contentDescription = "",
                            modifier = Modifier.size(16.dp),
                            contentScale = ContentScale.Crop
                        )

                        Column {
                            Text(text = "${vNacional.tipo}", fontSize = 18.sp)
                            Text(
                                text = vNacional.destino ?: "Sin descripción",
                                //agregar ?:
                                fontSize = 10.sp,
                            )
                            Text("$${vNacional.extras} MXN")
                        }
                    }
                }
            }
        }

        LazyRow(modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Start){

            items(vNacionales) { vNacional ->Text(text = "Vuelos Internacionales")}

            items(vInternacionales) { vInternacional ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
                {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(id = vInternacional.imagen),
                            contentDescription = "",
                            modifier = Modifier.size(16.dp),
                            contentScale = ContentScale.Crop
                        )

                        Column {
                            Text(text = "${vInternacional.tipo}", fontSize = 18.sp)
                            Text(
                                text = vInternacional.destino ?: "Sin descripción",
                                fontSize = 10.sp,
                            )
                            Text("${vInternacional.extras}")
                        }
                    }
                }
            }
        }

    }

}