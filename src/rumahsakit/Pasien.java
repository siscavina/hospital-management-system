package rumahsakit;

public class Pasien extends Person {
    private String jenisKelamin;
    private String alamat;

    public Pasien(String id, String nama, int umur, String jenisKelamin, String alamat) {
        super(id, nama, umur); // Memanggil konstruktor kelas induk
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
    }

    // Getter dan Setter untuk jenisKelamin
    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    // Getter dan Setter untuk alamat
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}