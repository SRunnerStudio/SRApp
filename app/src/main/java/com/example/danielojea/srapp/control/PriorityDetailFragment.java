package com.example.danielojea.srapp.control;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.danielojea.srapp.R;
import com.example.danielojea.srapp.charactercreation.PriorityDetailActivity;
import com.example.danielojea.srapp.charactercreation.PriorityListActivity;


/**
 * A fragment representing a single PriorityItem detail screen.
 * This fragment is either contained in a {@link PriorityListActivity}
 * in two-pane mode (on tablets) or a {@link PriorityDetailActivity}
 * on handsets.
 */
public class PriorityDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private PriorityContentProvider.PriorityItem mItem;
    View rootView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */

    public PriorityDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = PriorityContentProvider.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.priority_detail_list, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.priorityitem_detailA)).setText(mItem.details[0]);
            ((TextView) rootView.findViewById(R.id.priorityitem_detailB)).setText(mItem.details[1]);
            ((TextView) rootView.findViewById(R.id.priorityitem_detailC)).setText(mItem.details[2]);
            ((TextView) rootView.findViewById(R.id.priorityitem_detailD)).setText(mItem.details[3]);
            ((TextView) rootView.findViewById(R.id.priorityitem_detailE)).setText(mItem.details[4]);
        }

        return rootView;
    }

}
