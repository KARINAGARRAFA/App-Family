package pe.edu.lsc.familialaureana;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import pe.edu.lsc.familialaureana.view.LoginGeneral;
import pe.edu.lsc.familialaureana.view.Mensajes;
import pe.edu.lsc.familialaureana.view.RegistroG;
import pe.edu.lsc.familialaureana.view.Ubicacion;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // variables globales
    Button boton,btnInisiarSesion;
    ImageView btnMensaje, btnLlamada,btnUbicacion,btnvisitaweb,btnFace,btnEdmodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // instanciacion de las variables globales
        boton = (Button) findViewById(R.id.btnRegistrase);
        boton.setOnClickListener(this);
        btnInisiarSesion = (Button) findViewById(R.id.btnIniciarSesion);
        btnInisiarSesion.setOnClickListener(this);
        btnMensaje = (ImageView) findViewById(R.id.imageMensaje);
        btnMensaje.setOnClickListener(this);
        btnLlamada = (ImageView) findViewById(R.id.imageLlamada);
        btnLlamada.setOnClickListener(this);
        btnUbicacion = (ImageView) findViewById(R.id.imageUbicacion);
        btnUbicacion.setOnClickListener(this);
        btnvisitaweb = (ImageView) findViewById(R.id.imageVisita);
        btnvisitaweb.setOnClickListener(this);
        btnFace = (ImageView) findViewById(R.id.imageFace);
        btnFace.setOnClickListener(this);
        btnEdmodo = (ImageView) findViewById(R.id.imageEdmodo);
        btnEdmodo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        Uri uri;
        Intent in;
        // actividad a realizarse al precionar sobre un botton u otro elemento segun sea el caso
        switch (v.getId()) {
            case R.id.btnRegistrase:
                i = new Intent(this, RegistroG.class);
                startActivity(i);
                break;
            case R.id.btnIniciarSesion:
                i=new Intent(this,LoginGeneral.class);
                startActivity(i);
                break;
            case R.id.imageMensaje:
                i = new Intent(this, Mensajes.class);
                startActivity(i);
                break;
            case R.id.imageLlamada:
                i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:666-666-666"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(i);
                break;
            case R.id.imageUbicacion:
                i=new Intent(this,Ubicacion.class);
                startActivity(i);
                break;
            case R.id.imageVisita:
                uri = Uri.parse("https://jarroba.com/como-solucionar-errores-en-android/");
                in = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(in);
                break;
            case R.id.imageFace:
                uri = Uri.parse("https://www.facebook.com/lsc.edu.pe/");
                in = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(in);
                break;
            case R.id.imageEdmodo:
                uri = Uri.parse("https://www.edmodo.com/");
                in = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(in);
                break;


            default:
                break;
        }

    }
}
