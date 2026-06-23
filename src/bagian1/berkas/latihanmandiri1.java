package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class latihanmandiri1 {
    public static void main(String[] args) {

        // =====================================================================
        // Soal 1: Cek keberadaan dan ukuran berkas laporan.txt
        // =====================================================================
        File berkasLaporan = new File("laporan.txt");

        if (berkasLaporan.exists()) {
            System.out.println("Berkas ada, ukuran: "
                    + berkasLaporan.length() + " byte");
        } else {
            System.out.println("Berkas laporan.txt tidak ditemukan.");
        }

        System.out.println(); // Pembatas antar latihan

        // =====================================================================
        // Soal 2: Buat folder baru bernama arsip dengan mkdir()
        // =====================================================================
        File folderArsip = new File("arsip");

        if (folderArsip.mkdir()) {
            System.out.println("Folder 'arsip' berhasil dibuat.");
        } else {
            System.out.println("Folder 'arsip' gagal dibuat (atau sudah ada).");
        }

        System.out.println(); // Pembatas antar latihan

        // =====================================================================
        // Soal 3: Buat berkas sementara.txt lalu hapus dengan delete()
        // =====================================================================
        File berkasSementara = new File("sementara.txt");

        try {
            // Membuat berkas baru
            berkasSementara.createNewFile();
            System.out.println("Sebelum dihapus, ada? "
                    + berkasSementara.exists());

            // Menghapus berkas
            berkasSementara.delete();
            System.out.println("Sesudah dihapus, ada? "
                    + berkasSementara.exists());

        } catch (IOException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
    }
}