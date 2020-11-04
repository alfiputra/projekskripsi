package ap.mobile.formtes.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ap.mobile.formtes.R
import ap.mobile.formtes.room.Data
import ap.mobile.formtes.tes.PenyimpananTes
import kotlinx.android.synthetic.main.list_penyimpanan_tes.view.*

class DataAdapter(val allData: ArrayList<Data>): RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val customView = layoutInflater.inflate(R.layout.list_penyimpanan_tes, parent, false)
        return DataViewHolder(customView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = allData.get(position)
        holder.dataView.save_result.text = data.data
        holder.dataView.save_date.text = data.date
    }

    override fun getItemCount(): Int {
        return allData.size
    }

    class DataViewHolder(val dataView: View): RecyclerView.ViewHolder(dataView){
//        companion object{
//            val DATA_KEY = "DATA"
//            val DATE_KEY = "DATE"
//        }
        init {
            dataView.setOnClickListener{
                val intent = Intent(dataView.context, PenyimpananTes::class.java)
//                intent.putExtra(DATA_KEY, data?.data)
//                intent.putExtra(DATE_KEY, data?.date)
                dataView.context.startActivity(intent)
            }
        }
    }

    fun setData(list: List<Data>){
        allData.clear()
        allData.addAll(list)
        notifyDataSetChanged()
    }
}