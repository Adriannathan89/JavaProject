import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cafe{
    private String id;
    private String nama;
    private boolean IsOpen;
    private ArrayList<Menu> DaftarMenu = new ArrayList<Menu>();
    private int Omset;
    private Comparator MyCmp = new ComparatorById();

    public Cafe() {

    }

    public boolean GetStatus() {
        return this.IsOpen;
    }
    public void SetStatus(boolean opn) {
        this.IsOpen = opn;
    }
    public Cafe(String id, String nama, boolean IsOpen) {
        this.id = id;
        this.nama = nama;
        this.IsOpen = IsOpen;
    }

    public void Pembayaran(int TotalHarga) {
        System.out.println("Pembayaran berhasil kami terima");
        System.out.println("Kamu akan segera menerima pesanan kamu");
        Omset += TotalHarga;
    }

    public int GetOmset() {
        return Omset;
    }
    public void AddMenu(Menu kopi) {
        DaftarMenu.add(kopi);
        Collections.sort(DaftarMenu, MyCmp);
    }
    public Menu CariMenu(String NamaKopi) {
        int l = 0, r = DaftarMenu.size() - 1;
        if(r < 0) {
            return null;
        } 
        else{
        while(l <= r) {
            int mid = (l + r)/2;
            Menu Fnd = DaftarMenu.get(mid);
            if(Fnd.GetNamaKopi().equals(NamaKopi)) {
                return Fnd;
            }
            if(Fnd.GetNamaKopi().compareTo(NamaKopi) == 1){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return null;
        }
    }
    public void GetMenuList() {
        System.out.println("+" + "-".repeat(20 + 2) + "+" + "-".repeat(15 + 2) + "+");
        System.out.println(String.format("| %-20s | %15s |", "Nama Barang", "Harga"));
        System.out.println("+" + "-".repeat(20 + 2) + "+" + "-".repeat(15 + 2) + "+");
        for(int i = 0; i < DaftarMenu.size(); i++) {
            Menu Kopix = DaftarMenu.get(i);
            System.out.println(String.format("| %-20s | %15d |", Kopix.GetNamaKopi(), Kopix.GetHargaBarang()));
        }
        System.out.println("+" + "-".repeat(20 + 2) + "+" + "-".repeat(15 + 2) + "+");
    }
}