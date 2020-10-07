package ap.mobile.formtes

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ap.mobile.formtes.Adapter.VideoAdapter
import ap.mobile.formtes.data.listVideo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.menu_terapi_video.*
import java.io.IOException
import java.io.InputStream

class MenuTerapiVideo :AppCompatActivity () {

    //val videoList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_terapi_video)

        val v_json: String

        try {
            val vInputStream: InputStream = assets.open("Video.json")

            v_json = vInputStream.bufferedReader().use { it.readText() }

            val vd = object : TypeToken<List<listVideo>>() {}.type

            val listVideo: List<listVideo> = Gson().fromJson(v_json.toString(), vd)

            val vAdapter = VideoAdapter(listVideo)

            rv_video.setHasFixedSize(true)
            rv_video.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

            rv_video.adapter = vAdapter

            vAdapter.setOnItemClickListener(object : VideoAdapter.VideoClickListener {
                override fun onItemClick(v: View, position: Int) {
                    Toast.makeText(
                        this@MenuTerapiVideo,
                        "Clicked: ${vAdapter.getItem(position)}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })

        } catch (e: IOException) {

        }


        //       val mAdapter = VideoAdapter()


        //>>>>lama<<<<<
//        val rv = findViewById<RecyclerView>(R.id.recycler_view)
//        rv.layoutManager = LinearLayoutManager(applicationContext)
//
//        val json: String
//        try {
//            val inputStream: InputStream = assets.open("Video.json")
//            json = inputStream.bufferedReader().use { it.readText() }
//
//            val vd = object : TypeToken<List<Video>>() {}.type
//            val video: List<Video> = Gson().fromJson(json.toString(), vd)
//            val adapter = VideoAdapter(video)
//            rv.adapter = adapter
//
//        } catch (e: IOException) {
//
//        }
//    }


        // >>>>>--------<<<<<
//        recycler_view.layoutManager = LinearLayoutManager(this)
//        recycler_view.adapter = VideoAdapter(videoList)
//
//        postToList()
//    }
//
//    private fun addToList (video: String){
//        videoList.add(video)
//    }
//
//    fun postToList(){
//        for (i in 1..10)
//        addToList("Video ke $i")
//    }
    }
}