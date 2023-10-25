package com.example.naturesons

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView

class window_3 : AppCompatActivity() {

    // delcaracao de um objeto mediaPlayer
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window_3)


        val btn_play:ImageButton= findViewById(R.id.btn_play)
        var isPlaying = false

        btn_play.setOnClickListener{
            // Verifique se o MediaPlayer está nulo ou não está reproduzindo
            if(mediaPlayer==null || !mediaPlayer!!.isPlaying){
                // Crie e inicie o MediaPlayer
                mediaPlayer=MediaPlayer.create(this,R.raw.som_lareira)
                mediaPlayer?.start()
                isPlaying = true
                btn_play.setImageResource(R.drawable.pause)

            }else{
                mediaPlayer?.stop()
                mediaPlayer?.release()
                mediaPlayer = null
                isPlaying=false
                btn_play.setImageResource(R.drawable.play)

            }
        }



        val imageView = findViewById<ImageView>(R.id.imageViewa)
        val imageResourceId = intent.getIntExtra("imageResourceId", 0)
        if (imageResourceId != 0) {
            // Carregue a imagem usando o ID do recurso
            imageView.setImageResource(imageResourceId)


        }

    }
}








/*set ao video aqui
    val videoUri = Uri.parse("android.resource://${packageName}/${intent.getStringExtra("taskModel.videoUri")}")
    val videoView = findViewById<VideoView>(R.id.video_play)
    videoView.setVideoURI(videoUri)
    videoView.start()*/