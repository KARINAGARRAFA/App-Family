package pe.edu.lsc.familialaureana.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pe.edu.lsc.familialaureana.R;

public class RegistroG extends AppCompatActivity implements View.OnClickListener{

    // variables globales
    Button yacuenta,btnDocente,btnEstudiante,btnPadre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_g);

        // insanciacion de variables globales
        yacuenta =(Button) findViewById(R.id.btnYaCuanta);
        yacuenta.setOnClickListener(this);
        btnDocente =(Button) findViewById(R.id.btnDocente);
        btnDocente.setOnClickListener(this);
        btnEstudiante =(Button) findViewById(R.id.btnEstudiante);
        btnEstudiante.setOnClickListener(this);
        btnPadre =(Button) findViewById(R.id.btnPadre);
        btnPadre.setOnClickListener(this);
    }

    @Override
    // funcion que controla la accion a tomar cuando se presione sobre un elemento
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.btnYaCuanta:
                i=new Intent(this,LoginGeneral.class);
                startActivity(i);
                break;
            case R.id.btnDocente:
                i=new Intent(this,VerificacionDni.class);
                startActivity(i);
                break;
            case R.id.btnEstudiante:
                i=new Intent(this,VerificacionDni.class);
                startActivity(i);
                break;
            case R.id.btnPadre:
                i=new Intent(this,VerificacionDni.class);
                startActivity(i);
                break;
            default:
                break;
        }

    }
}
