package pe.edu.lsc.familialaureana.view.Padre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import pe.edu.lsc.familialaureana.R;

public class InsigniasPadre extends AppCompatActivity {

    // declaracion de variables globales
    Spinner listaHijos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insignias_padre);

        // instanciacion de varibles globales
        listaHijos = (Spinner) findViewById(R.id.spinner);
        String[] hijos= {"Juan","Maria","Nadie"};

        // asignado al spinner el string anterior mente declarado (hijos) asi se mostrara en el spiner los elementos del string
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,hijos);
        listaHijos.setAdapter(adapter);
    }
}
