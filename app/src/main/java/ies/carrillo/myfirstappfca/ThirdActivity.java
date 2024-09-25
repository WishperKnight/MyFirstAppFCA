package ies.carrillo.myfirstappfca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
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
        Intent getData=getIntent();


        tvPlainTextView.setText("Plain text: "+getData.getStringExtra("plainText"));
        tvPlainTextView.setText("Number: "+getData.getStringExtra("number"));
        tvPlainTextView.setText("Decimal: "+getData.getStringExtra("decimal"));
        tvPlainTextView.setText("Switch state: "+booleanState(getData.getBooleanExtra("switch")));

    }
    private String booleanState(boolean state){

        String booleanState="true";
        if (state==true){
            return booleanState;
        }else{
            booleanState="false";
            return booleanState;
        }

    }
}