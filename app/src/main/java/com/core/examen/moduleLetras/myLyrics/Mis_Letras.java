package com.core.examen.moduleLetras.myLyrics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.core.examen.MainActivity;
import com.core.examen.R;
import com.core.examen.moduleLetras.Letras;
import com.core.examen.moduleLetras.myLyrics.fragment.Fragment_Recycler;

import butterknife.ButterKnife;

public class Mis_Letras extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mis_letras);
        ButterKnife.bind(this);


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame, new Fragment_Recycler());
        transaction.commit();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        startActivity(new Intent(getApplicationContext(), Letras.class));

    }
}
