package com.example.mobileexercice;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class ActivityCadastro_2 extends AppCompatActivity {

    private Button btnVoltar;
    private ConstraintLayout constraintLayout;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Doação de sangue - Agendamento");
        setSupportActionBar(toolbar);
        addListenerButton();
        addAutoComplete();
    }

    private void addAutoComplete(){

        String cidades[] = {"Fortaleza","Quixadá", "Quixeramobim"};
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewCidade);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ActivityCadastro_2.this, android.R.layout.simple_dropdown_item_1line, cidades);

        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);
    }

    private void addListenerButton(){
        btnVoltar = findViewById(R.id.btn_voltar_cadastro1);
        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ActivityCadastro.class);
            startActivity(intent);
        });
    }

}