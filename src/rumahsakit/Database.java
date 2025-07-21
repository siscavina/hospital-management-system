
package rumahsakit;
    
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private Connection connection;

    // Constructor untuk koneksi ke database
    public Database() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rumahsakit", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metode untuk menambahkan pasien
    public void addPasien(Pasien pasien) {
        String query = "INSERT INTO pasien (id, nama, umur, jenisKelamin, alamat) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, pasien.getId());
            statement.setString(2, pasien.getNama());
            statement.setInt(3, pasien.getUmur());
            statement.setString(4, pasien.getJenisKelamin());
            statement.setString(5, pasien.getAlamat());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metode untuk mendapatkan semua pasien
    public List<Pasien> getAllPasien() {
        List<Pasien> pasienList = new ArrayList<>();
        String query = "SELECT * FROM pasien";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Pasien pasien = new Pasien(
                    resultSet.getString("id"),
                    resultSet.getString("nama"),
                    resultSet.getInt("umur"),
                    resultSet.getString("jenisKelamin"),
                    resultSet.getString("alamat")
                );
                pasienList.add(pasien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pasienList;
    }

    // Metode untuk memperbarui pasien
    public void updatePasien(Pasien pasien) {
        String query = "UPDATE pasien SET nama=?, umur=?, jenisKelamin=?, alamat=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, pasien.getNama());
            statement.setInt(2, pasien.getUmur());
            statement.setString(3, pasien.getJenisKelamin());
            statement.setString(4, pasien.getAlamat());
            statement.setString(5, pasien.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metode untuk menghapus pasien
    public void deletePasien(String id) {
        String query = "DELETE FROM pasien WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metode untuk menambahkan dokter
    public void addDokter(Dokter dokter) {
        String query = "INSERT INTO dokter (id, nama, umur, spesialis) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dokter.getId());
            statement.setString(2, dokter.getNama());
            statement.setInt(3, dokter.getUmur());
            statement.setString(4, dokter.getSpesialis());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metode untuk mendapatkan semua dokter
    public List<Dokter> getAllDokter() {
        List<Dokter> dokterList = new ArrayList<>();
        String query = "SELECT * FROM dokter";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Dokter dokter = new Dokter(
                    resultSet.getString("id"),
                    resultSet.getString("nama"),
                    resultSet.getInt("umur"),
                    resultSet.getString("spesialis")
                );
                dokterList.add(dokter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dokterList;
    }

    // Metode untuk memperbarui dokter
    public void updateDokter(Dokter dokter) {
        String query = "UPDATE dokter SET nama=?, umur=?, spesialis=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dokter.getNama());
            statement.setInt(2, dokter.getUmur());
            statement.setString(3, dokter.getSpesialis());
            statement.setString(4, dokter.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metode untuk menghapus dokter
    public void deleteDokter(String id) {
        String query = "DELETE FROM dokter WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metode untuk menutup koneksi database
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
