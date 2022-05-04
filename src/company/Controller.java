package company;

import java.io.FileNotFoundException;
import java.util.Collections;

@SuppressWarnings("SameReturnValue")
public class Controller {
  private final UserInterface ui = new UserInterface();
  private final OrderList orderList = new OrderList();
  private Menucard menuCard = new Menucard();
  private final Timer timer = new Timer();
  private final FileReader fileReader = new FileReader();
  private final FileWriter fileWriter = new FileWriter();
  private Statistics myStat;
  private int orderNumber;
  private int revenue;

  private void makeNewOrder() {

    String costumerName = ui.userInputName();
    String pickupTime = timer.pickupTime();

    Order newPizzaOrder = new Order(pickupTime, costumerName, orderNumber);
    int pizzaOfChoiceMenuNumber = 1;
    while (pizzaOfChoiceMenuNumber != 0) {
      pizzaOfChoiceMenuNumber = ui.userIndputPizzaMenuNumber();
      newPizzaOrder.addPizzaToNewOrder(menuCard, myStat, pizzaOfChoiceMenuNumber);
    }
    //Kun ordrer med noget i, går videre i systemet
    if (newPizzaOrder.getOrderItems().size() != 0) {
      orderList.addOrder(newPizzaOrder);
      orderNumber++;
      revenue += newPizzaOrder.getTotalPrice();
    }
  }

  private void showWaitingOrders() {
    TimeComparator timeComparator = new TimeComparator();
    Collections.sort(orderList.getListOfOrders(), timeComparator);
    ui.displayOrderList(orderList.getListOfOrders());
  }

  private void removeOrder() {
    boolean removed = orderList.removeOrder(ui.removeOrder());

    if (removed) {
      ui.displayOrderRemoved();
    } else {
      ui.displayOrderNotFound();
    }

  }

  private boolean exitprogramAndSaveValuesToFiles() throws FileNotFoundException {
    fileWriter.saveStatsToFile(myStat);
    fileWriter.saveOrderNumber(orderNumber);
    fileWriter.saveTotalRevenueToFile(revenue);
    return false;
  }

  private void importAllDataForSystemFromFiles() throws FileNotFoundException {

    menuCard = fileReader.loadMenuFromMenucardfile();

    myStat = new Statistics(menuCard.getMenuCard().size());
    myStat.setMenuArray(fileReader.loadStatsFromFile(myStat.getMenuArray().length));

    orderNumber = fileReader.loadOrderNumberFromFile();

    revenue = fileReader.loadRenenueFromFile();

  }

  public void mainMenu() throws FileNotFoundException {

    importAllDataForSystemFromFiles();

    boolean loop = true;
    while (loop) {

      ui.displayMenu();
      int choice = ui.userIndputNumber();

      switch (choice) {
        case 1 -> ui.printMenu(menuCard);
        case 2 -> makeNewOrder();
        case 3 -> showWaitingOrders();
        case 4 -> removeOrder();
        case 5 -> ui.displayStats(myStat);
        case 6 -> ui.displayRevenue(revenue);
        case 10 -> loop = exitprogramAndSaveValuesToFiles();
        default -> ui.printInvalidChoice();
      }

    }

  }
}
