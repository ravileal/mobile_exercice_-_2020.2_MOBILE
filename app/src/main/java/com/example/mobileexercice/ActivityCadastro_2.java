package com.example.mobileexercice;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.Button;

public class ActivityCadastro_2 extends AppCompatActivity {

    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Doação de sangue - Agendamento");
        setSupportActionBar(toolbar);
        addListenerButton();
    }

    private void addListenerButton(){
        btnVoltar = findViewById(R.id.btn_voltar_cadastro1);
        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ActivityCadastro.class);
            startActivity(intent);
        });
    }

}