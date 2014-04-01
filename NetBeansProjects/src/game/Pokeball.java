package game;

import org.jbox2d.common.Vec2;

import city.soi.platform.*;

/**
 * Pick-ups in a game. When the player collides with an orange, the
 * player's oranges count is increased and the orange is removed
 * from the world. 
 */
public class Pokeball extends Body implements CollisionListener {

    /** The game in which the player is playing. */
    private Game game;

    /**
     * Initialize a new pokeball.
     * @param g The game.
     */
    public Pokeball(Game game) {
        super(game.getWorld(), new CircleShape(19));
        this.game = game;
        this.game.getWorld().addCollisionListener(this);
        setImage(new BodyImage("images/pokeball.png"));
        setFillColor(java.awt.Color.ORANGE);
        setLineColor(java.awt.Color.BLACK);
    }
    
     public void collide(CollisionEvent e) 
    {
    if (e.getOtherBody().equals(game.getPlayer())) 
    {
        destroy();
        game.getPlayer().incrementPokeballCount();
        System.out.println("Pokeballs Collected: " +game.getPlayer().getPokeball());
    }
    }
}
