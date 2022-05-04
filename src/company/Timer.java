package company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer {

  public String pickupTime() {
    int minTime = 600000;
    int maxTime = 3600000;
    int randomTime = (int) Math.floor(Math.random() * (maxTime - minTime + 1) + minTime);

    // Timeren viser en time senere (altså hvornår pizzaen skal afhentes (3600000 er en time i millisekunder))
    Date date = new Date(System.currentTimeMillis() + randomTime);
    return new SimpleDateFormat("hh:mm").format(date);
  }

}
