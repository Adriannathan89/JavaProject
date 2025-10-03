public class Menu{
    private int IdBarang;
    private String kopi;
    private int harga;
    private int stock;

    public Menu() {

    }

    public Menu(int IdBarang, String kopi, int harga, int stock)  {
        this.IdBarang = IdBarang;
        this.kopi = kopi;
        this.harga = harga;
        this.stock = stock;
    }
    public int GetIdBarang(){
        return this.IdBarang;
    }
    public String GetNamaKopi(){
        return this.kopi;
    }
    public int GetHargaBarang(){
        return this.harga;
    }
    public int GetStock() {
        return this.stock;
    }
    public void SetStock(int Qty) {
        this.stock = this.stock - Qty;
    }
    public String toString() {
        return String.format("Kopi %s dengan Id %d, harga %d, sisa Stock %d" , this.kopi, this.IdBarang, this.harga, this.stock);
    }
    public boolean IsAvailable() {
        return stock >= 1;
    } 
}