package rumahsakit;

public class Dokter extends Person {
    private String spesialis;

    public Dokter(String id, String nama, int umur, String spesialis) {
        super(id, nama, umur); // Memanggil konstruktor kelas induk
        this.spesialis = spesialis;
    }

    // Getter dan Setter untuk spesialis
    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }
}