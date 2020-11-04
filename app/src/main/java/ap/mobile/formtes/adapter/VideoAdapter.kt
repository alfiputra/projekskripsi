package ap.mobile.formtes.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ap.mobile.formtes.R
import ap.mobile.formtes.terapi.VideoPlayer
import ap.mobile.formtes.data.ListVideo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_list_video.view.*


class VideoAdapter(var Videos: List<ListVideo>): RecyclerView.Adapter<VideoAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val v = layoutInflater.inflate(R.layout.layout_list_video, parent, false)
        return CustomViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val video = Videos.get(position)

        holder.v.textView_video_title.text = video.title
        holder.v.textView_duration.text = video.duration

        val thumbnailImageView =holder.v.imageView_thumbnail
        Picasso.get().load(video.thumbnail).into(thumbnailImageView)

        holder.listVideo = Videos.get(position)
    }

    override fun getItemCount(): Int {
        return Videos.size
    }


    class CustomViewHolder(val v: View, var listVideo: ListVideo? = null): RecyclerView.ViewHolder(v){

        companion object{
            val VIDEO_ID_KEY = "VIDEO_ID"
        }

        init {
            v.setOnClickListener {

                val intent = Intent(v.context, VideoPlayer::class.java)
                intent.putExtra(VIDEO_ID_KEY, listVideo?.id)

                v.context.startActivity(intent)
            }
        }
    }
}

