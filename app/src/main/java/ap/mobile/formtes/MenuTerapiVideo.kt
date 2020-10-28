package ap.mobile.formtes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ap.mobile.formtes.Adapter.AsmrtistAdapter
import ap.mobile.formtes.Adapter.VideoAdapter
import ap.mobile.formtes.data.ListVideo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.menu_terapi_list_video.*
import java.io.IOException
import java.io.InputStream

class MenuTerapiVideo :AppCompatActivity () {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_terapi_list_video)

        val v_json: String

        val navBarTitle = intent.getStringExtra(AsmrtistAdapter.CustomViewHolder.CHANNEL_NAME_KEY)
        supportActionBar?.title = navBarTitle

        val source = intent.getStringExtra(AsmrtistAdapter.CustomViewHolder.LINK_VIDEO_JSON_KEY)
//        println(source)

        try {
            val vInputStream: InputStream = assets.open(source)

            v_json = vInputStream.bufferedReader().use { it.readText() }

            val vd = object : TypeToken<List<ListVideo>>() {}.type

            val listVideo: List<ListVideo> = Gson().fromJson(v_json, vd)

            val vAdapter = VideoAdapter(listVideo)

            rv_video.setHasFixedSize(true)
            rv_video.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

            rv_video.adapter = vAdapter

        } catch (e: IOException) {

        }
    }
}