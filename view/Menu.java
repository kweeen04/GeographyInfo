package view;

import java.util.Scanner;
import model.EastAsiaCountries;

public class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }


    public int displayMenu() {
        System.out.println("========================MENU=========================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("======================================================================");
        System.out.print("Please choose an option: ");
        return scanner.nextInt();
    }


    public EastAsiaCountries inputCountryInfo() {
        scanner.nextLine();
        System.out.print("Input code of country: ");
        String countryCode = scanner.nextLine();
        System.out.print("Input name of country: ");
        String countryName = scanner.nextLine();
        System.out.print("Input total area: ");
        float totalArea = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Input terrain of country: ");
        String countryTerrain = scanner.nextLine();
        return new EastAsiaCountries(countryCode, countryName, totalArea, countryTerrain);
    }


    public void displayInfo(EastAsiaCountries[] countries) {
        if (countries.length == 0) {
            System.out.println("No country's information available.");
            return;
        }
        System.out.printf("%-15s%-15s%-15s%-15s\n", "Code", "Name", "Total area", "Terrain");
        for (EastAsiaCountries country : countries) {
            if (country != null) {
                country.display();
            }
        }
    }

    
    public String searchByName() {
        scanner.nextLine();
        System.out.print("Enter country's name to search: ");
        return scanner.nextLine();
    }
}
