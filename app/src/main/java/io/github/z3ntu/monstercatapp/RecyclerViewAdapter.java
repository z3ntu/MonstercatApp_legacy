package io.github.z3ntu.monstercatapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;

/**
 * Created by luca on 21.07.15.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements YouTubeThumbnailView.OnInitializedListener {

    private ArrayList<MonstercatVideo> mDataset;
    private RecyclerView.OnClickListener mOnClickListener;

    public RecyclerViewAdapter(@NonNull ArrayList<MonstercatVideo> dataset, @NonNull MonstercatApp monstercatApp) {
        mDataset = dataset;
        mOnClickListener = new RecyclerClickListener(monstercatApp);
    }

    public void add(MonstercatVideo monstercatVideo) {
        mDataset.add(monstercatVideo);
        notifyItemInserted(mDataset.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        v.setOnClickListener(mOnClickListener);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
//        viewHolder.mTextView.setText(mDataset[i]);
        viewHolder.mThumbnailView.setTag(mDataset.get(i).videoId);
        viewHolder.mThumbnailView.initialize(Config.API_KEY, this);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
        youTubeThumbnailLoader.setVideo(youTubeThumbnailView.getTag().toString());
    }

    @Override
    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
        System.out.println("weird error - " + youTubeInitializationResult.toString());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public YouTubeThumbnailView mThumbnailView;

        public ViewHolder(View v) {
            super(v);
            mThumbnailView = (YouTubeThumbnailView) v.findViewById(R.id.thumbnailView);
        }
    }

}