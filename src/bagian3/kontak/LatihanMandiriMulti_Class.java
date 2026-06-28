package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

// =====================================================================
// 3. CLASS MAIN: LatihanMandiriMulti_Class (Nama class disesuaikan dengan nama file)
// =====================================================================
public class LatihanMandiriMulti_Class {
    public static void main(String[] args) {
        // Menginisialisasi objek BukuKontak [cite: 298, 303]
        BukuKontak buku = new BukuKontak("kontak.txt");
        
        System.out.println("--- Tahap 1: Mengisi Data dan Menyimpan ---");
        // Parameter baru: Nama, Nomor, Email (Sesuai Soal No. 2) [cite: 324]
        buku.tambahKontak(new Kontak("Andi", "0811111", "andi@email.com"));
        buku.tambahKontak(new Kontak("Budi", "0822222", "budi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "0833333", "citra@email.com"));
        
        buku.tampilkanSemua(); // Menampilkan kontak awal [cite: 307]
        buku.simpankeBerkas(); // Menyimpan ke file kontak.txt [cite: 308]
        System.out.println();

        System.out.println("--- Tahap 2: Memuat Data pada Objek Baru ---");
        BukuKontak bukuLain = new BukuKontak("kontak.txt"); // [cite: 311]
        bukuLain.muatDariBerkas(); // Memuat dari berkas teks [cite: 312]
        bukuLain.tampilkanSemua(); // [cite: 313]
        System.out.println();

        // Uji Coba Soal No. 1: Fungsi cariKontak [cite: 322, 323]
        System.out.println("--- Tahap 3: Uji Coba Pencarian Kontak ---");
        bukuLain.cariKontak("Budi");
        bukuLain.cariKontak("Zaki");
        System.out.println();

        // Uji Coba Soal No. 3: Fungsi hapusKontak [cite: 325]
        System.out.println("--- Tahap 4: Uji Coba Penghapusan Kontak ---");
        bukuLain.hapusKontak("Andi"); // Menghapus kontak Andi dan otomatis memperbarui berkas
        System.out.println("\n--- Hasil Akhir Setelah Penghapusan ---");
        bukuLain.tampilkanSemua();
        System.out.println("Jumlah kontak sekarang: " + bukuLain.jumlahKontak()); // [cite: 314]
    }
}

// =====================================================================
// 1. CLASS MODEL: Kontak (Tanpa modifier public agar bisa satu file)
// =====================================================================
class Kontak {
    private final String nama; // [cite: 213]
    private final String nomor; // [cite: 214]
    private final String email; // Tambahan atribut email (Soal No. 2) [cite: 324]

    // Constructor yang disesuaikan untuk menampung email (Soal No. 2) [cite: 324]
    public Kontak(String nama, String nomor, String email) {
        this.nama = nama;
        this.nomor = nomor;
        this.email = email;
    }

    public String getNama() {
        return nama; // [cite: 224]
    }

    public String getNomor() {
        return nomor; // [cite: 227]
    }

    public String getEmail() { 
        return email; // Getter email (Soal No. 2) [cite: 324]
    }

    // Mengubah objek menjadi baris teks dengan 3 bagian data (Soal No. 2) [cite: 230, 324]
    public String keBaris() {
        return nama + ";" + nomor + ";" + email;
    }

    // Format tampilan informasi kontak (Soal No. 2) [cite: 232, 324]
    public String info() {
        return nama + " - " + nomor + " (" + email + ")";
    }
}

// =====================================================================
// 2. CLASS PENGELOLA: BukuKontak (Tanpa modifier public agar bisa satu file)
// =====================================================================
class BukuKontak {
    private final ArrayList<Kontak> daftar = new ArrayList<>(); // [cite: 247]
    private final String namaBerkas; // [cite: 247]

    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas; // [cite: 250]
    }

    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak); // [cite: 253]
    }

    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak =="); // [cite: 256]
        for (int i = 0; i < daftar.size(); i++) { // [cite: 256]
            Kontak k = daftar.get(i); // [cite: 257]
            System.out.println((i + 1) + ". " + k.info()); // [cite: 260]
        }
    }

    public void simpankeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) { // [cite: 264]
            for (Kontak k : daftar) { // [cite: 264]
                penulis.println(k.keBaris()); // [cite: 266]
            }
            System.out.println("Kontak disimpan ke " + namaBerkas); // [cite: 267]
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage()); // [cite: 269]
        }
    }

    // Memuat berkas teks dan memecah menjadi 3 bagian data (Soal No. 2) [cite: 273, 324]
    public void muatDariBerkas() {
        daftar.clear(); // [cite: 274]
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) { // [cite: 275]
            String baris;
            while ((baris = pembaca.readLine()) != null) { // [cite: 276, 277]
                String[] bagian = baris.split(";"); // [cite: 279]
                // Validasi panjang array hasil split diubah menjadi 3 (Soal No. 2) [cite: 280, 324, 368]
                if (bagian.length == 3) {
                    daftar.add(new Kontak(bagian[0], bagian[1], bagian[2])); // [cite: 281]
                }
            }
            System.out.println("Kontak dimuat dari " + namaBerkas); // [cite: 285]
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage()); // [cite: 287]
        }
    }

    public int jumlahKontak() {
        return daftar.size(); // [cite: 293]
    }

    // Method mencari kontak berdasarkan nama (Soal No. 1) [cite: 322, 388]
    public void cariKontak(String nama) {
        for (Kontak k : daftar) { // [cite: 388]
            if (k.getNama().equalsIgnoreCase(nama)) { // Menggunakan equalsIgnoreCase agar tidak sensitif huruf besar/kecil
                System.out.println("Ditemukan: " + k.info()); // [cite: 388]
                return; // [cite: 389]
            }
        }
        System.out.println("Kontak " + nama + " tidak ditemukan."); // [cite: 389]
    }

    // Method menghapus kontak berdasarkan nama lalu menyimpannya (Soal No. 3) [cite: 325]
    public void hapusKontak(String nama) {
        boolean ditemukan = false;
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNama().equalsIgnoreCase(nama)) {
                daftar.remove(i); // Menghapus dari ArrayList
                ditemukan = true;
                System.out.println("Kontak dengan nama '" + nama + "' berhasil dihapus.");
                break;
            }
        }
        
        if (ditemukan) {
            simpankeBerkas(); // Memanggil simpanKeBerkas agar perubahan diperbarui di file txt (Soal No. 3) [cite: 325]
        } else {
            System.out.println("Gagal menghapus! Kontak dengan nama '" + nama + "' tidak ditemukan.");
        }
    }
}