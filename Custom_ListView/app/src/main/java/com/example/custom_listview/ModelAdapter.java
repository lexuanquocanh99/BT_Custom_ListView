package com.example.custom_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;
import android.app.Dialog;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;


public class ModelAdapter extends ArrayAdapter<model> {

    private Context context;
    private int resource;
    private ArrayList<model> arrayListModel;
    ImageView arrow;

    public ModelAdapter(Context context, int resource, ArrayList<model> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrayListModel = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.custom_list_view,parent,false);

        ImageView image = convertView.findViewById(R.id.image);
        TextView title = convertView.findViewById(R.id.title);
        TextView artist = convertView.findViewById(R.id.artist);
        TextView duration = convertView.findViewById(R.id.duration);
        arrow = convertView.findViewById(R.id.arrow);



        model model = arrayListModel.get(position);

        image.setImageResource(model.getImage());
        title.setText(model.getTitle());
        artist.setText(model.getArtist());
        duration.setText(model.getTime());



        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getContext(),arrow);
                popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){

                            case R.id.menu_delete:
                                arrayListModel.remove(position);
                                notifyDataSetChanged();
                                return true;

                            case R.id.menu_edit:
                                final Dialog dialog = new Dialog(context);
                                dialog.setCancelable(false);
                                dialog.setTitle("Sửa");
                                dialog.setContentView(R.layout.edit);
                                dialog.show();

                                final EditText edit_title = dialog.findViewById(R.id.edt_title);
                                final EditText edit_artist = dialog.findViewById(R.id.edt_artist);
                                final EditText edit_duration = dialog.findViewById(R.id.edt_duration);
                                final Button btn_ok = dialog.findViewById(R.id.btn_save);
                                final Button btn_cancel = dialog.findViewById(R.id.btn_cancel);

                                btn_ok.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        arrayListModel.get(position).setTitle(edit_title.getText().toString());
                                        arrayListModel.get(position).setArtist(edit_artist.getText().toString());
                                        arrayListModel.get(position).setTime(edit_duration.getText().toString());
                                        dialog.cancel();
                                    }
                                });
                                btn_cancel.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.cancel();
                                    }
                                });
                                return true;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
        return convertView;
    }
}
