package com.example.act01_linkia;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Context context = this;
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Asociamos el spinner de la vista
        final Spinner spinner = (Spinner) findViewById(R.id.spinnerSex);

        //Asignamos valores

        String[] valuesToShow = {"MaleArray", "Female"};
        String[] valuesChar = {"M", "F"};

        /*TO DO: Transformar el array a un HashMap o Map, así asociamos un sexo a un tipo*/

        //Opción 1
        /*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.sex,R.layout.support_simple_spinner_dropdown_item);
        //Asignamos el adaptador al spinner
        spinner.setAdapter(adapter);*/

        //Opción 2
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valuesToShow);
        //Asignamos el adaptador al spinner
        spinner.setAdapter(adapter);


        Button btnHello = (Button) findViewById(R.id.buttonHello);

        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtName = (TextView) findViewById(R.id.editTextPersonName);
                //Recuperamos el texto del TextView y lo mostramos por consola
                Log.d("Msg", "Me han clicado: " + txtName.getText());

                //Pasamos a la función la vista para que salude con un Toast
                sayHello(view);

                //Hacemos uso del spinner que recuperamos el spinner


                //Mostramos un mensaje de consola con el valor del spinner
                Log.d("Msg", "El valor del spinner es: " + spinner.getSelectedItem().toString());

                /*AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Mensaje de bienvenida");
                builder.setMessage("Tu nombre es " + txtName.getText());
                builder.setCancelable(true);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();*/


            }

        });

    }

    public void sayHello(View view){

        //Opción 1
        Toast toast = new Toast(this);
        toast.setText("Hola que tal");
        toast.show();

        //Opción 2
        Toast.makeText(this,"ajjaajjaja",Toast.LENGTH_LONG).show();
    }

}