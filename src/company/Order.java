package company;

import java.util.ArrayList;

public class Order {
  private final String pickUpTime;
  private int totalPrice;
  private int orderNumber;
  private final String costumerName;
  private final ArrayList<Pizza> orderItems;

  public Order(String pickUpTime, String costumerName, int orderNumber) {
    this.pickUpTime = pickUpTime;
    this.costumerName = costumerName;
    this.totalPrice = 0;
    this.orderNumber = orderNumber;
    this.orderItems = new ArrayList<>();
  }

  public void addPizzaToNewOrder(Menucard menuCard, Statistics myStat, int pizzaOfChoiceMenuNumber) {

    if (pizzaOfChoiceMenuNumber > 0 && pizzaOfChoiceMenuNumber < menuCard.getMenuCard().size()) {
      Pizza chosenPizza = menuCard.findPizzaByMenuNumber(pizzaOfChoiceMenuNumber);
      this.addPizzaToOrder(chosenPizza);
      myStat.setMenuArrayItem(pizzaOfChoiceMenuNumber);
    } else if (pizzaOfChoiceMenuNumber == 0){
      this.setOrderNumber();
    }
  }

  public void addPizzaToOrder(Pizza chosenPizza) {
    orderItems.add(chosenPizza);
  }

  public String getCostumerName() {
    return costumerName;
  }

  public int getTotalPrice() {
    for (Pizza pizza : orderItems) {
      totalPrice += pizza.getPrice();
    }
    return totalPrice;
  }

  public ArrayList<Pizza> getOrderItems() {
    return orderItems;
  }

  public int getOrderNumber() {
    return orderNumber;
  }

  private void setOrderNumber() {
    this.orderNumber ++;
  }

  public String getPickUpTime() {
    return pickUpTime;
  }

}
