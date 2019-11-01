package com.example.loteria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int[] cartas = new int[54];
    private int timesPressed;
    private TextToSpeech mTTS;
    Locale locSpanish = new Locale("spa", "MEX");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar el TextToSpeech
        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(locSpanish);
                }
            }
        });
        // Velocidad del speech
        mTTS.setSpeechRate(.60f);
        Button btnNext = findViewById(R.id.btn_next);
        ImageButton btnRestart = findViewById(R.id.btn_restart);
        ImageView imgPrincipal = findViewById(R.id.iv_card);
        // Configuración de arranque
        startGame();

        // Al presionar 'Siguiente carta'
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateCard();
            }
        });

        imgPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = i + 1;
        }
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
        if (cartas[randomNumber] != 0 && timesPressed != 54) {
            drawCard(randomNumber);
            timesPressed++;

            String message = "Número de cartas jugadas: " + timesPressed;
            tvTimesPressed.setText(message);

            return;
        }

        // Si se ha presionado 54 veces
        if (timesPressed == 54) {
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

        switch (cartas[number]) {
            case 1:
                ivCard.setImageResource(R.drawable.uno);
                mTTS.speak("el gallo", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 2:
                ivCard.setImageResource(R.drawable.dos);
                mTTS.speak("el diablito", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 3:
                ivCard.setImageResource(R.drawable.tres);
                mTTS.speak("la dama", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 4:
                ivCard.setImageResource(R.drawable.cuatro);
                mTTS.speak("el catrín", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 5:
                ivCard.setImageResource(R.drawable.cinco);
                mTTS.speak("el paraguas ", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 6:
                ivCard.setImageResource(R.drawable.seis);
                mTTS.speak("la sirena", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 7:
                ivCard.setImageResource(R.drawable.siete);
                mTTS.speak("la escalera", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 8:
                ivCard.setImageResource(R.drawable.ocho);
                mTTS.speak("la botella", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 9:
                ivCard.setImageResource(R.drawable.nueve);
                mTTS.speak("el barril", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 10:
                ivCard.setImageResource(R.drawable.diez);
                mTTS.speak("el árbol", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 11:
                ivCard.setImageResource(R.drawable.once);
                mTTS.speak("el melón", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 12:
                ivCard.setImageResource(R.drawable.doce);
                mTTS.speak("el valiente", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 13:
                ivCard.setImageResource(R.drawable.trece);
                mTTS.speak("el gorrito", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 14:
                ivCard.setImageResource(R.drawable.catorce);
                mTTS.speak("la muerte", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 15:
                ivCard.setImageResource(R.drawable.quince);
                mTTS.speak("la pera", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 16:
                ivCard.setImageResource(R.drawable.dieciseis);
                mTTS.speak("la bandera", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 17:
                ivCard.setImageResource(R.drawable.diecisiete);
                mTTS.speak("el bandolón", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 18:
                ivCard.setImageResource(R.drawable.dieciocho);
                mTTS.speak("el violoncello", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 19:
                ivCard.setImageResource(R.drawable.diecinueve);
                mTTS.speak("la garza", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 20:
                ivCard.setImageResource(R.drawable.veinte);
                mTTS.speak("el pájaro", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 21:
                ivCard.setImageResource(R.drawable.veintiuno);
                mTTS.speak("la mano", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 22:
                ivCard.setImageResource(R.drawable.veintidos);
                mTTS.speak("la bota", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 23:
                ivCard.setImageResource(R.drawable.veintitres);
                mTTS.speak("la luna", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 24:
                ivCard.setImageResource(R.drawable.veinticuatro);
                mTTS.speak("el cotorro", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 25:
                ivCard.setImageResource(R.drawable.veinticinco);
                mTTS.speak("el borracho", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 26:
                ivCard.setImageResource(R.drawable.veintiseis);
                mTTS.speak("el negrito", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 27:
                ivCard.setImageResource(R.drawable.veintisiete);
                mTTS.speak("el corazón", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 28:
                ivCard.setImageResource(R.drawable.veintiocho);
                mTTS.speak("la sandía", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 29:
                ivCard.setImageResource(R.drawable.veintinueve);
                mTTS.speak("el tambor", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 30:
                ivCard.setImageResource(R.drawable.treinta);
                mTTS.speak("el camarón", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 31:
                ivCard.setImageResource(R.drawable.treintayuno);
                mTTS.speak("las jaras", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 32:
                ivCard.setImageResource(R.drawable.treintaydos);
                mTTS.speak("el músico", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 33:
                ivCard.setImageResource(R.drawable.treintaytres);
                mTTS.speak("la araña", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 34:
                ivCard.setImageResource(R.drawable.treintaycuatro);
                mTTS.speak("el soldado", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 35:
                ivCard.setImageResource(R.drawable.treintaycinco);
                mTTS.speak("la estrella", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 36:
                ivCard.setImageResource(R.drawable.treintayseis);
                mTTS.speak("el cazo", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 37:
                ivCard.setImageResource(R.drawable.treintaysiete);
                mTTS.speak("el mundo", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 38:
                ivCard.setImageResource(R.drawable.treintayocho);
                mTTS.speak("el apache", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 39:
                ivCard.setImageResource(R.drawable.treintaynueve);
                mTTS.speak("el nopal", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 40:
                ivCard.setImageResource(R.drawable.cuarenta);
                mTTS.speak("el alacrán", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 41:
                ivCard.setImageResource(R.drawable.cuarentayuno);
                mTTS.speak("la rosa", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 42:
                ivCard.setImageResource(R.drawable.cuarentaydos);
                mTTS.speak("la calavera", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 43:
                ivCard.setImageResource(R.drawable.cuarentaytres);
                mTTS.speak("la campana", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 44:
                ivCard.setImageResource(R.drawable.cuarentaycuatro);
                mTTS.speak("el cantarito", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 45:
                ivCard.setImageResource(R.drawable.cuarentaycinco);
                mTTS.speak("el venado", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 46:
                ivCard.setImageResource(R.drawable.cuarentayseis);
                mTTS.speak("el sol", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 47:
                ivCard.setImageResource(R.drawable.cuarentaysiete);
                mTTS.speak("la corona", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 48:
                ivCard.setImageResource(R.drawable.cuarentayocho);
                mTTS.speak("la chalupa", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 49:
                ivCard.setImageResource(R.drawable.cuarentaynueve);
                mTTS.speak("el pino", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 50:
                ivCard.setImageResource(R.drawable.cincuenta);
                mTTS.speak("el pescado", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 51:
                ivCard.setImageResource(R.drawable.cincuentayuno);
                mTTS.speak("la palma", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 52:
                ivCard.setImageResource(R.drawable.cincuentaydos);
                mTTS.speak("la maceta", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 53:
                ivCard.setImageResource(R.drawable.cincuentaytres);
                mTTS.speak("el arpa", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 54:
                ivCard.setImageResource(R.drawable.cincientaycuatro);
                mTTS.speak("la rana", TextToSpeech.QUEUE_FLUSH, null);
                break;
        }

        // Deshabilitar carta
        cartas[number] = 0;
    }
}
