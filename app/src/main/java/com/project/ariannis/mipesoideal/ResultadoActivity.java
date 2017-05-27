package com.project.ariannis.mipesoideal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    private static final double kgEnLibras = 2.2046;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView altura = (TextView) findViewById(R.id.txtAltura);
        TextView edad = (TextView) findViewById(R.id.txtEdad);
        TextView sexo = (TextView) findViewById(R.id.txtSexo);
        TextView resultado = (TextView) findViewById(R.id.txtResultados);

        double alturaIntent = getIntent().getDoubleExtra("altura", 0);
        String edadIntent      = getIntent().getStringExtra("edad");
        String sexoIntent   = getIntent().getStringExtra("sexo");
        double resultadoIntent = getIntent().getDoubleExtra("peso", 0);


        altura.setText("Altura : "+String.valueOf(alturaIntent));
        edad.setText("Edad : " + edadIntent);
        sexo.setText("Sexo : " + sexoIntent);

        resultado.setText(String.valueOf(resultadoIntent)+" kg.\n");
        resultadoIntent = Math.round(resultadoIntent * kgEnLibras);
        resultado.append(String.valueOf(resultadoIntent)+" libras.");
    }
}
