package com.project.ariannis.mipesoideal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
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
    private TextView txtEdad;
    private int dividendo;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        spinnerSexo = (Spinner)findViewById(R.id.spinnerSexo);
        txtAltura   = (TextView)findViewById(R.id.txtAltura);
        txtEdad     = (TextView)findViewById(R.id.txtEdad);

        //Formulas
        /*
          Peso ideal hombre = (altura cm – 100) – (altura cm – 150) / 4
          Peso ideal mujer = (altura cm – 100) – (altura cm – 150) / 2
        */
        btnCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(txtAltura.getText().toString().equals("") || txtEdad.getText().toString().equals("")
                        || spinnerSexo.getSelectedItem().toString().equals("Seleccione")){
                    MainActivity.this.mostrarDialogo();
                }else{
                    double altura = Double.parseDouble(txtAltura.getText().toString());

                    dividendo = 4;

                    if(spinnerSexo.getSelectedItem().toString().equals("Femenino")){
                        dividendo = 2;
                    }

                    double resultado = ((altura - 100) - (altura - 150) / dividendo);
                    Intent i = new Intent(MainActivity.this, ResultadoActivity.class);
                    i.putExtra("peso", resultado);
                    i.putExtra("altura", altura);
                    i.putExtra("edad", txtEdad.getText().toString());
                    i.putExtra("sexo", spinnerSexo.getSelectedItem().toString());
                    startActivity(i);
            }



        }
        });
        }

    public void mostrarDialogo(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Informacion")
                .setMessage("Complete el formulario.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
    }
}
