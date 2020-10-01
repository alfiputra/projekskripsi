package ap.mobile.belajarkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ap.mobile.formtes.R
import ap.mobile.formtes.data.Video


class Adapter(val userList: List<Video>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtId.text = userList.get(position).id
        holder.txtTitle.text = userList.get(position).title
        holder.txtDuration.text = userList.get(position).duration.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_video, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtId = itemView.findViewById<TextView>(R.id.txtId)
        val txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)
        val txtDuration = itemView.findViewById<TextView>(R.id.txtDuration)
    }

}