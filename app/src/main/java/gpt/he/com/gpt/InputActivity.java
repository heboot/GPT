package gpt.he.com.gpt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    private EditText account, chengbenjia, xianjia, chicang, zongquanyi, baozhengjin, etName;

    private RadioButton rbIn, rbOut;

    private Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        initView();
    }


    private void initView() {
        account = findViewById(R.id.et_account);
        chengbenjia = findViewById(R.id.et_chengbenjia);
        xianjia = findViewById(R.id.et_xianjia);
        chicang = findViewById(R.id.et_chicang);
        zongquanyi = findViewById(R.id.et_zongquanyi);
        baozhengjin = findViewById(R.id.et_baozhengjin);
        save = findViewById(R.id.btn_save);
        etName = findViewById(R.id.et_name);
        rbIn = findViewById(R.id.rb_in);
        rbOut =findViewById(R.id.rb_out);

        account.setText(MAPP.mapp.getAccount());
        zongquanyi.setText(MAPP.mapp.getZongquanyi() + "");
        baozhengjin.setText(MAPP.mapp.getBaozhengjin() + "");


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbIn.isChecked()){
                    if (!StringUtils.isEmpty(account.getText())) {
                        DataUtils.saveAccount(account.getText().toString());
                    }
                    if (!StringUtils.isEmpty(zongquanyi.getText())) {
                        DataUtils.saveZongquanyi(DataUtils.formatDouble2ByStr(zongquanyi.getText().toString()) + "");
                    }
                    if (!StringUtils.isEmpty(baozhengjin.getText())) {
                        DataUtils.saveBaozhengjin(DataUtils.formatDouble2ByStr(baozhengjin.getText().toString()) + "");
                    }

                    if (otherNull() && dataNull()) {
                        Toast.makeText(MAPP.mapp, "请输入数据哦", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (otherNull() && StringUtils.isEmpty(chengbenjia.getText())) {
                        Toast.makeText(MAPP.mapp, "请输入成本价", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (otherNull() && StringUtils.isEmpty(etName.getText())) {
                        Toast.makeText(MAPP.mapp, "请输入合约名称", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (otherNull() && StringUtils.isEmpty(chicang.getText())) {
                        Toast.makeText(MAPP.mapp, "请输入持仓数", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (otherNull() && StringUtils.isEmpty(baozhengjin.getText())) {
                        Toast.makeText(MAPP.mapp, "请输入保证金", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (!dataNull()) {
                        ChiCangModel chiCangModel = new ChiCangModel();
                        chiCangModel.setType("in");
                        chiCangModel.setChengbenjia(DataUtils.formatDoubleByStr(chengbenjia.getText().toString()));
                        chiCangModel.setXianjia(DataUtils.formatDoubleByStr(xianjia.getText().toString()));
                        chiCangModel.setChicangkeyong(Integer.parseInt(chicang.getText().toString()));
                        chiCangModel.setId(System.currentTimeMillis() + "");
                        chiCangModel.setName(etName.getText().toString());
                        DataUtils.addChidangData(chiCangModel);
                    }


                    Toast.makeText(MAPP.mapp, "保存成功", Toast.LENGTH_LONG).show();

                    finish();
                }else if(rbOut.isChecked()){
                    if (!StringUtils.isEmpty(account.getText())) {
                        DataUtils.saveAccount(account.getText().toString());
                    }
                    if (!StringUtils.isEmpty(zongquanyi.getText())) {
                        DataUtils.saveZongquanyi(DataUtils.formatDouble2ByStr(zongquanyi.getText().toString()) + "");
                    }
                    if (!StringUtils.isEmpty(baozhengjin.getText())) {
                        DataUtils.saveBaozhengjin(DataUtils.formatDouble2ByStr(baozhengjin.getText().toString()) + "");
                    }

                    if (otherNull() && dataNull()) {
                        Toast.makeText(MAPP.mapp, "请输入数据哦", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (otherNull() && StringUtils.isEmpty(chengbenjia.getText())) {
                        Toast.makeText(MAPP.mapp, "请输入成本价", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (otherNull() && StringUtils.isEmpty(etName.getText())) {
                        Toast.makeText(MAPP.mapp, "请输入合约名称", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (otherNull() && StringUtils.isEmpty(chicang.getText())) {
                        Toast.makeText(MAPP.mapp, "请输入持仓数", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (otherNull() && StringUtils.isEmpty(baozhengjin.getText())) {
                        Toast.makeText(MAPP.mapp, "请输入保证金", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (!dataNull()) {
                        ChiCangModel chiCangModel = new ChiCangModel();
                        chiCangModel.setType("out");
                        chiCangModel.setChengbenjia(DataUtils.formatDoubleByStr(chengbenjia.getText().toString()));
                        chiCangModel.setXianjia(DataUtils.formatDoubleByStr(xianjia.getText().toString()));
                        chiCangModel.setChicangkeyong(Integer.parseInt(chicang.getText().toString()));
                        chiCangModel.setId(System.currentTimeMillis() + "");
                        chiCangModel.setName(etName.getText().toString());
                        DataUtils.addChidangData(chiCangModel);
                    }
                    Toast.makeText(MAPP.mapp, "保存成功", Toast.LENGTH_LONG).show();
                    finish();
                }




            }
        });

    }

    private boolean otherNull() {
        if (StringUtils.isEmpty(account.getText())
                && StringUtils.isEmpty(zongquanyi.getText())
                && StringUtils.isEmpty(baozhengjin.getText())
                ) {
            return true;
        }
        return false;
    }

    private boolean dataNull() {
        if (StringUtils.isEmpty(chengbenjia.getText())
                && StringUtils.isEmpty(xianjia.getText())
                && StringUtils.isEmpty(etName.getText())
                && StringUtils.isEmpty(chicang.getText())
                ) {
            return true;
        }
        return false;
    }

}