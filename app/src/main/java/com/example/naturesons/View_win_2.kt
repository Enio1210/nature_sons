package com.example.naturesons


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class View_win_2(private val opentaskdetailview:List<TaskModel>
,private val openTaskDetail :(task:TaskModel)-> Unit)
    : RecyclerView.Adapter<TaskListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.view_nature, parent, false)
        return TaskListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return opentaskdetailview.size
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        val taskbind=opentaskdetailview[position]
        holder.bind(taskbind, openTaskDetail)

    }
}

class TaskListViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){

    val title_text= itemview.findViewById<TextView>(R.id.title_win2)
    val image_view= itemview.findViewById<ShapeableImageView>(R.id.image_View)



    fun bind(task:TaskModel,openTaskDetail: (task: TaskModel) -> Unit){
        title_text.text=task.title
       image_view.setImageResource(task.image_View)



        itemView.setOnClickListener{
            openTaskDetail.invoke(task)

        }
    }
}
/*chamada do video
val video_chuva= itemview.findViewById<VideoView>(R.id.video_play)*/
// image_back.setImageResource(task.image_back)

/* codigo pra setar um video
       val videoUri = Uri.parse("android.resource://${itemView.context.packageName}/${task.video_view}")
        video_chuva.setVideoURI(videoUri)*/
/* codigo pro video ja rodar quando iniciar a task
    video_chuva.start()*/
