package src.main.Week2.PokemonBattle;

import src.main.Week2.PokemonBattle.Spells.AirSpell;
import src.main.Week2.PokemonBattle.Spells.EarthSpell;
import src.main.Week2.PokemonBattle.Spells.FireSpell;
import src.main.Week2.PokemonBattle.Spells.Spell;
import src.main.Week2.PokemonBattle.Spells.WaterSpell;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StatsGenerator {
    private List<String> nameList;
    private List<String> elementList;
    Random random = new Random();

    public StatsGenerator() {
        try {
            this.nameList = Files.readAllLines(Paths.get("src/main/Week2/PokemonBattle/resources/NameList"));
            this.elementList = Files.readAllLines(Paths.get("src/main/Week2/PokemonBattle/resources/ElementList"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Pokemon generate(Pokemon pokemon) {
        int randIntName = this.random.nextInt(18);
        int randIntLevel = 5 + this.random.nextInt(16);
        pokemon.name = (String) this.nameList.get(randIntName);
        pokemon.element = this.validateElement(pokemon.name);
        pokemon.spells = this.spellValidation(pokemon.element);
        pokemon.level = randIntLevel;
        pokemon.baseDamage = (int) ((double) this.damageValidation(pokemon.element) * (double) pokemon.level * 0.25);
        pokemon.health = (int) (50.0 + 50.0 * (double) pokemon.level * 0.25);
        return pokemon;
    }

    private String validateElement(String name) {
        String resultElement = "";
        Iterator var3 = this.elementList.iterator();

        while (var3.hasNext()) {
            String element = (String) var3.next();
            switch (name) {
                case "Charmander":
                case "Charizard":
                case "Vulpix":
                    resultElement = "Fire";
                    break;
                case "Squirtle":
                case "Psyduck":
                case "Gyarados":
                case "Lapras":
                    resultElement = "Water";
                    break;
                case "Bulbasaur":
                case "Snorlax":
                case "Machop":
                case "Meowth":
                case "Diglett":
                    resultElement = "Earth";
                    break;
                case "Pidgeotto":
                case "Dragonite":
                case "Jigglypuff":
                case "Alakazam":
                case "Gengar":
                case "Mewtwo":
                    resultElement = "Air";
            }
        }

        return resultElement;
    }

    private Spell spellValidation(String element) {
        if (element.equals("Fire")) {
            return new FireSpell();
        } else if (element.equals("Water")) {
            return new WaterSpell();
        } else {
            return (Spell) (element.equals("Air") ? new AirSpell() : new EarthSpell());
        }
    }

    private int damageValidation(String element) {
        if (element.equals("Fire")) {
            return 10;
        } else if (element.equals("Water")) {
            return 6;
        } else {
            return element.equals("Air") ? 8 : 15;
        }
    }
}
