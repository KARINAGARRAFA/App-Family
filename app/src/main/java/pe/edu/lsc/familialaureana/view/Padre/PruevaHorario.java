package pe.edu.lsc.familialaureana.view.Padre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import pe.edu.lsc.familialaureana.R;

public class PruevaHorario extends AppCompatActivity {

    // declarando variables globales
    Spinner lista,listas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueva_horario);

        // instanciacion de variables globales
        lista =(Spinner) findViewById(R.id.spinner);
        //listas=(Spinner)findViewById(R.id.spinne);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this ,R.array.horario,android.R.layout.simple_spinner_item);
        lista.setAdapter(adapter);

        String[] opciones= {"hola","buenos","dias"};
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        //listas.setAdapter(adapter1);
    }
}
