import java.util.Scanner;

public class CurrencyConverter {
    int option = 0;
    boolean valid = false;
    private Scanner scanner;

    public CurrencyConverter(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMenu(){

        while (!valid) {

            System.out.println("Which pair of currency you want to convert?");
            System.out.println("1 - EUR/USD");
            System.out.println("2 - USD/GBP");
            System.out.println("3 - EUR/GBP");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option == 1 || option == 2 || option == 3 ) {
                    valid = true;
                } else {
                    System.out.println("Invalid option. Please enter 1, 2 or 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        switch (option){

            case 1:
                System.out.printf("USD: %.2f", EUR_to_USD_Converter());
                break;
            case 2:
                System.out.printf("GBP: %.2f", USD_to_GBP_Converter());
                break;
            case 3:
                System.out.printf("GBP: %.2f", EUR_to_GBP_Converter());
                break;
        }


    }

    public double EUR_to_USD_Converter(){
        double EUR = getValidAmount(scanner,"EUR");
        return EUR * 1.12 ;

    }

    public double USD_to_GBP_Converter(){
        double USD = getValidAmount(scanner,"USD");
        return USD * 0.75 ;
    }

    public double EUR_to_GBP_Converter(){
        double EUR = getValidAmount(scanner,"EUR");
        return EUR * 0.84 ;
    }

    public static double getValidAmount(Scanner scanner, String currency) {
        double amount = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print("Amount of " + currency);
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount >= 0) {
                    valid = true;
                } else {
                    System.out.println("Amount must be positive.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return amount;
    }



}
