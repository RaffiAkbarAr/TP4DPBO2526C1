# TP4DPBO2526C1

# Janji

Saya Raffi Akbar Ardiansyah dengan NIM 2511604 mengerjakan Tugas Praktikum 4 pada Mata Kuliah Desain dan Pemrograman Berorientasi Objek (DPBO) untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Struktur File

```
C:.
├───Dokumentasi
│       Error.png
│       Hapus Data.png
│       Tambah Data.png
│       Tampilan Sesudah Di hapus.png
│       Tampilan sesudah di update.png
│       Tampilan sesudah ditambah.png
│       Update Data.png
│
└───PeopleMenu
    ├───out
    │   └───production
    │       └───Restoranku
    │           │   PeopleMenu$1.class
    │           │   PeopleMenu.class
    │           │   Person.class
    │           │   README.md
    │           │
    │           └───com
    │               └───intellij
    │                   └───uiDesigner
    │                       └───core
    │                               AbstractLayout.class
    │                               DimensionInfo.class
    │                               GridConstraints.class
    │                               GridLayoutManager.class
    │                               HorizontalInfo.class
    │                               LayoutState.class
    │                               Spacer.class
    │                               SupportCode$TextWithMnemonic.class
    │                               SupportCode.class
    │                               Util.class
    │                               VerticalInfo.class
    │
    └───src
            PeopleMenu.form
            PeopleMenu.java
            Person.java

```

## Fungsi Program

Program RestaurantData dibuat untuk mengelola data pegawai restoran. Program ini menggunakan bahasa pemrograman Java dengan antarmuka grafis (GUI) menggunakan Java Swing dan desain form menggunakan IntelliJ UI Designer.

Program ini memiliki fitur untuk menambahkan, menampilkan, mengubah, dan menghapus data pegawai. Data yang dikelola meliputi ID, nama, tahun lahir, kategori pegawai, dan jabatan.

## 1. Desain Class Person

Class Person digunakan untuk merepresentasikan data pegawai restoran. Class ini memiliki lima atribut yang seluruhnya menggunakan access modifier private, yaitu:

id (String): menyimpan ID pegawai.

nama (String): menyimpan nama pegawai.

tahunLahir (int): menyimpan tahun lahir pegawai.

kategori (String): menyimpan kategori pegawai.

jabatan (String): menyimpan jabatan pegawai.

Class Person memiliki constructor untuk menginisialisasi nilai atribut ketika objek dibuat. Selain itu, terdapat method getter untuk mengambil nilai setiap atribut, yaitu getId(), getNama(), getTahunLahir(), getKategori(), dan getJabatan().

Dengan menggunakan class Person, setiap pegawai direpresentasikan sebagai objek yang dapat dikelola oleh program.

## 2. Desain Class PeopleMenu

Class PeopleMenu merupakan class utama yang mengatur tampilan antarmuka dan logika program. Class ini menggunakan JFrame sebagai jendela utama aplikasi.

Komponen yang digunakan dalam program meliputi:

JPanel (mainPanel): panel utama aplikasi.

JLabel (titleLabel): menampilkan judul aplikasi.

JTextField (txtId, txtNama, txtTahunLahir): menerima input ID, nama, dan tahun lahir.

JComboBox (cmbKategori): memilih kategori pegawai.

JComboBox (cmbJabatan): memilih jabatan pegawai.

JButton (btnTambah, btnUbah, btnHapus, btnBersihkan): menjalankan operasi tambah, ubah, hapus, dan bersihkan.

JTable (tablePegawai): menampilkan daftar data pegawai.

Pilihan kategori pegawai terdiri dari Full-time, Part-time, dan Magang. Sementara itu, pilihan jabatan terdiri dari Koki, Kasir, Pelayan, Manajer, dan Barista.

Untuk menyimpan data selama aplikasi berjalan, program menggunakan ArrayList<Person> dengan nama daftarPegawai. Data tersebut ditampilkan dalam tabel menggunakan DefaultTableModel.

Ketika aplikasi dijalankan, program langsung menampilkan 20 data pegawai contoh.

## 3. Fitur Program

a. Tambah Data

Pengguna dapat menambahkan pegawai dengan mengisi ID, nama, tahun lahir, kategori, dan jabatan. Ketika tombol tambah ditekan, program memeriksa kelengkapan input dan validitas tahun lahir.

Program juga memeriksa apakah ID sudah digunakan oleh pegawai lain. Jika seluruh pemeriksaan berhasil, data baru ditambahkan ke ArrayList dan ditampilkan pada tabel.

