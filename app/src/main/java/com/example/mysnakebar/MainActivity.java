package com.example.mysnakebar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtn;
    private RelativeLayout mRlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);

        mBtn.setOnClickListener(this);
        mRlv = (RelativeLayout) findViewById(R.id.rlv);
        mRlv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                Snackbar sna = Snackbar.make(mRlv, "", Snackbar.LENGTH_INDEFINITE);
                sna.setActionTextColor(Color.parseColor("#fb595b"));
                sna.getView().setBackgroundColor(Color.parseColor("#5b6066"));
                sna.setAction("点击", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
                    }
                });
                sna.show();
                break;
        }
    }
}
