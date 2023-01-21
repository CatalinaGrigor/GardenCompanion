package com.example.gardencompanion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gardencompanion.modele.DbAdapter;

import java.util.ArrayList;

public class ComparateurActivity extends AppCompatActivity {

    private DbAdapter dbAdapter;
    private ArrayAdapter<String> listingAdapterComparateur;
    private TextView lblPlante1, lblPlante2;
    private ListView listComparateur;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparateur);

        String nomPlante1=getIntent().getStringExtra("nomPlante1");
        String nomPlante2=getIntent().getStringExtra("nomPlante2");
        //les widgets doivent etre mis ici et non dans set widgets sinon ca ne marche pas.
        //on doit trouver les champs et apres leur mettre des valeurs
        lblPlante1=findViewById(R.id.lblPlante1);
        lblPlante2=findViewById(R.id.lblPlante2);
        lblPlante1.setText(nomPlante1);
        lblPlante2.setText(nomPlante2);
        this.dbAdapter=new DbAdapter(ComparateurActivity.this);

        listComparateur=findViewById(R.id.ListComparateur);
        afficherData();
    }

    private void afficherData() {
        String nomPlante1 = String.valueOf(lblPlante1.getText());
        String nomPlante2 = String.valueOf(lblPlante2.getText());
        ArrayList<String> registreComparateur = dbAdapter.getComparerCompagnons(nomPlante1, nomPlante2); // Get the current data


        listingAdapterComparateur = new ArrayAdapter(ComparateurActivity.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, registreComparateur);


        listComparateur.setAdapter(listingAdapterComparateur);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int option=item.getItemId();
        switch (option){
            case R.id.home:
                voyagerHome();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void voyagerHome() {
        Intent monIntentHome = new Intent(ComparateurActivity.this, MainActivity.class);

        startActivity(monIntentHome);
    }
}