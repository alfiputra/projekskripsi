package ap.mobile.formtes.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ap.mobile.formtes.MenuTerapiVideo
import ap.mobile.formtes.R
import ap.mobile.formtes.data.ListAsmrtist
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_list_asmrtist.view.*

class AsmrtistAdapter(val Asmrtist: List<ListAsmrtist>): RecyclerView.Adapter<AsmrtistAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val customView = layoutInflater.inflate(R.layout.layout_list_asmrtist, parent, false)
        return CustomViewHolder(customView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val asmr = Asmrtist.get(position)

        holder.v.textView_asmrtist.text = asmr.name
        holder.v.textView_description.text = asmr.description

        val profileImageView = holder.v.imageView_profile_asmrtist
        Picasso.get().load(asmr.profile).into(profileImageView)

        holder.listsmrtist = Asmrtist.get(position)
    }

    override fun getItemCount(): Int {
        return Asmrtist.size
    }


    class CustomViewHolder(val v: View, var listsmrtist: ListAsmrtist? = null): RecyclerView.ViewHolder(v){

        companion object{
            val LINK_VIDEO_JSON_KEY = "LINK_VIDEO_JSON"
            val CHANNEL_NAME_KEY = "CHANNEL_NAME"

        }

        init {
            v.setOnClickListener {
                val intent = Intent(v.context, MenuTerapiVideo::class.java)

                intent.putExtra(LINK_VIDEO_JSON_KEY,listsmrtist?.link)
                intent.putExtra(CHANNEL_NAME_KEY, listsmrtist?.name)

                v.context.startActivity(intent)

           }
        }
    }
}

