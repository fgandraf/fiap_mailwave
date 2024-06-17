package br.com.mailwave.screens._home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.mailwave.R
import br.com.mailwave.components.CardButton
import br.com.mailwave.components.CardTitle
import br.com.mailwave.components.FolderItem
import br.com.mailwave.components.PanelHeader
import br.com.mailwave.ui.theme.MailWaveTheme

@Composable
fun FoldersPanel(dockIsVisible: Boolean, navController: NavController, onClose: () -> Unit){

    var showCreateFolderDialog by remember { mutableStateOf(false) }
    var showCreateTagDialog by remember { mutableStateOf(false) }
    var folderName by remember { mutableStateOf("") }
    var tagName by remember { mutableStateOf("") }

    AnimatedVisibility(
        visible = dockIsVisible,
        enter = slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth }),
        exit = slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth })
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            PanelHeader(title = "") { onClose() }

            Column(
                modifier = Modifier
                    .background(Color(0xFF202022))
                    .verticalScroll(rememberScrollState()),
            ) {


                Card(modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 30.dp), colors = CardDefaults.cardColors(containerColor = Color.Black)) {
                    Column(modifier = Modifier.padding(10.dp)) {

                        CardTitle(title = "email@email.com")

                        FolderItem(label = "Caixa de Entrada", icon = R.drawable.baseline_inbox_24) { navController.navigate("messages/inbox") }
                        FolderItem(label = "Rascunho", icon = R.drawable.baseline_mode_edit_24) { navController.navigate("messages/draft") }
                        FolderItem(label = "Caixa de Saída", icon = R.drawable.baseline_outbox_24) { navController.navigate("messages/outbox") }
                        FolderItem(label = "Enviadas", icon = R.drawable.baseline_send_24) { navController.navigate("messages/sent") }
                        FolderItem(label = "Spam", icon = R.drawable.baseline_spam_24) { navController.navigate("messages/spam") }
                        FolderItem(label = "Lixeira", icon = R.drawable.baseline_trash_24) { navController.navigate("messages/trash") }
                    }
                }

                Card(modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 30.dp), colors = CardDefaults.cardColors(containerColor = Color.Black)) {
                    Column(modifier = Modifier.padding(10.dp)) {

                        CardTitle(title = "Marcadores")


                        FolderItem(label = "Importante", icon = R.drawable.baseline_tag_24, iconColor = Color.Yellow) { }
                        FolderItem(label = "Lazer", icon = R.drawable.baseline_tag_24, iconColor = Color.Red) { }
                        FolderItem(label = "Compras", icon = R.drawable.baseline_tag_24, iconColor = Color.Blue) { }


                        HorizontalDivider(color = Color.DarkGray, thickness = 0.5.dp, modifier = Modifier.padding(10.dp))

                        CardButton(label = "Adicionar") { showCreateTagDialog = true }
                    }
                }


                Card(modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 30.dp, bottom = 50.dp), colors = CardDefaults.cardColors(containerColor = Color.Black)) {
                    Column(modifier = Modifier.padding(10.dp)) {

                        CardTitle(title = "Pastas")

                        // Automaticamente gerada
                        FolderItem(label = "Pasta Automática 1", icon = R.drawable.baseline_create_new_folder_24) { }
                        FolderItem(label = "Pasta Automática 2", icon = R.drawable.baseline_create_new_folder_24) { }
                        FolderItem(label = "Pasta Automática 3", icon = R.drawable.baseline_create_new_folder_24) { }

                        // Criadas pelo usuário
                        FolderItem(label = "Pasta Pessoal 1", icon = R.drawable.baseline_create_new_folder_24, iconColor = Color(0xFF008000)) { }

                        HorizontalDivider(color = Color.DarkGray, thickness = 0.5.dp, modifier = Modifier.padding(10.dp))

                        CardButton(label = "Adicionar") { showCreateFolderDialog = true }
                    }
                }

            }


            if (showCreateFolderDialog) {
                AlertDialog(
                    onDismissRequest = { showCreateFolderDialog = false },
                    confirmButton = {
                        Button(onClick = {
                            // Lógica para criar pasta
                            showCreateFolderDialog = false
                        }) {
                            Text("Criar")
                        }
                    },
                    dismissButton = {
                        Button(onClick = { showCreateFolderDialog = false }) {
                            Text("Cancelar")
                        }
                    },
                    text = {
                        Column {
                            Text("Nome da Pasta")
                            TextField(value = folderName, onValueChange = { folderName = it })
                        }
                    }
                )
            }

            if (showCreateTagDialog) {
                AlertDialog(
                    onDismissRequest = { showCreateTagDialog = false },
                    confirmButton = {
                        Button(onClick = {
                            // Lógica para criar tag
                            showCreateTagDialog = false
                        }) {
                            Text("Criar")
                        }
                    },
                    dismissButton = {
                        Button(onClick = { showCreateTagDialog = false }) {
                            Text("Cancelar")
                        }
                    },
                    text = {
                        Column {
                            Text("Nome do marcador")
                            TextField(value = tagName, onValueChange = { tagName = it })
                        }
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NewFoldersPanelPreview(){
    MailWaveTheme(darkTheme = true) {
        FoldersPanel(
            dockIsVisible = true,
            NavController(LocalContext.current),
            onClose = {  }
        )
    }

}