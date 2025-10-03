public class Order{
    private String NamaBarang;
    private int Qty;
    private int TotalHarga;

    public Order(Menu kopi, int Qty){
        this.NamaBarang = kopi.GetNamaKopi();
        this.Qty = Qty;
        this.TotalHarga = kopi.GetHargaBarang() * Qty;
    }

    public int GetTotalHarga(){
        return this.TotalHarga;
    }

    public String GetNama() {
        return this.NamaBarang;
    }
    public void AddQty(int add) {
        this.Qty = this.Qty + add;
    }
    public String toString() {
        return String.format("| %-20s | %5d | %15d |", this.NamaBarang, this.Qty, this.TotalHarga);
    }
}