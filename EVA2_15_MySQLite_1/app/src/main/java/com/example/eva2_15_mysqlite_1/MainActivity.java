package com.example.eva2_15_mysqlite_1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase slqMyDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Crear o abrir la base de datos en el espacio interno
        slqMyDB = openOrCreateDatabase("mi_base_datos", MODE_PRIVATE, null);

        try {
            slqMyDB.execSQL("create table prueba(id integer primary key autoincrement," +
                    "columna1 text," +
                    "columna2 integer);");
        }catch (SQLiteException e){
            e.printStackTrace();
        }
        try {
            slqMyDB.execSQL("insert into prueba(columna1, columna2)values('HOLA MUNDO!',100);");
        }catch (SQLiteException e){
            e.printStackTrace();
        }
    }
}
