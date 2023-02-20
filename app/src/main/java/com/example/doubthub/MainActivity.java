package com.example.doubthub;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.doubthub.Fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HomeFragment homeFragment= new HomeFragment();
        NotificationFragment notificationFragment = new NotificationFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        AddFragment addFragment = new AddFragment();
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;
                    case R.id.nav_add:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, addFragment).commit();
                        return true;
                    case R.id.nav_notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, notificationFragment).commit();
                        return true;
                    case R.id.nav_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
                        return true;
                }
                    return false;
            }
        });
    }
}


//                    case R.id.nav_profile:
//                        SharedPreferences.Editor editor = getSharedPreferences("Preps",MODE_PRIVATE).edit();
//                        editor.putString("profileid", FirebaseAuth.getInstance().getCurrentUser().getUid());
//                        editor.apply();
//                        selectedFragment = new ProfileFragment();
//                        break;

