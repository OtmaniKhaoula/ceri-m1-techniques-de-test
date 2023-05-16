package fr.univavignon.pokedex.api;

import java.util.ArrayList;

/**
 * Pokemon metadata provider
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider{
    private ArrayList<PokemonMetadata> pokemonMetadataArrayList;

    public PokemonMetadataProvider(){
        pokemonMetadataArrayList = new ArrayList<>();

        PokemonMetadata bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        PokemonMetadata aquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);

        for (int i = 0; i <= 150; i++){
            if(i == 0){
                pokemonMetadataArrayList.add(bulbizarre);
            }else if (i == 133){
                pokemonMetadataArrayList.add(aquali);
            }else{
                pokemonMetadataArrayList.add(new PokemonMetadata(i, "anonymous", 0, 0, 0));
            }
        }
    }

    /**
     * Returns the pokemon at a given index
     * @param index Index of the pokemon to retrieve metadata for.
     * @return PokemonMetadata
     * @throws PokedexException
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index)
            throws PokedexException {
        if (index >= 0 && index <= 150){
            return pokemonMetadataArrayList.get(index);
        }
        throw new PokedexException("There is no pokemon with that id.+" +
                " Please enter an index between 0 and 150.");
    }
}
