package mobi.mpk.chessandroid.ui;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import javax.inject.Inject;

import mobi.mpk.chessandroid.App;
import mobi.mpk.chessandroid.R;

public class ActionBar {

    @Inject
    GamePresenter presenter;

    public ActionBar(final Activity activity, Toolbar toolbar) {

        App.getComponent().inject(this);

        new Drawer()
                .withActivity(activity)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(FontAwesome.Icon.faw_home).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_new_game).withIcon(FontAwesome.Icon.faw_gamepad),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_list_players).withIcon(FontAwesome.Icon.faw_users).setEnabled(false),
                        new SectionDrawerItem().withName(R.string.drawer_item_settings),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_help).withIcon(FontAwesome.Icon.faw_question_circle).setEnabled(false),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(FontAwesome.Icon.faw_cogs),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_exite).withIcon(FontAwesome.Icon.faw_sign_out).withIdentifier(3).setEnabled(false)
                ).withOnDrawerListener(new Drawer.OnDrawerListener() {
            @Override
            public void onDrawerOpened(View drawerView) {


            }

            @Override
            public void onDrawerClosed(View drawerView) {
            }
        }).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                if (drawerItem instanceof Nameable) {

                    int nameRes = ((Nameable) drawerItem).getNameRes();

                    if (nameRes == R.string.drawer_item_home && !(activity instanceof MainActivity)) {
                        Intent intent = new Intent(activity, MainActivity.class);
                        activity.startActivity(intent);
                    } else if (nameRes == R.string.drawer_item_new_game) {

                        presenter.setContext(activity);
                        presenter.openWaitingGame();

                    } else if (nameRes == R.string.drawer_item_settings && !(activity instanceof SettingsActivity)) {
                        Intent intent = new Intent(activity, SettingsActivity.class);
                        activity.startActivity(intent);
                    }

                }
            }
        })
                .build();
    }

}
