package bagian2.bacatulis;

import java.io.*;
import java.util.Scanner;

public class latihanmandiri2 {
    public static void main(String[] args) {

        File fileHari = new File("hari.txt");

        try {

            // =====================================================
            // Soal 1
            // Tulis 5 nama hari ke dalam hari.txt
            // =====================================================
            FileWriter tulis = new FileWriter(fileHari);

            tulis.write("Senin\n");
            tulis.write("Selasa\n");
            tulis.write("Rabu\n");
            tulis.write("Kamis\n");
            tulis.write("Jumat\n");

            tulis.close();

            System.out.println("=== Isi hari.txt setelah menulis 5 hari ===");

            Scanner baca1 = new Scanner(fileHari);
            while (baca1.hasNextLine()) {
                System.out.println(baca1.nextLine());
            }
            baca1.close();

            // =====================================================
            // Soal 2
            // Tambah 2 hari tanpa menghapus isi sebelumnya
            // =====================================================
            FileWriter tambah = new FileWriter(fileHari, true);

            tambah.write("Sabtu\n");
            tambah.write("Minggu\n");

            tambah.close();

            System.out.println("\n=== Isi hari.txt setelah ditambah 2 hari ===");

            Scanner baca2 = new Scanner(fileHari);
            while (baca2.hasNextLine()) {
                System.out.println(baca2.nextLine());
            }
            baca2.close();

            // =====================================================
            // Soal 3
            // Hitung jumlah baris dalam file
            // =====================================================
            int jumlahBaris = 0;

            Scanner baca3 = new Scanner(fileHari);
            while (baca3.hasNextLine()) {
                baca3.nextLine();
                jumlahBaris++;
            }
            baca3.close();

            System.out.println("\nJumlah baris dalam hari.txt = " + jumlahBaris);

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
