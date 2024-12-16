package src.main.Week2.PokemonBattle.Spells;

import src.main.Week2.PokemonBattle.Pokemon;

public class EarthSpell extends Spell {
    public EarthSpell() {
    }

    public void Attack(Pokemon target) {
        System.out.println("Сила гор обрушится на тебя! Встреть мою каменную ярость!");
        setCooldown(3);
        target.takeDamage(10);
    }

    public boolean shieldUse() {
        System.out.println("Твёрдость скалы станет моей защитой!");
        setCooldown(5);
        return true;
    }

    public int healing(Pokemon target) {
        System.out.println("Сила природы поднимет меня вновь и исцелит мои раны!");
        setCooldown(8);
        return 20;
    }

    public String toString() {
        return "Ваш покемон использует огненные способности";
    }
}
