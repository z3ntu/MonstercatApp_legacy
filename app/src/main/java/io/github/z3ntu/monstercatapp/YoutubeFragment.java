package io.github.z3ntu.monstercatapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by luca on 17.07.15.
 */
public class YoutubeFragment extends Fragment {
    private MonstercatApp mMonstercatApp;

    private MonstercatHelper monstercatHelper;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public static final YoutubeFragment newInstance(MonstercatApp monstercatApp) {
        System.out.println("newinstance");
        YoutubeFragment yf = new YoutubeFragment();
        yf.setMonstercatApp(monstercatApp);
        return yf;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.youtube_fragment, container, false);
        initInstances(v);
        return v;
    }

    private void initInstances(View v) {
        monstercatHelper = new MonstercatHelper(mMonstercatApp.getApplicationContext(), mMonstercatApp.mRequestQueue);

               /* RECYCLERVIEW */

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(mMonstercatApp);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerViewAdapter(new ArrayList<MonstercatVideo>(), mMonstercatApp);

        monstercatHelper.getMonstercatVideos((RecyclerViewAdapter) mAdapter);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setItemViewCacheSize(15);
    }

    public void setMonstercatApp(MonstercatApp monstercatApp) {
        this.mMonstercatApp = monstercatApp;
    }
}
