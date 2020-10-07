package ap.mobile.formtes.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ap.mobile.formtes.R
import ap.mobile.formtes.data.listVideo


class VideoAdapter(var listVideos: List<listVideo>): RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    private var vClickListener: VideoClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_video, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = listVideos.get(position)
        video.let { holder.bindItems(it)
        }
    }

    override fun getItemCount(): Int {
        return listVideos.size ?:0
    }

    fun getItem(position: Int): listVideo?{
        return listVideos.get(position)
    }

    fun setOnItemClickListener(videoClickListener: VideoClickListener){
        this.vClickListener = videoClickListener
    }

    inner class ViewHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {
        val itemId = itemView.findViewById<TextView>(R.id.txtId)
        val itemTitle = itemView.findViewById<TextView>(R.id.txtTitle)
        val itemDuration = itemView.findViewById<TextView>(R.id.txtDuration)

        init {
            if (vClickListener != null) {
                itemView.setOnClickListener(this)
            }
        }

        fun bindItems(listVideo: listVideo) {
            itemId.text=listVideo.id
            itemTitle.text=listVideo.title
            itemDuration.text=listVideo.duration.toString()
        }

        override fun onClick(v: View?) {
            if (v != null) {
                vClickListener?.onItemClick(v, adapterPosition)
            }
        }
    }

    interface VideoClickListener {
        fun onItemClick(v: View, position: Int)
    }
}
        //lama
//        val itemId = itemView.findViewById<TextView>(R.id.txtId)
//        val itemTitle = itemView.findViewById<TextView>(R.id.txtTitle)
//        val itemDuration = itemView.findViewById<TextView>(R.id.txtDuration)
//
//        init {
//
//            itemView.setOnClickListener { v: View -> val position: Int = adapterPosition
//                Toast.makeText(itemView.context, itemTitle.text, Toast.LENGTH_SHORT).show()

        //---
                //                Toast.makeText(itemView.context,
//                    "You clicked on item  ${position + 1}",
//                    Toast.LENGTH_SHORT).show()

//            }
//        }
//    }
//}
