package com.tania2.diaryfragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KumpulanAdapter extends RecyclerView.Adapter<KumpulanAdapter.VH> {
    private final Context ctx;
    private final List<Catatan> kumpulan;

    public KumpulanAdapter(Context ctx, List<Catatan> kumpulan) {
        this.ctx = ctx;
        this.kumpulan = kumpulan;
    }

    public static class VH extends RecyclerView.ViewHolder {
        private final TextView tvTitle;
        private final TextView tvKonten;
        private final TextView tvDate;
        private final TextView tvTime;

        public VH(@NonNull View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tvTitle);
            this.tvKonten = itemView.findViewById(R.id.tvKonten);
            this.tvDate = itemView.findViewById(R.id.tvDate);
            this.tvTime = itemView.findViewById(R.id.tvTime);
        }

        public void setCatatan(Catatan c) {
            this.tvTitle.setText(c.getTitle());
            this.tvKonten.setText(c.getKonten());
            this.tvDate.setText(c.getDate());
            this.tvTime.setText(c.getTime());
        }
        public void setKontenClickListener(final Catatan catatan, final KumpulanAdapter adapter) {
            this.tvKonten.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toggle maxLines to show the full content
                    if (tvKonten.getMaxLines() == 1) {
                        tvKonten.setMaxLines(Integer.MAX_VALUE);  // Expand content
                    } else {
                        tvKonten.setMaxLines(1);  // Collapse content to 1 line
                    }
                    // Notify the adapter to refresh this item
                    adapter.notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_catatan, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Catatan c = this.kumpulan.get(position);
        holder.setCatatan(c);
    }

    @Override
    public int getItemCount() {
        return kumpulan.size(); // Mengembalikan jumlah item dalam ArrayList
    }
}
