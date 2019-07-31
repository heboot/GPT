package gpt.he.com.gpt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioButton my, jy;


    private Intent intent;

    private TextView account, zongquanyi, chicangshizhi, yingkui, baozhengjin;

    private boolean initFlag = false;

    private LinearLayout llytChicang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        my = findViewById(R.id.rb_my);
        jy = findViewById(R.id.rb_jy);

        account = findViewById(R.id.tv_account);
        zongquanyi = findViewById(R.id.tv_zongquanyi);
        chicangshizhi = findViewById(R.id.chicangshizhi);
        yingkui = findViewById(R.id.tv_yingkui);
        baozhengjin = findViewById(R.id.tv_baozhengjin);

        llytChicang = findViewById(R.id.llyt_chicang);
        my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(MainActivity.this, InputActivity.class);
                startActivity(intent);

            }
        });
        llytChicang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(MainActivity.this, ChiCangActivity.class);
                startActivity(intent);

            }
        });


        initDatas();

        initFlag = true;
    }


    private void initDatas() {


        account.setText(MAPP.mapp.getAccount());
        zongquanyi.setText(MAPP.mapp.getZongquanyi() + "");
        chicangshizhi.setText(DataUtils.getAllChicangshizhi());
        yingkui.setText(DataUtils.getAllYingkui());
        baozhengjin.setText(MAPP.mapp.getBaozhengjin() + "");

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (initFlag) {
            initDatas();
        }
    }
}
