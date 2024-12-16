package src.main.Week2.PokemonBattle;

import java.util.Random;

public class BattleArena {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private final Random random = new Random();

    public BattleArena(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public void startBattle() {
        System.out.println("Бой начинается между " + this.pokemon1.name + " и " + this.pokemon2.name);

        while (this.pokemon1.health > 0 && this.pokemon2.health > 0) {
            this.takeTurn(this.pokemon1, this.pokemon2);
            if (this.pokemon2.health > 0) {
                this.takeTurn(this.pokemon2, this.pokemon1);
            }
        }

        this.declareWinner();
    }

    private void takeTurn(Pokemon attacker, Pokemon defender) {
        System.out.println("\n" + attacker.name + " атакует " + defender.name);
        if (attacker.spells.getCooldown() == 0) {
            boolean useShield = this.random.nextBoolean();
            if (useShield && attacker.spells.shieldUse()) {
                System.out.println(attacker.name + " использует щит!");
                attacker.isDefense = true;
            } else {
                attacker.useAttackSpell(defender);
            }
        } else {
            System.out.println(attacker.name + " не может использовать способность, так как идет перезарядка.");
            this.performAttack(attacker, defender);
        }

        this.displayStatus(attacker);
        this.displayStatus(defender);
        attacker.spells.decreaseCooldown();
    }

    private void performAttack(Pokemon attacker, Pokemon defender) {
        int baseDamage = attacker.baseDamage;
        double damageMultiplier = this.calculateDamageMultiplier(attacker.element, defender.element);
        int damage = (int) ((double) baseDamage * damageMultiplier);
        if (defender.isDefense) {
            damage /= 2;
            System.out.println(defender.name + " уменьшает урон благодаря защите!");
        }

        defender.takeDamage(damage);
        System.out.println(attacker.name + " наносит " + damage + " урона " + defender.name);
        defender.isDefense = false;
    }

    private double calculateDamageMultiplier(String attackerElement, String defenderElement) {
        if (attackerElement.equals("Fire") && defenderElement.equals("Earth")) {
            return 1.5;
        } else if (attackerElement.equals("Water") && defenderElement.equals("Fire")) {
            return 1.5;
        } else if (attackerElement.equals("Earth") && defenderElement.equals("Air")) {
            return 1.5;
        } else if (attackerElement.equals("Air") && defenderElement.equals("Water")) {
            return 1.5;
        } else if (defenderElement.equals("Fire") && attackerElement.equals("Water")) {
            return 0.75;
        } else if (defenderElement.equals("Water") && attackerElement.equals("Air")) {
            return 0.75;
        } else if (defenderElement.equals("Earth") && attackerElement.equals("Fire")) {
            return 0.75;
        } else {
            return defenderElement.equals("Air") && attackerElement.equals("Earth") ? 0.75 : 1.0;
        }
    }

    private void displayStatus(Pokemon pokemon) {
        System.out.println("\nСостояние " + pokemon.name + ":");
        int var10001 = pokemon.health < 0 ? 0 : pokemon.health;
        System.out.println("  Здоровье: " + var10001);
        System.out.println("  Уровень: " + pokemon.level);
        System.out.println("  Элемент: " + pokemon.element);
        System.out.println("  Защита активна: " + pokemon.isDefense);
        System.out.println("  Текущий кулдаун заклинания: " + pokemon.spells.getCooldown());
    }

    private void declareWinner() {
        if (this.pokemon1.health <= 0) {
            System.out.println("\n" + this.pokemon2.name + " побеждает в бою!");
        } else if (this.pokemon2.health <= 0) {
            System.out.println("\n" + this.pokemon1.name + " побеждает в бою!");
        }

    }

    public static void main(String[] args) {
        Pokemon pokemon1 = new Pokemon();
        Pokemon pokemon2 = new Pokemon();
        BattleArena arena = new BattleArena(pokemon1, pokemon2);
        arena.startBattle();
    }
}
