package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Player extends Character {

    private final List<Item> inventory;

    public Player(String name) {
        super(name, 100, 20);
        this.inventory = new ArrayList<>();
    }

    @Override
    public void attack(Character target) {
        int damage = attackPower;
        System.out.println(name + " attacks " + target.getName() + " with a sword and deals " + damage + " damage!");
        target.takeDamage(damage);
    }

    public void run() {
        System.out.println(name + " escaped!");
    }

    // ---- Inventário ----


    public boolean addItemToInventory(Item item) {
        Objects.requireNonNull(item, "item cannot be null");
        return inventory.add(item);
    }


    public boolean removeItemFromInventory(Item item) {
        return inventory.remove(item);
    }


    public void checkInventory() {
        if (inventory.isEmpty()) {
            System.out.println(name + " has no items in the inventory.");
            return;
        }
        System.out.println(name + "'s Inventory:");
        for (Item i : inventory) {
            System.out.println("- " + i);
        }
    }


    public List<Item> getInventory() {
        return Collections.unmodifiableList(inventory);
    }


    @Override
    public String toString() {
        return "Player{name='" + name + "', hp=" + health + ", attack=" + attackPower + ", items=" + inventory.size() + "}";
    }

    public void heal(int amount) {
        this.health += amount;
        if (this.health > 100) {
            this.health = 100;
        }
    }

}
