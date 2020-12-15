package com.example.yuekao6.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yuekao6.Ben.StudentBen;
import com.example.yuekao6.R;

import java.util.ArrayList;

class StuAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<StudentBen.StudenlistBean> stuList;

    public StuAdapter(Context context, ArrayList<StudentBen.StudenlistBean> stuList) {
        this.context = context;
        this.stuList = stuList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.stu_item, parent, false);
        return new StuViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        StudentBen.StudenlistBean bean = stuList.get(position);
        StuViewHolder stuViewHolder= (StuViewHolder) holder;
        stuViewHolder.name.setText(bean.getName());
        stuViewHolder.skill.setText(bean.getSkill()+"");
        stuViewHolder.theroy.setText(bean.getTheory()+"");
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(onItemLongClickListener!=null){
                    onItemLongClickListener.OnItemLongClick(position);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return stuList.size();
    }

    private class StuViewHolder extends RecyclerView.ViewHolder {
        TextView skill;
        TextView name;
        TextView theroy;
        public StuViewHolder(View root) {
            super(root);
            skill=root.findViewById(R.id.skill);
            name=root.findViewById(R.id.name);
            theroy=root.findViewById(R.id.theroy);
        }
    }

    public interface OnItemLongClickListener{
        void OnItemLongClick(int pos);
    }

    OnItemLongClickListener onItemLongClickListener;

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
}
