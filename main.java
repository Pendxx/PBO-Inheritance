import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private ArrayList<Kendaraan> armada;
    private Scanner scanner;

    public Main()
    {
        armada = new ArrayList<>();
        scanner = new Scanner(System.in);
        isiDataDummy();
        jalankanMenu();
    }

    private void isiDataDummy() {
        armada.add(new Mobil("Toyota Avanza", "B 1234 CD"));
        armada.add(new Mobil("Honda Brio", "D 5678 EF"));
        armada.add(new Motor("Yamaha NMAX", "AB 9012 GH"));
        armada.add(new Motor("Honda Vario", "F 3456 IJ"));
    }

    public void jalankanMenu()
    {
        int pilihan = 0;
        
        while (pilihan != 4) {
            System.out.println("\n===== Sistem Rental Kendaraan =====");
            System.out.println("1. Lihat Daftar Kendaraan");
            System.out.println("2. Sewa Kendaraan");
            System.out.println("3. Kembalikan Kendaraan");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            
            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine();
                prosesPilihan(pilihan);
            } else {
                System.out.println("Input harus angka!");
                scanner.nextLine();
            }
        }
    }

    private void prosesPilihan(int pilihan) {
        switch (pilihan) {
            case 1:
                tampilkanDaftar();
                break;
            case 2:
                prosesSewa();
                break;
            case 3:
                prosesKembali();
                break;
            case 4:
                System.out.println("Terima kasih telah menggunakan aplikasi.");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private void tampilkanDaftar() {
        System.out.println("\n--- Daftar Armada ---");
        for (int i = 0; i < armada.size(); i++) {
            System.out.println((i + 1) + ". " + armada.get(i).getInfo());
        }
    }

    private void prosesSewa() {
        tampilkanDaftar();
        System.out.print("Pilih nomor kendaraan untuk disewa: ");
        int indeks = scanner.nextInt() - 1;

        if (indeks >= 0 && indeks < armada.size()) {
            Kendaraan k = armada.get(indeks);
            if (k.getStatus()) {
                k.sewa();
                System.out.println("BERHASIL: Anda menyewa " + k.getInfo());
            } else {
                System.out.println("GAGAL: Kendaraan sedang disewa orang lain.");
            }
        } else {
            System.out.println("Nomor tidak valid.");
        }
    }

    private void prosesKembali() {
        tampilkanDaftar();
        System.out.print("Pilih nomor kendaraan untuk dikembalikan: ");
        int indeks = scanner.nextInt() - 1;

        if (indeks >= 0 && indeks < armada.size()) {
            Kendaraan k = armada.get(indeks);
            if (!k.getStatus()) {
                k.kembalikan();
                System.out.println("BERHASIL: Kendaraan dikembalikan. Sekarang tersedia.");
            } else {
                System.out.println("GAGAL: Kendaraan ini memang sedang tersedia (belum disewa).");
            }
        } else {
            System.out.println("Nomor tidak valid.");
        }
    }
    
    public static void main(String[] args) {
        new Main();
    }
}
