
import java.util.Comparator;

class ComparatorById implements Comparator{
    public int compare(Object A, Object B) {
        Menu a = (Menu) A;
        Menu b = (Menu) B;

        return a.GetNamaKopi().compareTo(b.GetNamaKopi());
    }
}