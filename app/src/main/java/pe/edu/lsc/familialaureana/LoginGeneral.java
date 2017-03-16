package pe.edu.lsc.familialaureana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LoginGeneral extends AppCompatActivity {
    Button ads;
    TextView usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_general);
        usuario = (TextView) findViewById(R.id.email);

    }
}
