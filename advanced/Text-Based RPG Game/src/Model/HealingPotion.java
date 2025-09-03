package Model;

import Model.Item;
import Model.Player;

public class HealingPotion extends Item {
    private final int healAmount = 30;

    public HealingPotion() {
        super("Healing Potion", "Adds 30 HP to Hero");
    }

    @Override
    public void use(Player player) {
        player.heal(healAmount);
        System.out.println(player.getName() + " drinks a Healing Potion and restores " + healAmount + " HP!");
    }
}
