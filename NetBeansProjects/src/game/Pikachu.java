package game;

import org.jbox2d.common.Vec2;

import city.soi.platform.*;

/**
 * Pick-ups in a game. When the player collides with an orange, the
 * player's oranges count is increased and the orange is removed
 * from the world. 
 */
public class Pikachu extends Body implements CollisionListener {

    /** The game in which the player is playing. */
    private Game game;

    /**
     * Initialize a new orange.
     * @param g The game.
     */
    public Pikachu(Game game) {
        super(game.getWorld(), new PolygonShape(-17.0f,15.0f, 14.0f,15.0f, 10.0f,-15.0f, -13.0f,-15.0f));
        this.game = game;
        this.game.getWorld().addCollisionListener(this);
        setImage(new BodyImage("images/pikachu.gif"));
        setFillColor(java.awt.Color.ORANGE);
        setLineColor(java.awt.Color.BLACK);
    }
    
     public void collide(CollisionEvent e) 
    {
    if (e.getOtherBody().equals(game.getPlayer())) {
        if (game.getPlayer().getPokeball() >= 4) {
            game.getSound().playPikachu();
            destroy();
            game.getPlayer().incrementPikachuCount();
            System.out.println("Level Complete");
            game.goToNextLevel();
        }
    }
    }
   
}

