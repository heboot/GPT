package gpt.he.com.gpt;

import android.app.Application;

import java.util.List;

public class MAPP extends Application {


    public static MAPP mapp;

    private List<ChiCangModel> chiCangModelList;


    private String account;

    private String zongquanyi, baozhengjin;


    @Override
    public void onCreate() {
        super.onCreate();
        mapp = this;

        DataUtils.loadChicangDatas();

    }

    public List<ChiCangModel> getChiCangModelList() {
        return chiCangModelList;
    }

    public void setChiCangModelList(List<ChiCangModel> chiCangModelList) {
        this.chiCangModelList = chiCangModelList;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getZongquanyi() {
        return zongquanyi;
    }

    public void setZongquanyi(String zongquanyi) {
        this.zongquanyi = zongquanyi;
    }

    public String getBaozhengjin() {
        return baozhengjin;
    }

    public void setBaozhengjin(String baozhengjin) {
        this.baozhengjin = baozhengjin;
    }
}
