package src.main.Week2.PokemonBattle;

import src.main.Week2.PokemonBattle.Spells.Spell;

public class Pokemon {
    public String name;
    public int level;
    public String element;
    public int health;
    public int baseDamage;
    public Spell spells;
    public boolean isDefense;

    public Pokemon() {
        StatsGenerator statsGenerator = new StatsGenerator();
        statsGenerator.generate(this);
    }

    public void attack(Pokemon opponent) {
        opponent.takeDamage(this.baseDamage);
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void useAttackSpell(Pokemon opponent) {
        this.spells.Attack(opponent);
    }

    public void useHillSpell() {
        this.health += this.spells.healing(this);
    }

    public void useDefenceSpell() {
        this.isDefense = this.spells.shieldUse();
    }
}
