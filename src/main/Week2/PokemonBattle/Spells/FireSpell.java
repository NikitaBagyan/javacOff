package src.main.Week2.PokemonBattle.Spells;

import src.main.Week2.PokemonBattle.Pokemon;

public class FireSpell extends Spell {
    String element = "Fire";

    public FireSpell() {
    }

    public void Attack(Pokemon target) {
        System.out.println("Вместе с жаром моей ярости, впусти в свой мир огненный шар!");
        setCooldown(3);
        target.takeDamage(10);
    }

    public boolean shieldUse() {
        System.out.println("Огненная стена, защити меня от злых взглядов!");
        setCooldown(5);
        return true;
    }

    public int healing(Pokemon target) {
        System.out.println("Пусть жар огня исцелит меня, даруя новые силы!");
        setCooldown(8);
        return 20;
    }

    public String toString() {
        return "Ваш покемон использует огненные способности";
    }
}
