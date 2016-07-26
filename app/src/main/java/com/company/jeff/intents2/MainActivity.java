package com.company.jeff.intents2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText nombre,contra,fecha;
    Button btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombre = (EditText)findViewById(R.id.txtinput1);
        contra = (EditText)findViewById(R.id.txtinput2);
        fecha = (EditText)findViewById(R.id.txtinput3);
        btn1 = (Button)findViewById(R.id.send_button);
        btn2 = (Button)findViewById(R.id.show_button);

        mostrar();
        enviar();
    }

    private void mostrar(){

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String mensaje = "Nombre:" +nombre.getText().toString() + "\nContraseña:" +contra.getText().toString() + "\nFecha:" +fecha.getText().toString();
                Toast.makeText(MainActivity.this,mensaje,Toast.LENGTH_LONG).show();

            }
        });

    }

    private void enviar(){

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);

                Bundle bundle = new Bundle();
                bundle.putString("nombre",nombre.getText().toString());
                bundle.putString("contra",contra.getText().toString());
                bundle.putString("fecha",fecha.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }





}
