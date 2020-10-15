package ap.mobile.formtes.Adapter

import android.content.Context
import android.media.Image
import android.media.ImageReader
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import ap.mobile.formtes.R
import ap.mobile.formtes.data.listAsmrtist
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_asmrtist.view.*
import kotlinx.android.synthetic.main.layout_video.view.*

class AsmrtistAdapter(var context: Context, var listAsmrtist: List<listAsmrtist>): RecyclerView.Adapter<AsmrtistAdapter.ViewHolder>() {

    private var aClickListener: AsmrClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_asmrtist, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val asmr = listAsmrtist.get(position)

        holder.v.txtAsmrtist.text = asmr.name
        holder.v.txtDesctiption.text = asmr.description

        val thumbnailImageView =holder.v.imgThumbnail
        Picasso.get().load(asmr.thumbnail).into(thumbnailImageView)

        val profileImageView = holder.v.imgProfile
        Picasso.get().load(asmr.profile).into(profileImageView)
//
//
//        asmr.let { holder.bindItems(it)
//
//        }
    }

    override fun getItemCount(): Int {
        return listAsmrtist.size ?:0
    }

    fun getItem(position: Int): listAsmrtist?{
        return listAsmrtist.get(position)
    }

    fun setOnItemClickListener(asmrClickListener: AsmrClickListener){
        this.aClickListener = asmrClickListener
    }

    inner class ViewHolder(val v: View): RecyclerView.ViewHolder(v), View.OnClickListener{

//        val itemAsmrtist = itemView.findViewById<TextView>(R.id.txtAsmrtist)
//        val itemDescription = itemView.findViewById<TextView>(R.id.txtDesctiption)
//        val itemProfile = itemView.findViewById<ImageView>(R.id.imgProfile)
//        val itemThumbnail = itemView.findViewById<ImageView>(R.id.imgThumbnail)

    init {
        if (aClickListener != null){
            itemView.setOnClickListener(this)
        }
    }

//        fun bindItems(listAsmrtist: listAsmrtist) {
//
////            itemAsmrtist.text = listAsmrtist.name
////            itemDescription.text = listAsmrtist.description
//
////            itemProfile.setImageResource(listAsmrtist.profile)
////            itemThumbnail.setImageResource(listAsmrtist.thumbnail)
//
// //           val resources = context.getResources()
////            val resourceId = context.resources.getIdentifier(listAsmrtist.profile,"drawable",context.packageName)
////            itemProfile.imageView.setImageDrawable(ContextCompat.getDrawable(context,resourceId))
////            itemThumbnail.view = listAsmrtist.thumbnail
//        }

        override fun onClick(v: View?) {
            if (v != null) {
                aClickListener?.onItemClick(v, adapterPosition)
            }
        }
    }

    interface AsmrClickListener {
        fun onItemClick(v: View, position: Int)
    }
}

