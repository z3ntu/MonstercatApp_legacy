package io.github.z3ntu.monstercatapp;

import android.support.annotation.DrawableRes;

/**
 * Created by luca on 09.07.15.
 */
public class RecyclerViewItem {
    protected String text;
    @DrawableRes
    protected int resid;

    public RecyclerViewItem(String text, @DrawableRes int resid) {
        this.text = text;
        this.resid = resid;
    }
}
