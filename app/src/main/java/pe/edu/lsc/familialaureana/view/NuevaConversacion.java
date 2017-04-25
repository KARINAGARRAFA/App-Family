package pe.edu.lsc.familialaureana.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import pe.edu.lsc.familialaureana.R;

public class NuevaConversacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_conversacion);
    }
    @Override
    // funcion que instancia el menu en la actividad
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    // funcion que controla que accion tomar al precionar sobre uan de las opciones del menu
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.archivos:
                return true;
            case R.id.enviar:
                return true;
        }



        return super.onOptionsItemSelected(item);
    }
}
