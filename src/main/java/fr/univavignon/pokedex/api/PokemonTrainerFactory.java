package fr.univavignon.pokedex.api;

/**
 * Pokemon Trainer Factory
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory{
    /**
     * Creates and return a new trainer
      * @param name           Name of the created trainer.
     * @param team           Team of the created trainer.
     * @param pokedexFactory Factory for creating associated pokedex instance.
     * @return PokemonTrainer
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team,
                                        IPokedexFactory pokedexFactory) {
        return new PokemonTrainer(name, team, pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory()));
    }
}
