package br.com.mailwave.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FolderItem(label:String, icon: ImageVector, onClick: () -> Unit) {

    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable { onClick() }
    ) {

        Spacer(modifier = Modifier.width(20.dp))

        Icon(
            icon,
            contentDescription = "Icon",
            tint = Color.Gray,
            modifier = Modifier.size(25.dp)
        )

        Spacer(modifier = Modifier.width(20.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = label,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}


@Preview
@Composable
fun FolderItemPreview(){
    FolderItem(label = "Caixa de Entrada", icon = Icons.Filled.MailOutline) { }
}