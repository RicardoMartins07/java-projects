import Model.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Player and enemy Creation
        Player player = new Player("Hero");
        Enemy goblin = new Enemy("Goblin", 50, 10);

        //Items
        HealingPotion healingPotion = new HealingPotion();
        player.addItemToInventory(healingPotion);
        SuperHealingPotion superHealingPotion = new SuperHealingPotion();
        player.addItemToInventory(superHealingPotion);

        System.out.println("=== Battle Start ===");

        //Fight until they're still alive
        while (player.isAlive() && goblin.isAlive()) {
            printStatus(player, goblin);

            boolean actionDone = heroTurn(scanner, player, goblin);
            if (!actionDone) {
                continue;
            }

            if (goblin.isAlive()) {
                goblin.attack(player);
            }
        }

        //Battle Ends
        System.out.println("\n=== Battle Result ===");
        if (player.isAlive()) {
            System.out.println(player.getName() + " wins!");
        } else {
            System.out.println(goblin.getName() + " wins!");
        }
    }

    private static void printStatus(Player player, Enemy goblin) {
        System.out.println("\n---------------------------");
        System.out.println(player.getName() + " HP: " + player.getHealth());
        System.out.println(goblin.getName() + " HP: " + goblin.getHealth());
        System.out.println("---------------------------");
    }


    public static boolean heroTurn(Scanner scanner, Player player, Enemy goblin) {
        System.out.println("\nHero's turn. Choose an action:");
        System.out.println("1 - Attack with sword");
        System.out.println("2 - Use item from Inventory");
        System.out.println("3 - Run");

        int option = readIntInRange(scanner, 1, 3, "Invalid option, please choose 1, 2 or 3:");

        switch (option) {
            case 1:
                player.attack(goblin);
                return true;

            case 2:
                return handleUseItem(scanner, player);

            case 3:
                player.run();
                System.exit(0);
                return true;

            default:
                return false;
        }
    }

    private static boolean handleUseItem(Scanner scanner, Player player) {
        List<Item> inventory = player.getInventory();

        if (inventory.isEmpty()) {
            System.out.println(player.getName() + " has no items in the inventory.");
            return false;
        }

        System.out.println("\n" + player.getName() + "'s Inventory:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + " - " + inventory.get(i));
        }
        System.out.println("0 - Cancel");

        int choice = readIntInRange(scanner, 0, inventory.size(),
                "Invalid option, choose between 0 and " + inventory.size() + ":");

        if (choice == 0) {
            System.out.println("Cancelled.");
            return false;
        }

        Item chosen = inventory.get(choice - 1);

        chosen.use(player);

        player.removeItemFromInventory(chosen);

        return true;
    }

    private static int readIntInRange(Scanner scanner, int min, int max, String invalidMsg) {
        Integer val = null;
        while (val == null) {
            if (scanner.hasNextInt()) {
                int candidate = scanner.nextInt();

                scanner.nextLine();
                if (candidate >= min && candidate <= max) {
                    val = candidate;
                } else {
                    System.out.println(invalidMsg);
                }
            } else {
                System.out.println("Please enter a number.");
                scanner.nextLine();
            }
        }
        return val;
    }
}
