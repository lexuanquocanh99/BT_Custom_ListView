package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        ArrayList<model> arrayList = new ArrayList<>();

        arrayList.add(new model(R.mipmap.ic_launcher,"Hơn Cả Yêu","Đức Phúc","4:16"));
        arrayList.add(new model(R.mipmap.ic_launcher,"Sao Anh Chưa Về Nhà","AMEE; Ricky Star","4:07"));
        arrayList.add(new model(R.mipmap.ic_launcher,"Khóc Cùng Em","Mr.Siro; Gray; Wind","3:56"));
        arrayList.add(new model(R.mipmap.ic_launcher,"Anh Thanh Niên","HuyR","3:51"));
        arrayList.add(new model(R.mipmap.ic_launcher,"Hai Phút Hơn","Pháo","2:29"));
        arrayList.add(new model(R.mipmap.ic_launcher,"Em Có Nghe","Kha","4:15"));
        arrayList.add(new model(R.mipmap.ic_launcher,"Do For Love","B Ray; AMee; Masew","3:09"));

        ModelAdapter modelAdapter = new ModelAdapter(this, R.layout.custom_list_view, arrayList);
        listView.setAdapter(modelAdapter);
    }
}
