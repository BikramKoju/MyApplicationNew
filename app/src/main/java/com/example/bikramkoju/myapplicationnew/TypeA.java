package com.example.bikramkoju.myapplicationnew;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TypeA extends Fragment {
    private GridView gridView;
    private GridViewAdapter gridViewAdapter;
    TextView result;


    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
     long sum;
    //=this.getActivity().getSharedPreferences("values",0);
    //double add=0.0;

    public TypeA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_type, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        result= (TextView) view.findViewById(R.id.resulta);

        sharedPreferences = this.getActivity().getSharedPreferences("values", 0);
         editor = sharedPreferences.edit();
      //  long sum = sharedPreferences.getLong("sum", 0);


        gridView = (GridView) view.findViewById(R.id.gridView);
        gridViewAdapter = new GridViewAdapter(getActivity(), R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridViewAdapter);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageItem item = (ImageItem) parent.getItemAtPosition(position);

                long value = Long.parseLong(item.getTitle());


                sum = sum + value;


                result.setText(String.valueOf(sum));


                //minus=minus+value;
                //  sum=value;

               // editor.putLong("sum", sum);
                // editor.putLong("minus",minus);
               // editor.commit();


               /* Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("title", String.valueOf(sum));

                //intent.putExtra("image", item.getImage());

                //Start details activity
                startActivity(intent);
                getActivity().overridePendingTransition(0,0);*/
            }


            // this.callingActivity(position);

            //  Toast.makeText(getActivity(), "You clicked it" + position, Toast.LENGTH_LONG).show();


           /* private void callingActivity(int position) {
                MainActivity obj= new MainActivity();

                Toast.makeText(getActivity(), "You clicked it" + position, Toast.LENGTH_LONG).show();


                obj.setNumber(1);*/

        });
    }

    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        TypedArray nums = getResources().obtainTypedArray(R.array.numbers);

        //String vlue=nums.getString(2);


        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            //Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), nums.getResourceId(i, -1));
            String vlue = nums.getString(i);

            imageItems.add(new ImageItem(bitmap, vlue));


        }
        return imageItems;
    }

}
