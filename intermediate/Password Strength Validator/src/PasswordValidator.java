public class PasswordValidator {

    public static boolean hasMinimumCharacters(String pw){

        return pw.length() >= 8;

    }

    public static boolean hasUpperCaseLetter(String pw){
        for (int i=0; i<pw.length(); i++) {
            char c = pw.charAt(i);
            if(Character.isUpperCase(c)){
                return true;
            }
        }

        return false;
    }

    public static boolean hasLowerCaseLetter(String pw){
        for (int i=0; i<pw.length(); i++) {
            char c = pw.charAt(i);
            if(Character.isLowerCase(c)){
                return true;
            }
        }

        return false;
    }

    public static boolean hasDigits(String pw){
        for (int i=0; i<pw.length(); i++) {
            char c = pw.charAt(i);
            if(Character.isDigit(c)){
                return true;
            }
        }

        return false;
    }

    public static boolean hasSpecialCharacter (String pw){
        for (int i=0; i<pw.length(); i++) {
            char c = pw.charAt(i);
            if(!Character.isLetterOrDigit(c)){
                return true;
            }
        }

        return false;

    }

    public  static boolean hasPassedAllTests(String pw){

        return hasDigits(pw) && hasLowerCaseLetter(pw) && hasUpperCaseLetter(pw) && hasMinimumCharacters(pw) && hasSpecialCharacter(pw);
    }

    public static void printValidationResults(String pw) {
        System.out.println("\nMinimum length (8): " + hasMinimumCharacters(pw) + " ,Current Length: "+pw.length());
        System.out.println("Uppercase letter: " + hasUpperCaseLetter(pw));
        System.out.println("Lowercase letter: " + hasLowerCaseLetter(pw));
        System.out.println("Digit: " + hasDigits(pw));
        System.out.println("Special character: " + hasSpecialCharacter(pw));
        System.out.println("✅ Passed all tests: " + hasPassedAllTests(pw));
    }



}
