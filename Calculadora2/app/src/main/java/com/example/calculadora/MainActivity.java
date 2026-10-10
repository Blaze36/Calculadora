package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero1, etNumero2;
    private final OperacionesMatematicas operaciones = new OperacionesMatematicas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero1 = findViewById(R.id.etNumero1);
        etNumero2 = findViewById(R.id.etNumero2);

        Button btnSuma = findViewById(R.id.btnSuma);
        Button btnResta = findViewById(R.id.btnResta);
        Button btnDivision = findViewById(R.id.btnDivision);
        Button btnMultiplicacion = findViewById(R.id.btnMultiplicacion);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { calcular("Suma"); }
        });
        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { calcular("Resta"); }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { calcular("División"); }
        });
        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { calcular("Multiplicación"); }
        });
    }

    private void calcular(String operacion) {
        String t1 = etNumero1.getText().toString().trim();
        String t2 = etNumero2.getText().toString().trim();

        if (t1.isEmpty() || t2.isEmpty()) {
            Toast.makeText(this, "Ingrese ambos números", Toast.LENGTH_SHORT).show();
            return;
        }

        double a, b;
        try {
            a = Double.parseDouble(t1);
            b = Double.parseDouble(t2);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingrese valores numéricos válidos", Toast.LENGTH_SHORT).show();
            return;
        }

        double valor;
        try {
            switch (operacion) {
                case "Suma":           valor = operaciones.sumar(a, b); break;
                case "Resta":          valor = operaciones.restar(a, b); break;
                case "Multiplicación": valor = operaciones.multiplicar(a, b); break;
                default:               valor = operaciones.dividir(a, b); break;
            }
        } catch (ArithmeticException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        Resultado resultado = new Resultado(operacion, a, b, valor);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("resultado", resultado);
        startActivity(intent);
    }
}