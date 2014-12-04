package kr.co.aroundthetruck.customer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sumin on 2014-12-03.
 */
public class BrandList extends Activity {

    String[] truckArea = {"서울시, 양재", "서울시 뭐뭐"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brand_list);

        Spinner mySpinner = (Spinner)findViewById(R.id.spinner);
        mySpinner.setAdapter(new MyCustomAdapter(BrandList.this, R.layout.text_row, truckArea));

        ListView lv = (ListView)findViewById(R.id.brandlist);
        ArrayList<Brand> brands= new ArrayList<Brand>();
        BrandAdapter adapter = new BrandAdapter(this,brands);
        lv.setAdapter(adapter);
    }

    public class MyCustomAdapter extends ArrayAdapter<String> {

        public MyCustomAdapter(Context context, int textViewResourceId,
                               String[] objects) {
            super(context, textViewResourceId, objects);
            // TODO Auto-generated constructor stub
        }

        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            // TODO Auto-generated method stub
            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            return getCustomView(position, convertView, parent);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            //return super.getView(position, convertView, parent);

            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.layout.text_row, parent, false);
            TextView label=(TextView)row.findViewById(R.id.area);
            label.setText(truckArea[position]);
            return row;
        }
    }

    public class BrandAdapter extends BaseAdapter {
        Context mContext;
        ArrayList<Brand> list;

        public BrandAdapter(Context context, ArrayList<Brand> list) {
            this.mContext = context;
            this.list = list;
        }



        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {

            ViewHolder holder;

            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.brand_row, parent, false);
                holder.brandImage = (ImageView) convertView.findViewById(R.id.brandimage);
                holder.brandName = (TextView) convertView.findViewById(R.id.brandname);
                holder.brandDistance= (TextView) convertView.findViewById(R.id.distance);
                holder.like= (TextView) convertView.findViewById(R.id.like);
                holder.category= (TextView) convertView.findViewById(R.id.category);
                holder.likebtn= (Button) convertView.findViewById(R.id.likebtn);

                convertView.setTag(holder);
            }else{

                holder = (ViewHolder) convertView.getTag();

            }
            holder.brandImage  .setImageResource(list.get(pos).getBrandImage());
            holder.brandName.setText(list.get(pos).getBrandName());
            holder.brandDistance.setText(list.get(pos).getBrandDistance());
            holder.like.setText(list.get(pos).getBrandDistance());
            holder.category.setText(list.get(pos).getBrandDistance());

            return convertView;

        }

        private class ViewHolder
        {
            ImageView brandImage;
            TextView brandName;
            TextView brandDistance;
            TextView like;
            TextView category;
            Button likebtn;

        }


    }
}