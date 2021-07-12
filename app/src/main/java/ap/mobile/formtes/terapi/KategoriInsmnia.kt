package ap.mobile.formtes.terapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ap.mobile.formtes.R
import ap.mobile.formtes.adapter.KategoriAdapter
import ap.mobile.formtes.data.ListKategori
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.menu_terapi_list_asmrtist.*
import java.io.IOException
import java.io.InputStream

class KategoriInsmnia :AppCompatActivity () {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_terapi_list_asmrtist)

        val jsonK: String

        try {
            val aInputStream: InputStream = assets.open("KategoriInsomnia.json")
            jsonK = aInputStream.bufferedReader().use { it.readText() }

            val asmr = object: TypeToken<List<ListKategori>>() {}.type

            val listKategori: List<ListKategori> = Gson().fromJson(jsonK, asmr)
            val aAdapter = KategoriAdapter(listKategori)

            rv_asmrtist.setHasFixedSize(true)
            rv_asmrtist.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

            rv_asmrtist.adapter = aAdapter

        } catch (e: IOException) {

        }
    }
}