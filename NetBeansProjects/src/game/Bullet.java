package game;
import org.jbox2d.common.Vec2;
import city.soi.platform.*;

/**
*The axe class creates the properties of the weapon
*/
public class Bullet extends Body implements CollisionListener {

private Game game;

public Bullet(Game game) {
super(game.getWorld(), new PolygonShape(-10.0f,-9.0f, 10.0f,-9.0f, 10.0f,9.0f, -10.0f,9.0f, -10.0f,-9.0f));
this.game = game;
this.applyForce(new Vec2(30, 15));
getWorld().addCollisionListener(this);
}

/** Destroys object, except the player*/
public void collide(CollisionEvent e) {
if (e.getOtherBody() != game.getPlayer()) {
destroy();
}

}
}