package com.baidu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.bean.SpecialBean;
import com.baidu.mall.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvSpecialAdapter extends RecyclerView.Adapter<RlvSpecialAdapter.VH> {
    private Context context;
    private ArrayList<SpecialBean.DlistBean> mArr;

    public RlvSpecialAdapter(Context context, ArrayList<SpecialBean.DlistBean> mArr) {
        this.context = context;
        this.mArr = mArr;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.special_item, null, false);
        new VH(view);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        if (mArr != null && mArr.size() > 0){
            SpecialBean.DlistBean dlistBean = mArr.get(i);
            vh.tvSpeciaTitle.setText(dlistBean.getTitle());
            vh.tvLove.setText(dlistBean.getCollect_count()+"");
            vh.tvEye.setText(dlistBean.getRead_count()+"");
            vh.tvMessage.setText(dlistBean.getComment_count()+"");
            vh.tv_classify_name.setText(dlistBean.getCategory_name());
            vh.tvPrice.setText("￥"+dlistBean.getPrice()+"元");
        }

    }

    @Override
    public int getItemCount() {
        return mArr.size();
    }

    public void addData(ArrayList<SpecialBean.DlistBean> arr) {
        mArr.addAll(arr);
        notifyDataSetChanged();
    }

    public class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_specia_title)
        TextView tvSpeciaTitle;
        @BindView(R.id.line)
        View line;
        @BindView(R.id.tv_special_love)
        TextView tvLove;
        @BindView(R.id.tv_eye)
        TextView tvEye;
        @BindView(R.id.tv_classify_name)
        TextView tv_classify_name;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_message)
        TextView tvMessage;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
