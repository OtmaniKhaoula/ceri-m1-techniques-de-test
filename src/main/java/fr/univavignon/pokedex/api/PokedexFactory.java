package fr.univavignon.pokedex.api;

/**
 * Pokedex Factoy
 */
public class PokedexFactory implements IPokedexFactory{
    /**
     *
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory   Pokemon factory the created pokedex will use.
     * @return Pokedex
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider,
                                  IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }

}
