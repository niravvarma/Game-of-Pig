package edu.bsu.pig;

/**
 * Class set to final as not designing for subclassing i.e. no subclasses will be created
 */
public final class Player {

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public String getName(){
        return name;
    }

}
