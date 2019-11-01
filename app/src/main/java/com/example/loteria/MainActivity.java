package com.example.loteria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int[] cartas = new int[54];
    private int timesPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNext = findViewById(R.id.btn_next);
        ImageButton btnRestart = findViewById(R.id.btn_restart);

        // Configuración de arranque
        startGame();

        // Al presionar 'Siguiente carta'
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateCard();
            }
        });

        // Al presionar <Reiniciar>
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
            }
        });
    }

    void startGame() {
        // Habilitar las cartas
        for(int i = 0; i < cartas.length; i++) { cartas[i] = i + 1; }
        timesPressed = 0;

        TextView tvTimesPressed = findViewById(R.id.tv_timesPressed);
        tvTimesPressed.setText("");

        // Imagen de inicio
        ImageView ivCard = findViewById(R.id.iv_card);
        ivCard.setImageResource(R.drawable.start);

        // Botones
        Button btnNext = findViewById(R.id.btn_next);
        ImageButton btnRestart = findViewById(R.id.btn_restart);
        btnNext.setVisibility(View.VISIBLE);
        btnRestart.setVisibility(View.VISIBLE);
    }

    void generateCard() {
        TextView tvTimesPressed = findViewById(R.id.tv_timesPressed);
        Random random = new Random();

        int randomNumber = random.nextInt(54);

        // Si la carta no está deshabilitada y no se ha presionado 54 veces
        if(cartas[randomNumber] != 0 && timesPressed != 54) {
            drawCard(randomNumber);
            timesPressed++;

            String message = "Número de cartas jugadas: " + timesPressed;
            tvTimesPressed.setText(message);

            return;
        }

        // Si se ha presionado 54 veces
        if(timesPressed == 54) {
            // Imagen 'Sin cartas'
            ImageView ivCard = findViewById(R.id.iv_card);
            ivCard.setImageResource(R.drawable.empty);

            //Boton
            Button btnNext = findViewById(R.id.btn_next);
            btnNext.setVisibility(View.GONE);

            return;
        }

        generateCard();
    }

    void drawCard(int number) {
        ImageView ivCard = findViewById(R.id.iv_card);

        switch(cartas[number]) {
            case 1:
                ivCard.setImageResource(R.drawable.uno);
                break;
            case 2:
                ivCard.setImageResource(R.drawable.dos);
                break;
            case 3:
                ivCard.setImageResource(R.drawable.tres);
                break;
            case 4:
                ivCard.setImageResource(R.drawable.cuatro);
                break;
            case 5:
                ivCard.setImageResource(R.drawable.cinco);
                break;
            case 6:
                ivCard.setImageResource(R.drawable.seis);
                break;
            case 7:
                ivCard.setImageResource(R.drawable.siete);
                break;
            case 8:
                ivCard.setImageResource(R.drawable.ocho);
                break;
            case 9:
                ivCard.setImageResource(R.drawable.nueve);
                break;
            case 10:
                ivCard.setImageResource(R.drawable.diez);
                break;
            case 11:
                ivCard.setImageResource(R.drawable.once);
                break;
            case 12:
                ivCard.setImageResource(R.drawable.doce);
                break;
            case 13:
                ivCard.setImageResource(R.drawable.trece);
                break;
            case 14:
                ivCard.setImageResource(R.drawable.catorce);
                break;
            case 15:
                ivCard.setImageResource(R.drawable.quince);
                break;
            case 16:
                ivCard.setImageResource(R.drawable.dieciseis);
                break;
            case 17:
                ivCard.setImageResource(R.drawable.diecisiete);
                break;
            case 18:
                ivCard.setImageResource(R.drawable.dieciocho);
                break;
            case 19:
                ivCard.setImageResource(R.drawable.diecinueve);
                break;
            case 20:
                ivCard.setImageResource(R.drawable.veinte);
                break;
            case 21:
                ivCard.setImageResource(R.drawable.veintiuno);
                break;
            case 22:
                ivCard.setImageResource(R.drawable.veintidos);
                break;
            case 23:
                ivCard.setImageResource(R.drawable.veintitres);
                break;
            case 24:
                ivCard.setImageResource(R.drawable.veinticuatro);
                break;
            case 25:
                ivCard.setImageResource(R.drawable.veinticinco);
                break;
            case 26:
                ivCard.setImageResource(R.drawable.veintiseis);
                break;
            case 27:
                ivCard.setImageResource(R.drawable.veintisiete);
                break;
            case 28:
                ivCard.setImageResource(R.drawable.veintiocho);
                break;
            case 29:
                ivCard.setImageResource(R.drawable.veintinueve);
                break;
            case 30:
                ivCard.setImageResource(R.drawable.treinta);
                break;
            case 31:
                ivCard.setImageResource(R.drawable.treintayuno);
                break;
            case 32:
                ivCard.setImageResource(R.drawable.treintaydos);
                break;
            case 33:
                ivCard.setImageResource(R.drawable.treintaytres);
                break;
            case 34:
                ivCard.setImageResource(R.drawable.treintaycuatro);
                break;
            case 35:
                ivCard.setImageResource(R.drawable.treintaycinco);
                break;
            case 36:
                ivCard.setImageResource(R.drawable.treintayseis);
                break;
            case 37:
                ivCard.setImageResource(R.drawable.treintaysiete);
                break;
            case 38:
                ivCard.setImageResource(R.drawable.treintayocho);
                break;
            case 39:
                ivCard.setImageResource(R.drawable.treintaynueve);
                break;
            case 40:
                ivCard.setImageResource(R.drawable.cuarenta);
                break;
            case 41:
                ivCard.setImageResource(R.drawable.cuarentayuno);
                break;
            case 42:
                ivCard.setImageResource(R.drawable.cuarentaydos);
                break;
            case 43:
                ivCard.setImageResource(R.drawable.cuarentaytres);
                break;
            case 44:
                ivCard.setImageResource(R.drawable.cuarentaycuatro);
                break;
            case 45:
                ivCard.setImageResource(R.drawable.cuarentaycinco);
                break;
            case 46:
                ivCard.setImageResource(R.drawable.cuarentayseis);
                break;
            case 47:
                ivCard.setImageResource(R.drawable.cuarentaysiete);
                break;
            case 48:
                ivCard.setImageResource(R.drawable.cuarentayocho);
                break;
            case 49:
                ivCard.setImageResource(R.drawable.cuarentaynueve);
                break;
            case 50:
                ivCard.setImageResource(R.drawable.cincuenta);
                break;
            case 51:
                ivCard.setImageResource(R.drawable.cincuentayuno);
                break;
            case 52:
                ivCard.setImageResource(R.drawable.cincuentaydos);
                break;
            case 53:
                ivCard.setImageResource(R.drawable.cincuentaytres);
                break;
            case 54:
                ivCard.setImageResource(R.drawable.cincientaycuatro);
                break;
        }

        // Deshabilitar carta
        cartas[number] = 0;
    }
}
