package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tvOperacion = findViewById(R.id.tvOperacion);
        TextView tvResultado = findViewById(R.id.tvResultado);
        Button btnVolver = findViewById(R.id.btnVolver);

        Resultado r = (Resultado) getIntent().getSerializableExtra("resultado");
        if (r != null) {
            tvOperacion.setText(r.getOperacion() + ": " + r.getNumero1() + " y " + r.getNumero2());
            tvResultado.setText("Resultado: " + r.getValor());
        }

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { finish(); }
        });
    }
}