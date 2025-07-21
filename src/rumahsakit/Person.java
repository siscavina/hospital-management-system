package rumahsakit;

public class Person {
    private String id;
    private String nama;
    private int umur;

    public Person(String id, String nama, int umur) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
    }

    // Getter dan Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }
}