package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokemonMetadataProviderTest {
    PokemonMetadata bulbizarre = new PokemonMetadata(0, "Bulbizarre",  126, 126, 90);
    PokemonMetadata aquali = new PokemonMetadata(133, "Aquali",  186, 168, 260);
    IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);

    @BeforeEach
    public void setUp() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarre);
        when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(aquali);
        when(pokemonMetadataProvider.getPokemonMetadata(42)).thenThrow(PokedexException.class);
    }
    @Test
    void outOfBoundsIndexTest(){
        try{
            assertThrows(PokedexException.class, getErr());
        } catch (PokedexException pe){

        }
    }

    Executable getErr() throws PokedexException{
        pokemonMetadataProvider.getPokemonMetadata(42);
        return null;
    }
    @Test
    void getIndexTest() throws PokedexException {
        assertEquals(bulbizarre.getIndex(), pokemonMetadataProvider.getPokemonMetadata(0).getIndex());
        assertEquals(aquali.getIndex(), pokemonMetadataProvider.getPokemonMetadata(133).getIndex());
    }

    @Test
    void getNameTest() throws PokedexException {
        assertEquals(bulbizarre.getName(), pokemonMetadataProvider.getPokemonMetadata(0).getName());
        assertEquals(aquali.getName(), pokemonMetadataProvider.getPokemonMetadata(133).getName());
    }

    @Test
    void getAttackTest() throws PokedexException {
        assertEquals(bulbizarre.getAttack(), pokemonMetadataProvider.getPokemonMetadata(0).getAttack());
        assertEquals(aquali.getAttack(), pokemonMetadataProvider.getPokemonMetadata(133).getAttack());
    }

    @Test
    void getDefenseTest() throws PokedexException {
        assertEquals(bulbizarre.getDefense(), pokemonMetadataProvider.getPokemonMetadata(0).getDefense());
        assertEquals(aquali.getDefense(), pokemonMetadataProvider.getPokemonMetadata(133).getDefense());
    }

    @Test
    void getStaminaTest() throws PokedexException {
        assertEquals(bulbizarre.getStamina(), pokemonMetadataProvider.getPokemonMetadata(0).getStamina());
        assertEquals(aquali.getStamina(), pokemonMetadataProvider.getPokemonMetadata(133).getStamina());

    }
}