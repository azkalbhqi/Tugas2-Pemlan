package PemlanTugas.tugas3;

// Nama: Azkal Baihaqi PS
// Nim: 235150407111001

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tugas3_azkal {
    public static void main(String[] args) {
        Scanner sysin = new Scanner(System.in);
        List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        boolean check = true;
        while (check) {
            System.out.print("Masukkan NIM Mahasiswa: ");
            String nim = sysin.nextLine();
            System.out.print("Masukkan Nama Mahasiswa: ");
            String nama = sysin.nextLine();

            Mahasiswa mahasiswa = new Mahasiswa(nim, nama);

            boolean checkTambahMataKuliah = true;
            while (checkTambahMataKuliah) {
                System.out.print("Masukkan Kode Mata Kuliah: ");
                String kodeMK = sysin.nextLine();
                System.out.print("Masukkan Nama Mata Kuliah: ");
                String namaMK = sysin.nextLine();
                System.out.print("Masukkan Nilai (Angka): ");
                int nilaiAngka = sysin.nextInt();
                sysin.nextLine(); // Membersihkan newline

                MataKuliah mataKuliah = new MataKuliah(kodeMK, namaMK, nilaiAngka);
                mahasiswa.addMatkul(mataKuliah);

                System.out.print("Apakah ingin menambahkan mata kuliah lagi? (y/n): ");
                String input = sysin.nextLine();
                if (!input.equalsIgnoreCase("y")) {
                    checkTambahMataKuliah = false;
                }
            }

            daftarMahasiswa.add(mahasiswa);

            System.out.print("Apakah ingin menambahkan mahasiswa lagi? (y/n): ");
            String inputMahasiswa = sysin.nextLine();
            if (!inputMahasiswa.equalsIgnoreCase("y")) {
                check = false;
            }
        }

        // Cetak KHS
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            System.out.println("Kartu Hasil Studi (KHS) Mahasiswa");
            System.out.println("NIM: " + mahasiswa.nim);
            System.out.println("Nama: " + mahasiswa.nama);
            for (MataKuliah mataKuliah : mahasiswa.mataKuliahList) {
                System.out.println("Mata Kuliah: " + mataKuliah.kodeMK + " - " + mataKuliah.namaMK + " - Nilai Huruf: " + mataKuliah.konversiNilai());
            }
        }

        sysin.close();

    }
}

class Mahasiswa {
    String nim;
    String nama;
    List<MataKuliah> mataKuliahList;

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.mataKuliahList = new ArrayList<>();
    }

    public void addMatkul(MataKuliah mataKuliah) {
        mataKuliahList.add(mataKuliah);
    }
}

class MataKuliah {
    String kodeMK;
    String namaMK;
    int nilaiAngka;

    public MataKuliah(String kodeMK, String namaMK, int nilaiAngka) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.nilaiAngka = nilaiAngka;
    }

    public String konversiNilai() {
        if (nilaiAngka >= 80 && nilaiAngka <= 100) {
            return "A";
        } else if (nilaiAngka >= 60 && nilaiAngka < 80) {
            return "B";
        } else if (nilaiAngka >= 50 && nilaiAngka < 60) {
            return "C";
        } else if (nilaiAngka >= 40 && nilaiAngka < 50) {
            return "D";        
        } else {
            return "E (Tidak Lulus)";
        }
    }
}

