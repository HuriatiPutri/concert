package com.example.concertonline.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Popular implements Parcelable {
    private float id;
    private float id_eo;
    private float jum_tiket;
    private String foto;
    private String judul;
    private String waktu_mulai;
    private String waktu_selesai;
    private String desk;
    private String link_live_konser;
    private String created_at;
    private String updated_at;
    private String mulai_harga_tiket;
    private String tanggal;
    private String waktu;


    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public float getId_eo() {
        return id_eo;
    }

    public void setId_eo(float id_eo) {
        this.id_eo = id_eo;
    }

    public float getJum_tiket() {
        return jum_tiket;
    }

    public void setJum_tiket(float jum_tiket) {
        this.jum_tiket = jum_tiket;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getWaktu_mulai() {
        return waktu_mulai;
    }

    public void setWaktu_mulai(String waktu_mulai) {
        this.waktu_mulai = waktu_mulai;
    }

    public String getWaktu_selesai() {
        return waktu_selesai;
    }

    public void setWaktu_selesai(String waktu_selesai) {
        this.waktu_selesai = waktu_selesai;
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public String getLink_live_konser() {
        return link_live_konser;
    }

    public void setLink_live_konser(String link_live_konser) {
        this.link_live_konser = link_live_konser;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getMulai_harga_tiket() {
        return mulai_harga_tiket;
    }

    public void setMulai_harga_tiket(String mulai_harga_tiket) {
        this.mulai_harga_tiket = mulai_harga_tiket;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(id);
        dest.writeFloat(id_eo);
        dest.writeFloat(jum_tiket);
        dest.writeString(foto);
        dest.writeString(judul);
        dest.writeString(waktu_mulai);
        dest.writeString(waktu_selesai);
        dest.writeString(desk);
        dest.writeString(link_live_konser);
        dest.writeString(mulai_harga_tiket);
        dest.writeString(tanggal);
        dest.writeString(waktu);
    }
}
