package PemlanTugas.tugas2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * tugas2_Azkal Baihaqi_235150407111001_Sistem Infoermasi A
 */
public class tugas2_azkal {

    public static void main(String[] args) {
       

        Scanner sysin = new Scanner(System.in);
        //mnembuat arraylist untuk list mahasiswa
        ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();
        //membuat var check untuk melanjutkan kode
        String check = "y";

        System.out.println();

        
        
        while(check.equals("y")){

            sysin.nextLine();
        //membuat object mahasiswa
            Mahasiswa mahasiswa = new Mahasiswa();
        //mengambil nama
            System.out.print("Nama: ");
            String nama = sysin.nextLine();
            mahasiswa.setNama(nama);
        //mengambil NIM
            System.out.print("NIM: ");
            String nim = sysin.nextLine();
            mahasiswa.setNim(nim);
        //mengambil alamta
            System.out.print("Alamat: ");
            String alamat = sysin.nextLine();
            mahasiswa.setAlamat(alamat);

        //menambah mahasiswa ke list
            mahasiswaList.add(mahasiswa);

        //check apakah mau menambah mahasiswa
            System.out.print("Mau Menambah? (y/n)");
            String checking = sysin.next();
        //checking
            check = checking;
        }

        //output
        for (Mahasiswa mahasiswa : mahasiswaList) {
            System.out.println("====================================");
            System.out.printf("%-15s | %-10s | %-30s%n", mahasiswa.nama, mahasiswa.nim, mahasiswa.alamat);
            System.out.println("=====================================");
        }
        
        sysin.close();
    }
}


class Mahasiswa{ //kelas mahasiswa
    String nama;
    String nim;
    String alamat;

    //set nama
    void setNama(String nama){
        this.nama = nama;
    }
    //set Nim
    void setNim(String nim){
        this.nim = nim;
    }
    //set Alamat
    void setAlamat(String alamat){
        this.alamat = alamat;
    }

}