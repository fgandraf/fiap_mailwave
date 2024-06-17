package br.com.mailwave.screens._home

import android.provider.LiveFolders
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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

    var showCreateFolderDialog by remember { mutableStateOf(false) }
    var showCreateTagDialog by remember { mutableStateOf(false) }
    var folderName by remember { mutableStateOf("") }
    var tagName by remember { mutableStateOf("") }
    var tags by remember {
        mutableStateOf(
            listOf(
                "Urgente",
                "Trabalho",
                "Pessoal"
            )
        )
    }
    var fixedTags = listOf(
        "Importante",
        "Lazer",
        "Compras"
    )
    var folders by remember {
        mutableStateOf(
            listOf(
                "Inbox",
                "Sent",
                "Drafts",
                "Spam",
                "Trash"
            )
        )
    }

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

        Column(modifier = Modifier.fillMaxSize()) {

            PanelHeader(title = "Pastas") { onClose() }

            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF202022)),
            ) {
                val folders = listOf( "Caixa de Entrada", "Enviadas", "Rascunhos", "Spam", "Lixeira")

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    items(folders) { folder ->
                        Text(
                            text = folder,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navController.navigate("messages/$folder")
                                    onClose()
                                }
                                .padding(vertical = 16.dp),
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        HorizontalDivider(color = Color.DarkGray, thickness = 0.5.dp)
                    }
                    item {
                        Spacer(modifier = Modifier.height(5.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Tags Personalizadas",
                                modifier = Modifier.padding(vertical = 16.dp),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Spacer(modifier = Modifier.width(25.dp))
                            Button(onClick = { showCreateTagDialog = true },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Gray,
                                    contentColor = Color.Black
                                )
                            ) {
                                Icon(Icons.Default.Add, contentDescription = "Add Tag")
                                Text("Criar Tag")
                            }
                        }
                        fixedTags.forEach { tag ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 3.dp, horizontal = 5.dp),
                                verticalAlignment = Alignment.CenterVertically

                            )
                            {
                                Text(text = tag, fontSize = 18.sp, color = Color.Gray)
                            }

                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Pastas Automáticas",
                                modifier = Modifier.padding(vertical = 16.dp),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Spacer(modifier = Modifier.width(25.dp))
                            Button(onClick = { showCreateFolderDialog = true },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Gray,
                                    contentColor = Color.Black
                                )
                            ) {
                                Icon(Icons.Default.Add, contentDescription = "Add Folder")
                                Text("Criar Pasta")
                            }
                        }
                    }

                }


                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                ) {

                    MenuItemArrowFolder(label = "Tags Personalizadas", divider = true, imageid = R.drawable.baseline_tag_24) { }



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