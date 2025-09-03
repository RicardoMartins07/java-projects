package Model;



public class SuperHealingPotion extends Item {
    private final int healAmount = 50;

    public SuperHealingPotion() {
        super("Healing Potion", "Adds 50 HP to Hero");
    }

    @Override
    public void use(Player player) {
        player.heal(healAmount);
        System.out.println(player.getName() + " drinks a Healing Potion and restores " + healAmount + " HP!");
    }
}
