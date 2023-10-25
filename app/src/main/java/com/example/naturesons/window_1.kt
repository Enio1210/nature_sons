package com.example.naturesons

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView



class window_1 : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window1)

        val videoView = findViewById<VideoView>(R.id.video_mar)
        videoView.setMediaController(null)
        mediaPlayer = MediaPlayer.create(this, R.raw.praia_fixa) // Substitua "nome_do_video" pelo nome do seu arquivo de vídeo na pasta res/raw

        videoView.setOnPreparedListener { mp ->
            // Configurar loop infinito
            mp.isLooping = true
        }

        // Para sincronizar o VideoView com o MediaPlayer
        // esse codigo que faz os botoes aparecer
       // videoView.setMediaController(MediaController(this))

        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.praia_fixa))
        videoView.requestFocus()

        videoView.setOnCompletionListener {
            // Reinicie a reprodução quando o vídeo terminar
            mediaPlayer.start()
        }

        // Inicie a reprodução do vídeo
        videoView.start()


        val buttow_win_2: Button= findViewById(R.id.button_window_1)

        buttow_win_2.setOnClickListener{

            val intent=Intent(this,window_2::class.java)
            startActivity(intent)

        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }


}