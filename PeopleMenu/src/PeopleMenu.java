import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class PeopleMenu extends JFrame {
    // Field ini dihubungkan dengan komponen pada PeopleMenu.form
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JTextField txtId;
    private JTextField txtNama;
    private JTextField txtTahunLahir;
    private JComboBox<String> cmbKategori;
    private JComboBox<String> cmbJabatan;
    private JButton btnTambah;
    private JButton btnUbah;
    private JButton btnHapus;
    private JButton btnBersihkan;
    private JTable tablePegawai;

    private final ArrayList<Person> daftarPegawai = new ArrayList<>();
    private DefaultTableModel model;

    public PeopleMenu() {
        setContentPane(mainPanel);
        setTitle("RestaurantData - Data Pegawai Restoran");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 500);
        setLocationRelativeTo(null);

        cmbKategori.setModel(new DefaultComboBoxModel<>(
                new String[]{"Full-time", "Part-time", "Magang"}));
        cmbJabatan.setModel(new DefaultComboBoxModel<>(
                new String[]{"Koki", "Kasir", "Pelayan", "Manajer", "Barista"}));

        model = new DefaultTableModel(
                new Object[]{"ID", "Nama", "Tahun Lahir", "Kategori", "Jabatan"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablePegawai.setModel(model);
        tablePegawai.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        btnTambah.addActionListener(e -> tambahData());
        btnUbah.addActionListener(e -> ubahData());
        btnHapus.addActionListener(e -> hapusData());
        btnBersihkan.addActionListener(e -> bersihkanForm());

        tablePegawai.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tablePegawai.getSelectedRow() >= 0) {
                int row = tablePegawai.convertRowIndexToModel(tablePegawai.getSelectedRow());
                txtId.setText(model.getValueAt(row, 0).toString());
                txtNama.setText(model.getValueAt(row, 1).toString());
                txtTahunLahir.setText(model.getValueAt(row, 2).toString());
                cmbKategori.setSelectedItem(model.getValueAt(row, 3).toString());
                cmbJabatan.setSelectedItem(model.getValueAt(row, 4).toString());
                txtId.setEditable(false);
            }
        });

        tambahContoh();
    }

    private void tambahContoh() {
        // Data awal contoh agar tabel langsung terisi banyak saat aplikasi dibuka.
        daftarPegawai.add(new Person("R001", "Andi Pratama", 1998, "Full-time", "Koki"));
        daftarPegawai.add(new Person("R002", "Sinta Maharani", 2001, "Part-time", "Kasir"));
        daftarPegawai.add(new Person("R003", "Bima Saputra", 2003, "Magang", "Pelayan"));
        daftarPegawai.add(new Person("R004", "Dewi Lestari", 1999, "Full-time", "Manajer"));
        daftarPegawai.add(new Person("R005", "Rizky Ramadhan", 2000, "Full-time", "Barista"));
        daftarPegawai.add(new Person("R006", "Nadia Putri", 2002, "Part-time", "Pelayan"));
        daftarPegawai.add(new Person("R007", "Fajar Nugroho", 1997, "Full-time", "Koki"));
        daftarPegawai.add(new Person("R008", "Intan Permata", 2001, "Magang", "Kasir"));
        daftarPegawai.add(new Person("R009", "Dimas Firmansyah", 1999, "Part-time", "Barista"));
        daftarPegawai.add(new Person("R010", "Aulia Rahma", 2000, "Full-time", "Pelayan"));
        daftarPegawai.add(new Person("R011", "Yoga Kurniawan", 1996, "Full-time", "Manajer"));
        daftarPegawai.add(new Person("R012", "Maya Anggraini", 2002, "Magang", "Barista"));
        daftarPegawai.add(new Person("R013", "Arif Setiawan", 1998, "Part-time", "Koki"));
        daftarPegawai.add(new Person("R014", "Putri Amelia", 2003, "Magang", "Kasir"));
        daftarPegawai.add(new Person("R015", "Rafi Hidayat", 2001, "Full-time", "Pelayan"));
        daftarPegawai.add(new Person("R016", "Citra Wulandari", 1997, "Part-time", "Manajer"));
        daftarPegawai.add(new Person("R017", "Bagas Maulana", 2000, "Full-time", "Barista"));
        daftarPegawai.add(new Person("R018", "Laila Safitri", 1999, "Magang", "Pelayan"));
        daftarPegawai.add(new Person("R019", "Kevin Wijaya", 2002, "Part-time", "Kasir"));
        daftarPegawai.add(new Person("R020", "Nisa Oktaviani", 1998, "Full-time", "Koki"));
        tampilkanData();
    }

    private boolean validasi() {
        if (txtId.getText().trim().isEmpty()
                || txtNama.getText().trim().isEmpty()
                || txtTahunLahir.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID, nama, dan tahun lahir wajib diisi.");
            return false;
        }
        try {
            int tahun = Integer.parseInt(txtTahunLahir.getText().trim());
            if (tahun < 1900 || tahun > java.time.Year.now().getValue()) {
                JOptionPane.showMessageDialog(this, "Tahun lahir tidak valid.");
                return false;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Tahun lahir harus berupa angka.");
            return false;
        }
        return true;
    }

    private Person ambilForm() {
        return new Person(txtId.getText().trim(), txtNama.getText().trim(),
                Integer.parseInt(txtTahunLahir.getText().trim()),
                String.valueOf(cmbKategori.getSelectedItem()),
                String.valueOf(cmbJabatan.getSelectedItem()));
    }

    private void tambahData() {
        if (!validasi()) return;
        String id = txtId.getText().trim();
        for (Person p : daftarPegawai) {
            if (p.getId().equalsIgnoreCase(id)) {
                JOptionPane.showMessageDialog(this, "ID pegawai sudah digunakan.");
                return;
            }
        }
        daftarPegawai.add(ambilForm());
        tampilkanData();
        bersihkanForm();
    }

    private void ubahData() {
        int row = tablePegawai.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih data pada tabel yang ingin diubah.");
            return;
        }
        if (!validasi()) return;
        int modelRow = tablePegawai.convertRowIndexToModel(row);
        daftarPegawai.set(modelRow, ambilForm());
        tampilkanData();
        bersihkanForm();
    }

    private void hapusData() {
        int row = tablePegawai.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih data pada tabel yang ingin dihapus.");
            return;
        }
        int jawaban = JOptionPane.showConfirmDialog(this,
                "Yakin ingin menghapus data pegawai ini?",
                "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (jawaban == JOptionPane.YES_OPTION) {
            daftarPegawai.remove(tablePegawai.convertRowIndexToModel(row));
            tampilkanData();
            bersihkanForm();
        }
    }

    private void tampilkanData() {
        model.setRowCount(0);
        for (Person p : daftarPegawai) {
            model.addRow(new Object[]{p.getId(), p.getNama(), p.getTahunLahir(),
                    p.getKategori(), p.getJabatan()});
        }
    }

    private void bersihkanForm() {
        txtId.setText("");
        txtNama.setText("");
        txtTahunLahir.setText("");
        cmbKategori.setSelectedIndex(0);
        cmbJabatan.setSelectedIndex(0);
        txtId.setEditable(true);
        tablePegawai.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PeopleMenu().setVisible(true));
    }
}
