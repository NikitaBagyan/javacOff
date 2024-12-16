package src.test.Week2.PokemonBattle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.Week2.PokemonBattle.Pokemon;

public class PokemonTest {
    private Pokemon attacker;
    private Pokemon defender;

    public PokemonTest() {
    }

    @BeforeEach
    void setUp() {
        this.attacker = new Pokemon();
        this.defender = new Pokemon();
        this.attacker.name = "Charizard";
        this.attacker.level = 10;
        this.attacker.element = "Fire";
        this.attacker.health = 100;
        this.attacker.baseDamage = 20;
        this.defender.name = "Bulbasaur";
        this.defender.level = 8;
        this.defender.element = "Grass";
        this.defender.health = 100;
        this.defender.baseDamage = 15;
    }

    @Test
    void notNullPokemon() {
        Pokemon pokemon = new Pokemon();
        Assertions.assertNotNull(pokemon);
    }

    @Test
    void notPokemonNullParameters() {
        Pokemon pokemon = new Pokemon();
        Assertions.assertNotNull(pokemon.name);
        Assertions.assertNotNull(pokemon.level);
        Assertions.assertNotNull(pokemon.element);
        Assertions.assertNotNull(pokemon.health);
        Assertions.assertNotNull(pokemon.baseDamage);
        Assertions.assertNotNull(pokemon.spells);
        Assertions.assertNotNull(pokemon.isDefense);
    }

    @Test
    void testAttack() {
        int initialHelth = this.defender.health;
        this.attacker.attack(this.defender);
        Assertions.assertEquals(initialHelth - this.attacker.baseDamage, this.defender.health);
    }

    @Test
    void testUseAttackSpell() {
        int initialHelth = this.defender.health;
        this.attacker.useAttackSpell(this.defender);
        Assertions.assertTrue(this.defender.health < initialHelth);
    }

    @Test
    void testUseHillSpell() {
        int initialHeal = this.defender.health;
        Pokemon var10000 = this.defender;
        var10000.health -= 20;
        this.defender.useHillSpell();
        Assertions.assertTrue(this.defender.health > initialHeal - 20);
    }

    @Test
    void testUseDefenceSpell() {
        this.defender.isDefense = false;
        this.defender.useDefenceSpell();
        Assertions.assertTrue(this.defender.isDefense);
    }
}
