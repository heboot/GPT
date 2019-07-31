package gpt.he.com.gpt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ChiCangActivity extends AppCompatActivity {

    private RecyclerView rvList;

    private ChicangAdapter chicangAdapter;

    private TextView clear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicang);

        initView();

        DataUtils.loadChicangDatas();

    }


    private void initView() {
        rvList = findViewById(R.id.rv_list);
        clear = findViewById(R.id.tv_clear);
        rvList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        chicangAdapter = new ChicangAdapter(MAPP.mapp.getChiCangModelList());

        rvList.setAdapter(chicangAdapter);


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MAPP.mapp.getChiCangModelList() == null) {
                    return;
                }
                chicangAdapter.getData().clear();
                chicangAdapter.notifyDataSetChanged();
                MAPP.mapp.getChiCangModelList().clear();
                DataUtils.clearDatas();
            }
        });
    }


}
