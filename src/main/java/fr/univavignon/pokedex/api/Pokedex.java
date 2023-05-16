package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Pokedex class
 */
public class Pokedex implements IPokedex{
    private final ArrayList<Pokemon> pokemonsArrayList;
    private final IPokemonMetadataProvider pokemonMetadataProvider;
    private final IPokemonFactory pokemonFactory;

    public Pokedex(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory){
        this.pokemonFactory = pokemonFactory;
        this.pokemonMetadataProvider = pokemonMetadataProvider;
        this.pokemonsArrayList = new ArrayList<>();
    }

    /**
     * parameters: none
     * @return int size of the pokedex
     */
    @Override
    public int size() {
        return pokemonsArrayList.size();
    }

    /**
     * @param pokemon Pokemon to add to this pokedex.
     * @return index of the newly added pokemon or -1 if fail
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        if(pokemon != null){
            pokemonsArrayList.add(pokemon);
            return pokemonsArrayList.size()-1;
        }
        return -1;
    }

    /**
     *
     * @param id Unique pokedex relative identifier.
     * @return pokemon at position id
     * @throws PokedexException
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        return pokemonsArrayList.get(id);
    }

    /**
     *
     * @return all pokemons arrayList
     */
    @Override
    public List<Pokemon> getPokemons() {
        return pokemonsArrayList;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        ArrayList<Pokemon> pokemons = new ArrayList<>(pokemonsArrayList);
        pokemons.sort(order);
        return pokemons;
    }

    /**
     *
     * @param index Pokemon index.
     * @param cp    Pokemon CP.
     * @param hp    Pokemon HP.
     * @param dust  Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Pokemon
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust,
                                 int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    /**
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return PokemonMetadata
     * @throws PokedexException
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index)
            throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
