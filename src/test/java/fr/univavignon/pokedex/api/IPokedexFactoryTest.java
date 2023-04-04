package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class IPokedexFactoryTest {
    IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
    IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
    IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
    IPokedex awaitedReturn = mock(IPokedex.class);

    @BeforeEach
    public void setUp(){
        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(awaitedReturn);
    }

    @Test
    void createPokedexTest() {
        //On vérifie que on arrive bien a crée une classe de type IPokedex
        assertTrue(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory) instanceof IPokedex);

    }
}