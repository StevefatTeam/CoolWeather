package com.stevefat.coolweather.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.stevefat.coolweather.R;
import com.stevefat.coolweather.model.http.entity.Weather;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author : stevefat
 * Email :ngh8897@gmail.com
 * Created : 17-3-24 下午6:00.
 */

public class MainRecycleAdapter extends RecyclerView.Adapter<MainRecycleAdapter.ViewHolder> {

    List<Weather.ResultBean.FutureBean> future;

    public MainRecycleAdapter(List<Weather.ResultBean.FutureBean> future) {
        future.remove(0);
        this.future = future;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Weather.ResultBean.FutureBean futureBean = future.get(position);

        //跳过第一个数据
        //内层的今天天气
        holder.week.setText(futureBean.getWeek());

        String temp = futureBean.getTemperature();
        String maxTempStr = temp.substring(0, temp.indexOf("C")).trim();
        String minTempStr = temp.substring(temp.indexOf("/") + 1, temp.lastIndexOf("C")).trim();
        holder.maxTemp.setText(maxTempStr);
        holder.minTemp.setText(minTempStr);


    }

    @Override
    public int getItemCount() {
        return future.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.week)
        TextView week;
        @BindView(R.id.week_day)
        TextView weekDay;
        @BindView(R.id.weather_img)
        ImageView weatherImg;
        @BindView(R.id.max_temp)
        TextView maxTemp;
        @BindView(R.id.min_temp)
        TextView minTemp;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
