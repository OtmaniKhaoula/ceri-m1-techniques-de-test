package fr.univavignon.pokedex.api;

/**
 * Pokemon POJO.
 *
 * @author fv
 */
public final class Pokemon extends PokemonMetadata {

    /**
     * Combat Point of the pokemon.
     **/
    private final int cp;

    /**
     * HP of the pokemon.
     **/
    private final int hp;

    /**
     * Required dust for upgrading this pokemon.
     **/
    private final int dust;

    /**
     * Required candy for upgrading this pokemon.
     **/
    private final int candy;

    /**
     * IV perfection percentage.
     **/
    private final double iv;

    /**
     * Default constructor.
     *
     * @param index1   Pokemon index.
     * @param name1    Pokemon name.
     * @param attack1  Attack level.
     * @param defense1 Defense level.
     * @param stamina1 Stamina level.
     * @param cp1      Pokemon cp.
     * @param hp1      Pokemon hp.
     * @param dust1    Required dust for upgrading this pokemon.
     * @param candy1   Required candy for upgrading this pokemon.
     * @param iv1      IV perfection percentage.
     */
    public Pokemon(
            final int index1,
            final String name1,
            final int attack1,
            final int defense1,
            final int stamina1,
            final int cp1,
            final int hp1,
            final int dust1,
            final int candy1,
            final double iv1) {
        super(index1, name1, attack1, defense1, stamina1);
        this.cp = cp1;
        this.hp = hp1;
        this.dust = dust1;
        this.candy = candy1;
        this.iv = iv1;
    }

    /**
     * Combat Point getter getter.
     *
     * @return int cp
     **/
    public int getCp() {
        return cp;
    }

    /**
     * HP getter.
     *
     * @return int hp
     **/
    public int getHp() {
        return hp;
    }

    /**
     * Dust getter.
     *
     * @return int dust
     **/
    public int getDust() {
        return dust;
    }

    /**
     * Candy getter.
     *
     * @return int candy
     **/
    public int getCandy() {
        return candy;
    }

    /**
     * IV getter.
     *
     * @return double iv
     **/
    public double getIv() {
        return iv;
    }

}
