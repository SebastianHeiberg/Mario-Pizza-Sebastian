package company;

import java.util.ArrayList;

public class Pizza {

  private final String name;
  private final int menuNumber;
  private final int price;
  private final ArrayList<Topping> toppings;

  public Pizza(String name, int menuNumber, int price) {
    this.name = name;
    this.menuNumber = menuNumber;
    this.price = price;
    this.toppings = new ArrayList<>();
  }

  public String getName() {
    return this.name;
  }

  public int getPrice() {
    return price;
  }

  public ArrayList<Topping> getToppings() {
    return toppings;
  }

  public void addToppings(ArrayList<Topping> toppings) {
    this.toppings.addAll(toppings);
  }

  public int getMenuNumber() {
    return menuNumber;
  }
  }
