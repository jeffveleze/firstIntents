package com.company.jeff.intents2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
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
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    EditText nombre,contra,fecha;
    Button btn1,btn2;
    @BindView(R.id.proof_button) Button proofButton;
    @BindView(R.id.proof_text) TextView proofText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

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

                if(!nombre.getText().toString().isEmpty() &&
                        !contra.getText().toString().isEmpty() &&
                        !fecha.getText().toString().isEmpty()){

                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("nombre",nombre.getText().toString());
                    bundle.putString("contra",contra.getText().toString());
                    bundle.putString("fecha",fecha.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                    
                }else {
                    Snackbar.make(view,"Información adjunta no está completa",Snackbar.LENGTH_SHORT).show();
                }

            }
        });

    }

    @OnClick(R.id.proof_button)
    public void submit(View view){

        proofButton.setBackgroundColor(Color.parseColor("#01D6BB"));
        proofText.setText("Cambió con ButterKnife");
        Snackbar.make(view,"Probando los Snackbars",Snackbar.LENGTH_SHORT).show();

    }

}
