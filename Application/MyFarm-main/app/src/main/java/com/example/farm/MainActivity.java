package com.example.farm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter();

        // 리스트뷰 참조 및 Adapter 달기
        listView = (ListView)findViewById(R.id.listview1);
        listView.setAdapter(adapter);

        // (추가, 삭제 구현)
        // 첫 번째 아이템 추가
        adapter.addItem("A1000001", "POT_1");
        adapter.addItem("A1000002", "POT_2");
        adapter.addItem("A1050311", "POT_3");
        adapter.addItem("B2055341", "POT_4");
        adapter.addItem("B2062355", "POT_5");





        // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // get item
                ListViewItem item = (ListViewItem)parent.getItemAtPosition(position);

                String nameStr = item.getNameStr();
                String idStr = item.getIdStr();

                // TODO : use item data.

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }

}
