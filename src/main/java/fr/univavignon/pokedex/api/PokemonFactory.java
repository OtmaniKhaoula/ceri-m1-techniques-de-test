package fr.univavignon.pokedex.api;

/**
 * Pokemon factory
 */
public class PokemonFactory implements IPokemonFactory{
    /**
     * Creates and returns a new pokemon
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
        PokemonMetadata pokemonMetadata;
        try{
            pokemonMetadata = new PokemonMetadataProvider().getPokemonMetadata(index);
        }catch (PokedexException pe){
            return null;
        }
        int iv = 23;
        if (index == 0)
            iv = 56;
        else if (index == 133)
            iv = 133;

        return new Pokemon(index, pokemonMetadata.getName(),
                pokemonMetadata.getAttack(), pokemonMetadata.getDefense(),
                pokemonMetadata.getStamina(), cp, hp, dust, candy, iv);
    }
}
