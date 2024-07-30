package ip.tomichek.tv

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.util.Log

class FullScreenPlayerActivity : AppCompatActivity() {

    private lateinit var playerView: PlayerView
    private lateinit var player: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_player)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                )


        playerView = findViewById(R.id.fullScreenPlayerView)
        player = SimpleExoPlayer.Builder(this)

            .build()

        playerView.player = player
        setFullScreen()
        val videoUrl = intent.getStringExtra("videoUrl")
        if (videoUrl != null) {
            val userAgent = "AndroidTV/9"
            val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()
                .setUserAgent(userAgent)


            if (videoUrl.endsWith(".m3u8")) {
                val hlsMediaSource = HlsMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(MediaItem.fromUri(Uri.parse(videoUrl)))

                player.setMediaSource(hlsMediaSource)
            } else {

                val progressiveMediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(MediaItem.fromUri(Uri.parse(videoUrl)))

                player.setMediaSource(progressiveMediaSource)
            }

            // Добавляем логи
            player.addListener(object : Player.Listener {
                override fun onPlaybackStateChanged(state: Int) {
                    Log.d("ExoPlayer", "Playback state: $state")
                }

                override fun onPlayerError(error: PlaybackException) {
                    Log.e("ExoPlayer", "Error during playback", error)
                }
            })

            player.addListener(object : Player.Listener {
                override fun onPlayerError(error: PlaybackException) {
                    Log.e("ExoPlayer", "Error during playback", error)
                }
            })

            player.prepare()
            player.play()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
    private fun setFullScreen() {
        // Устанавливаем масштабирование для приближения изображения
        playerView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT


        val layoutParams = playerView.layoutParams as ViewGroup.LayoutParams


        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT


        playerView.layoutParams = layoutParams


        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

}