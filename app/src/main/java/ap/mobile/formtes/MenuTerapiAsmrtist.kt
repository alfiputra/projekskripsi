package ap.mobile.formtes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ap.mobile.formtes.Adapter.AsmrtistAdapter
import ap.mobile.formtes.data.ListAsmrtist
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.menu_terapi_list_asmrtist.*
import java.io.IOException
import java.io.InputStream

class MenuTerapiAsmrtist :AppCompatActivity () {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_terapi_list_asmrtist)

        val a_json: String

        try {
            val aInputStream: InputStream = assets.open("ASMRtist.json")
            a_json = aInputStream.bufferedReader().use { it.readText() }

            val asmr = object: TypeToken<List<ListAsmrtist>>() {}.type

            val listAsmrtist: List<ListAsmrtist> = Gson().fromJson(a_json, asmr)
            val aAdapter = AsmrtistAdapter(listAsmrtist)

            rv_asmrtist.setHasFixedSize(true)
            rv_asmrtist.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

            rv_asmrtist.adapter = aAdapter

        } catch (e: IOException) {

        }
    }
}