package com.example.appforcv_jc.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.appforcv_jc.components.PetInfoItem
import com.example.appforcv_jc.components.TopBar
import com.example.appforcv_jc.data.DummyPetDataSource

@Preview(showBackground = true)
@Composable
fun PrevHome(){
Home(onSwitchClick = { /*TODO*/ }, onPetClick = {})
}

@Composable
fun Home(
    onSwitchClick: () -> Unit,
    onPetClick: (Int) -> Unit
) {
    val petList = DummyPetDataSource.dogList
       Scaffold(
        topBar = {
            TopBar {
                onSwitchClick()
            }
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues){
            itemsIndexed(petList){ index, petList ->
                PetInfoItem(pet = petList){
                    onPetClick(index)
               }
            }
        }
    }
}
