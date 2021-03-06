package progmobile.coursenligne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class StreamingActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY="AIzaSyAuuPqwHjlE4nbOz8EF1Gw95tFYj5HtaXc";//obligatoire, clé perso qu'il faut demander à google pour avoir le droit d'utiliser l'api youtube dans un projet
    public static String VIDEO_ID="QjICgmk31js";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming);
        /*VideoView vidView = (VideoView)findViewById(R.id.video);
        String vidAddress = "rtsp://v6.cache4.c.youtube.com/CigLENy73wIaHwmh5W2TKCuN2RMYDSANFEgGUgx1c2VyX3VwbG9hZHMM/0/0/0/video.3gp";
        Uri vidUri = Uri.parse(vidAddress);
        vidView.setVideoURI(vidUri);

        //vidView.setVideoPath("http://www.dailymotion.com/video/x5j58uo_the-definitive-guide-to-sqlite_school");

        vidView.start();*/
        Bundle b=getIntent().getExtras();
        String pathCours=b.getString("pathCours");

        //Pour initialiser une vidéo youtube on a juste besoin de la chaine de caractère à la fin
        // de la vidéo, par exemple https://www.youtube.com/watch?v=4a0FbQdH3dY -> 4a0FbQdH3dY
        String[] split=pathCours.split("v=");

        //si le split n'a rien splitté parce que le path donné était déjà de la forme 4a0FbQdH3dY
        if (split.length<2)
            VIDEO_ID=split[0];
        else VIDEO_ID=split[1];

        Toast.makeText(this,VIDEO_ID,Toast.LENGTH_SHORT).show();
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.video);
        youTubePlayerView.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean b) {
        if(null== player) return;

        // Start buffering
        if (!b) {
            player.cueVideo(VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failed to initialize.", Toast.LENGTH_LONG).show();
    }
}
