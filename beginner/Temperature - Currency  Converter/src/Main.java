import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int option = 0;
        boolean valid = false;

        Scanner scanner = new Scanner(System.in);

        while (!valid) {

            System.out.println("Choose an option to continue:");
            System.out.println("1 - Temperatue Converter");
            System.out.println("2 - Currency Converter");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option == 1 || option == 2 ) {
                    valid = true;
                } else {
                    System.out.println("Invalid option. Please enter 1 or 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        if (option == 1){
            TemperatureConverter temperatureConverter = new TemperatureConverter(scanner);
            temperatureConverter.showMenu();
        }
        else {
            CurrencyConverter currencyConverter = new CurrencyConverter(scanner);
            currencyConverter.showMenu();
        }



        scanner.close();



    }


}