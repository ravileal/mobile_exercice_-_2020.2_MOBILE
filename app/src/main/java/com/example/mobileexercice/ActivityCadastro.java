package com.example.mobileexercice;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class ActivityCadastro extends AppCompatActivity {

    private ToggleButton tglBtnNotificacaoes;
    private Button btnCadastrar;
    private Button btnTipoSangue;
    private Spinner spinnerCountries;
    private RadioGroup radGrpSexo;
    private TextView textViewBloodDonation;

    private String[] countries = {
            "Argentina",
            "Brazil",
            "China",
            "Chile",
            "Japão",
            "United States",
    };

    ArrayList<String> list = new ArrayList<String>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Doação de sangue - Agendamento");
        setSupportActionBar(toolbar);

        addListenerOnButton();
        addListenerSpinner();
        addListenerRadioButton();
        addListenerTextView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_item_sair) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    public void addListenerOnButton(){
        addListenerOnButtonProximaTela();
        addListenerOnButtonNotifications();
        addListenerOnButtonTipoSangue();
    }

    private void addListenerOnButtonTipoSangue(){
        btnTipoSangue = (Button) findViewById(R.id.buttonTipoSangue);
        btnTipoSangue.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(ActivityCadastro.this, btnTipoSangue);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                Toast.makeText(ActivityCadastro.this, item.getTitle()+" selecionado!", Toast.LENGTH_SHORT).show();
                return true;
            });

            popup.show();
        });
    }

    private void addListenerOnButtonNotifications(){
        tglBtnNotificacaoes = (ToggleButton) findViewById(R.id.toggleButtonNotificacaoes);
    }

    private void addListenerOnButtonProximaTela(){
        btnCadastrar = (Button) findViewById(R.id.buttonCadastrar);
        btnCadastrar.setOnClickListener(v -> {
            int selected = radGrpSexo.getCheckedRadioButtonId();
            RadioButton radBtn = findViewById(selected);

            StringBuffer result = new StringBuffer();

            result.append("Notificacoes: "+tglBtnNotificacaoes.getText());
            result.append("\nSexo: " + radBtn.getText());

            Toast.makeText(ActivityCadastro.this, result.toString(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), ActivityCadastro_2.class);
            startActivity(intent);
        });
    }

    private void addListenerSpinner(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countries);

        spinnerCountries = (Spinner) findViewById(R.id.spinnerCountry);
        spinnerCountries.setAdapter(adapter);
        spinnerCountries.setSelection(1);

        spinnerCountries.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(ActivityCadastro.this, countries[position]+ " foi selecionado como país de origem", Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {}
                }
        );
    }

    private void addListenerRadioButton(){
        radGrpSexo = (RadioGroup) findViewById(R.id.radioGroupSexo);
        radGrpSexo.check(R.id.radioButtonMasculino);
    }

    public void addListenerTextView(){
        textViewBloodDonation = (TextView) findViewById(R.id.textViewBloodDonation);
        textViewBloodDonation.setOnLongClickListener(v -> {
            Toast.makeText(ActivityCadastro.this, "Essa é a logo da doação de sangue", Toast.LENGTH_SHORT).show();
            return true;
        });
        textViewBloodDonation.setOnClickListener(v -> Toast.makeText(ActivityCadastro.this, "Logo", Toast.LENGTH_SHORT).show());
    }

}