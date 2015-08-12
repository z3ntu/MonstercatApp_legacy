package io.github.z3ntu.monstercatapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.youtube.player.YouTubeThumbnailView;

/**
 * Created by luca on 29.07.15.
 */
public class RecyclerClickListener implements RecyclerView.OnClickListener {

    private MonstercatApp mMonstercatApp;

    public RecyclerClickListener(MonstercatApp monstercatApp) {
        this.mMonstercatApp = monstercatApp;
    }

    @Override
    public void onClick(View v) {
        YouTubeThumbnailView youTubeThumbnailView = (YouTubeThumbnailView) v.findViewById(R.id.thumbnailView);
        System.out.println(youTubeThumbnailView.getTag().toString());
//        mMonstercatApp.startYoutubeVideo(youTubeThumbnailView.getTag().toString());
        mMonstercatApp.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://youtube.com/watch?v=" + youTubeThumbnailView.getTag().toString())));
    }
}
