package controller;

import model.EastAsiaCountries;
import model.ManageEastAsiaCountries;
import view.Menu;

public class Management {
    private ManageEastAsiaCountries manage;
    private Menu menu;

    public Management(ManageEastAsiaCountries manage, Menu menu) {
        this.manage = manage;
        this.menu = menu;
    }

    public void run() {
        int choice;
        do {
            choice = menu.displayMenu();
            switch (choice) {
                case 1:
                    addCountryInfo();
                    break;
                case 2:
                    displayRecentEnteredInfo();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    displaySortedInfo();
                    break;
                case 5:
                    System.out.println("Exiting the program..");
                    break;
                default:
                    System.out.println("Invalid choice. Please input again.");
            }
        } while (choice != 5);
    }

    private void addCountryInfo() {
        try {
            EastAsiaCountries country = menu.inputCountryInfo();
            manage.addInfo(country);
            System.out.println("Country added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " +e.getMessage());
        }
    }

    private void displayRecentEnteredInfo() {
        try {
            EastAsiaCountries[] recentEnteredInfo = manage.getRecentEnteredInfo();
            menu.displayInfo(recentEnteredInfo);
        } catch (Exception e) {
            System.out.println("Error: " +e.getMessage());
        }
    }

    private void searchByName() {
        try {
            String searchName = menu.searchByName();
            EastAsiaCountries[] searchResult = manage.searchByName(searchName);
            menu.displayInfo(searchResult);
        } catch (Exception e) {
            System.out.println("Error: " +e.getMessage());
        }
    }

    private void displaySortedInfo() {
        try {
            EastAsiaCountries[] sortedInfo = manage.sortAscend();
            menu.displayInfo(sortedInfo);
        } catch (Exception e) {
            System.out.println("Error: " +e.getMessage());
        }
    }
}
