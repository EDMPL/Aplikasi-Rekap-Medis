package com.example.akaed.aplikasipuskesmas.model;

/**
 * Created by USER on 8/30/2018.
 */

public class Keluarga {
    String namaKepalaKeluarga;
    String alamat;

    public String getNamaKepalaKeluarga() {
        return namaKepalaKeluarga;
    }

    public void setNamaKepalaKeluarga(String namaKepalaKeluarga) {
        this.namaKepalaKeluarga = namaKepalaKeluarga;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Keluarga(String namaKepalaKeluarga, String alamat) {
        this.namaKepalaKeluarga = namaKepalaKeluarga;
        this.alamat = alamat;
    }
}
