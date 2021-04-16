package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.example.exercise1.R;

import java.util.ArrayList;

public class KontakMahasiswa extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener  {

    SearchView searchView;
    private ListView list;
    private KontakAdapter adapter;
    String[] listnama;
    public static ArrayList<com.example.exercise1.ClassNama> classNamaArrayList = new ArrayList<com.example.exercise1.ClassNama>();
    Bundle bundle = new Bundle();
    Intent intent;
    String Kontak;

    ArrayAdapter<String > arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak_mahasiswa);
        searchView = findViewById(R.id.search_bar);
        listnama = new String[]{"Inayah", "Ilham", "Eris", "Fikri", "Maul",
                "Intan", "Vina", "Gita", "Vian", "Lutfi" };
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, android.R.id.text1,listnama);
        list = findViewById(R.id.listkontak);
        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listnama.length; i++) {
            com.example.exercise1.ClassNama classNama = new com.example.exercise1.ClassNama(listnama[i]);
            classNamaArrayList.add(classNama);
            adapter = new KontakAdapter(this);
            list.setAdapter(arrayAdapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Kontak = classNamaArrayList.get(position).getName();
                    bundle.putString("a", Kontak.trim());
                    PopupMenu pm = new PopupMenu(getApplicationContext(), view);
                    pm.setOnMenuItemClickListener(KontakMahasiswa.this);
                    pm.inflate(R.menu.popup_menu);
                    pm.show();



                }
            });
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    KontakMahasiswa.this.arrayAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    KontakMahasiswa.this.arrayAdapter.getFilter().filter(newText);
                    return false;
                }
            });

        }
    }
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),DetailData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnviewnomor:
                String nomor_kontak = Kontak.trim();
                String Nomor = "";
                if (nomor_kontak == "Inayah"){
                    Nomor = "08132209899";
                }
                else if (nomor_kontak == "Ilham"){
                    Nomor = "08124589900";
                }
                else if (nomor_kontak == "Eris"){
                    Nomor = "08145498093";
                }
                else if (nomor_kontak == "Fikri"){
                    Nomor = "08129900332";
                }
                else if (nomor_kontak == "Maul"){
                    Nomor = "08132111889";
                }
                else if (nomor_kontak == "Intan"){
                    Nomor = "08147899210";
                }
                else if (nomor_kontak == "Vina"){
                    Nomor = "08124499580";
                }
                else if (nomor_kontak == "Gita"){
                    Nomor = "08199222355";
                }
                else if (nomor_kontak == "Lutfi"){
                    Nomor = "08983593012";
                }
                else if (nomor_kontak == "Vian"){
                    Nomor = "08124589893";
                }

                Toast.makeText(getApplicationContext(),Nomor, Toast.LENGTH_LONG).show();
                break;

        }
        return false;

    }

}