package com.example.policemodule.police;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.policemodule.PoliceAdapter;
import com.example.policemodule.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Police_fragment extends Fragment
{

    @BindView(R.id.police_frag_rv)
    RecyclerView recyclerView;

    ArrayList<Police_Info> infos;

    RecyclerView.LayoutManager layoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parent=inflater.inflate(R.layout.police_fragment,container,false);
        ButterKnife.bind(this,parent);
        infos=new ArrayList<>();
        infos.add(new Police_Info(R.drawable.ic_launcher_background,"nrgjnf","jgnjrn","njgnjrg","jgrjgnfh0"));
        infos.add(new Police_Info(R.drawable.ic_launcher_background,"gjntth","jgnjnh","gkrnjrn","ngjnj"));
        infos.add(new Police_Info(R.drawable.ic_launcher_background,"gjntth","jgnjnh","gkrnjrn","ngjnj"));
        infos.add(new Police_Info(R.drawable.ic_launcher_background,"gjntth","jgnjnh","gkrnjrn","ngjnj"));
        infos.add(new Police_Info(R.drawable.ic_launcher_background,"nrgjnf","jgnjrn","njgnjrg","jgrjgnfh0"));
        infos.add(new Police_Info(R.drawable.ic_launcher_background,"gjntth","jgnjnh","gkrnjrn","ngjnj"));
        infos.add(new Police_Info(R.drawable.ic_launcher_background,"gjntth","jgnjnh","gkrnjrn","ngjnj"));
        infos.add(new Police_Info(R.drawable.ic_launcher_background,"gjntth","jgnjnh","gkrnjrn","ngjnj"));


        initrecycleadapter(getContext());
        return  parent;
    }

    private void initrecycleadapter(Context context)
    {
        layoutManager = new LinearLayoutManager(getActivity());
        PoliceAdapter policeAdapter=new PoliceAdapter(getActivity(),infos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(policeAdapter);
    }

}
