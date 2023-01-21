package com.example.gardencompanion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gardencompanion.modele.DbAdapter;

import java.util.ArrayList;

public class InfoPlanteActivity extends AppCompatActivity {

    private Button btnBon;
    private Button btnMauvais;
    private TextView lblPlante;
    private DbAdapter dbAdapter;
    private ArrayAdapter<String> listingAdapterInfo;
    private ListView listingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_plante);

        String nomPlante=getIntent().getStringExtra("nomPlante");

        //les widgets doivent etre mis ici et non dans set widgets sinon ca ne marche pas.
        //on doit trouver les champs et apres leur mettre des valeurs
        lblPlante=findViewById(R.id.lblPlante);

        lblPlante.setText(nomPlante);

        listingView=findViewById(R.id.listingView);
        this.dbAdapter=new DbAdapter(InfoPlanteActivity.this);

        setWidgets();
        setListeners();

        afficherData();
    }

    private void afficherData() {
        String nomPlante;
        nomPlante=String.valueOf(lblPlante.getText());
        ArrayList<String> registreInfoPlante=dbAdapter.getInfoPlante(nomPlante);
        listingAdapterInfo=new ArrayAdapter(InfoPlanteActivity.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, registreInfoPlante);


        listingView.setAdapter(listingAdapterInfo);

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
        Intent monIntentHome = new Intent(InfoPlanteActivity.this, MainActivity.class);

        startActivity(monIntentHome);
    }

    private void setWidgets() {
        btnBon = findViewById(R.id.btnBon);
        btnMauvais = findViewById(R.id.btnMauvais);


    }

    private void setListeners() {
        btnBon.setOnClickListener(mClickListener1);
        btnMauvais.setOnClickListener(mClickListener1);
    }
    private View.OnClickListener mClickListener1=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(v.getId()==R.id.btnBon){
                afficherBon();
            }else{
                afficherMauvais();
            }

        }
    };

    private void afficherBon() {
        Intent monIntentBon= new Intent(InfoPlanteActivity.this, BonCompagnonActivity.class);
        monIntentBon.putExtra("nomPlante", lblPlante.getText().toString());
        //monIntent.putExtra("nom", txtNom.getText().toString());
        //monIntent.putExtra("salaire", Double.parseDouble(txtSalaire.getText().toString()));
        startActivity(monIntentBon);

    }

    private void afficherMauvais() {
        Intent monIntentMauvais= new Intent(InfoPlanteActivity.this, MauvaisCompagnonActivity.class);
        //ajouter le data
        monIntentMauvais.putExtra("nomPlante", lblPlante.getText().toString());
        //monIntent.putExtra("nom", txtNom.getText().toString());
        //monIntent.putExtra("salaire", Double.parseDouble(txtSalaire.getText().toString()));
        startActivity(monIntentMauvais);
    }


}