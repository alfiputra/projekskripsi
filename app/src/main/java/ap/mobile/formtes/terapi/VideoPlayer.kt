package ap.mobile.formtes.terapi

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ap.mobile.formtes.R
import ap.mobile.formtes.adapter.VideoAdapter
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlinx.android.synthetic.main.video_player.*


class VideoPlayer: AppCompatActivity(){
//    private lateinit var newConfig: Configuration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video_player)

        val source = intent.getStringExtra(VideoAdapter.CustomViewHolder.VIDEO_ID_KEY)

        val youTubePlayerView = findViewById<YouTubePlayerView>(R.id.youtube_player_view)
        lifecycle.addObserver(youTubePlayerView)


        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)

                val videoId = source
                youTubePlayer.loadVideo(videoId, 0f)


            }
        })
//        onConfigurationChanged()
        youTubePlayerView.enterFullScreen()
    }


//    fun onConfigurationChanged() {
//       newConfig = Configuration()
//
//        //Checks the orientation of the screen
//        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
//            //youtube_player_view.enterFullScreen()
//        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            youtube_player_view.exitFullScreen()
//        }
//    }
}