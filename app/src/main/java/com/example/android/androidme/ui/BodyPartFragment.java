package com.example.android.androidme.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.android.androidme.R;
import com.example.android.androidme.data.AndroidImageAssets;

import java.util.List;

public class BodyPartFragment extends Fragment {

    private static final String LOG_TAG = BodyPartFragment.class.getSimpleName();
    private static final String LIST_INDEX = "list_index";
    private static final String IMAGE_ID_LIST = "image_ids";
    private List<Integer> mImageIds;
    private int mListIndex;

    // mandatory constructor for instantiating  the fragment
    public BodyPartFragment() {

    }

    /**
     * Inflates the fragment layout and sets any image resource
     */
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        // inflate the Android-Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part,container,false);
        // get a reference to the image view in the fragment layout
        final ImageView imageView = rootView.findViewById(R.id.body_part_image_view);
        if(mImageIds != null) {
            // set the image resource to display
            imageView.setImageResource(mImageIds.get(mListIndex));
            // set the image resource to the list item at the stored index
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int size = mImageIds.size();
                    mListIndex = (mListIndex + 1)%size;
                    // set the image resource to the list item at the stored index
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });

        }
        else{
            Log.v(LOG_TAG,"list is null");
        }
        return rootView;
    }

    public void setImageIds(List<Integer> imageIds){
        mImageIds = imageIds;
    }

    public void setListIndex(int index) {
        mListIndex = index;
    }
}
