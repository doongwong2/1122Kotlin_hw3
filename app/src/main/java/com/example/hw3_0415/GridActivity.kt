package com.example.hw3_0415

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class GridActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        val ia_ids = intent.getIntArrayExtra("EXTRA_IDS")
        val ids = ArrayList<Int>()
        for(element in ia_ids!!)
        {
            ids.add(Integer.valueOf(element))
        }
        setContent{
            showAlbum(ids)
        }
    }
}

@Composable
fun showAlbum(ids : ArrayList<Int>)
{

    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ){
        items(ids){ item ->
            Image(painter = painterResource(id = item),
                contentDescription = "",
                modifier = Modifier
                    .size(150.dp),
                contentScale = ContentScale.Crop)
        }
    }
}