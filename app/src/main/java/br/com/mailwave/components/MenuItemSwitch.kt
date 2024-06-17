package br.com.mailwave.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MenuItemSwitch(label: String, initialState: Boolean, divider: Boolean, onCheck: () -> Unit){
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight()
                    .padding(start = 30.dp)
            ) {
                Text(
                    text = label,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    color = Color.White
                )
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(end = 15.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Switch(
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = Color(0xFF4CD964),
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = Color.Black,
                        uncheckedBorderColor = Color.White,
                        checkedBorderColor = Color(0xFF4CD964)
                    ),
                    checked = initialState,
                    onCheckedChange = { onCheck() }
                )
            }
        }

        if (divider)
            HorizontalDivider(color = Color.DarkGray, thickness = 1.dp, modifier = Modifier.padding(horizontal = 10.dp))

    }
}