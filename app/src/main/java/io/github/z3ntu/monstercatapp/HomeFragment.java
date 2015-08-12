package io.github.z3ntu.monstercatapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by luca on 29.07.15.
 */
public class HomeFragment extends Fragment {

    private MonstercatApp mMonstercatApp;

    public static final HomeFragment newInstance(MonstercatApp monstercatApp) {
        System.out.println("newinstance");
        HomeFragment hf = new HomeFragment();
        hf.setMonstercatApp(monstercatApp);
        return hf;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);
        initInstances(v);
        System.out.println(v.findViewById(R.id.home_textView).toString());
        if(!mMonstercatApp.isAppInstalled("com.google.android.youtube"))
            Toast.makeText(mMonstercatApp.getApplicationContext(), R.string.youtube_not_found, Toast.LENGTH_LONG).show();
        return v;
    }

    private void initInstances(View v) {

    }


    public void setMonstercatApp(MonstercatApp monstercatApp) {
        this.mMonstercatApp = monstercatApp;
    }
}
