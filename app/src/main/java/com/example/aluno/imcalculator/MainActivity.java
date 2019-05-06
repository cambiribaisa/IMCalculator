package com.example.aluno.imcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView resultado;
    private Button limpar;
    private Button calcular;
    private EditText peso;
    private EditText altura;
    private TextView classifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = (EditText)findViewById(R.id.peso);
        altura = (EditText)findViewById(R.id.altura);
        calcular = (Button) findViewById(R.id.calcular);
        resultado = (TextView) findViewById(R.id.resultado);
        limpar = (Button) findViewById(R.id.limpar);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Double imc;
                    double p = Double.parseDouble(peso.getText().toString());
                    double a = Double.parseDouble(altura.getText().toString());

                    Double x = a*a;
                    imc = p/x;

                    String pattern = "##.##";
                    DecimalFormat decimalFormat = new DecimalFormat(pattern);

                    resultado.setText(""+decimalFormat.format(imc));

                    if(imc < 18.5){
                        classifi.setText("Abaixo do peso");
                    }
                    else if(imc > 18.6 && imc < 24.9){

                        classifi.setText("Peso ideal");

                    }
                    else if(imc > 25.0 && imc < 29.9){
                        classifi.setText("Obesidade grau I");
                    }
                    else if(imc > 30.0 && imc < 34.9){
                        classifi.setText("Obesidade grau II (severa)");
                    }
                    else{
                        classifi.setText("Obesidade grau III (mórbida)");
                    }


                } catch (Exception E){
                    // Caso ocorra algum erro...
                    Toast.makeText(MainActivity.this, "Houve um problema. Tente novamente!", Toast.LENGTH_SHORT).show();

                }
            }
        });


        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    peso.setText("");
                    altura.setText("");
                    resultado.setText("");

                } catch (Exception E){
                    // Caso ocorra algum erro...
                    Toast.makeText(MainActivity.this, "Houve um problema. Tente novamente!", Toast.LENGTH_SHORT).show();

                }
            }
        });







    }
}
