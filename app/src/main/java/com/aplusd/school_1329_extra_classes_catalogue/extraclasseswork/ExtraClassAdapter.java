package com.aplusd.school_1329_extra_classes_catalogue.extraclasseswork;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aplusd.school_1329_extra_classes_catalogue.R;
import com.aplusd.school_1329_extra_classes_catalogue.model.ExtraClass;
import com.aplusd.school_1329_extra_classes_catalogue.viewmodels.Config;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * @author Azamat Dzhonov
 * @date 20.12.2017
 */

public class ExtraClassAdapter extends RecyclerView.Adapter<ExtraClassAdapter.ViewHolderExtraClass> {

    private ArrayList<ExtraClass> extraClasses = new ArrayList<ExtraClass>();
    private Context context = null;

    public ExtraClassAdapter(Context context) {
        this.context = context;
    }

    public void setCourses(ArrayList<ExtraClass> extraClassArrayList)
    {
        extraClasses = extraClassArrayList;
        notifyDataSetChanged();
    }

    public ArrayList<ExtraClass> searchClass (String str)
    {
        str = str.toLowerCase();
        ArrayList<ExtraClass> result = new ArrayList<>();
        for(ExtraClass i : extraClasses)
            if(i.getName().toLowerCase().contains(str))
                result.add(i);
        return result;
    }

    @Override
    public ViewHolderExtraClass onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderExtraClass
                (LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_additional_class, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolderExtraClass holder, final int position) {

        holder.tvTypeLabel.setText(Config.FIELD_ACTIVITY_TYPE);
        holder.tvAgeLabel.setText(Config.FIELD_AUDITORE_AGE);
        holder.tvNameLabel.setText(Config.FIELD_NAME);

        holder.tvName.setText(extraClasses.get(position).getName());
        holder.tvAge.setText(extraClasses.get(position).getAuditoreAge());
        holder.tvType.setText(extraClasses.get(position).getActivityType());


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ExtraClassDetailActivity.class);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(Config.INTENT_EXTRACOURSE, extraClasses.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return extraClasses.size();
    }


   static class ViewHolderExtraClass extends RecyclerView.ViewHolder
    {
        private View view = null;

        private TextView tvNameLabel = null;
        private TextView tvAgeLabel = null;
        private TextView tvTypeLabel = null;

        private TextView tvName = null;
        private TextView tvType = null;
        private TextView tvAge = null;

        public ViewHolderExtraClass(View view)
        {
            super(view);
            this.view = view;
            this.tvName = view.findViewById(R.id.tvName);
            this.tvType = view.findViewById(R.id.tvType);
            this.tvAge = view.findViewById(R.id.tvAge);

            this.tvNameLabel = view.findViewById(R.id.tvNameLabel);
            this.tvAgeLabel = view.findViewById(R.id.tvAgeLabel);
            this.tvTypeLabel = view.findViewById(R.id.tvTypeLabel);

        }

    }

}
