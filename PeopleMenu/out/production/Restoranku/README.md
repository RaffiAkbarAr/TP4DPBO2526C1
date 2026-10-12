# RestaurantData - Java Swing UI Designer

## File
- `Person.java`: model data pegawai.
- `PeopleMenu.java`: logika CRUD dan main program.
- `PeopleMenu.form`: desain form IntelliJ UI Designer.

## Cara menjalankan
1. Ekstrak folder ini ke project Java IntelliJ.
2. Pastikan ketiga file berada di folder source yang sama.
3. Pastikan plugin Swing UI Designer aktif.
4. Buka `PeopleMenu.form` pada IntelliJ, lalu pilih tab Design untuk melihat desain.
5. Jalankan `PeopleMenu.java` melalui ikon Run di samping `main`.

## Field binding form
`mainPanel`, `titleLabel`, `txtId`, `txtNama`, `txtTahunLahir`, `cmbKategori`, `cmbJabatan`, `btnTambah`, `btnUbah`, `btnHapus`, `btnBersihkan`, `tablePegawai`.

## Fitur
Tambah, ubah, hapus dengan konfirmasi, tampilkan data di JTable, validasi input, dan bersihkan form. Data disimpan sementara di ArrayList, belum ke database.
