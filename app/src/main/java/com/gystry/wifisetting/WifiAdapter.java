package com.gystry.wifisetting;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WifiAdapter extends RecyclerView.Adapter {
    private Context context;
    private LayoutInflater mInflater;
    private List<String> mList;

    public WifiAdapter(Context context, List<String> mList) {
        this.context = context;
        this.mList = mList;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = mInflater.inflate(R.layout.item_wifi, viewGroup, false);
        return new WifiViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof WifiViewHolder) {
            ((WifiViewHolder) viewHolder).bindView(mList.get(i), i);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class WifiViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvName;
        private final TextView tvLock;
        private final TextView tvMessage;
        private final TextView tvSignal;

        public WifiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = ((TextView) itemView.findViewById(R.id.tv_name));
            tvLock = ((TextView) itemView.findViewById(R.id.tv_lock));
            tvMessage = ((TextView) itemView.findViewById(R.id.tv_message));
            tvSignal = ((TextView) itemView.findViewById(R.id.tv_signal));
        }

        public void bindView(String s, int i) {

        }
    }
}
