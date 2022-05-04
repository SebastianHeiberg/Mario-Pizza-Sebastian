package company;

import java.util.ArrayList;

public class Menucard {

  private final ArrayList<Pizza> menuCard;

  public Menucard() {
    this.menuCard = new ArrayList<>();
  }

  public ArrayList<Pizza> getMenuCard() {
    return this.menuCard;
  }

  public Pizza findPizzaByMenuNumber(int pizzaChoice) {
    for (Pizza pizza : menuCard) {
      if (pizza.getMenuNumber() == pizzaChoice) {
        return pizza;
      }
    }
    return null;
  }


  public void addToMenu(Pizza pizza) {
    menuCard.add(pizza);
  }
}

