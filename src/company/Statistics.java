package company;

public class Statistics {
  private int [] menuArray;

  public Statistics(int sizeOfArray) {
    this.menuArray = new int [sizeOfArray];
  }

  public void setMenuArrayItem (int menuItemNumber){
    menuArray[menuItemNumber-1] ++;
  }

  public int[] getMenuArray() {
    return menuArray;
  }

  public void setMenuArray(int[] menuArray) {
    this.menuArray = menuArray;
  }
}
