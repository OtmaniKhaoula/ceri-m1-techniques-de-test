package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

class IPokemonFactoryTest {
    IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
    Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 5, 1000);

    @Test
    void createPokemonTest() {
        assertEquals(bulbizarre, pokemonFactory.createPokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
        assertEquals(aquali, pokemonFactory.createPokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 5, 1000));
    }
}