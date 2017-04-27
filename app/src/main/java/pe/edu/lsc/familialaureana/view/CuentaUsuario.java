package pe.edu.lsc.familialaureana.view;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import pe.edu.lsc.familialaureana.R;

public class CuentaUsuario extends AppCompatActivity {

    // declaracion de variables globales
    TabHost tabHost;
    TabHost.TabSpec tb1,tb2,tb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta_usuario);

        // insanciacion de varibles globales
        tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();

        // asignando el titulo y adjuntando sobre el layout correspondiente a los tabhost
        tb1 = tabHost.newTabSpec("Eticket 1");
        tb1.setIndicator("Perfil");
        tb1.setContent(R.id.layout1);
        tabHost.addTab(tb1);

        tb2 = tabHost.newTabSpec("Eticket 2");
        tb2.setIndicator("Invitar");
        tb2.setContent(R.id.layout2);
        tabHost.addTab(tb2);

        tb3 = tabHost.newTabSpec("Eticket 3");
        tb3.setIndicator("Ayuda");
        tb3.setContent(R.id.layout3);
        tabHost.addTab(tb3);
    }


}
