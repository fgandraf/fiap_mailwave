package br.com.mailwave.screens._home

import android.provider.LiveFolders
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.mailwave.R
import br.com.mailwave.components.MenuDoubleItemArrow
import br.com.mailwave.components.MenuItemArrow
import br.com.mailwave.components.MenuItemArrowFolder
import br.com.mailwave.components.MenuItemSwitch
import br.com.mailwave.components.PanelHeader
import br.com.mailwave.ui.theme.MailWaveTheme

@Composable
fun FoldersPanel(dockIsVisible: Boolean, navController: NavController, onClose: () -> Unit){
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

            PanelHeader(title = "MAILWAVE") { onClose() }
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF202022))) {

                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 30.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                ) {

                    MenuItemArrowFolder(label = "Caixa de Entrada", divider = false, imageid = R.drawable.baseline_inbox_24) { }
                    MenuItemArrowFolder(label = "Enviadas", divider = false, imageid = R.drawable.baseline_send_24) { }
                    MenuItemArrowFolder(label = "Rascunhos", divider = false, imageid = R.drawable.baseline_drafts_24) { }
                    MenuItemArrowFolder(label = "Spam", divider = false, imageid = R.drawable.baseline_spam_24) { }
                    MenuItemArrowFolder(label = "Lixeira", divider = false, imageid = R.drawable.baseline_trash_24) { }
                }

                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 30.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                ) {

                    MenuItemArrowFolder (label = "Pastas Automáticas", divider = false, imageid = R.drawable.baseline_create_new_folder_24) { }

                }

                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                ) {

                    MenuItemArrowFolder(label = "Tags Personalizadas", divider = true, imageid = R.drawable.baseline_tag_24) { }

                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun FoldersPanelPreview(){
    MailWaveTheme(darkTheme = true) {
        FoldersPanel(
            dockIsVisible = true,
            NavController(LocalContext.current),
            onClose = {  }
        )
    }
}