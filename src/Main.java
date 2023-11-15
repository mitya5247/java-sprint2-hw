
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        ArrayList<String> linesMonth1 = fileReader.readFileContents("m.202101.csv");
        ArrayList<String> linesMonth2 = fileReader.readFileContents("m.202102.csv");
        ArrayList<String> linesMonth3 = fileReader.readFileContents("m.202103.csv");
        ArrayList<String> yearMonth = fileReader.readFileContents("y.2021.csv");

        MonthlyReport month1 = new MonthlyReport(linesMonth1); // объявляем массивы с месяцами
      //  Transaction month2 = new Transaction(linesMonth2);
     //   Transaction month3 = new Transaction(linesMonth3);


      //  boolean linesMonthBool = (month1.name != null) && (month2.name != null) && (month3.name != null);

        System.out.println(yearMonth);

      //  if (linesMonthBool) {


        //    System.out.println(month1);
         //   System.out.println(month2);
        //    System.out.println(month3);

            System.out.println("Самая большая затрата " + month1.maxExspense());
     //   } else {
       //     System.out.println("Файлы не прочитаны");
      //  }



    }
}

