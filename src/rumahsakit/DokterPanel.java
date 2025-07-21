package rumahsakit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class DokterPanel extends JPanel {
    private JTextField idField;
    private JTextField namaField;
    private JTextField umurField;
    private JTextField spesialisField;
    private JTable dokterTable;
    private DefaultTableModel tableModel;

    public DokterPanel() {
        setLayout(new BorderLayout());

        // Judul
        JLabel titleLabel = new JLabel("Manajemen Dokter", SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Panel untuk input data dokter
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
        
                inputPanel.add(new JLabel("Spesialis:"));
        spesialisField = new JTextField(15);
        inputPanel.add(spesialisField);
        
        JButton addButton = new JButton("Tambah Dokter");
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.CENTER);

        // Tabel Dokter
        String[] columnNames = {"ID", "Nama", "Umur", "Spesialis"};
        tableModel = new DefaultTableModel(columnNames, 0);
        dokterTable = new JTable(tableModel);
        add(new JScrollPane(dokterTable), BorderLayout.SOUTH);

        // Action listener untuk tombol tambah dokter
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String nama = namaField.getText();
                String umur = umurField.getText();
                String spesialis = spesialisField.getText();
                
                // Validasi input
                if (id.isEmpty() || nama.isEmpty() || umur.isEmpty() || spesialis.isEmpty()) {
                    JOptionPane.showMessageDialog(DokterPanel.this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Tambahkan data ke tabel
                Object[] rowData = {id, nama, umur, spesialis};
                tableModel.addRow(rowData);

                // Kosongkan field input
                idField.setText("");
                namaField.setText("");
                umurField.setText("");
                spesialisField.setText("");
            }
        });
    }
}