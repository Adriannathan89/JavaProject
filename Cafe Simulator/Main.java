import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cafe Copysop = new Cafe("Ax1443", "Copysop", true);
        BuatPesanan Ordr = new BuatPesanan();
        String OptionList = """
        Silahkan pilih Menu untuk Self Care:
        1. Lihat Menu
        2. Buat Pesanan 
        3. Lihat Pesanan Saya
        4. Lakukan Pembayaran
        5. Selesaikan Pesanan
        """;

        if(Copysop.GetStatus() == false) {
            System.out.println("Mohon Maaf kami sedang tutup, kembali lah beberapa saat lagi");
        }
        while(Copysop.GetStatus()) {
        System.out.println(OptionList);
        Scanner Inp = new Scanner(System.in);
        int Option = Inp.nextInt();
        switch (Option) {
            case 1: Copysop.GetMenuList(); break;
            case 2: {
                Scanner InpPesanan = new Scanner(System.in);
                String PesanKopi = InpPesanan.next();
                int Qty = InpPesanan.nextInt();
                if(Copysop.CariMenu(PesanKopi) == null) {
                    System.out.println("Mohon maaf kami tidak mempunyai menu itu\n");
                    break;
                }
                Menu Pesanan = Copysop.CariMenu(PesanKopi);
                if(Pesanan.GetStock() < Qty) {
                    System.out.println(String.format("Mohon Maaf Kami Kekurangan stock untuk pesanan %s kamu", Pesanan.GetNamaKopi()));
                    System.out.println("");
                } else{
                    Ordr.TakeOrder(Pesanan, Qty);
                    Pesanan.SetStock(Qty);
                    System.out.println(String.format("Pesanan untuk %s sebanyak %d berhasil ditambahkan ke keranjang", Pesanan.GetNamaKopi(), Qty));
                    System.out.println("");
                }
                break;
            }
            case 3: Ordr.LihatPesanan(); break;
            case 4: {
                Copysop.Pembayaran(Ordr.GetTotalPesanan());
                Ordr = new BuatPesanan();
                break;
            }
        }
        if(Option == 5) break;

        if(Option == 1443) {
                String AdminOptionList = """
                Silahkan pilih Menu untuk mengakses Menu Admin:
                1. Tambahkan Menu Baru
                2. Cari Barang
                3. Lihat Pendapatan Hari ini
                4. Tutup Cafe
                5. Keluar Mode Admin
                """;

                System.out.println("Selamat datang di menu Admin Copysop");
                System.out.print("Verifikasi Diri Anda = ");
                Scanner InpUsr = new Scanner(System.in);
                String Password = InpUsr.next();
                if(Password.equals("Admin123")) {
                    while(true) {
                    System.out.println("\nSelamat Datang Pemilik Copysop\n");
                    System.out.println(AdminOptionList);
                    System.out.print("Silahkan memilih menu = ");
                    Scanner InpAdmin = new Scanner(System.in);
                    Option = InpAdmin.nextInt();
                    switch (Option) {
                        case 1: {
                            System.out.println("Silahkan Masukan Menu baru dengan Format -> Id Nama Harga Stock");
                            InpAdmin = new Scanner(System.in);
                            int ID = InpAdmin.nextInt();
                            String Nama = InpAdmin.next();
                            int Harga = InpAdmin.nextInt();
                            int stock = InpAdmin.nextInt();
                            Menu KopiBaru = new Menu(ID, Nama, Harga, stock);
                            Copysop.AddMenu(KopiBaru);
                            System.out.println(Copysop.CariMenu(Nama) + "Berhasil di tambahkan ke dalam list" + "\n");
                            break;
                        }
                        case 2: {
                            System.out.print("Barang Apa yang sedang kamu cari? ");
                            InpAdmin = new Scanner(System.in);
                            String caribarang = InpAdmin.next();
                            if(Copysop.CariMenu(caribarang) != null) {
                                System.out.println("ditemukan " + Copysop.CariMenu(caribarang) + "\n");
                            } else {
                                System.out.println(String.format("Barang %s tidak dapat ditemukan\n", caribarang));
                            }
                            break;
                        }
                        case 3: {
                            System.out.println(String.format("Total Pendapatan Hari ini adalah %d\n", Copysop.GetOmset()));
                            break;
                        }
                        case 4: Copysop.SetStatus(false);
                    }
                    if(Option == 5) break;
                    }
                }
            }
        }
    }
}