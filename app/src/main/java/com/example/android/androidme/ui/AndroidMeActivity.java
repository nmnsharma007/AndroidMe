package com.example.android.androidme.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.android.androidme.R;
import com.example.android.androidme.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and
// legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        if(savedInstanceState == null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            BodyPartFragment headFragment = new BodyPartFragment();
            BodyPartFragment bodyFragment = new BodyPartFragment();
            BodyPartFragment legsFragment = new BodyPartFragment();
            headFragment.setImageIds(AndroidImageAssets.getHeads());
            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            legsFragment.setImageIds(AndroidImageAssets.getLegs());
            headFragment.setListIndex(1);
            bodyFragment.setListIndex(1);
            legsFragment.setListIndex(1);
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_head_view,headFragment)
                    .commit();
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_body_view,bodyFragment)
                    .commit();
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_legs_view,legsFragment)
                    .commit();
        }
    }
}