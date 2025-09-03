package Model;

public class Enemy extends Character {

    public Enemy(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " strikes " + target.getName() + " with claws!");
        target.takeDamage(attackPower);
    }
}

