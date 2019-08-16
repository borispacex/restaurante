package com.example.restaurante;

import android.hardware.Sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
// import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

// import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int indice = 0;
    int imagenes[] = {
            R.drawable.thimpu,
            R.drawable.fricase,
            R.drawable.sajta,
            R.drawable.platopacenio,
            R.drawable.charkekan,
            R.drawable.sopademani,
            R.drawable.ajidefideo,
            R.drawable.saice,
            R.drawable.sopadefideo,
            R.drawable.picantemixto,
            R.drawable.milasedepollo,
            R.drawable.chairo
    };
    String textos[] = {
            "Thimpu",
            "Fricase",
            "Sajta",
            "Plato Paceño",
            "Charquekan",
            "Sopa de mani",
            "Aji de Fideo",
            "Saice",
            "Sopa de fideo",
            "Picante mixto",
            "Milanesa de pollo",
            "Chairo"
    };
    private ImageView pimg;
    private TextView nomImg;
    private TextView tprecios;

    private EditText epedido;
    private EditText epagar;

    private Button btnDevolver;
    private Button btnComprar;


    int precio[] = {
        26, 32, 28, 25 ,30, 18, 15, 20, 12, 35, 18, 22
    };

    int espera[] = {
        12, 10, 10, 15, 15, 5, 5, 10, 5, 15, 8, 5
    };

    int pedido[] = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    int apagar[] = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    int suma = 0;
    int cantidad = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pimg = (ImageView) findViewById(R.id.imageView);
        nomImg = (TextView) findViewById(R.id.textView );
        tprecios = (TextView) findViewById(R.id.textViewPrecio);
        epedido = (EditText) findViewById(R.id.inputpedido);
        epagar = (EditText) findViewById(R.id.inputpagar);
        btnComprar = (Button) findViewById(R.id.comprar);
        btnDevolver = (Button) findViewById(R.id.devolver);
    }


    public void antes(View vista) {
        indice--;
        if (indice<0) indice=11;
        nomImg.setText(textos[indice]+" ");
        pimg.setImageResource(imagenes[indice]);
        tprecios.setText(precio[indice]+"");

        epagar.setText(suma+"");
        epedido.setText(pedido[indice]+"");

        if (pedido[indice] == 0) {
            btnDevolver.setEnabled(false);
        }else{
            btnDevolver.setEnabled(true);
        }
    }

    public void siguiente(View vista) {
        indice++;
        if (indice>11) indice=0;
        nomImg.setText(textos[indice]+" ");
        pimg.setImageResource(imagenes[indice]);
        tprecios.setText(precio[indice]+"");

        epagar.setText(suma+"");
        epedido.setText(pedido[indice]+"");

        if (pedido[indice] == 0) {
            btnDevolver.setEnabled(false);
        }else{
            btnDevolver.setEnabled(true);
        }
    }

    public void devolver(View view) {
        if (pedido[indice] > 0) {

            pedido[indice] = pedido[indice] - 1;
            apagar[indice] = apagar[indice] - precio[indice];

            suma = suma - precio[indice];
            cantidad = cantidad - 1;

            epagar.setText(suma+"");
            epedido.setText(pedido[indice]+"");
        }
        if (pedido[indice] == 0) btnDevolver.setEnabled(false);
    }

    public void f(View view) {
        Toast toast = Toast.makeText(this, "Pedido total: "+cantidad+"   -   "+"A pagar total: "+suma, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void c(View view) {
        for (int i=0; i< 12; i++) {
            pedido[i] = 0;
            apagar[i] = 0;
        }
        epagar.setText("0");
        epedido.setText("0");
        suma = 0;
        cantidad = 0;
        btnDevolver.setEnabled(false);
    }

    public void comprar(View view) {
        pedido[indice] = pedido[indice] + 1;
        apagar[indice] = apagar[indice] + precio[indice];

        suma = suma + precio[indice];
        cantidad = cantidad + 1;

        epagar.setText(suma+"");
        epedido.setText(pedido[indice]+"");

        btnDevolver.setEnabled(true);
    }
}
