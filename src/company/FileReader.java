package company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileReader {

  public Menucard loadMenuFromMenucardfile() throws FileNotFoundException {

    Menucard menucard = new Menucard();

    Scanner fileInput = new Scanner(new File("menucard.csv"));

    while (fileInput.hasNextLine()) {

      String line = fileInput.nextLine();
      Scanner lineInput = new Scanner(line).useDelimiter(";").useLocale(Locale.ENGLISH);
      String name = lineInput.next();
      int menuNumber = lineInput.nextInt();
      int price = lineInput.nextInt();

      Pizza pizza = new Pizza(name, menuNumber, price);

      String toppingsInStringForm = lineInput.next();
      ArrayList<Topping> thePizzaToppings = findToppingsFromString(toppingsInStringForm);
      pizza.addToppings(thePizzaToppings);

      menucard.addToMenu(pizza);
    }
    return menucard;
  }

  private ArrayList<Topping> findToppingsFromString(String stringFromInput) {
    ArrayList<Topping> toppings = new ArrayList<>();

    String word = "";
    for (int i = 1; i < stringFromInput.length() - 2; i++) {

      if (stringFromInput.charAt(i) == ',') {
        toppings.add(Topping.valueOf(word));
      } else if (stringFromInput.charAt(i) == ' ') {
        word = "";
      } else {
        word += stringFromInput.charAt(i);
      }
    }
    return toppings;
  }

  public int[] loadStatsFromFile(int sizeOfArray) throws FileNotFoundException {

    int[] myStats = new int[sizeOfArray];

    Scanner fileScanner = new Scanner(new File("Statistik.txt"));

    while (fileScanner.hasNextLine()) {
      String data = fileScanner.nextLine();
      int pizzanumber = Integer.parseInt(data.substring(0, 2));
      int numberOfBuys = Integer.parseInt(data.substring(3));

      myStats[pizzanumber - 1] = numberOfBuys;
    }
    return myStats;
  }

  public int loadOrderNumberFromFile() throws FileNotFoundException {
    Scanner file = new Scanner(new File("OrderNumber.txt"));
    int number = 0;
    while (file.hasNextLine()) {
      number = Integer.parseInt(file.next());
    }
    return number;

  }

  public int loadRenenueFromFile() throws FileNotFoundException {
    Scanner file = new Scanner(new File("Revenue.txt"));
    int number = 0;
    while (file.hasNextLine()) {
      number = Integer.parseInt(file.next());
    }
    return number;
  }
}
