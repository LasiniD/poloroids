package com.example.poloroids;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.poloroids.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationViewUser.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home){
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("HomeFragment");
                if (fragment == null) {
                    fragment = new HomeFragment();
                }
                replaceFragment(fragment);
            } else if (item.getItemId() == R.id.colors) {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("ColorsFragment");
                if (fragment == null) {
                    fragment = new ColorsFragment();
                }
                replaceFragment(fragment);
            }else if (item.getItemId() == R.id.gallery) {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("GalleryFragment");
                if (fragment == null) {
                    fragment = new GalleryFragment();
                }
                replaceFragment(fragment);
            }else if (item.getItemId() == R.id.orders) {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("OrdersFragment");
                if (fragment == null) {
                    fragment = new OrdersFragment();
                }
                replaceFragment(fragment);
            }else if (item.getItemId() == R.id.profile) {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("ProfileFragment");
                if (fragment == null) {
                    fragment = new ProfileFragment();
                }
                replaceFragment(fragment);
            }
            return true;
        });

        boolean navigateToHome = getIntent().getBooleanExtra("navigateToHome",false);
        if (navigateToHome){
            replaceFragment(new HomeFragment());
        }


    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameUser,fragment);
        fragmentTransaction.commit();
    }
}