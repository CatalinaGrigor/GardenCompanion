package com.example.gardencompanion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.gardencompanion.modele.DbAdapter;

import java.util.ArrayList;

public class BonCompagnonActivity extends AppCompatActivity {
    private TextView lblPlanteB;
    private ListView listBonCompagnons;
    private DbAdapter dbAdapter;
    private ArrayAdapter<String> listingAdapterBon;
    SimpleCursorAdapter mSCA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon_compagnon);
        this.dbAdapter=new DbAdapter(BonCompagnonActivity.this);

        String nomPlante=getIntent().getStringExtra("nomPlante");
        lblPlanteB=findViewById(R.id.lblPlanteB);

        lblPlanteB.setText(nomPlante);
        listBonCompagnons=findViewById(R.id.ListBon);

        afficherData();

    }

    private void afficherData() {
        String nomPlante;
        nomPlante = String.valueOf(lblPlanteB.getText());
        ArrayList<String> registreBonCompagnons = dbAdapter.getBonCompagnonPlante(nomPlante); // Get the current data

        listingAdapterBon = new ArrayAdapter(BonCompagnonActivity.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, registreBonCompagnons);

        listBonCompagnons.setAdapter(listingAdapterBon);

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
        Intent monIntentHome = new Intent(BonCompagnonActivity.this, MainActivity.class);
        monIntentHome.putExtra("nomPlante",lblPlanteB.getText().toString());

        startActivity(monIntentHome);
    }
    private void voyagerRetour() {
        Intent monIntentRetour = new Intent(BonCompagnonActivity.this, InfoPlanteActivity.class);
        //ajouter le data
        monIntentRetour.putExtra("nomPlante",lblPlanteB.getText().toString());
        //monIntent.putExtra("nom", txtNom.getText().toString());
        //monIntent.putExtra("salaire", Double.parseDouble(txtSalaire.getText().toString()));
        startActivity(monIntentRetour);
    }
}