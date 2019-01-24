public abstract class Player {
    protected String name;

    /**
     * Constructor for Player
     * @param inName the name of the player
     */
    public Player(String inName) {
        name = inName;
    }

    /**
     * Return the move location for the player
     * @param board the board of the game
     * @return the move location for the player
     */
    public abstract String getMove(Board board);
}
