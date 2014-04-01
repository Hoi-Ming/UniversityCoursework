package game;

import city.soi.platform.*;

/** Basic players in a game. */
public class Player extends Actor {

    /** The number of pokeballs the player currently has. */
    private int pokeballs;
    /** The game. */
    private Game game;
    /**The number of magikarp the player currently has. */
    private int magikarp;
     /**The number of pikachu the player currently has. */
    private int pikachu;
    
    private int energy;
    
    private int lives;

    /**
     * Initialise a new player.
     * @param game  The game in which the player will be playing.
     */
    public Player(Game game) {
        super(game.getWorld(), new PolygonShape(-20.5f,-27.5f, 19.5f,-27.5f, 19.5f,27.5f, -20.5f,27.5f, -20.5f,-27.5f));
        this.game = game;
        pokeballs = 0;
        lives = 5;
        setFillColor(java.awt.Color.MAGENTA);
        setLineColor(java.awt.Color.BLACK);
        setImage(new BodyImage("images/f5.gif"));
    }
    
   
    /** Increase the pokeball count. */
    public void incrementPokeballCount() {
        pokeballs++;
    }
    
        /** Decrease the pokeball count. */
    public void decrementPokeballCount() {
        pokeballs--;
    }
    
    /** Increase the pikachu count. */
    public void incrementPikachuCount() {
        pokeballs++;
    }

    /** Increase the magikarp count. */
    public void incrementMagikarpCount() {
        magikarp++;
    }
    
    /** Decrease the magikarp count. */
    public void decrementMagikarpCount() {
        magikarp--;
    }
    
    public void incrementEnergyCount() {
        energy++;
    }
    
    public void incrementLivesCount() {
        lives++;
    }
    
    public void decrementLivesCount() {
        lives--;
    }

    /** The number of pokeball the player currently has. */
    public int getPokeball() {
        return pokeballs;
    }
    
     /** The number of pikachu the player currently has. */
    public int getPikachu() {
        return pikachu;
    }
    
     /** The number of magikarp the player currently has. */
    public int getMagikarp() {
        return magikarp;
    }
    
    public int getEnergy() {
        return energy;
    }
     
    public int getLives() {
        return lives;
    }
    
    public void setLives(int lives) {
        this.lives = lives;
    } 
    
    public void resetLives() {
        lives = 5;
    }
    
    public void resetCount() {
        pokeballs = 0;
    }
}
