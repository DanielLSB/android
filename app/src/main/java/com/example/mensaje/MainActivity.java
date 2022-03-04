package com.example.mensaje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText txtChat;
Button btnRegistrar;

    private DatabaseReference Clases;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Clases = FirebaseDatabase.getInstance().getReference("Clases");

        txtChat=(EditText) findViewById(R.id.txtchat);
        btnRegistrar=(Button) findViewById(R.id.btnregistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarClases();
            }
        });

    }

    public void registrarClases(){
       String chat=txtChat.getText().toString();

       if(!TextUtils.isEmpty(chat)){
           String id = Clases.push().getKey();
           Clases leccion = new Clases(id ,chat);
           Clases.child("Lecciones").child(id).setValue(leccion);

           Toast.makeText(this, "enviado", Toast.LENGTH_LONG).show();
       }else{
           Toast.makeText(this, "no enviado", Toast.LENGTH_LONG).show();
       }

    }
}



