Setelah proses selesai, form akan dikosongkan kembali.

b. Menampilkan Data

Data pegawai ditampilkan menggunakan JTable dengan lima kolom:

ID

Nama

Tahun Lahir

Kategori

Jabatan

Tabel diatur agar sel tidak dapat diedit secara langsung. Pengguna dapat memilih satu baris untuk melihat data pada form atau melakukan perubahan dan penghapusan.

c. Mengubah Data

Pengguna memilih baris pegawai pada tabel. Setelah baris dipilih, data pegawai akan dimasukkan secara otomatis ke dalam form.

Kolom ID dibuat tidak dapat diedit ketika data dipilih. Pengguna dapat mengubah nama, tahun lahir, kategori, atau jabatan, kemudian menekan tombol ubah.

Program akan memvalidasi input sebelum memperbarui data pada ArrayList. Setelah berhasil, tabel diperbarui dan form dikosongkan kembali.

d. Menghapus Data

Pengguna memilih data pegawai yang ingin dihapus, kemudian menekan tombol hapus.

Program menampilkan dialog konfirmasi dengan pesan "Yakin ingin menghapus data pegawai ini?". Jika pengguna memilih Yes, data akan dihapus dari ArrayList dan tabel diperbarui.

Jika pengguna memilih No, proses penghapusan dibatalkan.

e. Membersihkan Form

Tombol bersihkan digunakan untuk mengosongkan kolom ID, nama, dan tahun lahir. Pilihan kategori dan jabatan dikembalikan ke pilihan pertama.

Selain itu, tombol ini mengaktifkan kembali kolom ID dan menghilangkan pilihan baris pada tabel.

f. Validasi Input

Program menggunakan method validasi() untuk memeriksa kelengkapan input dan memastikan tahun lahir berupa angka dalam rentang 1900 hingga tahun berjalan.

Jika kolom wajib belum diisi atau tahun lahir tidak valid, program akan menampilkan pesan kesalahan. Program juga menolak ID yang sudah digunakan saat penambahan data.

## 4. Alur Program (Flow Kode)

Alur program dimulai dari method main() pada class PeopleMenu. Program menggunakan SwingUtilities.invokeLater() untuk menampilkan jendela aplikasi.

Setelah jendela dibuat, program mengatur pilihan kategori dan jabatan, menginisialisasi tabel, memasang event listener pada tombol dan tabel, serta menambahkan 20 data pegawai contoh.

Selanjutnya, pengguna dapat melakukan operasi berikut:

Tambah: pengguna mengisi form, kemudian menekan tombol tambah. Program memvalidasi data dan memeriksa duplikasi ID sebelum menyimpan data baru.

Ubah: pengguna memilih data pada tabel. Form terisi otomatis, kemudian pengguna memperbarui informasi dan menekan tombol ubah.

Hapus: pengguna memilih data dan menekan tombol hapus. Program menampilkan konfirmasi sebelum menghapus data.

Bersihkan: pengguna menekan tombol bersihkan untuk mengosongkan form dan membatalkan pemilihan data.

Setelah operasi berhasil, tabel diperbarui agar menampilkan data terbaru. Dengan demikian, seluruh pengelolaan data pegawai dapat dilakukan melalui antarmuka aplikasi.

## 5. Desain Form PeopleMenu.form

File PeopleMenu.form digunakan untuk menyimpan desain antarmuka grafis yang dibuat menggunakan IntelliJ UI Designer.

Desain form dihubungkan dengan class PeopleMenu.java melalui field binding. Komponen yang digunakan mencakup panel utama, label, kolom input, pilihan kategori dan jabatan, tombol operasi, serta tabel data pegawai.

Komponen tombol dihubungkan dengan method yang menangani operasi tambah, ubah, hapus, dan bersihkan. Sementara itu, pemilihan baris pada tabel digunakan untuk memasukkan data pegawai ke dalam form secara otomatis.

Pemisahan desain form dan logika program membantu membuat struktur kode lebih terorganisasi.

6. Penyimpanan Data

Program menggunakan ArrayList<Person> sebagai tempat penyimpanan data selama aplikasi berjalan. Data yang ditambahkan, diubah, atau dihapus akan memengaruhi data yang tersimpan di dalam memori dan ditampilkan pada tabel.

Program belum menggunakan database atau penyimpanan permanen. Oleh karena itu, perubahan data tidak otomatis tersimpan ketika aplikasi ditutup.


## Dokumentasi

![Tampilan Awal](dokumentasi/cpp/Tampilan%20Awal.png)
