package gpt.he.com.gpt;

import java.io.Serializable;

public class ChiCangModel implements Serializable {

    private String id;

    private String name;

    private int chicangkeyong;

    private double chengbenjia;

    private double xianjia;

    private String yingkui;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChicangkeyong() {
        return chicangkeyong;
    }

    public void setChicangkeyong(int chicangkeyong) {
        this.chicangkeyong = chicangkeyong;
    }

    public double getChengbenjia() {
        return chengbenjia;
    }

    public void setChengbenjia(double chengbenjia) {
        this.chengbenjia = chengbenjia;
    }

    public double getXianjia() {
        return xianjia;
    }

    public void setXianjia(double xianjia) {
        this.xianjia = xianjia;
    }

    public String getYingkui() {
        return yingkui;
    }

    public void setYingkui(String yingkui) {
        this.yingkui = yingkui;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
