package com.example.twocats.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.twocats.R;
import com.example.twocats.bean.HomeData;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ExploreResyclerViewAdapter
 * @Author name
 * @Date 2023/1/9
 * @Description
 */
public class ExploreResyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<HomeData> mdata = new ArrayList<>();
    final private static int PULL_DOWN = 1;
    final private static int PULL_UP = 2;

    final private static int LAST = 0;
    final private static int NORMAL = -1;
    private ClickInterface clickInterface;
    public ExploreResyclerViewAdapter(Context context, List<HomeData> data) {
        this.context = context;
        this.mdata = data;
    }
    public ExploreResyclerViewAdapter() {
    }
    public void addData(List<HomeData> data,int state){
        if (state==PULL_DOWN){
            mdata.addAll(data);
        }else{
           mdata.addAll(0,data);
        }
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder = null;
        switch(viewType){
            case NORMAL:
                View view = LayoutInflater.from(context).inflate(R.layout.explore_item,null);
                viewHolder = new Normal(view);
                break;
            case LAST:
                View view1 = LayoutInflater.from(context).inflate(R.layout.last_loading_item,null);
                viewHolder = new Last(view1);
                break;
        }

        return viewHolder;
    }
    public void setOnclick(ClickInterface clickInterface) {
        this.clickInterface = clickInterface;
    }

    public interface ClickInterface {
        void onImageClick(View view, int id,String name,String head,String title);
        void onHeadClick(View view, int user_id);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case NORMAL:
                Normal normal = (Normal) holder;
                BinNormal(normal,position);
                break;
            case LAST:
                Last last = (Last) holder;

                break;
        }


    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            int position = holder.getLayoutPosition();
            if (getItemViewType(position) == LAST) {
                params.setFullSpan(true);
            }
        }
    }

    private void BinNormal(Normal holder, int position){
        Glide.with(context)
                .load(mdata.get(position).getCover())
                .into(holder.imageView);
        holder.title.setText(mdata.get(position).getText());
        Glide.with(context)
                .load(mdata.get(position).getUser_head())
                .into(holder.user_head);
        holder.user_name.setText(mdata.get(position).getUser_name());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickInterface != null) {
                    clickInterface.onImageClick(v,mdata.get(position).getId(),
                            mdata.get(position).getUser_name(),
                            mdata.get(position).getUser_head(),
                            mdata.get(position).getText());
                }
            }
        });
        holder.user_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickInterface.onHeadClick(v,mdata.get(position).getUser_id());
            }
        });
    }
    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount()-1 ){
            return LAST;
        }
        return NORMAL;
    }

    @Override
    public int getItemCount() {
        return mdata.size()+1;
    }

    class Normal extends ViewHolder {
        ImageView imageView;
        TextView title;
        ImageView user_head;
        TextView user_name;
        public Normal(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            user_head = itemView.findViewById(R.id.uesr_head);
            user_name = itemView.findViewById(R.id.user_name);
        }
    }
    class Last extends ViewHolder {
        public Last(@NonNull View itemView) {
            super(itemView);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
