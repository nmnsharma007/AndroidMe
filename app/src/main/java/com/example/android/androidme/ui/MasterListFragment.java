package com.example.android.androidme.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.android.androidme.R;
import com.example.android.androidme.data.AndroidImageAssets;


// This fragment displays all of the AndroidMe images in one large list
// The list appears as a grid of images
public class MasterListFragment extends Fragment {

    //empty constructor
    public MasterListFragment() {

    }

    // inflates the grid view of all AndroidMe images
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        final View rootView = inflater.inflate(R.layout.fragment_master_list,
                container,false);
        // Get a reference to the GridView in the fragment_master_list xml layout file
        GridView gridView = rootView.findViewById(R.id.images_grid_view);
        // create the adapter
        // This adapter takes in the context and an ArrayList of all the image resources to display
        MasterListAdapter mAdapter = new MasterListAdapter(getContext(),AndroidImageAssets.getAll());
        // set the adapter on the grid view
        gridView.setAdapter(mAdapter);
        return rootView;
    }
}
