package bagian3.kontak;
public class MainKontak {
 public static void main(String args[]) {
 // Membuat objek pengelola dan mengisinya
 BukuKontak buku = new BukuKontak ("kontak.txt");
 buku.tambahKontak (new Kontak("Andi", "0811111"));
 buku.tambahKontak(new Kontak("Budi", "0822222"));
 buku.tambahKontak (new Kontak("Citra", "0833333"));
 buku.tampilkanSemua();
 buku.simpankeBerkas();
 System.out.println();
 // Objek baru yang kosong, lalu memuat dari berkas
 BukuKontak bukulain = new BukuKontak("kontak.txt");
 bukulain.muatDariBerkas();
 bukulain.tampilkanSemua();
 System.out.println("Jumlah kontak: " + bukulain.jumlahKontak());
 }
}