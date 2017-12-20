package com.aplusd.school_1329_extra_classes_catalogue.classeslist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Azamat Dzhonov
 * @date 20.12.2017
 */

public class ExtraClassAdapter extends RecyclerView.Adapter<ExtraClassAdapter.ViewHolderExtraClass> {

    @Override
    public ViewHolderExtraClass onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolderExtraClass holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public ExtraClassAdapter()
    {

    }

   static class ViewHolderExtraClass extends RecyclerView.ViewHolder
    {
        public ViewHolderExtraClass(View view)
        {
            super(view);
        }

    }

}
