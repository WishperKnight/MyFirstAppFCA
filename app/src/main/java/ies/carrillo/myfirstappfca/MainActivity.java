package ies.carrillo.myfirstappfca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Ciclo de vida", "Ha entrado en el modo onCreate");
        //Declaramos las variables
        Button sendButton = findViewById(R.id.button);

        //Declaramos el Intent para pasar a la second activity
        Intent secondView = new Intent(this, SecondActivity.class);
        //aniadimos funcionalidad al boton para enviar el texto a la segunda actividad
        sendButton.setOnClickListener(v -> {
            startActivity(secondView);

        });


    }


    @Override
    protected void onStart() {

        super.onStart();


        Log.i("Ciclo de vida", "Ha entrado en el modo onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de vida", "Ha entrado en el modo onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de vida", "Ha entrado en el modo onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de vida", "Ha entrado en el modo onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de vida", "Ha entrado en el modo onDestroy");
    }

}