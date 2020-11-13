package ap.mobile.formtes.tes

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ap.mobile.formtes.R
import ap.mobile.formtes.adapter.DataAdapter
import ap.mobile.formtes.room.Data
import ap.mobile.formtes.room.DataDB
import kotlinx.android.synthetic.main.hasil_tes.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.util.*


class HasilTes:AppCompatActivity()  {

    val db by lazy { DataDB(this) }
    private lateinit var dataAdapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hasil_tes)

        dataAdapter = DataAdapter(arrayListOf())

        val hasil = intent.getStringExtra("Hasil")
        val hasilTes = findViewById<TextView>(R.id.textView)
        hasilTes.text = hasil

        val hasilDeskripsi = findViewById<TextView>(R.id.text_deskripsi)
        if(hasil.toInt() <= 7){
            hasilDeskripsi.text ="Anda tidak mengalami Insomnia"
        } else if (hasil.toInt() <= 14){
            hasilDeskripsi.text = "Anda Mengalami Insomnia Ringan"
        }else if (hasil.toInt() <= 21){
            hasilDeskripsi.text = "Anda Mengalami Insomnia Sedang"
        } else if (hasil.toInt() <= 28){
            hasilDeskripsi.text = "Anda Mengalami Insomnia Parah"
        }



        val calendar = Calendar.getInstance()
        val currentDate: String = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.time)
        val date = findViewById<TextView>(R.id.textView_date)
        date.text = currentDate

        setupListener()
    }

    fun setupListener(){
        button.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.dataDao().insertData(
                    Data(
                        0,
                        textView.text.toString(),
                        textView_date.text.toString(),
                        text_deskripsi.text.toString())
                )
            }
            intent = Intent(this, PenyimpananTes::class.java)
            startActivity(intent)
        }
    }

}