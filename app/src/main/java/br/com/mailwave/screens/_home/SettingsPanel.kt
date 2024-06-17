package br.com.mailwave.screens._home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.mailwave.components.MenuDoubleItemArrow
import br.com.mailwave.components.MenuItemArrow
import br.com.mailwave.components.MenuItemSwitch
import br.com.mailwave.components.PanelHeader
import br.com.mailwave.ui.theme.MailWaveTheme

@Composable
fun SettingsPanel(dockIsVisible: Boolean, navController: NavController, onClose: () -> Unit){
    AnimatedVisibility(
        visible = dockIsVisible,
        enter = slideInHorizontally(),
        exit = slideOutHorizontally()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1C1C1E)),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            PanelHeader(title = "Configurações") { onClose() }

            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF202022))) {

                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 40.dp, end = 20.dp, bottom = 30.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                ) {

                    MenuDoubleItemArrow(firstLine = "Contas", secondLine = "2 contas conectadas") { }
                }



                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 30.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                ) {

                    MenuItemSwitch(label = "Pausar Notificações", initialState = false, divider = true) { }
                    MenuItemSwitch(label = "Face ID / Touch ID", initialState = true, divider = true) { }
                    MenuItemArrow(label = "Configurar Notificações", divider = false) { }

                }



                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 30.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                ) {

                    MenuItemArrow(label = "Assinatura", divider = false) { }

                }



                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                ) {

                    MenuItemArrow(label = "Sobre", divider = true) { }
                    MenuItemArrow(label = "Termos de Privacidade", divider = true) { }
                    MenuItemArrow(label = "Sair", divider = false) { }

                }
            }


        }
    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SettingsPanelPreview(){
    MailWaveTheme(darkTheme = true) {
        SettingsPanel(
            dockIsVisible = true,
            NavController(LocalContext.current),
            onClose = {  }
        )
    }
}