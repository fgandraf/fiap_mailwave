package br.com.mailwave.screens._home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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
        enter = slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth }),
        exit = slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth })
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
                    .padding(top = 10.dp)
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
            // Body - Lista de Pastas
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
                            Text("Nome da Tag")
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
fun FoldersPanelPreview(){
    MailWaveTheme(darkTheme = true) {
        FoldersPanel(
            dockIsVisible = true,
            NavController(LocalContext.current),
            onClose = {  }
        )
    }

}