package game;

import org.jbox2d.common.Vec2;

import city.soi.platform.*;

/**
 * Pick-ups in a game. When the player collides with an orange, the
 * player's oranges count is increased and the orange is removed
 * from the world. 
 */
public class Energy extends Body implements CollisionListener {

    /** The game in which the player is playing. */
    private Game game;

    /**
     * Initialize a new energy.
     * @param g The game.
     */
    public Energy(Game game) {
        super(game.getWorld(), new PolygonShape(-10.0f,10.0f, 9.0f,10.0f, 9.0f,-9.0f, -10.0f,-9.0f, -10.0f,10.0f));
        this.game = game;
        this.game.getWorld().addCollisionListener(this);
        setImage(new BodyImage("images/energy.gif"));
        setFillColor(java.awt.Color.ORANGE);
        setLineColor(java.awt.Color.BLACK);
    }
    
     public void collide(CollisionEvent e) 
    {
    if (e.getOtherBody().equals(game.getPlayer())) 
    {
        destroy();
        game.getPlayer().incrementEnergyCount();
        System.out.println("Energy Collected: " +game.getPlayer().getEnergy());
    }
    }
}
