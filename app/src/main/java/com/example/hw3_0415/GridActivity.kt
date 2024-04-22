package com.example.hw3_0415

import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class GridActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        init(this@GridActivity)


        val ia_ids = intent.getIntArrayExtra("EXTRA_IDS")
        val ids = ArrayList<Int>()
        for(element in ia_ids!!)
        {
            ids.add(Integer.valueOf(element))
        }
        setContent{

            var notPlay  = remember {mutableStateOf(true)}
            var playText = remember{mutableStateOf(this@GridActivity.getString(R.string.play))}
            Column()
            {
                showAlbum(ids)
                Row()
                {
                    Button(onClick = {
                        if (notPlay.value) {
                            playerStart()
                            playText.value = getString(R.string.pause)
                            notPlay.value = false
                        } else {
                            playerPause()
                            playText.value =getString(R.string.play)
                            notPlay.value = true
                        }

                    }
                    )
                    {
                        Text(text = playText.value)
                    }
                    Button(onClick = {playerStop()}){
                        Text(text = stringResource(id = R.string.stop))
                    }
                }}


        }
    }
    override fun onDestroy(){
        super.onDestroy()
        player.release()
    }
}

lateinit var player: MediaPlayer

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

private fun init(context : Context){
    try{
        player = MediaPlayer.create(context,
            R.raw.discordcall)

        player.setOnCompletionListener{
            try{
                player?.stop()
                player?.prepare()

            }
            catch(e: Exception)
            {

            }
        }
    }
    catch(e: Exception)
    {

    }
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

