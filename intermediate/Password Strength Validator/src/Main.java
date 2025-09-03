import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int option = 0;
        while(option!=1) {

            System.out.println("Please enter the password:");
            System.out.println("* Must have minimum 8 characthers");
            System.out.println("* One UpperCase letter");
            System.out.println("* One LowerCase letter");
            System.out.println("* One number");
            System.out.println("* One Special characther i.e: !@#$%");

            String pw = scanner.nextLine();


            boolean passed = PasswordValidator.hasPassedAllTests(pw);
            System.out.println(
                    passed
                            ? "\n✅ Password meets all the requirements."
                            : "\n❌ Password failed to meet one or more requirements."
            );

            PasswordValidator.printValidationResults(pw);


            System.out.print("\nPress ENTER to try another password, or type '1' to exit: ");
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); // clear buffer
            } else {
                scanner.nextLine(); // skip invalid input
                option = 0;
            }
        }
        System.out.println("\n👋 Exiting... Goodbye!");
        scanner.close();
    }


    //REGEX METHODS
    public static boolean hasDigitsRegex(String pw) {
        return pw.matches(".*\\d.*");
    }

    public static boolean hasUpperCaseRegex(String pw){
        return pw.matches(".*[A-Z].*");
    }

    public static boolean hasLowercaseRegex(String pw) {
        return pw.matches(".*[a-z].*");
    }

    public static boolean hasSpecialCharRegex(String pw) {
        return pw.matches(".*[^a-zA-Z0-9].*");
    }

}