package com.example.gardencompanion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gardencompanion.modele.DbAdapter;
import com.example.gardencompanion.modele.PlanteDbHelper;

import java.util.ArrayList;

public class MauvaisCompagnonActivity extends AppCompatActivity {

    private TextView lblPlanteM;
    private ListView listMauvaisCompagnon;
    private DbAdapter dbAdapter;
    private ArrayAdapter<String> listingAdapterMauvais;


    private SQLiteDatabase dbase;
    private PlanteDbHelper dbHelper;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mauvais_compagnon);
        this.dbAdapter=new DbAdapter(MauvaisCompagnonActivity.this);

        String nomPlante=getIntent().getStringExtra("nomPlante");
        lblPlanteM=findViewById(R.id.lblPlanteM);

        lblPlanteM.setText(nomPlante);

        listMauvaisCompagnon=findViewById(R.id.ListMauvais);

        afficherData();
    }

    private void afficherData() {
        String nomPlante;
        nomPlante=String.valueOf(lblPlanteM.getText());

        ArrayList<String> registreMauvaisCompagnons=dbAdapter.getMauvaisCompagnons(nomPlante);
        listingAdapterMauvais=new ArrayAdapter(MauvaisCompagnonActivity.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, registreMauvaisCompagnons);


        listMauvaisCompagnon.setAdapter(listingAdapterMauvais);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainbm,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int option=item.getItemId();
        switch (option){
            case R.id.home:
                voyagerHome();
                break;
            case R.id.retour:
                voyagerRetour();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void voyagerHome() {
        Intent monIntentHome = new Intent(MauvaisCompagnonActivity.this, MainActivity.class);

        startActivity(monIntentHome);
    }
    private void voyagerRetour() {
        Intent monIntentRetour = new Intent(MauvaisCompagnonActivity.this, InfoPlanteActivity.class);
        //ajouter le data
        monIntentRetour.putExtra("nomPlante",lblPlanteM.getText().toString());

        startActivity(monIntentRetour);
    }
}