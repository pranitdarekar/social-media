package com.example.socialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.Window;

import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class OtherUser extends AppCompatActivity {

    Toolbar toolbar;
    String otherUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_other_user);

        otherUser = getIntent().getStringExtra("searched_username");

        toolbar = findViewById(R.id.toolbar_other_user);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(otherUser);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        SubMenu subMenu = menu.findItem(R.id.main_menu).getSubMenu();
        for (int i = 0; i < subMenu.size(); i++) {
            MenuItem subMenuItem = subMenu.getItem(i);
            subMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    // Handle submenu item tap
                    switch (item.getItemId()) {
                        case R.id.add_posts:
                            Intent addPostIntent = new Intent(getApplicationContext(), AddPost.class);
                            startActivity(addPostIntent);
                            finish();
                            break;
                        case R.id.logout:
                            FirebaseAuth.getInstance().signOut();
                            Intent logoutIntent = new Intent(getApplicationContext(), Login.class);
                            startActivity(logoutIntent);
                            finish();
                            break;
                        case R.id.edit_profile:
                            Intent editProfileIntent = new Intent(getApplicationContext(), EditProfile.class);
                            startActivity(editProfileIntent);
                            finish();
                            break;
                        case R.id.search_user:
                            Intent searchUserIntent = new Intent(getApplicationContext(), SearchUser.class);
                            startActivity(searchUserIntent);
                            finish();
                            break;
                    }
                    return true;
                }
            });
        }
        return true;
    }
}