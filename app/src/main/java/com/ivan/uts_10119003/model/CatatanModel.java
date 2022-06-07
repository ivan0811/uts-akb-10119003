package com.ivan.uts_10119003.model;

public class CatatanModel {
    private String id, judul, kategori, konten, created_at;

    public CatatanModel(String id, String judul, String kategori, String konten, String created_at) {
        this.id = id;
        this.judul = judul;
        this.kategori = kategori;
        this.konten = konten;
        this.created_at = created_at;
    }

    public String getId() { return id; }

    public String getJudul() {
        return judul;
    }

    public String getKategori() {
        return kategori;
    }

    public String getKonten() {
        return konten;
    }

    public String getCreated_at() {
        return created_at;
    }
}
