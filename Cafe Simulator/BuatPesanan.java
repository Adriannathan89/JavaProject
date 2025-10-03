import java.util.ArrayList;

public class BuatPesanan{
    private ArrayList<Order> ListOrder = new ArrayList<Order>();
    private int TotalPesanan;

    public BuatPesanan() {

    }
    public void TakeOrder(Menu Kopi, int Qty) {
        Order Minuman = new Order(Kopi, Qty);
        boolean BelumAda = true;
        for(int i = 0; i < ListOrder.size(); i++) {
            Order tmp = ListOrder.get(i);
            if(tmp.GetNama().equals(Kopi.GetNamaKopi())) {
                tmp.AddQty(Qty);
                ListOrder.set(i, tmp);
                BelumAda = false;
            }
        }
        if(BelumAda) ListOrder.add(Minuman);
        TotalPesanan += Minuman.GetTotalHarga();
    }
    public int GetTotalPesanan(){
        return TotalPesanan;
    }

    public void LihatPesanan() {
        System.out.println("Berikut ini Pesanan Kamu");
        System.out.println("+" + "-".repeat(20 + 2) + "+" + "-".repeat(5 + 2) + "+" + "-".repeat(15 + 2) + "+");
        System.out.println(String.format("| %-20s | %5s | %15s |", "Nama Barang", "Qty", "Harga"));
        System.out.println("+" + "-".repeat(20 + 2) + "+" + "-".repeat(5 + 2) + "+" + "-".repeat(15 + 2) + "+");
        for(int i = 0; i < ListOrder.size(); i++){
            Order tmp = ListOrder.get(i);
            System.out.println(tmp);
        }
        System.out.println("+" + "-".repeat(20 + 2) + "+" + "-".repeat(5 + 2) + "+" + "-".repeat(15 + 2) + "+");
        System.out.println(String.format("\nTotal Harga         : %d\n", TotalPesanan));
    }
}