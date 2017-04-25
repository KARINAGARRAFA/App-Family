package pe.edu.lsc.familialaureana.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pe.edu.lsc.familialaureana.R;
import pe.edu.lsc.familialaureana.view.LoginGeneral;

public class VerificacionDni extends AppCompatActivity implements View.OnClickListener{

    // variables globaless
    Button btnverificar,btnYatengoCuenta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificacion_dni);

        // instanciar las variables globales
        btnverificar = (Button) findViewById(R.id.btnverificar);
        btnverificar.setOnClickListener(this);
        btnYatengoCuenta=(Button) findViewById(R.id.btnYaCuanta);
        btnYatengoCuenta.setOnClickListener(this);
    }

    // funcion que genera un cuadro de dialogo al verificar el DNI ingresado
    public void alertDiaologBasico(){
        AlertDialog.Builder builer = new  AlertDialog.Builder(this);
        builer.setMessage("Este DNI: 34343434, pertenece a, JUAN MAMANI INCA, desea agregar? ").setTitle("MENSAJE DE CONFIRMACION");
        builer.setPositiveButton("si",new DialogInterface.OnClickListener() {
           public  void onClick(DialogInterface dialog,int id){

           }
        });

        builer.setNegativeButton("no",new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog,int id) {

           }
        });

        builer.show();
    }

    @Override
    // funcion que controla que accion realizar al precionar sobre cierto elemento
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.btnverificar:
                alertDiaologBasico();
                break;
            case R.id.btnYaCuanta:
                i=new Intent(this,LoginGeneral.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
