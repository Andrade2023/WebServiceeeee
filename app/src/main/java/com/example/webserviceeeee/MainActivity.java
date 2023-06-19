package com.example.webserviceeeee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btlogin(View view)
    {

        Map<String, String> datos = new HashMap<String, String>();
        String Url= "https://revistas.uteq.edu.ec/ws//login.php?usr=cristian&pass=cristian123";
        WebService ws= new WebService(Url,datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");




    }
    public void btenviar(View View){

        EditText  Usuario = findViewById(R.id.userText);
        EditText Contraseña= findViewById(R.id.PasswordText);
        String user;
        String pass;
        user = Usuario.getText().toString();
        pass = Contraseña.getText().toString();
        Bundle b = new Bundle();
        b.putString("Usuario",user);
        b.putString("Contraseña",pass);
        Intent intent = new Intent(MainActivity.this,WelcomeActivity.class);
        intent.putExtras(b);
        startActivity(intent);




    }
    public void btlimpiar(View view)
    {
        EditText  usuario = findViewById(R.id.userText);
        EditText contraseña= findViewById(R.id.PasswordText);
        usuario.setText("");
        contraseña.setText("");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        TextView resultado= (TextView) findViewById(R.id.resultado);
        resultado.setText("resp del servicio: " + result);

    }
}