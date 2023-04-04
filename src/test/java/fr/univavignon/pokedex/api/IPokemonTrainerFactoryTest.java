package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokemonTrainerFactoryTest {
    IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
    IPokedex pokedex = mock(IPokedex.class);
    IPokemonTrainerFactory pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
    PokemonTrainer green = new PokemonTrainer("Green", Team.MYSTIC, pokedex);

    @BeforeEach
    void setUp(){
        when(pokemonTrainerFactory.createTrainer("Green", Team.MYSTIC, pokedexFactory)).thenReturn(green);
    }

    @Test
    void createTrainerTest() {
        assertTrue(pokemonTrainerFactory.createTrainer("Green", Team.MYSTIC, pokedexFactory) instanceof PokemonTrainer);
    }

    @Test
    void getNameTest() {
        assertEquals(pokemonTrainerFactory.createTrainer("Green", Team.MYSTIC, pokedexFactory).getName(), green.getName());
    }

    @Test
    void getTeamTest() {
        assertEquals(pokemonTrainerFactory.createTrainer("Green", Team.MYSTIC, pokedexFactory).getTeam(), green.getTeam());
    }

    @Test
    void getPokedexTest() {
        assertEquals(pokemonTrainerFactory.createTrainer("Green", Team.MYSTIC, pokedexFactory).getPokedex(), green.getPokedex());
    }
}