package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;


class IPokedexFactoryTest {
    //IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
    IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
    IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

    @Test
    void createPokedexTest() {
        //On vérifie que on arrive bien a crée une classe de type IPokedex

        //Version avec les mocks
        assertTrue(new PokedexFactory().createPokedex(pokemonMetadataProvider, pokemonFactory) instanceof IPokedex);

    }
}