package company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
  public final Scanner sc = new Scanner(System.in);

  public String userInputName(){
    System.out.print("Input name of costumer: ");
    return sc.next();
  }

  public void displayOrderRemoved () {
    System.out.println("Order removed.");
  }

  public void displayOrderNotFound () {
    System.out.println("Order not found.");
  }

  public void displayMenu () {

    System.out.printf("""

        Display the Menu  : 1
        Add Order         : 2
        View Orders       : 3
        Remove Order      : 4
        Pizza statistics  : 5
        Total Revenue     : 6
        Exit program      : 10
        
        """);
  }

  public void displayStats (Statistics myStat){

    System.out.println("\nThis is the current stats of pizzas sold:");
    for (int i = 0; i < myStat.getMenuArray().length; i++) {
      System.out.printf("\nPizza number %-2d has been sold %d times",i+1,myStat.getMenuArray()[i]);
    }
    System.out.println();
  }

  public int userIndputNumber() {
    System.out.print("Input choice: ");

    try {
      return sc.nextInt();
    } catch (InputMismatchException OIN) {
      System.out.println("Only input numbers");
    }
    sc.next();
    return 0;
  }

  public int userIndputPizzaMenuNumber() {
    System.out.println();
    System.out.println("Input 0 to end the Order.");
    System.out.print("Else input menu number of the pizza: ");
    int pizzaNumber = 0;
    try {
      pizzaNumber = sc.nextInt();
    } catch (InputMismatchException ON) {
      System.out.println("only numbers allowed, try again.");
    }
    return pizzaNumber;
  }

  public void displayOrderList(ArrayList<Order> liste){

    for (int i = 0; i < liste.size(); i++) {

      Order temp = liste.get(i);
      ArrayList<Pizza> pizzaInOrder = temp.getOrderItems();
      System.out.printf("""
          Ordrenummer:      %d
          Pickuptime:       %s
          Name:             %s
          Price total:      %d kr
          
          """, temp.getOrderNumber(), temp.getPickUpTime(), temp.getCostumerName(), temp.getTotalPrice());

      for (Pizza pizza : pizzaInOrder) {
      System.out.printf("""
          Pizza name:       %s
          Pizza toppings:   %s
          
          """, pizza.getName(),pizza.getToppings());
    }
    }
  }

  public void printInvalidChoice(){
    System.out.println("Invalid choice");
  }

  public void printMenu(Menucard menuCard) {
    String dot = ".";

    for (Pizza pizza : menuCard.getMenuCard()) {
      System.out.printf("""
          %d. %s %s %d kr
          """, pizza.getMenuNumber(), pizza.getName(), dot.repeat(60 - (pizza.getName().length())), pizza.getPrice());
      System.out.println(pizza.getToppings() + "\n");
    }
  }

  public int removeOrder(){
    System.out.println("Input number of order you want to remove");
    return sc.nextInt();
  }

  public void displayRevenue(int revenue) {
    System.out.println("\nTotal revenue: " + revenue + " kr.");
  }
}
