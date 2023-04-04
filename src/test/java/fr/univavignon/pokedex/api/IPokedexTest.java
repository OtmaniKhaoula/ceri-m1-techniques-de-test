package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokedexTest {
    IPokedex pokedex = mock(IPokedex.class);
    Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 5, 1000);
    List<Pokemon> pokemonList = new ArrayList<>();

    @BeforeEach
    void setUp() throws PokedexException {
        pokemonList.add(bulbizarre);
        when(pokedex.size()).thenReturn(pokemonList.size());

        when(pokedex.addPokemon(any(Pokemon.class))).then(invocation -> {
            int pokemonIndex = pokemonList.size();
            pokemonList.add(invocation.getArgument(0));
            return pokemonIndex;
        });
        when(pokedex.getPokemons()).thenReturn(pokemonList);

        when(pokedex.getPokemon(any(Integer.class))).then(invocation -> {
            try{
                return pokemonList.get(invocation.getArgument(0));
            } catch (IndexOutOfBoundsException e){
                throw new PokedexException("out of bounds");
            }
        });
    }

    @Test
    void outOfBoundsIndexTest(){
        try{
            assertThrows(PokedexException.class, getErr());
        } catch (PokedexException pe){

        }
    }

    Executable getErr() throws PokedexException{
        pokedex.getPokemon(42);
        return null;
    }
    @Test
    void sizeTest() {
        assertEquals(pokedex.size(), pokemonList.size());
    }

    @Test
    void addPokemonTest() throws PokedexException {
        int currentIndex = pokemonList.size();
        assertEquals(pokedex.addPokemon(aquali), currentIndex);
        assertEquals(pokedex.getPokemon(currentIndex), aquali);
    }

    @Test
    void getPokemonTest() throws PokedexException {
        assertEquals(pokedex.getPokemon(0), pokemonList.get(0));
    }

    @Test
    void getPokemonsTest() {
        assertEquals(pokedex.getPokemons().size(), pokemonList.size());
    }

}