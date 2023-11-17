import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;


public class Transaction { // хранение массивов и ArrayList

    ArrayList<String> name = new ArrayList<>();

    ArrayList<Boolean> isExpense = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>();


    ArrayList<Integer> unitPrice = new ArrayList<>();

    String nameMonth;


   public Transaction(ArrayList<String> Arraylines, String nameMonth) {
       System.out.println(Arraylines.size());
       for (int i = 1; i < Arraylines.size(); i++) {
           String[] lines = Arraylines.get(i).split(",");
           name.add(lines[0]);
           isExpense.add(Boolean.parseBoolean(lines[1]));
           quantity.add(Integer.parseInt(lines[2]));
           unitPrice.add(Integer.parseInt(lines[3]));

       }
       this.nameMonth = nameMonth;
   }


   public Transaction(ArrayList<String> arrayLinesYear) { // конструктор для месяцев
       for (int i = 1; i < arrayLinesYear.size(); i++) {
           String[] lines = arrayLinesYear.get(i).split(",");
           name.add(String.valueOf(lines[0]));
           quantity = null;
           isExpense.add(Boolean.parseBoolean(lines[2]));
           unitPrice.add(Integer.valueOf(lines[1]));
       }
   //    String yearName = nameYear;
   }

//    void addMonth(Transaction currentMonth) {
//        for (int i = 0; i < currentMonth.name.size(); i++) {
//            name.add(currentMonth.name.get(i));
//            unitPrice.add(currentMonth.unitPrice.get(i));
//            isExpense.add(currentMonth.isExpense.get(i));
//            quantity.add(currentMonth.quantity.get(i));
//        }
//    }

    @Override
    public String toString() {
        return "Transaction{" +
                "name=" + name +
                ", isExpense=" + isExpense +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }


}
