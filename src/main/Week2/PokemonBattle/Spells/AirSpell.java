package src.main.Week2.PokemonBattle.Spells;

import src.main.Week2.PokemonBattle.Pokemon;

public class AirSpell extends Spell {
    public AirSpell() {
    }

    public void Attack(Pokemon target) {
        System.out.println("Как порыв ветра, я пронзаю все на своем пути!");
        setCooldown(3);
        target.takeDamage(10);
    }

    public boolean shieldUse() {
        System.out.println("Воздушный поток окружает меня, не подпуская никого близко!");
        setCooldown(5);
        return true;
    }

    public int healing(Pokemon target) {
        System.out.println("Как порыв ветра, я пронзаю все на своем пути!");
        setCooldown(8);
        return 20;
    }

    public String toString() {
        return "Ваш покемон использует огненные способности";
    }
}
