package com.example.appforcv_jc.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appforcv_jc.R
import com.example.appforcv_jc.data.DummyPetDataSource
import hoods.com.jetpetrescue.data.model.Owner
import hoods.com.jetpetrescue.data.model.Pet

@Preview(showBackground = true)
@Composable
fun PrevOwnerCardInfo(){
    val owner = DummyPetDataSource.dogList[0].owner
    val pet = DummyPetDataSource.dogList[1]
    OwnerCardInfo(owner = owner, pet = pet)

}
@Composable
fun OwnerCardInfo(owner: Owner, pet: Pet){
    val toastContext = LocalContext.current
    Spacer(modifier = Modifier.height(16.dp))
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = owner.image),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp, 60.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = owner.name, color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.W600,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = owner.basicInfo,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyMedium,
                    )
            }
        }
        Surface(
            modifier = Modifier
                .size(40.dp)
                .clickable {
                    Toast
                        .makeText(
                            toastContext,
                            "Send \"${pet.name}\" to social network",
                            Toast.LENGTH_LONG
                        )
                        .show()
                }
                .clip(CircleShape),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.size(20.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_messenger),
                    contentDescription = null,
                    tint = Color.White
                )

            }

        }

    }
}