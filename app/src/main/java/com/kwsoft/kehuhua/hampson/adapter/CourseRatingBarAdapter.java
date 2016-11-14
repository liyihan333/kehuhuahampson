package com.kwsoft.kehuhua.hampson.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kwsoft.kehuhua.adcustom.R;
import com.kwsoft.kehuhua.hampson.view.AutoNextLineLinearlayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class CourseRatingBarAdapter extends BaseAdapter {
    private Context mContext;
    private List<List<Map<String, String>>> list = new ArrayList<>();

    private boolean isFristTime = true;

    /**
     * 标签之间的间距 px
     */
    final int itemMargins = 17;

    /**
     * 标签的行间距 px
     */
    final int lineMargins = 10;

    private ViewGroup container = null;


    public CourseRatingBarAdapter(Context mContext, List<List<Map<String, String>>> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;

        List<Map<String, String>> map = list.get(i);


//                = (String[]) map.get(0).get("tags");
        if (view == null) {
            //解析布局
            view = LayoutInflater.from(mContext).inflate(R.layout.activity_course_ratingbar_star_list_item, null);
            //创建ViewHolder持有类
            holder = new ViewHolder();
            //将每个控件的对象保存到持有类中
            holder.tv_title = (TextView) view.findViewById(R.id.tv_title);
            holder.my_ping_jia = (TextView) view.findViewById(R.id.my_ping_jia);

            holder.tv_teach_content = (TextView) view.findViewById(R.id.tv_teach_content);
            holder.tv_teach_name = (TextView) view.findViewById(R.id.tv_teach_name);
            holder.teach_name_title = (TextView) view.findViewById(R.id.teach_name_title);
            holder.star0 = view.findViewById(R.id.star0);
            holder.star1 = view.findViewById(R.id.star1);
            holder.star2 = view.findViewById(R.id.star2);
            holder.star3 = view.findViewById(R.id.star3);
            holder.star4 = view.findViewById(R.id.star4);
            //满意度，字段选择
            // holder.ll_cb_layout = (AutoNextLineLinearlayout) view.findViewById(R.id.autolayout);

            //将每个convertView对象中设置这个持有类对象
            view.setTag(holder);
        } else {
            //每次需要使用的时候都会拿到这个持有类
            holder = (ViewHolder) view.getTag();

        }
        //满意度，字段选择
        AutoNextLineLinearlayout ll_cb_layout = (AutoNextLineLinearlayout) view.findViewById(R.id.autolayout);

        //然后可以直接使用这个类中的控件，对控件进行操作，而不用重复去findViewById了
        //课程名称
        holder.tv_title.setText(map.get(1).get("fieldCnName2"));
        //我的评价
        holder.my_ping_jia.setText(map.get(2).get("fieldCnName"));

        String pingJiaMiaoShu = map.get(5).get("fieldCnName2");
        ll_cb_layout.removeAllViews();
        if (pingJiaMiaoShu != null && pingJiaMiaoShu.length() > 0) {
            String[] tags = pingJiaMiaoShu.split(",");//注意，这里的逗号为中文的
            Log.e(TAG, "getView: pingJiaMiaoShu " + pingJiaMiaoShu);
            for (String tag : tags) {
                TextView textview = (TextView) LayoutInflater.from(mContext).inflate(R.layout.assess_list_cb_item, null);
                Log.e("tag", tag + "?" + tags.length);
                textview.setText(tag);
                ll_cb_layout.addView(textview);
            }
        }


        //获取星级汉字
        String xingJi = map.get(2).get("fieldCnName2");


        switch (xingJi) {


            case "五星":
                holder.star0.setBackgroundResource(R.mipmap.star_ratingbar_full);
                holder.star1.setBackgroundResource(R.mipmap.star_ratingbar_full);
                holder.star2.setBackgroundResource(R.mipmap.star_ratingbar_full);
                holder.star3.setBackgroundResource(R.mipmap.star_ratingbar_full);
                holder.star4.setBackgroundResource(R.mipmap.star_ratingbar_full);
                break;
            case "四星":
                holder.star0.setBackgroundResource(R.mipmap.star_ratingbar_full);
                holder.star1.setBackgroundResource(R.mipmap.star_ratingbar_full);
                holder.star2.setBackgroundResource(R.mipmap.star_ratingbar_full);
                holder.star3.setBackgroundResource(R.mipmap.star_ratingbar_full);
                holder.star4.setBackgroundResource(R.mipmap.star_ratingbar_empty);

                break;
            case "三星":
                holder.star0.setBackgroundResource(R.mipmap.star_ratingbar_full);
                holder.star1.setBackgroundResource(R.mipmap.star_ratingbar_full);
                holder.star2.setBackgroundResource(R.mipmap.star_ratingbar_full);
                holder.star3.setBackgroundResource(R.mipmap.star_ratingbar_empty);
                holder.star4.setBackgroundResource(R.mipmap.star_ratingbar_empty);
                break;
            case "二星":
                holder.star0.setBackgroundResource(R.mipmap.star_ratingbar_full);
                holder.star1.setBackgroundResource(R.mipmap.star_ratingbar_full);
                holder.star2.setBackgroundResource(R.mipmap.star_ratingbar_empty);
                holder.star3.setBackgroundResource(R.mipmap.star_ratingbar_empty);
                holder.star4.setBackgroundResource(R.mipmap.star_ratingbar_empty);
                break;
            case "一星":
                holder.star0.setBackgroundResource(R.mipmap.star_ratingbar_full);
                holder.star1.setBackgroundResource(R.mipmap.star_ratingbar_empty);
                holder.star2.setBackgroundResource(R.mipmap.star_ratingbar_empty);
                holder.star3.setBackgroundResource(R.mipmap.star_ratingbar_empty);
                holder.star4.setBackgroundResource(R.mipmap.star_ratingbar_empty);
                break;
            default:
                holder.star0.setBackgroundResource(R.mipmap.star_ratingbar_empty);
                holder.star1.setBackgroundResource(R.mipmap.star_ratingbar_empty);
                holder.star2.setBackgroundResource(R.mipmap.star_ratingbar_empty);
                holder.star3.setBackgroundResource(R.mipmap.star_ratingbar_empty);
                holder.star4.setBackgroundResource(R.mipmap.star_ratingbar_empty);


                break;

        }


        //老师标题和老师名字
        holder.teach_name_title.setText(map.get(0).get("fieldCnName"));
        holder.tv_teach_name.setText(map.get(0).get("fieldCnName2"));
        //获取评价信息

        //获取备注
        holder.tv_teach_content.setText(map.get(3).get("fieldCnName2"));
        //  holder.ll_cb_layout.removeAllViews();


        return view;
    }

    private static final String TAG = "CourseRatingBarAdapter";

    class ViewHolder {
        TextView tv_title, tv_teach_name, tv_teach_content, teach_name_title, my_ping_jia;
        View star0, star1, star2, star3, star4;
        //RatingBar ratingbar;
        //AutoNextLineLinearlayout ll_cb_layout;
    }

    public void clear(){
        list.removeAll(list);
        notifyDataSetChanged();
    }
    public void addData(List<List<Map<String, String>>> addData){
        list.addAll(addData);
        notifyDataSetChanged();
    }

    public List<List<Map<String, String>>> getDatas(){
        return list;

    }
}
