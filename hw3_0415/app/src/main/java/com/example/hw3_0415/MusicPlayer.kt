package com.example.hw3_0415

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import java.lang.Exception

class MusicPlayer : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        val imgResourceId = intent.getIntExtra("IMG",0)
        val musResourceId = intent.getIntExtra("MUS",0)

        init(this@MusicPlayer, musResourceId)

        setContent {

            var notPlay = remember{mutableStateOf(true)}
            var playText = remember{mutableStateOf(this@MusicPlayer.getString(R.string.play))}

            Column( horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Image(painter = painterResource(id = imgResourceId),
                    contentDescription = " ",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .fillMaxWidth())

                Row()
                {
                    Button(onClick = {
                        if(notPlay.value){
                            playerStart()
                            playText.value = getString(R.string.pause)
                            notPlay.value = false
                        }
                        else
                        {
                            playerPause()
                            playText.value = getString(R.string.play)
                            notPlay.value = true
                        }
                    })
                    {
                        Text(text = playText.value)
                    }
                    Button(onClick = {playerStop()}){
                        Text(text = stringResource(id = R.string.stop))
                    }
                }

            }

        }

    }
    override fun onDestroy(){
        super.onDestroy()
        player.release()
    }
}

lateinit var player: MediaPlayer

private fun init(context: Context, musResourceId : Int)
{
    try {
        player = MediaPlayer.create(context,musResourceId)

        player.setOnCompletionListener {
            try {
                player?.stop()
                player?.prepare()
            }
            catch(e: Exception){}

        }
    }
    catch(e: Exception){}
}

fun playerStart(){
    try{
        player.start()
    }
    catch(e: Exception){}
}

fun playerPause(){
    if(!player.isPlaying()){
        return
    }
    try{
        player.pause()
    }
    catch(e: Exception){}
}

fun playerStop(){
    try{
        player.stop()
        player.prepare()
    }
    catch(e: Exception){}
}