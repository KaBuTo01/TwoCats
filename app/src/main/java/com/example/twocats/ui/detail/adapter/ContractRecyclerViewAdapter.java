package com.example.twocats.ui.detail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.twocats.R;
import com.example.twocats.bean.Content;
import com.example.twocats.bean.HomeData;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ContractResyclerViewAdapter
 * @Author name
 * @Date 2023/1/30
 * @Description
 */
public class ContractRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Content> mdata = new ArrayList<>();
    private Context mcontext;
    private ClicksListener clickListener;
    //普通条目
    private static final int NORMAL = -1;
    //第一条
    private static final int ARTICLE_ONE = 0;
    //最后一条
    private static final int THE_LAST_RECORD = 1;

    public ContractRecyclerViewAdapter(List<Content> data, Context mcontext) {
        this.mdata = data;
        this.mcontext = mcontext;
    }
    public void addData(List<Content> data){

            mdata.addAll(data);
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder=null;
        switch (viewType){
            //普通条目
            case NORMAL:
                View view = LayoutInflater.from(mcontext).inflate(R.layout.contract_item,null);
                viewHolder = new Normal(view);
                break;
            //第一条
            case ARTICLE_ONE:
                View view1 = LayoutInflater.from(mcontext).inflate(R.layout.article_one_item,null);
                viewHolder = new Top(view1);
                break;
            //最后一条
            case THE_LAST_RECORD:
                View view2 = LayoutInflater.from(mcontext).inflate(R.layout.last_item,null);
                viewHolder = new Last(view2);
                break;
            default:
                throw new IllegalStateException("Unexception value"+viewType);

        }

        return viewHolder;
    }
    public void setOnClickListener(ClicksListener clickListener){
        this.clickListener=clickListener;
    }
    public interface ClicksListener{void click(int sture);};
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder=(ViewHolder) holder;
        int type = getItemViewType(position);
        switch (type){
            case NORMAL:
                Normal normal = (Normal) holder;
                binNormal(normal,position);
                break;
            case ARTICLE_ONE:
                Top top = (Top) holder;
                binTop(top,position);
                break;
            case THE_LAST_RECORD:
                Last last = (Last) holder;
                binLast(last,position);
                break;
        }


    }
    private void binNormal(Normal holder,int position) {
        holder.name.setText(mdata.get(position-1).getUser_name());
        holder.text.setText(mdata.get(position-1).getContent());
        Glide.with(mcontext)
                .load(mdata.get(position-1).getUser_head())
                .into(holder.image);
    }
    private void binTop(Top holder,int position) {
        holder.num.setText("共" + mdata.size() + "条评论");


    }
    private void binLast(Last holder,int position) {
        holder.loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               clickListener.click(THE_LAST_RECORD);
            }
        });
    }
    @Override
    public int getItemViewType(int position) {
            if (position == 0){
                return ARTICLE_ONE;
            }
            if (position == getItemCount()-1){
                return THE_LAST_RECORD;
            }
        return NORMAL;
    }

    @Override
    public int getItemCount() {
        if (mdata!=null){
            return mdata.size()+2;
        }
        return 0;
    }
    //正常条目
    class Normal extends ViewHolder {
        private  ImageView image;
        private  TextView name;
        private  TextView text;
        public Normal(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.head);
            name = itemView.findViewById(R.id.name);
            text = itemView.findViewById(R.id.text);
        }
    }
    //第一条
    class Top extends ViewHolder {

        private  TextView num;

        public Top(@NonNull View itemView) {
            super(itemView);
            num = itemView.findViewById(R.id.num);
        }
    }

    //最后一条
    class Last extends ViewHolder {

        private  TextView loading;

        public Last(@NonNull View itemView) {
            super(itemView);
            loading = itemView.findViewById(R.id.loading);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

}
