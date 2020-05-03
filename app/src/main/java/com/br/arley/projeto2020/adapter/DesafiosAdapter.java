package com.br.arley.projeto2020.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.br.arley.projeto2020.R;
import com.br.arley.projeto2020.model.Desafio;

public class DesafiosAdapter extends BaseAdapter {

    List<Desafio> desafioList;
    Context context;

    public DesafiosAdapter(List<Desafio> desafioList, Context context) {
        this.desafioList = desafioList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return desafioList.size();
    }

    @Override
    public Object getItem(int position) {
        return desafioList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.itens_atividade, parent, false);

        TextView tvNome = view.findViewById(R.id.item_atividade_tv_nome);
        TextView tvDescricao = view.findViewById(R.id.item_atividade_tv_descricao);
        ImageView ivDesafio = view.findViewById(R.id.item_atividade_iv_image);
        ImageButton ibPlay = view.findViewById(R.id.item_atividade_ib_play);


        return view;
    }
}
