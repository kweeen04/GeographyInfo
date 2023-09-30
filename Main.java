import controller.Management;
import model.ManageEastAsiaCountries;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        ManageEastAsiaCountries manage = new ManageEastAsiaCountries();
        Menu menu = new Menu();
        Management controller = new Management(manage, menu);

        controller.run();
    }
}
