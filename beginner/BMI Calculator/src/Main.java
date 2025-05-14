import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        /*Variable declaration*/

        double weight;
        float height;
        boolean  isOptionValid = false;
        double bmi;


        /*Scanner for  user Input*/
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("Please choose whether you prefer KG or Lbs:");
            System.out.println("1 - KG");
            System.out.println("2 - Lbs");

            int option = scanner.nextInt();

            switch(option) {
                case 1:
                    weight = getWeight(scanner);
                    height = getHeight(scanner);
                    if (!isValidData(weight, height)) {
                        break;
                    }
                    bmi = BMI_Calcs_Kg(weight, height);
                    System.out.printf("Your BMI is: %.2f (%s)", bmi, classifyBMI(bmi));
                    isOptionValid = true;
                    break;
                case 2:
                    weight = getWeight(scanner);
                    height = getHeight(scanner);
                    if (!isValidData(weight, height)) {
                        break;
                    }
                    bmi = BMI_Calcs_Lbs(weight, height);
                    System.out.printf("Your BMI is: %.2f (%s)", bmi, classifyBMI(bmi));
                    isOptionValid = true;
                    break;
                default:
                    System.out.println("Please choose a valid option");
            }

        }while (!isOptionValid);
        scanner.close();

    }

    public static double BMI_Calcs_Kg(double weight, float height){
        return weight / (height*height);
    }

    public static double BMI_Calcs_Lbs(double weight, float height){
        return (weight * 703) / (height*height);
    }

    public static double getWeight(Scanner scanner) {
        System.out.print("What's your weight? ");
        return scanner.nextDouble();
    }

    public static float getHeight(Scanner scanner) {
        System.out.print("What's your height? (e.g. 1.70 in meters or inches) ");
        return scanner.nextFloat();
    }

    public static boolean isValidData(double weight, float height){
        if (weight <= 0 || height <= 0) {
            System.out.println("Invalid input. Weight and height must be positive numbers.");
            return false;
        }
        return  true;
    }

    public static String classifyBMI(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 24.9) return "Normal weight";
        if (bmi < 29.9) return "Overweight";
        return "Obese";
    }


}