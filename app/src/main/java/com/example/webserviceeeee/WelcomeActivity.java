package com.example.webserviceeeee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Localizar los controles
        TextView txtSaludo = (TextView)findViewById(R.id.txtBienvenido);
//Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();
//Construimos el mensaje a mostrar
        txtSaludo.setText("Hola!, Bienvenido \n " +
                bundle.getString("Usuario")+ "Su clave es" +
                bundle.getString("Usuario"));
    }

}