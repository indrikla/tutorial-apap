# Tutorial APAP
## Authors
* **Indri Klarissa Ramadhanti** - *1906302554* - *APAP C*

---
## Tutorial 8
### Pertanyaan
1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian
melakukan langkah - langkah tersebut?
-> Untuk menghilangkan value daari inputan sebelumnya, saya mengimplementasikan codingan dibawah ini agar form inputannya secara default akan seperti ini tiap user berhasil menambahkan item baru.
![ss](https://i.ibb.co/WV2KqgM/message-Image-1638461315043.jpg)
2. Jelaskan fungsi dari async dan await!
-> Fungsi dari async adalah untuk menjalankan suatu fungsi bersamaan dengan javascript (dapat dilakukan secara bersamaan dengan tahapan lain). Sedangkan untuk await biasanya terdapat di dalam fungsi async, await berarti codingan akan berhenti dari fungsi async terlebih dahulu sampai task selesai dilakukan.
3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 9 pada Component Lifecycle
pada pertanyaan ini.
![ss](https://ibb.co/74cVY38)
![ss](https://ibb.co/3Fkzdhg)
![ss](https://ibb.co/7K1RxxM)
![ss](https://ibb.co/x5FMRYN)
4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate,
componentDidUpdate, componentWillReceiveProps, componentWillUnmount.
Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja
yang biasanya menggunakan lifecycle method tersebut”
-> - componentDidMount: dijalankan setelah fungsi render() selesai dilakukan dan komponen telah dipasang (mounted) ke DOM ketika kita dapat melihat komponen UI yang telah dirender. Use case yang biasanya menggunakan ini adalah ketika membuat fetch() ke server atau setState() dari suatu state yang nantinya akan melakukan render dari data yang terbaru. Ketika melakukan update state pada fungsi ini akan memanggil fungsi render() kembali.
-> - shouldComponentUpdate: digunakan untuk menentukan untuk memperbolehkan diupdate atau tidak suatu state berdasarkan state yang akan diubah. Dengan menerapkan ini, nantinya dapat return boolean. Namun saat ini bisa menerapkan React.PureComponent. Biasanya digunakan untuk performance optimisation measures. Use case yang menggunakan ini adalah untuk mengecek state saat ini dengan yang akan diubahnya.
-> - componentDidUpdate: digunakan dipanggil ketika state baru saja diubah. Fungsi ini dapat digunakan untuk mengoperasikan DOM ketika komponen sudah di-update. Use case yang dapat menggunakan ini adalah ketika melakukan network request.
-> - componentWillReceiveProps:dijalankan sebelum mounted component menerima props yang baru. Biasanya fungsi ini digunakan apabila ingin melakukan setState terhadap perubahan props. Fungsi ini dipanggil ketika terjadi update pada props saja. Biasanya use case yang menggunakan ini adalah setState()
-> - componentWillUnmount: dipanggil ketika component di-unmount. Use case yang menggunakan ini adalah untuk cleanup seperti invalidating timers, canceling network request atau cleaning up terhadap subscription yang dibuat di componentDidMount
---
## Tutorial 7
### Pertanyaan
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot
sebagai ilustrasi dari apa yang Anda jelaskan.
-> 1. Saya menambahkan method handleRemoveItemFromCart dimana ketika tergetInd lebih besar sama dengan 0, code untuk me-remove item seperti yang terlampir
di screenshoot berikut ![ss](https://i.ibb.co/1zFvNMq/no1.jpg)![ss](https://i.ibb.co/5BJt5DQ/no1-2.jpg)
-> 2. Saya menambahkan const newBalance = this.state.balance + newItem.price yang akan mengkalkulasi balance terbaru dan nantinya akan di set state 
pada state balance ![ss](https://i.ibb.co/RSPhkQv/no2.jpg)![ss](https://i.ibb.co/1zFvNMq/no1.jpg)
-> 3. Menambahkan kondisi jika newBalance kurang dari 0 ![ss](https://i.ibb.co/RSPhkQv/no2.jpg)

2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?
-> State adalah sebuah properti atau variabel yang didefinisikan di dalam sebuah class (private), sedangkan props adalah properti atau variabel yang berasal dari luar class atau class parent atau dapat digunakan oleh component lain

3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam
React? sebutkan alasannya.
-> Iya, karena component react memudahkan proses development pada aplikasi yang kompleks. React membagi UI menjadi bagian-bagian 
yang independen dan dapat digunakan kembali. Sehingga kita dapat memikirkan tiap bagian UI secara terpisah dan hal itu sangat memudahkan dalam proses development.

4. Apa perbedaan class component dan functional component?
-> Functional component hanya bisa menggunakan props itu sebabnya function component disebut stateless component atau biasa digunakan juga sebagai UI Component (komponen yang menangani tampilan). Sedangkan Class component dapat menggunakan state dan props

5. Dalam react, apakah perbedaan component dan element?
-> Komponen di React merupakan function atau class yang menerima input dan mengembalikan elemen, 
yang hanya merupakan deskripsi dari apa yang dapat kita lihat di layar komputer kita (tidak dapat diubah dan tidak dapat diterapkan metode apa pun di atasnya)

---
## Tutorial 6
### Pertanyaan
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?

- Otentikasi (key): Proses memverifikasi siapa seseorang saat ingin memasuki sebuah aplikasi/website; apakah ia sudah pernah terdaftar maupun belum. Contoh implementasinya adalah login pada 21cineplux.
- Otorisasi (permissions): Proses memverifikasi aplikasi, file, dan data spesifik apa yang dapat diakses oleh pengguna berdasarkan role yang ia miliki. Contoh implementasinya adalah hanya admin yang bisa melihat list user yang ada pada 21cineplux.


2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.

merupakan implementasi PasswordEncoder yang menggunakan fungsi hashing BCrypt.
BCrypt adalah salted hash function satu arah berdasarkan cipher Blowfish. 
Dengan ini, pengguna dapat secara opsional menyediakan "kekuatan" (alias putaran log di BCrypt) dan instance SecureRandom. 
Semakin besar parameter kekuatan, secara eksponensial akan semakin banyak pula "pekerjaan" yang harus dilakukan untuk meng-hash kata sandi.
BCryptPasswordEncoder bertujuan untuk memberikan peningkatan pada kata sandi teks biasa dan algoritma hashing tradisional (md5). 


3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?
Hashing lebih aman digunakan untuk penyimpanan data yang butuh keamanan lebih seperti password karena ia merupakan fungsi satu arah yang tidak mungkin untuk "mendekripsi" hash dan mendapatkan nilai plaintext aslinya.
Sedangkan Encryption adalah fungsi dua arah, artinya plaintext asli dapat dengan mudah diambil kembali. 
Encryption lebih baik digunakan untuk menyimpan data yang membutuhkan keamanan yang lebih rendah seperti alamat pengguna.


4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
UUID (Universally Unique Identifier) merepresentasikan nilai sepanjang 128 bit yang unik. 
UUID berfungsi untuk membuat nama file acak, session id, id transaksi, id suatu akun, dan lain-lain.

5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut?
UserDetailsServicelmpl.java berguna dalam proses otentikasi karena ia berfungsi untuk memvalidasi apakah username dan password yang diinput user (client side) ada dan sesuai dengan yang ada di database.

---
## Tutorial 5
### Pertanyaan
1. Apa itu Postman? Apa kegunaannya?
   Aplikasi uji coba REST API yang merupakan REST Client. Digunakan sebagai tool untuk proses development API. Postman memiliki banyak fitur seperti collection, environment, response, mock server, script test, dll.

2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
- @JsonIgnoreProperties: menandai properti atau daftar properti yang akan diabaikan pada tingkat class.
- @JsonProperty: memetakan nama properti dengan kunci JSON selama serialisasi dan deserialisasi.

3. Apa kegunaan atribut WebClient?
Spring WebClient adalah klien web yang menyediakan metode umum untuk mengirim data/menerima data dari local/intranet/Internet apa pun yang diidentifikasi oleh URI. 
WebClient menggunakan class WebRequest untuk menyediakan akses ke resources dan menangani respons yang dikembalikan dari server.

4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?   
- ResponseEntity: mewakili seluruh respons HTTP yaitu kode status, header, dan isi sehingga dapat digunakan untuk mengonfigurasi respons HTTP sepenuhnya.
- BindingResult: objek Spring yang menyimpan hasil validasi dan binding serta berisi error-error yang mungkin terjadi dan digunakan setelah objek model yang divalidasi atau Spring akan gagal memvalidasi objek dan melempar exception.

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
