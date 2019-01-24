public class MoveInfo {
    private String loc;
    private int score;

    /**
     * Construct a MoveInfo object with a location and
     * score
     * @param inLoc   the location of the move
     * @param inScore the score of the move
     */
    public MoveInfo(String inLoc, int inScore) {
        loc = inLoc;
        score = inScore;
    }

    /**
     * Return the row of the move
     * @return the location of the move
     */
    public String getLoc() {
        return loc;
    }

    /**
     * Return the score of the move
     * @return score of the move
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the location of the score
     * @param inLoc the location of the score
     */
    public void setLoc(String inLoc) {
        loc = inLoc;
    }
}
