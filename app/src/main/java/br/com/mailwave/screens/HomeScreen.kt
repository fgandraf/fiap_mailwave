package br.com.mailwave.screens

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import br.com.mailwave.components.ChooseOptions
import br.com.mailwave.components.EmailSingle
import br.com.mailwave.components.Header
import br.com.mailwave.integration.RetrofitInstance
import br.com.mailwave.integration.UserLoginMockTest
import br.com.mailwave.integration.dto.UserLoginRequest
import br.com.mailwave.models.Email
import br.com.mailwave.repository.AppRepository
import br.com.mailwave.screens._home.FoldersPanel
import br.com.mailwave.screens._home.SettingsPanel
import br.com.mailwave.ui.theme.MailWaveTheme

@Composable
fun HomeScreen(navController: NavController){

    var menuDockIsVisible by remember { mutableStateOf(false) }
    var settingsDockIsVisible by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val appRepository = AppRepository(context);

    var messageApi = RetrofitInstance.messageApi

    Box(modifier = Modifier.fillMaxSize()){
        Column {

            Header(
                settingsClick = { settingsDockIsVisible = true },
                searchClick = { },
                menuClick = { menuDockIsVisible = true }
            )

            ChooseOptions(choseOption = "all")

            LazyColumn(modifier = Modifier.fillMaxWidth()) {

                val sharedPreferences: SharedPreferences = context.getSharedPreferences("mailWave", Context.MODE_PRIVATE)
                val token: String = sharedPreferences.getString("token", "")!!

                items(messageApi.getUnreadMessages(UserLoginMockTest.userId, token).body()!!) {
                    var newEmail = Email(
                        senderImage = 0,
                        sender = it.sender,
                        body = it.body,
                        folder = it.folder,
                        tag = it.tag,
                        read = it.isRead
                    )
                    appRepository.insertEmail(newEmail)
                }

                items(appRepository.getAllEmails()){

                    EmailSingle(imageId = it.senderImage, emailSender = it.sender, emailBody = it.body, read = it.read)

                }

            }

        }
        
//       navController.navigate("message/create")
//       navController.navigate("message/read")


    }
    FoldersPanel(menuDockIsVisible, navController) { menuDockIsVisible = false;}
    SettingsPanel(settingsDockIsVisible, navController) { settingsDockIsVisible = false;}
}

fun syncMessagesApi() {

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview(){
    MailWaveTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(NavController(context = LocalContext.current))
        }
    }
}