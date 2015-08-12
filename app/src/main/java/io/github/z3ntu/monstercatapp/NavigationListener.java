package io.github.z3ntu.monstercatapp;

import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;

/**
 * Created by luca on 29.07.15.
 */
public class NavigationListener implements NavigationView.OnNavigationItemSelectedListener {

    private static final long DRAWER_CLOSE_DELAY_MS = 250;

    private final Handler mDrawerActionHandler = new Handler();

    private final MonstercatApp mMonstercatApp;
    private final DrawerLayout mDrawerLayout;

    public NavigationListener(MonstercatApp monstercatApp, DrawerLayout drawerLayout) {
        mMonstercatApp = monstercatApp;
        this.mDrawerLayout = drawerLayout;
    }


    @Override
    public boolean onNavigationItemSelected(final MenuItem menuItem) {
//        menuItem.setChecked(true);

        // allow some time after closing the drawer before performing real navigation
        // so the user can see what is happening
        mDrawerLayout.closeDrawer(GravityCompat.START);
        mDrawerActionHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mMonstercatApp.navigate(menuItem.getItemId());
            }
        }, DRAWER_CLOSE_DELAY_MS);


        return true;
    }
}
