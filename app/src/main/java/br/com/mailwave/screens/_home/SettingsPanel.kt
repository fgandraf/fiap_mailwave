package br.com.mailwave.screens._home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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
                .height(90.dp)
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            // Header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp)
                    .padding(horizontal = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                )
                {
                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .size(50.dp)
                            .clickable { onClose() },
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.primary,
                        )
                    }
                }

                HorizontalDivider(color = Color.DarkGray, thickness = 1.dp, modifier = Modifier.padding(top = 10.dp))
            }

            // Body
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 20.dp),
                    colors = CardColors(containerColor = MaterialTheme.colorScheme.surface, contentColor = Color.White, disabledContentColor = Color.Yellow, disabledContainerColor = Color.Red)
                ) { }

                Spacer(modifier = Modifier.height(20.dp))

                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(horizontal = 20.dp),
                    colors = CardColors(containerColor = MaterialTheme.colorScheme.surface, contentColor = Color.White, disabledContentColor = Color.Yellow, disabledContainerColor = Color.Red)
                ) { }

                Spacer(modifier = Modifier.height(20.dp))

                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 20.dp),
                    colors = CardColors(containerColor = MaterialTheme.colorScheme.surface, contentColor = Color.White, disabledContentColor = Color.Yellow, disabledContainerColor = Color.Red)
                ) { }

                Spacer(modifier = Modifier.height(20.dp))

                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .padding(horizontal = 20.dp),
                    colors = CardColors(containerColor = MaterialTheme.colorScheme.surface, contentColor = Color.White, disabledContentColor = Color.Yellow, disabledContainerColor = Color.Red)
                ) { }







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