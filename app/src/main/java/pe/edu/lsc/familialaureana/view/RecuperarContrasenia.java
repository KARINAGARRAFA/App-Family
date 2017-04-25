package pe.edu.lsc.familialaureana.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pe.edu.lsc.familialaureana.R;

public class RecuperarContrasenia extends AppCompatActivity implements View.OnClickListener{

    // varibles globales
    Button btnMensaje;
    TextView txtRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasenia);

        // instanciacion de variables globales
        btnMensaje = (Button) findViewById(R.id.btnenviarMensaje);
        btnMensaje.setOnClickListener(this);
        txtRegistrarse=(TextView) findViewById(R.id.textRegistrase);
        txtRegistrarse.setOnClickListener(this);
    }

    @Override
    // funcion que controla la acciona a tomar al precionar sobre un elemento
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.btnenviarMensaje:
                // enviar mensaje a un correo
                break;
            case R.id.textRegistrase:
                i = new Intent(this, RegistroG.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
