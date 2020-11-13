package ap.mobile.formtes.tes

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import ap.mobile.formtes.R
import ap.mobile.formtes.room.DataDB
import kotlinx.android.synthetic.main.soal_tes.*

class SoalTes : AppCompatActivity() {

    val map_nilai = mapOf<String, Int>("Tidak Ada" to 0,"Ringan" to 1, "Sedang" to 2, "Berat" to 3,
        "Sangat Parah" to 4, "Sangat Puas" to 0,"Puas" to 1, "Cukup Puas" to 2, "Tidak Puas" to 3, "Sangat Tidak PUas" to 4,
        "Sama Sekali Tidak Terlihat" to 0,"Sedikit Terlihat" to 1, "Cukup Terlihat" to 2, "Sangat Terlihat" to 3, "Luar Biasa Terlihat" to 4,
        "Sama Sekali Tidak Khawatir" to 0,"Sedikit Khawatir" to 1, "Cukup Khawatir" to 2, "Sangat Khawatir" to 3, "Luar Biasa Khawatir" to 4,
        "Sama Sekali Tidak Berpengaruh" to 0,"Sedikit Berpengaruh" to 1, "Cukup Berpengaruh" to 2, "Sangat Berpengaruh" to 3, "Luar Biasa Berpengaruh" to 4)

    var hasil: Int = 0
    val db by lazy { DataDB(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.soal_tes)

        val rg1 = findViewById<RadioGroup>(R.id.rgOpsiNomer1)
        val rg2 = findViewById<RadioGroup>(R.id.rgOpsiNomer2)
        val rg3 = findViewById<RadioGroup>(R.id.rgOpsiNomer3)
        val rg4 = findViewById<RadioGroup>(R.id.rgOpsiNomer4)
        val rg5 = findViewById<RadioGroup>(R.id.rgOpsiNomer5)
        val rg6 = findViewById<RadioGroup>(R.id.rgOpsiNomer6)
        val rg7 = findViewById<RadioGroup>(R.id.rgOpsiNomer7)

        rg1?.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            hasil += map_nilai.get(radio.text.toString())!!.toInt()
        }
        rg2.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            hasil += map_nilai.get(radio.text.toString())!!.toInt()
        }
        rg3.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            hasil += map_nilai.get(radio.text.toString())!!.toInt()
        }
        rg4.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            hasil += map_nilai.get(radio.text.toString())!!.toInt()
        }
        rg5.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            hasil += map_nilai.get(radio.text.toString())!!.toInt()
        }
        rg6.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            hasil += map_nilai.get(radio.text.toString())!!.toInt()
        }
        rg7.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            hasil += map_nilai.get(radio.text.toString())!!.toInt()
        }
        setupListener()
    }

    fun setupListener(){
        btnProses.setOnClickListener {
            val hasilTes = hasil.toString()
            val intent = Intent(this@SoalTes, HasilTes::class.java)
            intent.putExtra("Hasil", hasilTes)
            startActivities(arrayOf(intent))
        }
    }
}