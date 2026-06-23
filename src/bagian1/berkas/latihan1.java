package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class latihan1 {
public static void main(String args[]) throws IOException {
 // Objek File hanyalah penunjuk, belum tentu ada di disk
 File berkas = new File("catatan.txt");
 // Membuat berkas baru bila belum ada
 if (berkas.createNewFile()) {
 System.out.println("Berkas dibuat : " + berkas.getName());
 } else {
 System.out.println("Berkas sudah ada: " + berkas.getName());
 }
 // Memeriksa informasi berkas
 System.out.println("Apakah ada? :" + berkas.exists());
 System.out.println("Path absolut: " + berkas.getAbsolutePath());
 System.out.println("Ukuran (byte): " + berkas.length());
 System.out.println("Dapat dibaca: " + berkas.canRead());
 }
}
