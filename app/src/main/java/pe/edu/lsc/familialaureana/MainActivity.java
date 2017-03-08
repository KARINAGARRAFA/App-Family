package pe.edu.lsc.familialaureana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = (Button) findViewById(R.id.btnRegistrase);
        boton.setOnClickListener(this);
            }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegistrase:
                Intent i=new Intent(this,RegistroG.class);
                startActivity(i);
                break;
            default:
                break;
        }

    }
}
