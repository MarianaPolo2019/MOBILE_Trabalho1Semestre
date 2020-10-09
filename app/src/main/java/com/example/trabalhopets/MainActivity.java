package com.example.trabalhopets;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Button btnSelect, btnEscolha, btnPet, btnService, btnVoltarPet, btnVoltarService;
    RadioGroup rdgPets;
    CheckBox ckbTosa, ckbBanho, ckbPasseio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CarregarTelaPrincipal();
    }

    public void CarregarTelaPrincipal(){
        setContentView(R.layout.activity_main);
        btnPet = findViewById(R.id.btnPet);
        btnService = findViewById(R.id.btnService);

        btnPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPets();
            }
        });

        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CarregarTelaService();
            }
        });
    }

    public void CarregarTelaPets(){
        setContentView(R.layout.pets);
        rdgPets = findViewById(R.id.rdgPets);
        btnVoltarPet = findViewById(R.id.btnVoltarPets);
        btnEscolha = findViewById(R.id.btnEscolha);

        btnEscolha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);

                msg.setTitle("Você escolheu: ");
                msg.setMessage(escolhaPet());
                msg.setNeutralButton("Fechar", null);
                msg.show();
            }
        });

        btnVoltarPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPrincipal();
            }
        });
    }

    public void CarregarTelaService(){
        setContentView(R.layout.services);
        ckbBanho = findViewById(R.id.ckbBanho);
        ckbTosa = findViewById(R.id.ckbTosa);
        ckbPasseio = findViewById(R.id.ckbPasseio);
        btnSelect = findViewById(R.id.btnSelect);
        btnVoltarService = findViewById(R.id.btnVoltarService);


        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setTitle("Serviços escolhidos");
                msg.setMessage(escolhaServices(ckbBanho, ckbTosa, ckbPasseio));
                msg.setNeutralButton("Fechar", null);
                msg.show();
            }
        });

        btnVoltarService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPrincipal();
            }
        });
    }


    public String escolhaPet(){
        int escolha = rdgPets.getCheckedRadioButtonId();

        if(escolha == R.id.rdbGato){
            return "Gato";
        } else if(escolha == R.id.rdbCachorro){
            return "Cachorro";
        } else if(escolha == R.id.rdbPassaro){
            return "Passaro";
        }
        return "";
    }

    public String escolhaServices(CheckBox ckbBanho, CheckBox ckbTosa, CheckBox ckbPasseio){

        String escolhas = "";
        if(ckbBanho.isChecked()){ escolhas += "Banho" + "\n";}
        if(ckbTosa.isChecked()){ escolhas += "Tosa" + "\n";}
        if(ckbPasseio.isChecked()){ escolhas += "Passeio" + "\n";}
        return escolhas;
    }
}