# Tutorial APAP
## Authors
* **Indri Klarissa Ramadhanti** - *1906302554* - *APAP C*
---
## Tutorial 3
### Pertanyaan
1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model
(@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
- @AllArgsConstructor menghasilkan constructor dengan 1 parameter untuk tiap field yang ada di suatu class
- @NoArgsConstructor menghasilkan constructor tanpa parameter
- @Setter menghasilkan method setter secara otomatis
- @Getter menghasilkan method getter secara otomatis
- @Entity mendefinisikan bahwa suatu class akan dipetakan ke tabel
- @Table menentukan detail tabel yang akan digunakan dengan tujuan untuk mempertahankan entity dalam database

2. Pada class BioskopDB, terdapat method findByNoBioskop, apakah kegunaan dari method
tersebut?
method findByNoBioskop berfungsi untuk mendapatkan objek bioskop dari nomor bioskop yang unik tiap bioskop

3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn
- @JoinTable: untuk pemetaan Many-To-Many dan asosiasi One-To-Many
- @JoinColumn: untuk menentukan kolom untuk bergabung dengan entity association/element collection.

4. Pada class PenjagaModel, digunakan anotasi @JoinColumn pada atribut bioskop, apa
kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa
perbedaan nullable dan penggunaan anotasi @NotNull?
- name: menunjukan nama dari kolom gabungan
- referencedColumnName: properti yang berfungsi menunjukan nama kolom dalam suatu tabel yang direferensikan dengan tabel tujuan
- nullable: anotasi yang digunakan untuk menyatakan suatu elemen beranotasi dapat menjadi null dalam beberapa kondisi/keadaan
- @Not null: anotasi yang tidak akan memperbolehkan nilai null untuk field yang dibatasi (tetapi boleh empty)

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
- FetchType.LAZY: berfungsi memberi tahu Hibernate untuk mengambil entity yang berkaitan dengan  database saat menggunakan relasi. 
- CascadeType.ALL: berfungsi menyebarkan (cascade) seluruh operasi EntityManager seperti MERGE, REFRESH, PERSIST, REMOVE, MERGE, dan atau DETACH ke entitas yang berkaitan. 
- FetchType.EAGER: berfungsi memberi tahu Hibernate untuk mendapatkan seluruh elemen relasi saat dilakukannya pemilihan entitas root.

### Latihan1. 
1. Ubah fitur View All Bioskop yang menampilkan seluruh bioskop, menjadi terurut
berdasarkan nama bioskop. (Hint: Gunakan fitur yang dimiliki oleh JPA Repository!)
a. Spesifikasi: Terdapat tombol View All pada Home.
2. Tambahkan fitur Update Penjaga Bioskop. Fitur ini dapat mengubah seluruh informasi
penjaga bioskop kecuali id penjaga bioskop. Spesifikasi dari fitur ini:
a. Penjaga bioskop hanya dapat di-update ketika bioskop sedang tutup.
b. Terdapat tombol Update Penjaga di setiap penjaga pada suatu halaman bioskop
3. Tambahkan fitur delete penjaga bioskop yang dapat digunakan untuk menghapus seorang
penjaga dari sebuah bioskop. Spesifikasi dari fitur ini:
a. Penjaga bioskop hanya dapat di-delete ketika bioskop sedang tutup.
b. Terdapat tombol Delete Penjaga di setiap penjaga pada suatu halaman bioskop

---
## Tutorial 2
### Pertanyaan
1. http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10 Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi 
Akan tertampil whitelabel error page dikarenakan controller akan melakukan return view template "add-bioskop" tetapi template html add-bioskop belum dibuat sehingga program tidak akan menemukannya.

2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
Spring Framework menyediakan fitur component-scan, yaitu dia akan melihat isi package yang kita sebutkan, yang kemudian akan mencari class-class yang diberi anotasi berikut: @Repository, @Service, @Controller, @Component.
Setelah ditemukan, maka dia akan melakukan inisialisasi terhadap class tersebut, dan lalu meng-inject semua dependency. Untuk injection ini, kita juga tidak perlu lagi menyediakan setter method maupun menambahkan argumen di constructor. Kita dapat menggunakan anotasi @Autowired.

3. Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20 APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
Terjadi error karena parameter jumlah studio tidak ada padahal diset required = true.

4. Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung, link apa yang harus diakses?
Asumsi Bioskop Maung memiliki id = 1, maka Papa APAP dapat mengaksesnya lewat link /bioskop/view?idBioskop=1 atau /bioskop/view/id-bioskop/1

5. Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/bioskop/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu
Halaman menampilkan detail semua bioskop yang telah ditambah lengkap besertaid, nama, alamat, nomor telepon, jumlah studionya. 
![ss](https://i.ibb.co/h8N2mhD/Screenshot-1869.png)

### Latihan
1. Pada BioskopController tambahkan sebuah method view Bioskop dengan menggunakan Path Variable. Misalnya, kamu ingin memasukkan data sebuah Bioskop yang memiliki idBioskop 1, untuk melihat data yang baru dimasukkan tersebut, user dapat mengakses halaman http://localhost:8080/bioskop/view/id-bioskop/1. 
![ss](https://i.ibb.co/3fNFVRr/Screenshot-1867.png)
2. Tambahkan fitur untuk melakukan update jumlahStudio Bioskop berdasarkan idBioskop. Misalnya, setelah melakukan add Bioskop pada tahap 1 bab View Template, cobalah untuk mengubah jumlahStudio objek Bioskop tersebut menjadi 999 dengan mengakses halaman http://localhost:8080/bioskop/update/id-bioskop/1/jumlah-studio/999 Tampilkan juga sebuah halaman yang memberikan informasi bahwa data tersebut telah berhasil diubah. 
![ss](https://i.ibb.co/C8s4sZq/Screenshot-1868.png) ![ss](https://i.ibb.co/h8N2mhD/Screenshot-1869.png)
3. Tambahkan fitur untuk melakukan delete Bioskop berdasarkan idBioskop. Misalnya, setelah melakukan add Bioskop pada tahap 1 bab View Template dan melakukan update seperti pada latihan nomor 2, cobalah untuk melakukan delete data tersebut dengan mengakses halaman http://localhost:8080/bioskop/delete/id-bioskop/1. Tampilkan sebuah halaman yang memberikan informasi bahwa data tersebut telah berhasil dihapus.
![ss](https://i.ibb.co/xSPVdHM/Screenshot-1870.png) ![ss](https://i.ibb.co/rcH0h31/Screenshot-1871.png)

---
## Tutorial 1
### What I have learned today
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Issue Tracker berfungsi untuk melakukan keep track of tasks, enhancements, dan bugs untuk proyek yang kita kerjakan. Issue Tracker bisa dibilang seperti layaknya email, hanya saja bersifat kolaboratif dengan kollaborator di repositori yang kita kerjakan.
2. Apa perbedaan dari git merge dan git merge --squash?
Squash merge adalah opsi penggabungan di Git yang akan menghasilkan komit gabungan dengan hanya satu induk. Sedangkan perintah git merge memungkinkan kita mengambil jalur pengembangan independen yang dibuat oleh git branch dan mengintegrasikannya ke dalam satu cabang.
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi?
VCS mampu melacak setiap modifikasi kode, serta dapat membandingkan kode dari versi sebelumnya dan mulai memperbaiki kekeliruan yang ada pada kode. Karena sistem pelacakan yang akurat, version control system dapat mengurangi gangguan serta kesalahan pada kinerja semua anggota tim engineering.


### Spring
4. Apa itu library & dependency?
Library dan dependency dapat dianalogikan seperti "buah dan apel". Jika aplikasi menggunakan library, maka aplikasi tersebut memiliki dependency (atau ketergantungan) pada perpustakaan itu.
5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven adalah alat otomatisasi build yang digunakan terutama untuk proyek Java. Maven membuat struktur project sendiri sehingga project tersebut akan dapat dibuka dengan berbagai IDE dikarenakan Maven mendefinisikan projectnya sendiri. Selain itu memanage Dependency dengan Maven menjadi mudah. Alternatif Maven sendiri salah satunya Gradle yang biasa digunakan untuk production dengan skala lebih besar.
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
Spring dapat bekerja di aplikasi Java apa pun, tidak terbatas untuk pengembangan web saja. Spring dapat digunakan untuk pengembangan aplikasi berbasis desktop
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?
@RequestParam digunakan untuk mengekstrak parameter kueri sementara @PathVariable digunakan untuk mengekstrak data langsung dari URI

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
Pada tutorial kali ini saya masih abu-abu tentang konsep framework spring dan masih dalam proses
meng-adjust knowledge framework Django ke Spring.

- [ ] Kenapa saya harus belajar APAP?
- [x] Kenapa?
Karena dengan belajar APAP kita jadi bisa ngoding ^__________^ dan mengerti penggunaan framework Spring

(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu
lebih dalam tentang penulisan README.md di GitHub pada link
[berikut](https://help.github.com/en/articles/basic-writing-and-formatting-syntax))