package src.main.Week2.PokemonBattle.Spells;

import src.main.Week2.PokemonBattle.Pokemon;

public abstract class Spell {
    int damage;
    String element;
    public int currentCooldown;

    public Spell() {
    }

    public int getCooldown() {
        return this.currentCooldown;
    }

    public void decreaseCooldown() {
        if (this.currentCooldown > 0) {
            --this.currentCooldown;
        }

    }
    public void setCooldown(int cooldown) {
        currentCooldown = cooldown;
    }

    public abstract void Attack(Pokemon var1);

    public abstract boolean shieldUse();

    public abstract int healing(Pokemon var1);

}
