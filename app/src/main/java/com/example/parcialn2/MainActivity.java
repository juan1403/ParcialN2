package com.example.parcialn2;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adaptador myAdapter;
    private List<ClipData.Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();

        itemList.add(new Item("Juan Charris", "Descripción 1", "https://static.vecteezy.com/system/resources/thumbnails/028/237/216/small_2x/photographer-3d-profession-avatars-illustrations-free-png.png"));
        itemList.add(new Item("Jose Mercado", "Descripción 2", "https://img.freepik.com/psd-gratis/3d-ilustracion-persona-gafas-sol_23-2149436188.jpg?size=338&ext=jpg"));
        itemList.add(new Item("Maria Movilla", "Descripción 3", "https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png"));
        itemList.add(new Item("Andres Zuñiga", "Descripción 4", "https://static.vecteezy.com/system/resources/previews/011/381/900/original/young-businessman-3d-cartoon-avatar-portrait-png.png"));
        itemList.add(new Item("Ferlan Torres", "Descripción 5", "https://static.vecteezy.com/system/resources/thumbnails/028/201/622/small/lawyer-man-3d-profession-avatars-illustrations-free-png.png"));
        itemList.add(new Item("James Falcao", "Descripción 6", "https://static.vecteezy.com/system/resources/thumbnails/028/241/023/small_2x/lawyer-man-3d-profession-avatars-illustrations-free-png.png"));

        myAdapter = new Adaptador(itemList, item -> {
            Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
            intent.putExtra("title", item.getTitle());
            intent.putExtra("description", item.getDescription());
            intent.putExtra("imageUrl", item.getImageUrl());
            startActivity(intent);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}


