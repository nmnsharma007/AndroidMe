package com.example.android.androidme.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.androidme.R;
import com.example.android.androidme.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity implements
        MasterListFragment.onImageClickListener{

    // Variables to store the values for list index of the selected images
    // the default value will be index = 0
    private int headIndex;
    private int bodyIndex;
    private int legIndex;
    private boolean mTwoPane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.android_me_linear_layout) != null){
            mTwoPane = true;
            // Getting rid of the next button
            Button button = findViewById(R.id.next_button);
            button.setVisibility(View.GONE);
            GridView gridView = findViewById(R.id.images_grid_view);
            gridView.setNumColumns(2);
            if(savedInstanceState == null){
                setContentView(R.layout.activity_android_me);
                FragmentManager fragmentManager = getSupportFragmentManager();
                BodyPartFragment headFragment = new BodyPartFragment();
                BodyPartFragment bodyFragment = new BodyPartFragment();
                BodyPartFragment legsFragment = new BodyPartFragment();
                headFragment.setImageIds(AndroidImageAssets.getHeads());
                bodyFragment.setImageIds(AndroidImageAssets.getBodies());
                legsFragment.setImageIds(AndroidImageAssets.getLegs());
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
        else{
            mTwoPane = false;
        }
    }

    @Override
    public void onImageSelected(int position) {
        int bodyPartNumber = position/12;
        // store the correct list index no matter where in the image list has been clicked
        int listIndex = position - 12 * bodyPartNumber;
        if(mTwoPane == true) {
            // handle two pane case
            BodyPartFragment newFragment = new BodyPartFragment();
            // set the currently displayed item for the correct body part fragment
            switch (bodyPartNumber) {
                case 0:
                    // A head image has been clicked
                    newFragment.setImageIds(AndroidImageAssets.getHeads());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.head_container,newFragment)
                            .commit();
                    break;
                case 1:
                    // A head image has been clicked
                    newFragment.setImageIds(AndroidImageAssets.getHeads());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container,newFragment)
                            .commit();
                    break;
                case 2:
                    // A head image has been clicked
                    newFragment.setImageIds(AndroidImageAssets.getHeads());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.legs_container,newFragment)
                            .commit();
                    break;

            }
        }
        else{
            switch (bodyPartNumber) {
                case 0: headIndex = listIndex;
                    break;
                case 1: bodyIndex = listIndex;
                    break;
                case 2: legIndex = listIndex;
                    break;
                default: break;
            }
            Bundle b = new Bundle();
            b.putInt("headIndex",headIndex);
            b.putInt("bodyIndex",bodyIndex);
            b.putInt("legIndex",legIndex);

            // Attach the bundle to an intent
            final Intent intent = new Intent(this,AndroidMeActivity.class);
            intent.putExtra("Bundle",b);
            Button button = findViewById(R.id.next_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(intent);
                }
            });
        }
    }
}