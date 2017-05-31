package com.snape.shivichu.androidgridview.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.snape.shivichu.androidgridview.R;
import com.snape.shivichu.androidgridview.adapter.CustomGridViewAdapter;
import com.snape.shivichu.androidgridview.holder.Item;

import java.util.ArrayList;

/**
 * Created by Shivichu on 31-05-2017.
 */

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;
    CoordinatorLayout coordinatorLayout;
    Bitmap iconBoy,iconGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator);
        //set grid view item
        iconBoy = BitmapFactory.decodeResource(this.getResources(), R.drawable.boy);
         iconGroup = BitmapFactory.decodeResource(this.getResources(), R.drawable.users);


       initView();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Snackbar snackbar = Snackbar.make(coordinatorLayout,"U Clicked On :"+""+gridArray.get(i).getTitle(),Snackbar.LENGTH_SHORT);
                snackbar.show();

            }
        });
    }

    private void initView() {

        for(int i=0;i<20;i++)
        {

            if(i%2==0)
            {
                gridArray.add(new Item(iconBoy,"Boy"+""+String.valueOf(i+1)));

            }

            else
            {
                gridArray.add(new Item(iconGroup,"User"+""+String.valueOf(i+1)));

            }


        }


        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);
    }


}
