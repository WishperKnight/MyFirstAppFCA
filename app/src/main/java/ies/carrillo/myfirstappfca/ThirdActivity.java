package ies.carrillo.myfirstappfca;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Log.i("tercera activity", "iniciamoa la tercera actividad");
        loadingComponents();

    }

    /**
     * Metodo para cargar los componenetes de la vista
     */
    private void loadingComponents() {

        //Declaramos los componenetes
        TextView tvPlainTextView = findViewById(R.id.tvPlainText);
        TextView tvNumber = findViewById(R.id.tvNumber);
        TextView tvDecimal = findViewById(R.id.tvDecimal);
        TextView tvSwitchState = findViewById(R.id.tvSwitchState);

        //Declaramos el boton
        Button btnGoMainPage = findViewById(R.id.btnGoMainPage);

        //declaramos el intent
        Intent goMainPage = new Intent(this, MainActivity.class);
        Intent getData = getIntent();
        // Log.i("Datos", getData.getData().toString());
        //Rellenamos ls campos con los datos pasados por el intent de la SecondActivity
        tvPlainTextView.setText("Plain text: " + getData.getStringExtra("plainText").toString());
        tvNumber.setText("Number: " + getData.getIntExtra("number", 0));
        tvDecimal.setText("Decimal: " + getData.getDoubleExtra("decimal", 0.0));
        String estado = booleanState(getData.getBooleanExtra("switch", true));
        tvSwitchState.setText("Switch state: " + estado);

        //Preparamos la accion del boton
        btnGoMainPage.setOnClickListener(v -> startActivity(goMainPage));
    }

    private String booleanState(boolean state) {

        String booleanState = "true";
        if (state != true) {
            booleanState = "false";
            return booleanState;
        }
        return booleanState;
    }
}