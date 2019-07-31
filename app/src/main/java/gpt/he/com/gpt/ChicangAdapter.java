package gpt.he.com.gpt;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class ChicangAdapter extends BaseQuickAdapter<ChiCangModel, BaseViewHolder> {


    private boolean isIn = false;

    public ChicangAdapter(List<ChiCangModel> chiCangModelList) {
        super(R.layout.item_chicang, chiCangModelList);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, ChiCangModel item) {
        viewHolder.setText(R.id.tv_name, item.getName());
        viewHolder.setText(R.id.tv_chengbenjia, DataUtils.formatDouble(item.getChengbenjia()) + "/");
        viewHolder.setText(R.id.tv_xianjia, DataUtils.formatDouble(item.getXianjia()));

        if (item.getXianjia() >= item.getChengbenjia()) {
            isIn = true;
        } else {
            isIn = false;
        }

        if (isIn) {
            ((TextView) viewHolder.getView(R.id.tv_shizhi)).setTextColor(MAPP.mapp.getResources().getColor(R.color.colorPrimary));
            ((TextView) viewHolder.getView(R.id.tv_xianjia)).setTextColor(MAPP.mapp.getResources().getColor(R.color.colorPrimary));
            ((TextView) viewHolder.getView(R.id.tv_yingkui)).setTextColor(MAPP.mapp.getResources().getColor(R.color.colorPrimary));
            ((TextView) viewHolder.getView(R.id.tv_baifenbi)).setTextColor(MAPP.mapp.getResources().getColor(R.color.colorPrimary));
        } else {
            ((TextView) viewHolder.getView(R.id.tv_xianjia)).setTextColor(MAPP.mapp.getResources().getColor(R.color.c5EC271));
            ((TextView) viewHolder.getView(R.id.tv_baifenbi)).setTextColor(MAPP.mapp.getResources().getColor(R.color.c5EC271));
            ((TextView) viewHolder.getView(R.id.tv_shizhi)).setTextColor(MAPP.mapp.getResources().getColor(R.color.c5EC271));
            ((TextView) viewHolder.getView(R.id.tv_yingkui)).setTextColor(MAPP.mapp.getResources().getColor(R.color.c5EC271));
        }


        viewHolder.setText(R.id.tv_chicang, item.getChicangkeyong() + "");
        viewHolder.setText(R.id.tv_keyong, item.getChicangkeyong() + "");

        viewHolder.setText(R.id.tv_chengben, DataUtils.getChengbenText(item.getChengbenjia(), item.getChicangkeyong()) + "/");
        viewHolder.setText(R.id.tv_shizhi, DataUtils.getShizhiText(item.getXianjia(), item.getChicangkeyong()));

        viewHolder.setText(R.id.tv_yingkui, DataUtils.getYingkuiText(item.getXianjia(), item.getChengbenjia(), item.getChicangkeyong()));

        viewHolder.setText(R.id.tv_baifenbi, DataUtils.getBaifenbiText(item.getXianjia(), item.getChengbenjia()));

//                .setText(R.id.tv, item.getText())
//                .setText(R.id.tweetDate, item.getCreatedAt())
//                .setVisible(R.id.tweetRT, item.isRetweet())
//                .linkify(R.id.tweetText);
//        Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) viewHolder.getView(R.id.iv));
    }
}
