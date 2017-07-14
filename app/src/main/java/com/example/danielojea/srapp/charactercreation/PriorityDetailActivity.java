package com.example.danielojea.srapp.charactercreation;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.Priority;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.PriorityDetailFragment;
import com.example.danielojea.srapp.R;

import java.io.Serializable;

/**
 * An activity representing a single PriorityItem detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link PriorityListActivity}.
 */
public class PriorityDetailActivity extends AppCompatActivity {
    int listItemPosition;
    Priority priorityItem;
    SRCharacter character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priorityitem_detail);
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(PriorityDetailFragment.ARG_ITEM_ID, getIntent().getStringExtra(PriorityDetailFragment.ARG_ITEM_ID));

            PriorityDetailFragment fragment = new PriorityDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.priorityitem_detail_container, fragment)
                    .commit();

            listItemPosition = (int) getIntent().getSerializableExtra("Position");
            priorityItem = (Priority) getIntent().getSerializableExtra("priorityItem");
            character = (SRCharacter) getIntent().getSerializableExtra("Character");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setPriorityA(View v) {
        ((TextView) findViewById(R.id.a)).setTextAppearance(R.style.TextAppearance_AppCompat_Large);
        ((TextView) findViewById(R.id.b)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.c)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.d)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.e)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        priorityItem.setPriority(1);
        updatePriorityDetailList();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setPriorityB(View v) {
        ((TextView) findViewById(R.id.a)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.b)).setTextAppearance(R.style.TextAppearance_AppCompat_Large);
        ((TextView) findViewById(R.id.c)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.d)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.e)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        priorityItem.setPriority(2);
        updatePriorityDetailList();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setPriorityC(View v) {
        ((TextView) findViewById(R.id.a)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.b)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.c)).setTextAppearance(R.style.TextAppearance_AppCompat_Large);
        ((TextView) findViewById(R.id.d)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.e)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        priorityItem.setPriority(3);
        updatePriorityDetailList();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setPriorityD(View v) {
        ((TextView) findViewById(R.id.a)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.b)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.c)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.d)).setTextAppearance(R.style.TextAppearance_AppCompat_Large);
        ((TextView) findViewById(R.id.e)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        priorityItem.setPriority(4);
        updatePriorityDetailList();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setPriorityE(View v) {
        ((TextView) findViewById(R.id.a)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.b)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.c)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.d)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.e)).setTextAppearance(R.style.TextAppearance_AppCompat_Large);
        priorityItem.setPriority(5);
        updatePriorityDetailList();
    }

    private void updatePriorityDetailList() {
    Intent i = new Intent(this, PriorityListActivity.class);
        i.putExtra("Character",character);
        i.putExtra("Position",listItemPosition);
        i.putExtra("priorityItem",(Serializable)priorityItem);

        startActivity(i);

    }

    //@RequiresApi(api = Build.VERSION_CODES.M)
  /*
    public void setA(){
        ((TextView) findViewById(R.id.a)).setTextAppearance(R.style.TextAppearance_AppCompat_Large);
        ((TextView) findViewById(R.id.b)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.c)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.d)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.e)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
    }
    public void setB(){
        ((TextView) findViewById(R.id.a)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.b)).setTextAppearance(R.style.TextAppearance_AppCompat_Large);
        ((TextView) findViewById(R.id.c)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.d)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.e)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
    }
    public void setC(){
        ((TextView) findViewById(R.id.a)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.b)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.c)).setTextAppearance(R.style.TextAppearance_AppCompat_Large);
        ((TextView) findViewById(R.id.d)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.e)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
    }
    public void setD(){
        ((TextView) findViewById(R.id.a)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.b)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.c)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.d)).setTextAppearance(R.style.TextAppearance_AppCompat_Large);
        ((TextView) findViewById(R.id.e)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
    }
    public void setE(){
        ((TextView) findViewById(R.id.a)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.b)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.c)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.d)).setTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        ((TextView) findViewById(R.id.e)).setTextAppearance(R.style.TextAppearance_AppCompat_Large);
    }
    */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, PriorityListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
