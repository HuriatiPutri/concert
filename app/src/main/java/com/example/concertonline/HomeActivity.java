package com.example.concertonline;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.concertonline.ui.akun.AkunFragment;
import com.example.concertonline.ui.home.HomeFragment;
import com.example.concertonline.ui.inbox.InboxFragment;
import com.example.concertonline.ui.watch.WatchFragment;

public class HomeActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fr_container, HomeFragment.newInstance())
                            .commitNow();
                    return true;
                case R.id.navigation_dashboard:
                   getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fr_container, WatchFragment.newInstance())
                            .commitNow();
                    return true;
                case R.id.navigation_notifications:
                    getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fr_container, InboxFragment.newInstance())
                        .commitNow();
                    return true;
                case R.id.navigation_akuns:
                    getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fr_container, AkunFragment.newInstance())
                        .commitNow();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
//        mTextMessage = findViewById(R.id.message);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fr_container, HomeFragment.newInstance())
                .commitNow();
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
