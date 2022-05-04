package company;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FileWriter {

  public void savePizzasToMenucardList(Menucard currentMenuCard) throws FileNotFoundException {

    PrintStream file = new PrintStream("menucard.csv");

    for (Pizza aNewPizzaToTheMenucard : currentMenuCard.getMenuCard()) {

      file.print(aNewPizzaToTheMenucard.getName());
      file.print(";");
      file.print(aNewPizzaToTheMenucard.getMenuNumber());
      file.print(";");
      file.print(aNewPizzaToTheMenucard.getPrice());
      file.print(";");
      file.print(aNewPizzaToTheMenucard.getToppings());
      file.print("\n");
    }
  }

  public void saveStatsToFile(Statistics statistics) throws FileNotFoundException {

    PrintStream file = new PrintStream("Statistik.txt");

    for (int i = 1; i < statistics.getMenuArray().length + 1; i++) {
      if (i < 10) {
        file.print("0" + i);
      } else {
        file.print(i);
      }
      file.print(" ");
      file.print(statistics.getMenuArray()[i - 1]);
      file.print("\n");
    }
  }

  public void saveOrderNumber(int number) throws FileNotFoundException {
    PrintStream file = new PrintStream("OrderNumber.txt");
    file.print(number);
  }

  public void saveTotalRevenueToFile(int revenue) throws FileNotFoundException {
    PrintStream file = new PrintStream("Revenue.txt");
    file.print(revenue);
  }
}
