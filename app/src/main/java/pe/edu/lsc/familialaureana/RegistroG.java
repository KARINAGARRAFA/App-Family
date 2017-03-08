package pe.edu.lsc.familialaureana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroG extends AppCompatActivity implements View.OnClickListener{
    Button yacuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_g);
        yacuenta =(Button) findViewById(R.id.btnYaCuanta);
        yacuenta.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnYaCuanta:
                Intent i=new Intent(this,LoginGeneral.class);
                startActivity(i);
                break;
            default:
                break;
        }

    }
}
