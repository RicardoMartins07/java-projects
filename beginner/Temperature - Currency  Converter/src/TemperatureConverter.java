import java.util.Scanner;

public class TemperatureConverter {

    int option = 0;
    boolean valid = false;
    private Scanner scanner;

    public TemperatureConverter(Scanner scanner) {
        this.scanner= scanner;
    }

    public void showMenu(){

        while (!valid) {

            System.out.println("Which pair of Temperature Units you want to convert?");
            System.out.println("1 - Cº/Fahrenheit");
            System.out.println("2 - Fahrenheit/Kelvin");
            System.out.println("3 - Cº/Kelvin");

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
                System.out.printf("Fahrenheit: %.2f", Celsius_to_Fahrenheit_Converter());
                break;
            case 2:
                System.out.printf("Kelvin: %.2f", Fahrenheit_to_Kelvin_Converter());
                break;
            case 3:
                System.out.printf("Kelvin: %.2f", Celsius_to_Kelvin_Converter());
                break;
        }
    }

    public double Celsius_to_Fahrenheit_Converter(){
        double temperature = getValidTemperature(scanner,"Celsius");
        return (temperature * 1.8) + 32 ;

    }

    public double Fahrenheit_to_Kelvin_Converter(){
        double temperature = getValidTemperature(scanner,"Fahrenheit");
        return (temperature + 459.67) / 1.8 ;
    }

    public double Celsius_to_Kelvin_Converter(){
        double temperature = getValidTemperature(scanner,"Cº");
        return temperature + 273.15 ;
    }

    public static double getValidTemperature(Scanner scanner, String degrees) {
        double temperature = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print("Temperature in " + degrees + " :");
            if (scanner.hasNextDouble()) {
                temperature = scanner.nextDouble();
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return temperature;
    }
}
