package company;

import java.util.ArrayList;


public class OrderList {

  private ArrayList<Order> listOfOrders;

  public OrderList() {
    this.listOfOrders = new ArrayList<>();
  }

  public void addOrder(Order newOrder) {
    listOfOrders.add(newOrder);
  }

  public ArrayList<Order> getListOfOrders() {
    return listOfOrders;
  }

  public boolean removeOrder(int orderNumber) {
    for (int i = this.listOfOrders.size() - 1; i >= 0; i--) {
      Order order = listOfOrders.get(i);
      if (orderNumber == order.getOrderNumber()) {
        listOfOrders.remove(order);
        return true;
      }
    }
    return false;
  }

}
