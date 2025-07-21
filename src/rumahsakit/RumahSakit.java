package rumahsakit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RumahSakit {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hospital Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);

            // TabbedPane untuk manajemen pasien dan dokter
            JTabbedPane tabbedPane = new JTabbedPane();

            // Menambahkan panel manajemen pasien
            PasienPanel pasienPanel = new PasienPanel();
            tabbedPane.addTab("Manajemen Pasien", pasienPanel);

            // Menambahkan panel manajemen dokter
            DokterPanel dokterPanel = new DokterPanel();
            tabbedPane.addTab("Manajemen Dokter", dokterPanel);

            // Menambahkan tabbedPane ke frame
            frame.add(tabbedPane);

            // Menampilkan frame
            frame.setVisible(true);
        });
    }
}