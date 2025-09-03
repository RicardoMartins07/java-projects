# RPG Battle Game (Java)

A small RPG project in Java where a **Player** faces an **Enemy** in a turn-based battle.  
The player can attack, use items from the inventory (like **Healing Potions**), or run away from the fight.

---


---

## ⚔️ Implemented Features

- **Player**
    - Starts with 100 HP and 20 attack power.
    - Inventory system using `List<Item>`.
    - Can add and remove items from inventory.
    - Methods for attacking, running, and healing (`heal(int)`).

- **Enemy**
    - Created with name, HP, and attack power.
    - Automatically attacks the player if still alive.

- **Item / HealingPotion**
    - Abstract `Item` system with method `use(Player player)`.
    - `HealingPotion` restores 30 HP to the player and is consumed after use.

- **Main**
    - Turn-based battle loop.
    - Console interactive menu:
        - Attack with sword.
        - Use item from inventory (list and select).
        - Run away.
    - Input validation for user choices.
    - Prints the current status (HP of Player and Enemy each turn).

---

## ✨ Example Gameplay
=== Battle Start ===

---------------------------
Hero HP: 100

Goblin HP: 50

---------------------------

Hero's turn. Choose an action:

1 - Attack with sword

2 - Use item from Inventory

3 - Run

---------------------------

## 🔮 Possible Improvements

- **Code structure**

  - Create a sub-package model.items to better organize items.

  - Implement Armor or Sword classes to increase defense/attack.

  - Add a maximum HP and prevent overhealing.

  - Use an enum for Player actions instead of "magic numbers".
  

- **Gameplay**

    - Multiple enemies in sequence or in groups.

    - Different enemy types with abilities (special attacks, defense, etc.).

    - Experience and leveling system for the Player.

    - Differentiate items between consumables (potions) and equipables (weapons, armor).

- **Interface**

     - Improve status messages to also display equipped items.

     - More detailed battle logs.


## ▶️ How to Run

1. Compile:
   ```bash
   javac Main.java model/*.java


