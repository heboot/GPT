package gpt.he.com.gpt;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class OutDataUtils {


    /**
     * 加载本地的所有持仓记录
     */
    public static void loadChicangDatas() {
        List<ChiCangModel> chiCangModelList = (List<ChiCangModel>) PreferencesUtils.getObj(MAPP.mapp, "chidangDatas");
        MAPP.mapp.setChiCangModelList(chiCangModelList);

        loadOtherDatas();
    }


    /**
     * 添加一条持仓记录
     *
     * @param chiCangModel
     */
    public static void addChidangData(ChiCangModel chiCangModel) {
        if (MAPP.mapp.getChiCangModelList() == null) {
            MAPP.mapp.setChiCangModelList(new ArrayList<ChiCangModel>());
        }
        MAPP.mapp.getChiCangModelList().add(chiCangModel);
        saveChicangDatas();
    }


    /**
     * 保存持仓记录到本地
     */
    private static void saveChicangDatas() {
        PreferencesUtils.saveObj(MAPP.mapp, "chidangDatas", MAPP.mapp.getChiCangModelList());
    }

    public static void clearDatas() {
        PreferencesUtils.saveObj(MAPP.mapp, "chidangDatas", null);
    }


    /**
     * 成本=  成本价 x 持仓
     * ceshi
     * @return
     */
    public static String getChengbenText(double chengben, int chicang) {
        return formatDouble((chengben * chicang) * 10000);
    }


    /**
     * 市值 = 现价 x 持仓数
     *
     * @param xianjia
     * @param chicang
     * @return
     */
    public static String getShizhiText(double xianjia, int chicang) {

        return formatDouble2a((xianjia * chicang) * 10000);
    }


    /**
     * 盈亏 = (现价  - 成本） * 持仓数
     * <p>
     * 盈亏＝（现价➖ 成本）×10000×手数
     *
     * @param xianjia
     * @param chengben
     * @param chicang
     * @return
     */
    public static String getYingkuiText(double xianjia, double chengben, int chicang) {
        return formatDouble3((xianjia - chengben) * 10000 * chicang);
    }


    /**
     * 百分比  (现价- 成本)/成本价
     *
     * @param xianjia
     * @param chengben
     * @return
     */
    public static String getBaifenbiText(double xianjia, double chengben) {
        String result = formatBaifen((xianjia - chengben) / chengben) + "%";
        return result;
    }


    /**
     * 持仓盈亏
     *
     * @param xianjia
     * @param chicang
     * @param chengben
     * @return
     */
    public static String getChicangYingkuiText(double xianjia, int chicang, double chengben) {
        return formatDouble((xianjia * chicang) - (chengben * chicang));
    }


    private static void loadOtherDatas() {
        String account = PreferencesUtils.getString(MAPP.mapp, "account");
        String baozhengjin = PreferencesUtils.getString(MAPP.mapp, "baozhengjin");
        String zongquanyi = PreferencesUtils.getString(MAPP.mapp, "zongquanyi");


        MAPP.mapp.setAccount(account);
        MAPP.mapp.setBaozhengjin(baozhengjin);
        MAPP.mapp.setZongquanyi(zongquanyi);

    }


    /**
     * 保存交易账号
     */
    public static void saveAccount(String account) {
        MAPP.mapp.setAccount(account);
        PreferencesUtils.putString(MAPP.mapp, "account", account);
    }

    /**
     * 保存保证金
     */
    public static void saveBaozhengjin(String baozhengjin) {
        MAPP.mapp.setBaozhengjin(baozhengjin);
        PreferencesUtils.putString(MAPP.mapp, "baozhengjin", String.valueOf(baozhengjin));
    }

    /**
     * 保存总权益
     */
    public static void saveZongquanyi(String zongquanyi) {
        MAPP.mapp.setZongquanyi(zongquanyi);
        PreferencesUtils.putString(MAPP.mapp, "zongquanyi", zongquanyi + "");
    }


    public static String formatDouble(double value) {
//        DecimalFormat df = new DecimalFormat("#.00");
//        String str = df.format(value);


        if (value == 0) {
            return "0.00";
        }
        NumberFormat nf = NumberFormat.getNumberInstance();

        nf.setGroupingUsed(false); //关闭分组，显示将不再以千位符分隔

        nf.setMaximumFractionDigits(4);
        nf.setRoundingMode(RoundingMode.DOWN);

        String result = nf.format(value);

        if (result.indexOf(".") < 1) {
            return result + ".00";
        }

        return nf.format(value);
    }

    public static String formatDouble2a(double value) {
//        DecimalFormat df = new DecimalFormat("#.00");
//        String str = df.format(value);


        if (value == 0) {
            return "0.00";
        }
        NumberFormat nf = NumberFormat.getNumberInstance();

        nf.setGroupingUsed(false); //关闭分组，显示将不再以千位符分隔

        nf.setMaximumFractionDigits(2);
        nf.setRoundingMode(RoundingMode.DOWN);

        String result = nf.format(value);

        if (result.indexOf(".") < 1) {
            return result + ".00";
        }

        return nf.format(value);
    }


    public static String formatDouble2ByStr(String v) {
//        DecimalFormat df = new DecimalFormat("#.00");
//        String str = df.format(value);

        double value = Double.parseDouble(v);
        if (value == 0) {
            return "0.00";
        }

        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(value);


    }

    public static double formatDoubleByStr(String value) {
//        DecimalFormat df = new DecimalFormat("#.00");
//        String str = df.format(value);


        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(false); //关闭分组，显示将不再以千位符分隔
        nf.setMaximumFractionDigits(4);
        nf.setRoundingMode(RoundingMode.DOWN);

        double vv = Double.parseDouble(nf.format(Double.parseDouble(value)));


        double result = Double.parseDouble(nf.format(vv));

        return result;
    }


    public static String formatDouble2(double value) {
//        DecimalFormat df = new DecimalFormat("#.00");
//        String str = df.format(value);


        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.setGroupingUsed(false); //关闭分组，显示将不再以千位符分隔
        nf.setRoundingMode(RoundingMode.DOWN);
        String aaa = nf.format(value);
        return aaa;
    }


    public static String formatDouble3(double value) {
//        DecimalFormat df = new DecimalFormat("#.00");
//        String str = df.format(value);


        return (int) value + ".00";
    }

    public static String formatBaifen(double value) {
        value = value * 100;
        DecimalFormat df = new DecimalFormat("#.00");
        String str = df.format(value);

        return str;

//        NumberFormat nf = NumberFormat.getNumberInstance();
//        nf.setMaximumFractionDigits(2);
//        nf.setGroupingUsed(false); //关闭分组，显示将不再以千位符分隔
//        nf.setRoundingMode(RoundingMode.UP);
//        String aaa = nf.format(value * 100);
//        return aaa;
    }


    public static String getAllChicangshizhi() {
        double totalValue = 0;

        if (MAPP.mapp.getChiCangModelList() == null || MAPP.mapp.getChiCangModelList().size() == 0) {
            return "0.00";
        }

        for (ChiCangModel chiCangModel : MAPP.mapp.getChiCangModelList()) {
//            if (chiCangModel.getXianjia() * chiCangModel.getChicangkeyong() > 0) {
            totalValue = totalValue + (chiCangModel.getXianjia() * chiCangModel.getChicangkeyong());
//            } else {
//                totalValue = totalValue - (chiCangModel.getXianjia() * chiCangModel.getChicangkeyong());
//            }
        }

        return formatDouble2a(totalValue * 10000);

    }

    public static String getAllYingkui() {
        double totalValue = 0;

        if (MAPP.mapp.getChiCangModelList() == null || MAPP.mapp.getChiCangModelList().size() == 0) {
            return "0.00";
        }

        for (ChiCangModel chiCangModel : MAPP.mapp.getChiCangModelList()) {
            totalValue = totalValue + ((chiCangModel.getXianjia() - chiCangModel.getChengbenjia()) * chiCangModel.getChicangkeyong());
        }

        return formatDouble2a(totalValue * 10000);
    }


}
