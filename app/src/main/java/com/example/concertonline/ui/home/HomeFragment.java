package com.example.concertonline.ui.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.concertonline.R;
import com.example.concertonline.adapter.BulanIniAdapter;
import com.example.concertonline.adapter.PopularAdapter;
import com.example.concertonline.api.BaseApiService;
import com.example.concertonline.api.UtilsApi;
import com.example.concertonline.model.Popular;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    ProgressBar pg1, pg2, pg3;
    BaseApiService baseApiService;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    RecyclerView rc_popular, rc_bulanini, rc_mendatang;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.home_fragment, container, false);
        rc_popular = v.findViewById(R.id.vp_popular);
        rc_bulanini = v.findViewById(R.id.vp_bulan);
        rc_mendatang = v.findViewById(R.id.vp_mendatang);

        pg1 = v.findViewById(R.id.pg1);
        pg2 = v.findViewById(R.id.pg2);
        pg3 = v.findViewById(R.id.pg3);

       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
       rc_popular.setLayoutManager(linearLayoutManager);
       rc_popular.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rc_bulanini.setLayoutManager(linearLayoutManager2);
        rc_bulanini.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rc_mendatang.setLayoutManager(linearLayoutManager3);
        rc_mendatang.setHasFixedSize(true);

        baseApiService = UtilsApi.getAPIService();

        baseApiService.HomeRequest().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if(response.isSuccessful()){

                    pg1.setVisibility(View.GONE);
                    pg2.setVisibility(View.GONE);
                    pg3.setVisibility(View.GONE);
//                    Toast.makeText(getContext(), "berhasil" + response.code(), Toast.LENGTH_SHORT).show();
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("populer");
                        ArrayList<Popular> list = new ArrayList<>();
                        for (int i=0; i<jsonArray.length();i++){
                            Popular popular = new Popular();
                            popular.setId(jsonArray.getJSONObject(i).getInt("id"));
                            popular.setId_eo(jsonArray.getJSONObject(i).getInt("id_eo"));
                            popular.setJum_tiket(jsonArray.getJSONObject(i).getInt("jum_tiket"));
                            popular.setFoto(jsonArray.getJSONObject(i).getString("foto"));
                            popular.setJudul(jsonArray.getJSONObject(i).getString("judul"));
                            popular.setWaktu_mulai(jsonArray.getJSONObject(i).getString("waktu_mulai"));
                            popular.setWaktu_selesai(jsonArray.getJSONObject(i).getString("waktu_selesai"));
                            popular.setDesk(jsonArray.getJSONObject(i).getString("desk"));
                            popular.setLink_live_konser(jsonArray.getJSONObject(i).getString("link_live_konser"));
                            popular.setMulai_harga_tiket(jsonArray.getJSONObject(i).getString("mulai_harga_tiket"));
                            popular.setTanggal(jsonArray.getJSONObject(i).getString("tanggal"));
                            popular.setWaktu(jsonArray.getJSONObject(i).getString("waktu"));

                            list.add(popular);
                        }
                        Log.i("list",list.toString());
                        PopularAdapter adapter = new PopularAdapter(getContext(), list);
                        rc_popular.setAdapter(adapter);

                        JSONArray jsonArray2 = jsonObject.getJSONObject("data").getJSONArray("bulanIni");
                        ArrayList<Popular> list2 = new ArrayList<>();
                        for (int i=0; i<jsonArray2.length();i++){
                            Popular popular = new Popular();
                            popular.setId(jsonArray2.getJSONObject(i).getInt("id"));
                            popular.setId_eo(jsonArray2.getJSONObject(i).getInt("id_eo"));
                            popular.setJum_tiket(jsonArray2.getJSONObject(i).getInt("jum_tiket"));
                            popular.setFoto(jsonArray2.getJSONObject(i).getString("foto"));
                            popular.setJudul(jsonArray2.getJSONObject(i).getString("judul"));
                            popular.setWaktu_mulai(jsonArray2.getJSONObject(i).getString("waktu_mulai"));
                            popular.setWaktu_selesai(jsonArray2.getJSONObject(i).getString("waktu_selesai"));
                            popular.setDesk(jsonArray2.getJSONObject(i).getString("desk"));
                            popular.setLink_live_konser(jsonArray2.getJSONObject(i).getString("link_live_konser"));
                            popular.setMulai_harga_tiket(jsonArray2.getJSONObject(i).getString("mulai_harga_tiket"));
                            popular.setTanggal(jsonArray2.getJSONObject(i).getString("tanggal"));
                            popular.setWaktu(jsonArray2.getJSONObject(i).getString("waktu"));

                            list2.add(popular);
                        }
                        Log.i("list",list.toString());
                        BulanIniAdapter adapter2 = new BulanIniAdapter(getContext(), list2);
                        rc_bulanini.setAdapter(adapter2);

                        JSONArray jsonArray3 = jsonObject.getJSONObject("data").getJSONArray("mendatang");
                        ArrayList<Popular> list3 = new ArrayList<>();
                        for (int i=0; i<jsonArray3.length();i++){
                            Popular popular = new Popular();
                            popular.setId(jsonArray3.getJSONObject(i).getInt("id"));
                            popular.setId_eo(jsonArray3.getJSONObject(i).getInt("id_eo"));
                            popular.setJum_tiket(jsonArray3.getJSONObject(i).getInt("jum_tiket"));
                            popular.setFoto(jsonArray3.getJSONObject(i).getString("foto"));
                            popular.setJudul(jsonArray3.getJSONObject(i).getString("judul"));
                            popular.setWaktu_mulai(jsonArray3.getJSONObject(i).getString("waktu_mulai"));
                            popular.setWaktu_selesai(jsonArray3.getJSONObject(i).getString("waktu_selesai"));
                            popular.setDesk(jsonArray3.getJSONObject(i).getString("desk"));
                            popular.setLink_live_konser(jsonArray3.getJSONObject(i).getString("link_live_konser"));
                            popular.setMulai_harga_tiket(jsonArray3.getJSONObject(i).getString("mulai_harga_tiket"));
                            popular.setTanggal(jsonArray3.getJSONObject(i).getString("tanggal"));
                            popular.setWaktu(jsonArray3.getJSONObject(i).getString("waktu"));

                            list3.add(popular);
                        }
                        Log.i("list",list3.toString());
                        BulanIniAdapter adapter3 = new BulanIniAdapter(getContext(), list3);
                        rc_mendatang.setAdapter(adapter2);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else{
                    Toast.makeText(getContext(), "gagal" + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(), "gagal" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
       return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

    }

}
