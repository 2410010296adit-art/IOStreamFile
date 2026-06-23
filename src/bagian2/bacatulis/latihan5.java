package bagian2.bacatulis;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class latihan5 {
 public static void main(String args[]) {
 // Parameter true berarti menambah (append), bukan menimpa
 try (PrintWriter penulis = new PrintWriter(new FileWriter("mahasiswa.txt", true))) {
 penulis.println("Dewi");
 penulis.println("Eka");
 System.out.println("Dua nama baru ditambahkan tanpa menghapus data lama.");
 } catch (IOException e) {
 System.out.println("Gagal menambah data: " + e.getMessage());
 }
 }
}