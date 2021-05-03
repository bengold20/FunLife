package com.make.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.TableLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.make.adapter.LoginAdapter;
import com.make.main.R;

import static com.make.main.R.drawable.facebook1;
import static com.make.main.R.drawable.img_gg;
import static com.make.main.R.drawable.twitter;

public class LoginActivity extends AppCompatActivity {

    TabLayout tabLayoutLogin;
    TabItem tb_login_item1, tb_login_item2;
    ViewPager viewPagerLogin;
    FloatingActionButton fbGoogle, fbFacebook, fbTwitter;

    float v = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        addControls();
        addEvents();
    }

    private void addControls() {
        tabLayoutLogin = findViewById(R.id.tb_login);

        viewPagerLogin = findViewById(R.id.vp_login);

        fbGoogle = findViewById(R.id.fab_google);
        fbFacebook = findViewById(R.id.fab_facebook);
        fbTwitter = findViewById(R.id.fab_Twitter);

        tb_login_item1 = findViewById(R.id.tb_login_item1);
        tb_login_item2 = findViewById(R.id.tb_login_item2);

        tabLayoutLogin.setTabGravity(TabLayout.GRAVITY_FILL);

        final LoginAdapter adapterLogin = new LoginAdapter(getSupportFragmentManager(), this, tabLayoutLogin.getTabCount());
        viewPagerLogin.setAdapter(adapterLogin);

        viewPagerLogin.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutLogin));

        fbFacebook.setImageResource(facebook1);
        fbFacebook.setTranslationY(300);

        fbGoogle.setImageResource(img_gg);
        fbGoogle.setTranslationY(300);

        fbTwitter.setImageResource(twitter);
        fbFacebook.setTranslationY(300);

        tabLayoutLogin.setTranslationY(300);

        fbFacebook.setAlpha(v);
        fbGoogle.setAlpha(v);
        fbTwitter.setAlpha(v);

        tabLayoutLogin.setAlpha(v);

        fbFacebook.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        fbGoogle.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        fbTwitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        tabLayoutLogin.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();

    }


    private void addEvents() {
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

}