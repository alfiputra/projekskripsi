package ap.mobile.formtes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ap.mobile.belajarkotlin.Adapter
import ap.mobile.formtes.data.Video
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream

class MenuTerapi :AppCompatActivity (){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_terapi)

        val rv = findViewById<RecyclerView>(R.id.recycler_view)
        rv.layoutManager = LinearLayoutManager(applicationContext)

        val json: String
        try {
            val inputStream: InputStream = assets.open("Video.json")
            json = inputStream.bufferedReader().use { it.readText() }

            val vd = object : TypeToken<List<Video>>() {}.type
            val video: List<Video> = Gson().fromJson(json.toString(), vd)
            val adapter = Adapter(video)
            rv.adapter = adapter
        } catch (e: IOException) {

        }
    }
}