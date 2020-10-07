package ap.mobile.formtes

import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ap.mobile.formtes.Adapter.AsmrtistAdapter
import ap.mobile.formtes.data.listAsmrtist
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.menu_terapi_asmrtist.*
import java.io.IOException
import java.io.InputStream

class MenuTerapiAsmrtist :AppCompatActivity () {

    //val videoList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_terapi_asmrtist)

        val items = listOf<listAsmrtist>(
            listAsmrtist("jojo_asmr",R.drawable.jojo_asmr, R.drawable.jojo_asmr, "aaaaaa"),
            listAsmrtist("dennis_asmr",R.drawable.dennis_asmr, R.drawable.dennis_asmr, "bbbbbb"),
            listAsmrtist("tingting_asmr",R.drawable.tingting_asmr, R.drawable.tingting_asmr, "cccccc")
        )

        val a_json: String

        try {
            val aInputStream: InputStream = assets.open("ASMRtist.json")

            a_json = aInputStream.bufferedReader().use { it.readText() }

            val asmr = object : TypeToken<List<listAsmrtist>>() {}.type

            val listAsmrtist: List<listAsmrtist> = Gson().fromJson(a_json, asmr)

            val aAdapter = AsmrtistAdapter(applicationContext ,listAsmrtist)



            rv_asmrtist.setHasFixedSize(true)
            rv_asmrtist.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

            rv_asmrtist.adapter = aAdapter

            aAdapter.setOnItemClickListener(object : AsmrtistAdapter.AsmrClickListener {
                override fun onItemClick(v: View, position: Int) {
                    Toast.makeText(
                        this@MenuTerapiAsmrtist,
                        "Cliked: ${aAdapter.getItem(position)}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })

        } catch (e: IOException) {

        }
    }
}