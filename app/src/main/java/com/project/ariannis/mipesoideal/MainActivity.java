package com.project.ariannis.mipesoideal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    private Spinner spinnerSexo;
    private TextView txtAltura;
    private int dividendo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        spinnerSexo = (Spinner)findViewById(R.id.spinnerSexo);
        txtAltura   = (TextView)findViewById(R.id.txtAltura);

        //Formulas
        /*
          Peso ideal hombre = (altura cm – 100) – (altura cm – 150) / 4
          Peso ideal mujer = (altura cm – 100) – (altura cm – 150) / 2
        */
        btnCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                double altura = Double.parseDouble(txtAltura.getText().toString());

                dividendo = 4;

                if(spinnerSexo.getSelectedItem().toString().equals("Femenino")){
                    dividendo = 2;
                }

                double resultado = ((altura - 100) - (altura - 150) / dividendo);

                Toast.makeText(MainActivity.this, "Tu peso ideal es "+String.valueOf(resultado), Toast.LENGTH_LONG).show();
            }
        });
    }
}
