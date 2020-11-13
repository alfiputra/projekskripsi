package ap.mobile.formtes.tes

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ap.mobile.formtes.R
import ap.mobile.formtes.adapter.DataAdapter
import ap.mobile.formtes.room.DataDB
import kotlinx.android.synthetic.main.penyimpanan_tes.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PenyimpananTes: AppCompatActivity() {

    val db by lazy { DataDB(this) }
    lateinit var dataAdapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.penyimpanan_tes)

        setupRecycleview()
    }

    override fun onStart(){
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val notes = db.dataDao().getData()
            Log.d("HasilTes", "dbResponse: $notes")
            withContext(Dispatchers.Main){
                dataAdapter.setData(notes)
            }
        }
    }


    fun setupRecycleview(){
        dataAdapter = DataAdapter(arrayListOf())
        list_data.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = dataAdapter
        }
    }
}