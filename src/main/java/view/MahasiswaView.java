/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author salsa
 */
import controller.MahasiswaController;
import model.MahasiswaDAO;
import java.util.Scanner;


public class MahasiswaView {
    public static void main(String[] args){
         MahasiswaDAO mahasiswaDAO = new MahasiswaDAO();
         MahasiswaController mahasiswaController = new MahasiswaController(mahasiswaDAO);
         
         Scanner scanner = new Scanner(System.in);
         int pilihan;
       
        while(true){
            System.out.println("Menu:");
            System.out.println("1. Tampilkan Semua Mahasiswa");
            System.out.println("2. Tambah Mahasiswa");
            System.out.println("3. Update Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Cek Koneksi Database");
            System.out.println("6. Keluar");
            System.out.print("PILIH OPSI: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan){
                case 1:
                    mahasiswaController.displayAllMahasiswa();
                    break;
                    
                case 2:
                    System.out.print("Masukkan NPM: ");
                    String npm = scanner.nextLine();

                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();

                    System.out.print("Masukkan Semester: ");
                    int semester = Integer.parseInt(scanner.nextLine());

                    System.out.print("Masukkan IPK: ");
                    float ipk = Float.parseFloat(scanner.nextLine());

                    mahasiswaController.addMahasiswa(npm, nama, semester, ipk);
                    break;

                case 3:
                    System.out.print("Masukkan ID mahasiswa: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Masukkan NPM baru: ");
                    String npmBaru = scanner.nextLine();

                    System.out.print("Masukkan Nama baru: ");
                    String namaBaru = scanner.nextLine();

                    System.out.print("Masukkan Semester baru: ");
                    int semesterBaru = Integer.parseInt(scanner.nextLine());

                    System.out.print("Masukkan IPK baru: ");
                    float ipkBaru = Float.parseFloat(scanner.nextLine());

                    mahasiswaController.updateMahasiswa(id, npmBaru, namaBaru, semesterBaru, ipkBaru);
                    break;

                case 4:
                    System.out.print("Masukkan ID Mahasiswa: ");
                    int idHapus = scanner.nextInt();
                    mahasiswaController.deleteMahasiswa(idHapus);
                case 5:
                    mahasiswaController.checkDatabaseConnection();
                    break;
                case 6:
                    // Keluar
                    mahasiswaController.closeConnection();
                    System.out.println("Program selesai.");
                    return;
                default:
                    System.out.println("Input Tidak valid");
            }
        }
    }
}