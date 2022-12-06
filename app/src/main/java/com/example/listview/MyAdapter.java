package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> names;

    public MyAdapter(Context context, int layout, List<String> names){
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    @Override
    public int getCount(){
        return this.names.size();
    }

    @Override
    public Object getItem(int position){
        return this.names.get(position);
    }

    @Override
    public long getItemId(int id){
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup){

        /* Custom ListView
            //Copiamos la vista - Copy the view
            View v = convertView;

            //Inflamos la vista que nos ha llegado con nuestro layout personalizado - We inflate the view that has come to us with our custom layout
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            v = layoutInflater.inflate(R.layout.list_item, null);

            //Traemos el valor actual dependiendo de la posicion - We get the current value depending on the position
            String currentName = names.get(position);

            //Referenciamos el elemento a modificar y lo rellenamos - We reference the element to modify and fill it
            TextView textView = v.findViewById(R.id.textView);
            textView.setText(currentName);

            //Devolvemos la vista inflada y modificada con nuestros datos - We return the inflated and modified view with our data
            return v;
        */


        /* ListView with View Holder Pattern */
        ViewHolder holder;

        if (convertView == null){
            //Inflamos la vista que nos ha llegado con nuestro layout personalizado
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();
            //Referenciamos el elemento a modificar y lo rellenamos
            holder.nameTextView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //Traemos el valor actual dependiendo de la posicion - We get the current value depending on the position
        String currentName = names.get(position);

        holder.nameTextView.setText(currentName);

        return convertView;
    }


    static class ViewHolder{
        private TextView nameTextView;
    }


}
