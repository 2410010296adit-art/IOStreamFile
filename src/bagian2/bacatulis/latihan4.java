package bagian2.bacatulis;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class latihan4 {
public static void main(String[] args) {
 try (BufferedReader pembaca = new BufferedReader(new FileReader("mahasiswa.txt"))){
 String baris;
 int nomor = 1;
 while ((baris = pembaca.readLine()) != null) {
 System.out.println(nomor + ". " + baris);
 nomor++;
 }
 } catch (IOException e) {
 System.out.println("Gagal membaca: " + e.getMessage());
 }
 }
}
