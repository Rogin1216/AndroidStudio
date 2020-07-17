package com.example.androidexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner ProvinceSpinner, MunicipalitySpinner, BarangaySpinner, SitioSpinner;
    List<String> subCategories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProvinceSpinner = findViewById(R.id.ProvinceSpinner);
        MunicipalitySpinner = findViewById(R.id.MunicipalitySpinner);
        BarangaySpinner = findViewById(R.id.BarangaySpinner);
        SitioSpinner = findViewById(R.id.SitioSpinner);

        List<String> categories = new ArrayList<>();
        categories.add("Abra");
        categories.add("Apayao");
        categories.add("Benguet");
        categories.add("Baguio");
        categories.add("Ifugao");
        categories.add("Kalinga");
        categories.add("Mt. Province");

        ArrayAdapter<String> adapter_1 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categories);
        adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ProvinceSpinner.setAdapter(adapter_1);

        ProvinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).equals("Abra"))
                {
                    subCategories.clear();
                    subCategories.add("Bangued");
                    subCategories.add("Boliney");
                    subCategories.add("Bucay");
                    subCategories.add("Bocloc");
                    subCategories.add("Daguioman");
                    fillSpinner();
                }
                else if (adapterView.getItemAtPosition(i).equals("Apayao"))
                {
                    subCategories.clear();
                    subCategories.add("Calanasan");
                    subCategories.add("Conner");
                    subCategories.add("Flora");
                    subCategories.add("Kabugao");
                    subCategories.add("Luna");
                    fillSpinner();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void fillSpinner()
    {
        ArrayAdapter<String> adapter_2 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,subCategories);
        adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MunicipalitySpinner.setAdapter(adapter_2);
    }
}

/**
    Spinner SitioSpinner = findViewById(R.id.SitioSpinner); <--setContentView
        SitioSpinner.setOnItemSelectedListener(this);
     @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
 */