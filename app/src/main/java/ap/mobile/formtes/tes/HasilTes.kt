package ap.mobile.formtes.tes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ap.mobile.formtes.R
import ap.mobile.formtes.adapter.DataAdapter
import ap.mobile.formtes.room.Data
import ap.mobile.formtes.room.DataDB
import kotlinx.android.synthetic.main.hasil_tes.*
import kotlinx.android.synthetic.main.penyimpanan_tes.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.DateFormat
import java.util.*


class HasilTes:AppCompatActivity() {

    val db by lazy { DataDB(this) }
//    private lateinit var dataAdapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hasil_tes)

        val hasil = intent.getStringExtra("Hasil")
        val hasilTes = findViewById<TextView>(R.id.textView)
        hasilTes.text = hasil

        val calendar = Calendar.getInstance()
        val currentDate: String = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.time)
        val date = findViewById<TextView>(R.id.textView_date)
        date.text = currentDate

//        list_data.layoutManager = LinearLayoutManager(this)
//        //list_data.adapter = DataAdapter

        setupListener()
    }

    override fun onStart(){
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val notes = db.dataDao().getData()
            Log.d("HasilTes", "dbResponse: $notes")
//            withContext(Dispatchers.Main){
//                dataAdapter.setData(notes)
//            }
        }
    }

    fun setupListener(){
        button.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.dataDao().insertData(
                    Data(0, textView.text.toString(), textView_date.text.toString())
                )
            }
            intent = Intent(this,PenyimpananTes::class.java)
            startActivity(intent)
        }
    }
}