package com.example.hw3_0415

import android.content.Context
import android.content.Intent
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
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

    //handles image display
    imageAmt.add(R.drawable.clarinet_bassclarinet)
    imageAmt.add(R.drawable.oboe_bassoon)
    imageAmt.add(R.drawable.flute_piccolo)
    imageAmt.add(R.drawable.alto_saxophone)
    imageAmt.add(R.drawable.tenor_saxophone)
    imageAmt.add(R.drawable.baritone_saxophone)
    imageAmt.add(R.drawable.trumpet)
    imageAmt.add(R.drawable.trombone)
    imageAmt.add(R.drawable.french_horn)
    imageAmt.add(R.drawable.euphonium)
    imageAmt.add(R.drawable.tuba)
    imageAmt.add(R.drawable.contrabass)
    imageAmt.add(R.drawable.percussion)

    //handles name display
    imageStr.add(R.string.clarinet_bassclarinet)
    imageStr.add(R.string.oboe_bassoon)
    imageStr.add(R.string.flute_piccolo)
    imageStr.add(R.string.alto_saxophone)
    imageStr.add(R.string.tenor_saxophone)
    imageStr.add(R.string.baritone_saxophone)
    imageStr.add(R.string.trumpet)
    imageStr.add(R.string.trombone)
    imageStr.add(R.string.french_horn)
    imageStr.add(R.string.euphonium)
    imageStr.add(R.string.tuba)
    imageStr.add(R.string.contrabass)
    imageStr.add(R.string.percussion)

    //handles mp3 names
    mp3list.add(R.raw.clarinet_basscl)
    mp3list.add(R.raw.oboe_bsn)
    mp3list.add(R.raw.flute_picc)
    mp3list.add(R.raw.alto_sax)
    mp3list.add(R.raw.tenor_sax)
    mp3list.add(R.raw.bari_sax)
    mp3list.add(R.raw.trp)
    mp3list.add(R.raw.tb)
    mp3list.add(R.raw.horn)
    mp3list.add(R.raw.eupho)
    mp3list.add(R.raw.tub)
    mp3list.add(R.raw.contrabass)
    mp3list.add(R.raw.percc)


    LazyVerticalGrid(columns = GridCells.Fixed(1)){

        items(imageAmt){
                item ->
            Row(verticalAlignment = Alignment.CenterVertically)
            {
                Image(painter = painterResource(id = item),
                    contentDescription = stringResource(id = item),
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .requiredSize(width = 135.dp, height = 75.dp))

                Button(onClick = {
                    val intent = Intent()
                    intent.setClassName(
                        context,
                        "com.example.hw3_0415.MusicPlayer"
                    )
                    intent.putExtra("IMG",imageAmt.getOrNull(imageAmt.indexOf(item)))
                    intent.putExtra("MUS",mp3list.getOrNull(imageAmt.indexOf(item)))
                    intent.putExtra("NAME",imageStr.getOrNull(imageAmt.indexOf(item)))
                    context.startActivity(intent)

                })
                {
                    Text(text = "play " + stringResource(id = imageStr[imageAmt.indexOf(item)]))
                }

            }


        }
    }


}


