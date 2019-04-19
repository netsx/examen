package com.core.examen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.core.examen.moduleLetras.Letras;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.letras)
    LinearLayout letras;
    @BindView(R.id.series)
    LinearLayout series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.letras, R.id.series})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.letras:


                    startActivity(new Intent(this, Letras.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                break;


                case R.id.series:

                    break;
        }
    }
}
