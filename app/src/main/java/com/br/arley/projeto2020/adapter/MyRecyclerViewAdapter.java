package com.br.arley.projeto2020.adapter;


import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;


import com.br.arley.projeto2020.R;
import com.br.arley.projeto2020.model.Atividade;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    public List<Atividade> atividadeList;
    private OnItemClickListener mListener;


    public interface OnItemClickListener{
        void onSoundPlayClick(int position);
        void onAtividadeClick(int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public MyRecyclerViewAdapter(List<Atividade> atividadeList){
        this.atividadeList = atividadeList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName, tvDescription;
        private ImageButton btnPlay;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            tvName = itemView.findViewById(R.id.item_atividade_tv_nome);
            tvDescription = itemView.findViewById(R.id.item_atividade_tv_descricao);
            btnPlay = itemView.findViewById(R.id.item_atividade_ib_play);

            btnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onSoundPlayClick(position);
                        }
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onAtividadeClick(position);
                        }
                    }
                }
            });

        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_atividade, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mListener);
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(atividadeList.get(position).getNome());
        holder.tvDescription.setText(atividadeList.get(position).getDescricao());
    }

    @Override
    public int getItemCount() {
        return atividadeList.size();
    }


}
