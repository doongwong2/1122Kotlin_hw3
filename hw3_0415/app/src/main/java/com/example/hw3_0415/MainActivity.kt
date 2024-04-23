package com.example.hw3_0415

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.core.content.ContextCompat.startActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            showImages(this@MainActivity)
        }

    }
}


@Composable
fun showImages(context : Context)
{
    val imageAmt = ArrayList<Int>()
    val imageStr = ArrayList<Int>()
    val mp3list = ArrayList<Int>()
    
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

    mp3list.add(R.raw.discordcall)
    mp3list.add(R.raw.gonnaflynow)
    mp3list.add(R.raw.discordcall)
    mp3list.add(R.raw.gonnaflynow)
    mp3list.add(R.raw.discordcall)

    LazyVerticalGrid(columns = GridCells.Fixed(1)){

        items(imageAmt){
                item ->
            Row()
            {
                Image(painter = painterResource(id = item),
                    contentDescription = stringResource(id = item),
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .requiredSize(width = 100.dp, height = 100.dp))

                Button(onClick = {
                    val intent = Intent()
                    intent.setClassName(
                        context,
                        "com.example.hw3_0415.MusicPlayer"
                    )
                    intent.putExtra("IMG",imageAmt.getOrNull(imageAmt.indexOf(item)))
                    intent.putExtra("MUS",mp3list.getOrNull(imageAmt.indexOf(item)))
                    context.startActivity(intent)

                })
                {
                    Text(text = "click to play " + stringResource(id = imageStr[imageAmt.indexOf(item)]))
                }

            }


        }
    }


}


