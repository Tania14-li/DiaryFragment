package com.tania2.diaryfragment;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Catatan implements Serializable {
    public String title;
    public String konten;
    public String tanggal;
    public String waktu;

    // Constructor
    public Catatan(String title, String konten) {
        this.title = title;
        this.konten = konten;

        // Tanggal dan jam otomatis dari sistem
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        this.tanggal = dateFormat.format(new Date());
        this.waktu = timeFormat.format(new Date());
    }

    // Getter dan Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = title;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public String getDate() {
        return tanggal;
    }
    public String getTime() {
        return waktu;
    }
}
