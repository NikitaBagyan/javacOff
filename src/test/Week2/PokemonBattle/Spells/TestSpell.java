package src.test.Week2.PokemonBattle.Spells;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.Week2.PokemonBattle.Spells.FireSpell;
import src.main.Week2.PokemonBattle.Spells.Spell;

public class TestSpell {
    private Spell spell;

    public TestSpell() {
    }

    @BeforeEach
    void setUp() {
        this.spell = new FireSpell();
    }

    @Test
    void getCooldownTest() {
        this.spell.currentCooldown = 10;
        Assertions.assertEquals(this.spell.getCooldown(), this.spell.currentCooldown);
    }

    @Test
    void decreaseCooldownTest() {
        this.spell.currentCooldown = 10;
        int initionalCooldown = this.spell.currentCooldown;
        this.spell.decreaseCooldown();
        Assertions.assertTrue(this.spell.currentCooldown < initionalCooldown);
    }
}
