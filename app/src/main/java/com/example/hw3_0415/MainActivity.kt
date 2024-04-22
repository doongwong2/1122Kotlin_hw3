package com.example.hw3_0415

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            showImages()
        }

    }
    private fun itemClicked(position: Int) {
        var imageIds: IntArray? = null;
        var musicIds: IntArray? = null;

        val intent = Intent()
        intent.setClassName(
            this,
            "com.example.hw3_0415.GridActivity"
        )
        intent.putExtra("EXTRA_IDS", imageIds!!)
        intent.putExtra("MUSIC", musicIds!!)
        startActivity(intent)
    }

}


@Composable
fun showImages()
{
    val imageAmt = ArrayList<Int>()
    val imageStr = ArrayList<Int>()
    
    imageAmt.add(R.drawable.clarinet_bassclarinet)
    imageAmt.add(R.drawable.oboe_bassoon)
    imageAmt.add(R.drawable.flute_piccolo)
    imageAmt.add(R.drawable.trumpet)
    imageAmt.add(R.drawable.tuba)
    
    imageStr.add(R.string.pause)
    imageStr.add(R.string.play)
    imageStr.add(R.string.stop)
    imageStr.add(R.string.brass)
    imageStr.add(R.string.woodwinds)

    Row()
    {
        LazyColumn(){
            items(imageAmt){
                item ->
                Image(painter = painterResource(id = item),
                    contentDescription = stringResource(id = item),
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .requiredSize(width = 100.dp, height = 100.dp))

            }
        }
        LazyColumn(){
            items(imageStr){
                    item ->
                Button( contentPadding = PaddingValues( 1.dp, 40.dp),
                    onClick = {onCLick()})
                {
                    Text(text = stringResource(id = item))
                }

            }
        }
        Text(text = "hi")
    }

}

fun onCLick() {
    TODO("Not yet implemented")
}

