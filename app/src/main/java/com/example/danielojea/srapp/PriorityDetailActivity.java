package com.example.danielojea.srapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.PriorityAbilities;
import com.example.danielojea.srapp.Classes.PriorityAttribute;
import com.example.danielojea.srapp.Classes.PriorityMagic;
import com.example.danielojea.srapp.Classes.PriorityMetatyp;
import com.example.danielojea.srapp.Classes.PriorityRessource;
import com.example.danielojea.srapp.charactercreation.Metatyp;

/**
 * An activity representing a single PriorityItem detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link PriorityListActivity}.
 */
public class PriorityDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priorityitem_detail);

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(PriorityDetailFragment.ARG_ITEM_ID, getIntent().getStringExtra(PriorityDetailFragment.ARG_ITEM_ID));
            //PriorityAbilities testAbility =(PriorityAbilities) getIntent().getSerializableExtra("PriorityAbilities");
            int listItemPosition =(int) getIntent().getSerializableExtra("Position");
            PriorityDetailFragment fragment = new PriorityDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.priorityitem_detail_container, fragment)
                    .commit();
            setCurrentPriority(checkCurrentPriority(listItemPosition));
        }
    }
    private int checkCurrentPriority( int listItemPosition){
        switch (listItemPosition) {
            case 0:
                PriorityMetatyp priorityMetatyp =(PriorityMetatyp) getIntent().getSerializableExtra("PriorityMetatyp");
                return priorityMetatyp.getPriority();
            case 1:
                PriorityAttribute priorityAttribute =(PriorityAttribute) getIntent().getSerializableExtra("PriorityMetatyp");
                return priorityAttribute.getPriority();
            case 2:
                PriorityMagic priorityMagic =(PriorityMagic) getIntent().getSerializableExtra("PriorityMetatyp");
                return priorityMagic.getPriority();
            case 3:
                PriorityAbilities priorityAbilities =(PriorityAbilities) getIntent().getSerializableExtra("PriorityMetatyp");
                return priorityAbilities.getPriority();
            case 4:
                PriorityRessource priorityRessource =(PriorityRessource) getIntent().getSerializableExtra("PriorityMetatyp");
                return priorityRessource.getPriority();
        }
        return 0;
    }

    public void setCurrentPriority(int priority){
        switch (priority) {
            case 1:
                setA();
                return;
            case 2:
                setB();
                return;
            case 3:
                setC();
                return;
            case 4:
                setD();
                return;
            case 5:
                setE();
                return;
        }
    }

    public void setPriorityA(View v){
        setA();
    }
    public void setPriorityB(View v){
        setB();
    }
    public void setPriorityC(View v){
        setC();
    }
    public void setPriorityD(View v){
        setD();
    }
    public void setPriorityE(View v){
        setE();
    }

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
