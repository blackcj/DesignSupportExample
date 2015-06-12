package com.blackcj.designsupportexample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blackcj.designsupportexample.R;

/**
 * Created by chris.black on 6/11/15.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements View.OnClickListener {

    private OnItemClickListener mItemClickListener;
    private int mPage;

    public RecyclerViewAdapter(int pageNum) {
        super();
        this.mPage = pageNum;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public void onClick(final View v) {
        if (mItemClickListener != null) {
            mItemClickListener.onItemClick(v);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText("Test " + mPage);
    }
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public FrameLayout container;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
            container = (FrameLayout) itemView.findViewById(R.id.container);
        }
    }

    public interface OnItemClickListener {

        void onItemClick(View view);

    }
}
