package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokemonFactoryTest {
    IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
    Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 5, 1000);
    @BeforeEach
    public void setUp(){
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
        when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 5)).thenReturn(aquali);
    }
    @Test
    void createPokemonTest() {
        Assertions.assertEquals(bulbizarre, pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
        Assertions.assertEquals(aquali, pokemonFactory.createPokemon(133, 2729, 202, 5000, 5));
    }

    @Test
    void getCpTest() {
        Assertions.assertEquals(bulbizarre.getCp(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCp());
        Assertions.assertEquals(aquali.getCp(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 5).getCp());
        Assertions.assertNotEquals(aquali.getCp(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCp());
    }

    @Test
    void getHpTest() {
        Assertions.assertEquals(bulbizarre.getHp(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getHp());
        Assertions.assertEquals(aquali.getHp(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 5).getHp());
        Assertions.assertNotEquals(aquali.getHp(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getHp());
    }

    @Test
    void getDustTest() {
        Assertions.assertEquals(bulbizarre.getDust(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getDust());
        Assertions.assertEquals(aquali.getDust(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 5).getDust());
        Assertions.assertNotEquals(aquali.getDust(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getDust());
    }

    @Test
    void getCandyTest() {
        Assertions.assertEquals(bulbizarre.getCandy(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCandy());
        Assertions.assertEquals(aquali.getCandy(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 5).getCandy());
        Assertions.assertNotEquals(aquali.getCandy(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCandy());
    }


}