package rumahsakit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class PasienPanel extends JPanel {
    private JTextField idField;
    private JTextField namaField;
    private JTextField umurField;
    private JTextField alamatField;
    private JComboBox<String> jenisKelaminCombo;
    private JTable pasienTable;
    private DefaultTableModel tableModel;

    public PasienPanel() {
        setLayout(new BorderLayout());

        // Judul
        JLabel titleLabel = new JLabel("Manajemen Pasien", SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Panel untuk input data pasien
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField(5);
        inputPanel.add(idField);
        
        inputPanel.add(new JLabel("Nama:"));
        namaField = new JTextField(15);
        inputPanel.add(namaField);
        
        inputPanel.add(new JLabel("Umur:"));
        umurField = new JTextField(3);
        inputPanel.add(umurField);
        
        inputPanel.add(new JLabel("Jenis Kelamin:"));
        jenisKelaminCombo = new JComboBox<>(new String[]{"Laki-laki", "Perempuan"});
        inputPanel.add(jenisKelaminCombo);
        
        inputPanel.add(new JLabel("Alamat:"));
        alamatField = new JTextField(15);
        inputPanel.add(alamatField);
        
        JButton addButton = new JButton("Tambah Pasien");
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.CENTER);

        // Tabel Pasien
        String[] columnNames = {"ID", "Nama", "Umur", "Jenis Kelamin", "Alamat"};
        tableModel = new DefaultTableModel(columnNames, 0);
        pasienTable = new JTable(tableModel);
        add(new JScrollPane(pasienTable), BorderLayout.SOUTH);

        // Action listener untuk tombol tambah pasien
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String nama = namaField.getText();
                String umur = umurField.getText();
                String jenisKelamin = (String) jenisKelaminCombo.getSelectedItem();
                String alamat = alamatField.getText();
                
                // Validasi input
                if (id.isEmpty() || nama.isEmpty() || umur.isEmpty() || alamat.isEmpty()) {
                    JOptionPane.showMessageDialog(PasienPanel.this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Tambahkan data ke tabel
                Object[] rowData = {id, nama, umur, jenisKelamin, alamat};
                tableModel.addRow(rowData);

                // Kosongkan field input
                idField.setText("");
                namaField.setText("");
                umurField.setText("");
                alamatField.setText("");
            }
        });
    }
}