package com.example.naturesons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class window_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window2)

        val task = listOf<TaskModel>(
            TaskModel("Cachoeira", R.drawable.cachoeira,R.drawable.cahoeira_7),
            TaskModel("Chuva", R.drawable.chuva,R.drawable.chuva_1),
           TaskModel("Deserto", R.drawable.deserto,R.drawable.deserto_3),
            TaskModel("Fogo", R.drawable.fogo,R.drawable.fogo_2),
            TaskModel("Floresta", R.drawable.floresta,R.drawable.floresta_1),
            TaskModel("Mar", R.drawable.mar,R.drawable.mar_6),
            TaskModel("Neve", R.drawable.neve,R.drawable.neve_5),
            TaskModel("Urbano", R.drawable.city,R.drawable.cidade_4),
            TaskModel("Vento", R.drawable.vento,R.drawable.vento_1),
            )
 val pesquisar :EditText= findViewById(R.id.pesquisar)






        val adapter:View_win_2= View_win_2(task, ::openTaskDetail)

        val recycler_view=findViewById<RecyclerView>(R.id.recycler_win2)
        recycler_view.layoutManager= LinearLayoutManager(this)
        recycler_view.adapter=adapter

    }

    private fun openTaskDetail(taskModel: TaskModel) {
        val intent = Intent(this, window_3::class.java)
        intent.putExtra("imageResourceId", taskModel.imageResourceId)
        startActivity(intent)
    }

}

