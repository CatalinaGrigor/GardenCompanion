package com.example.gardencompanion;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gardencompanion.modele.DbAdapter;
import com.example.gardencompanion.modele.Plante;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button btnPlante;
    private Button btnComparer;
    private TextView txtTitre;

    //spinner doit etre declarer a l'interieur de onCreate, sinon ca plante
    private Spinner spinner;
    private Spinner spinner1;
    private Spinner spinner2;
    //String[] plantes;
    String plante, plante1, plante2;

    private DbAdapter dbAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Spinner spinner = findViewById(R.id.spinner);
        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.plantes,
                android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setOnItemSelectedListener(this);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener( this);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        setWidgets();
        setListeners();

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        plante = parent.getItemAtPosition(position).toString();
        // Toast.makeText(parent.getContext(), plante, Toast.LENGTH_SHORT).show();
        switch (parent.getId()) {
            case R.id.spinner:
                plante = parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinner1:
                plante1 = parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinner2:
                plante2 = parent.getItemAtPosition(position).toString();
                if (plante1==plante2){
                    Toast.makeText(MainActivity.this,"Choisissez une 2me plantes differente pour comparer", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) { }


   /* @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
       // Toast.makeText(getApplicationContext(), "Plante choisie: "+plantes[position] ,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }*/



    private void setWidgets() {
        btnPlante = findViewById(R.id.btnPlante);
        btnComparer = findViewById(R.id.btnComparer);

        /*spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);*/

    }

    private void setListeners() {
        btnComparer.setOnClickListener(mClickListener);
        btnPlante.setOnClickListener(mClickListener);


    }
    private View.OnClickListener mClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(v.getId()==R.id.btnComparer){
                afficherComparateur();
            }else{
                afficherPlante();
            }

        }
    };

    private void afficherPlante() {
        Intent monIntentPlante = new Intent(MainActivity.this, InfoPlanteActivity.class);

        monIntentPlante.putExtra("nomPlante", plante);

        startActivity(monIntentPlante);

    }

    private void afficherComparateur() {
        Intent monIntentComparer = new Intent(MainActivity.this, ComparateurActivity.class);

        monIntentComparer.putExtra("nomPlante1", plante1);
        monIntentComparer.putExtra("nomPlante2", plante2);

        startActivity(monIntentComparer);
    }


}