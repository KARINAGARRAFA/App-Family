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
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button boton,btnInisiarSesion;
    ImageView btnMensaje, btnLlamada,btnUbicacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }

    @Override
    public void onClick(View v) {
        Intent i;
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

            default:
                break;
        }

    }
}
