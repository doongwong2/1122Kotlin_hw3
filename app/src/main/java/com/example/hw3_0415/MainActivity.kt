package com.example.hw3_0415

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val albumlist = ArrayList<Int>()

        albumlist.add(R.string.woodwinds)
        albumlist.add(R.string.brass)

        setContent {
           LazyColumn{
               items(albumlist){
                   item ->
                   Text(text = stringResource(id = item),
                       fontSize = 40.sp,
                       modifier =
                       Modifier.clickable{
                           var index = albumlist.indexOf(item)
                           itemClicked(index)
                       })
               }
            }
        }
    }

    private fun itemClicked(position: Int){
        var imageIds : IntArray? = null;

        if(position == 0){
            imageIds = intArrayOf(R.drawable.oboe_bassoon,
                R.drawable.flute_piccolo,
                R.drawable.clarinet_bassclarinet)
        }
        else
        {
            imageIds = intArrayOf(R.drawable.trumpet,
                R.drawable.tuba)
        }
        val intent = Intent()
        intent.setClassName(this,
            "com.example.hw3_0415.GridActivity")
        intent.putExtra("EXTRA_IDS",imageIds!!)
        startActivity(intent)
    }
}


