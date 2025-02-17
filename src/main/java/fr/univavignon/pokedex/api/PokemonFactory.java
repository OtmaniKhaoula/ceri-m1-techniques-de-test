package fr.univavignon.pokedex.api;

/**
 * Pokemon factory. Implementation of IPokemonFactory.
 *
 * @author Khaoula Otmani
 */
public class PokemonFactory implements IPokemonFactory {
    /**
     * Not captured Pokemons default iv.
     */
    private static final int DEFAULT_IV = 23;


    /**
     * Creates and returns a new Pokemon.
     *
     * @param index Pokemon index.
     * @param cp    Pokemon CP.
     * @param hp    Pokemon HP.
     * @param dust  Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Pokemon
     */
    @Override
    public Pokemon createPokemon(final int index, final int cp, final int hp,
                                 final int dust,
                                 final int candy) {
        PokemonMetadata pokemonMetadata;
        try {
            pokemonMetadata =
                    new PokemonMetadataProvider().getPokemonMetadata(index);
        } catch (PokedexException pe) {
            return null;
        }
        int iv = DEFAULT_IV;

        return new Pokemon(index, pokemonMetadata.getName(),
                pokemonMetadata.getAttack(), pokemonMetadata.getDefense(),
                pokemonMetadata.getStamina(), cp, hp, dust, candy, iv);
    }
}
