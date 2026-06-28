package bagian3.kontak;
public class Kontak {
 // Atribut: data yang dimiliki setiap kontak
 private final String nama;
 private final String nomor;
 // Constructor: dipanggil saat objek dibuat
 public Kontak (String nama, String nomor) {
 this.nama = nama;
 this.nomor = nomor;
 }
 // Getter: cara membaca atribut dari luar class
 public String getNama() {
 return nama;
 }
 public String getNomor() {
 return nomor;
 }
 // Mengubah objek menjadi satu baris teks untuk disimpan ke berkas
 public String keBaris() {
 return nama + ";" + nomor;
 }
 // Mengembalikan keterangan kontak dalam bentuk teks
 public String info() {
 return nama + " " + nomor;
 }
}