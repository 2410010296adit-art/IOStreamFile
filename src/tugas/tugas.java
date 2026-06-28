// Nama: Aditya Kurniawan
// NPM: 2410010296
package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

// =====================================================================
// 3. CLASS MAIN: tugas (Disesuaikan dengan nama file Anda: tugas.java)
// =====================================================================
public class tugas {
    public static void main(String[] args) {
        
        // 1. Menyimpan daftar nama kategori dalam sebuah array String (minimal 3, ukuran tetap) dan menampilkannya
        String[] kategori = {"Elektronik", "Pakaian", "Makanan", "Alat Tulis"};
        System.out.println("=== KATEGORI BARANG TOKO ===");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println("- Kategori " + (i + 1) + ": " + kategori[i]);
        }
        System.out.println();

        // 2. Membuat objek Gudang pertama dan menambahkan minimal 5 objek Barang
        Gudang gudangUtama = new Gudang("barang.txt");
        
        System.out.println("--- Tahap 1: Input Data Awal dan Penyimpanan ---");
        gudangUtama.tambahBarang(new Barang("Laptop ASUS", 8500000, 10));
        gudangUtama.tambahBarang(new Barang("Smartphone Samsung", 3500000, 15));
        gudangUtama.tambahBarang(new Barang("Kemeja Flanel", 150000, 50));
        gudangUtama.tambahBarang(new Barang("Biskuit Kaleng", 45000, 100));
        gudangUtama.tambahBarang(new Barang("Printer Epson", 2200000, 5));
        
        // Menampilkan data awal dan menyimpannya ke berkas teks barang.txt
        gudangUtama.tampilkanSemua();
        gudangUtama.simpanKeBerkas();
        System.out.println();

        // 3. Membuat objek Gudang baru yang kosong untuk membuktikan data tersimpan di berkas
        System.out.println("--- Tahap 2: Pembuktian Memuat Data dari Berkas ---");
        Gudang gudangBaru = new Gudang("barang.txt");
        
        // Memuat kembali data dari file, menampilkan list, serta total nilai persediaan gudang
        gudangBaru.muatDariBerkas();
        gudangBaru.tampilkanSemua();
        
        System.out.println("-------------------------------------");
        System.out.println("TOTAL NILAI PERSEDIAAN GUDANG: Rp" + gudangBaru.totalNilai());
        System.out.println("-------------------------------------");
    }
}

// =====================================================================
// 1. CLASS MODEL: Barang (Tanpa modifier public agar bisa menyatu di file tugas.java)
// =====================================================================
class Barang {
    private String nama;
    private double harga;
    private int stok;

    // Constructor untuk menginisialisasi data barang
    public Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter untuk mengakses atribut dari luar class
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Mengubah data objek menjadi format baris teks (titik koma ';') untuk disimpan ke berkas
    public String keBaris() {
        return nama + ";" + harga + ";" + stok;
    }

    // Menampilkan informasi detail mengenai barang
    public String info() {
        return nama + " | Harga: Rp" + harga + " | Stok: " + stok;
    }
}

// =====================================================================
// 2. CLASS PENGELOLA: Gudang (Tanpa modifier public agar bisa menyatu di file tugas.java)
// =====================================================================
class Gudang {
    // Koleksi untuk menampung objek bertipe Barang
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private String namaBerkas;

    public Gudang(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    // Menambahkan objek barang ke dalam ArrayList
    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    // Menampilkan seluruh daftar barang yang tersimpan
    public void tampilkanSemua() {
        System.out.println("====== DAFTAR BARANG DI GUDANG ======");
        if (daftarBarang.isEmpty()) {
            System.out.println("(Gudang kosong)");
        } else {
            for (int i = 0; i < daftarBarang.size(); i++) {
                System.out.println((i + 1) + ". " + daftarBarang.get(i).info());
            }
        }
    }

    // Menyimpan seluruh data barang dari ArrayList ke berkas teks
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftarBarang) {
                penulis.println(b.keBaris());
            }
            System.out.println("Data barang berhasil disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan ke berkas: " + e.getMessage());
        }
    }

    // Memuat kembali data barang dari berkas teks ke dalam ArrayList baru
    public void muatDariBerkas() {
        daftarBarang.clear(); // Bersihkan list sebelum memuat data baru
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    String nama = bagian[0];
                    double harga = Double.parseDouble(bagian[1]);
                    int stok = Integer.parseInt(bagian[2]);
                    daftarBarang.add(new Barang(nama, harga, stok));
                }
            }
            System.out.println("Data barang berhasil dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat dari berkas: " + e.getMessage());
        }
    }

    // Menghitung total nilai persediaan (harga dikali stok dari seluruh barang)
    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += b.getHarga() * b.getStok();
        }
        return total;
    }
}