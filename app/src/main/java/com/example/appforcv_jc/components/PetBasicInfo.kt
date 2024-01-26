package com.example.appforcv_jc.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appforcv_jc.R

@Preview(showBackground = true)
@Composable
fun PrevPetBasicInfo(){
    PetBasicInfo(name = "Sharik", gender = "mail", location = "Italy")
}
@Composable
fun PetBasicInfo(
    name: String,
    gender: String,
    location: String
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.align(alignment = CenterVertically)) {
            Text(text = name,
                modifier = Modifier.padding(end = 12.dp),
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp, 16.dp),
                    tint = Color.Red
                )
                Text(text = location,
                    modifier = Modifier.padding(
                        start = 8.dp,
                        top = 0.dp,
                        end = 12.dp,
                        bottom = 0.dp
                    ),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyMedium
                    )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Adobtabl",
                modifier = Modifier
                    .padding(
                        start = 0.dp,
                        end = 12.dp,
                        top = 0.dp,
                        bottom = 0.dp
                    ),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Column(
            modifier = Modifier.height(80.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GenderTag(gender = gender, modifier = Modifier)
            Text(
                text = "Dog",
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


