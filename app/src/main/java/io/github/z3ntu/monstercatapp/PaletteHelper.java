package io.github.z3ntu.monstercatapp;

import android.graphics.Bitmap;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;

/**
 * Created by luca on 15.07.15.
 */
public class PaletteHelper {

    public static void setPaletteToolbar(Bitmap bitmap, final Toolbar toolbar, final CollapsingToolbarLayout collapsingToolbarLayout) {
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                int defaultColor = 0xfff;
//                mToolbar.setBackgroundColor(palette.getLightVibrantColor(defaultColor));
                collapsingToolbarLayout.setContentScrimColor(palette.getLightVibrantColor(defaultColor));
//                mToolbar.setTitleTextColor(palette.getMutedSwatch().getTitleTextColor());
//                mToolbar.setTitleTextColor(Color.RED);
//                mToolbar.setTitleTextColor(0x000000);
//                mCollapsingToolbarLayout.setExpandedTitleColor(palette.getMutedSwatch().getTitleTextColor());
                collapsingToolbarLayout.setCollapsedTitleTextColor(palette.getVibrantSwatch().getTitleTextColor());
                collapsingToolbarLayout.setStatusBarScrimColor(palette.getVibrantSwatch().getTitleTextColor());
//                mToolbar.setTit
//                mToolbar.setTitle(R.string.app_name);
            }
        });
    }

}
