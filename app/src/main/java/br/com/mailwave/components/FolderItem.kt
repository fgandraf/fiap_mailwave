package br.com.mailwave.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.mailwave.R

@Composable
fun FolderItem(label:String, icon: Int, iconColor: Color = Color.Gray, onClick: () -> Unit) {

    Column {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .clickable { onClick() }
        ) {

            Spacer(modifier = Modifier.width(20.dp))

            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Icon",
                tint = iconColor,
                modifier = Modifier.size(20.dp)
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
}


@Preview
@Composable
fun FolderItemPreview(){
    FolderItem(label = "Caixa de Entrada", icon = R.drawable.menu) { }
}