package src.main.Week2.PokemonBattle.Spells;

import src.main.Week2.PokemonBattle.Pokemon;

public class WaterSpell extends Spell {
    public WaterSpell() {
    }

    public void Attack(Pokemon target) {
        System.out.println("Сила океана в моих руках! Почувствуй мощь водного потока!");
        setCooldown(3);
        target.takeDamage(10);
    }

    public boolean shieldUse() {
        System.out.println("Вода окружает меня, создавая непреодолимый барьер!");
        setCooldown(5);
        return true;
    }

    public int healing(Pokemon target) {
        System.out.println("Пусть чистая вода вернёт мне силу и унесёт мою боль!");
        setCooldown(8);
        return 20;
    }

    public String toString() {
        return "Ваш покемон использует огненные способности";
    }
}
