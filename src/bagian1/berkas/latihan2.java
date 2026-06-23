package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class latihan2 {
public static void main(String[] args) {
 File berkas = new File("data.txt");
 try {
 if (berkas.createNewFile()) {
 System.out.println("Berkas baru dibuat.");
 } else {
 System.out.println("Berkas sudah ada sebelumnya.");
 }
 } catch (IOException e) {
 System.out.println("Terjadi kesalahan: " + e.getMessage());
 }
 }
}