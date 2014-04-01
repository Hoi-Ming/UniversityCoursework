package game;

import org.jbox2d.common.Vec2;

import fsm.FSM;
import fsm.FSMState;
import city.soi.platform.*;

/**
 * Pick-ups in a game. When the player collides with an orange, the
 * player's oranges count is increased and the orange is removed
 * from the world. 
 */
public class Magikarp extends Body implements StepListener, CollisionListener {

    private enum State {
        ROLL_LEFT, ROLL_RIGHT, STAND_STILL
    }
    public static final float RANGE = 150;
    private Game game;
    private State state;

    public Magikarp(Game game) {
        super(game.getWorld(), new PolygonShape(-18.0f,13.0f, 15.0f,13.0f, 15.0f,-16.0f, -18.0f,-16.0f));
        this.game = game;
        state = State.STAND_STILL;
        this.game.getWorld().addCollisionListener(this);
        getWorld().addStepListener(this);
        setImage(new BodyImage("images/magikarp.gif"));
    }

    public boolean inRangeLeft() {
        Player p = game.getPlayer();
        float gap = getPosition().x - p.getPosition().x;
        return gap < RANGE && gap > 0;
    }

    public boolean inRangeRight() {
        Player p = game.getPlayer();
        float gap = getPosition().x - p.getPosition().x;
        return gap > -RANGE && gap < 0;
    }

    public boolean inRange() {
        return inRangeLeft() || inRangeRight();
    }

    private void enterState(State newState) {
        state = newState;
        switch (state) {
            case ROLL_LEFT:
                setAngularVelocity(1);
                break;
            case ROLL_RIGHT:
                setAngularVelocity(-1);
                break;
            case STAND_STILL:
                setAngularVelocity(0);
                setLinearVelocity(new Vec2());
                break;
        }
    }

    private void exitCurrentState() {
    }
    
    private void gotoState(State s) {
        exitCurrentState();
        enterState(s);
    }

    // update
    public void preStep(StepEvent e) {
        switch (state) {
            case ROLL_LEFT:
                if (inRangeRight()) {
                    gotoState(State.ROLL_RIGHT);
                } else if (!inRange()) {
                    gotoState(State.STAND_STILL);
                } else {
                    setAngularVelocity(1);
                }
                break;
            case ROLL_RIGHT:
                if (inRangeLeft()) {
                    gotoState(State.ROLL_LEFT);
                } else if (!inRange()) {
                    gotoState(State.STAND_STILL);
                } else {
                    setAngularVelocity(-1);
                }
                break;
            case STAND_STILL:
                if (inRangeLeft()) {
                    gotoState(State.ROLL_LEFT);
                } else if (inRangeRight()) {
                    gotoState(State.ROLL_RIGHT);
                }
                break;
        }
    }
     
    
    
    public void postStep(StepEvent e) {
    }
 
    public void attack(Player player) {
        if (player.getPokeball() > 0) {
            player.decrementPokeballCount();
            System.out.println("Magikarp knocked out your pokeball:" + game.getPlayer().getPokeball());
            }
        if (player.getLives() > 0) {
            player.decrementLivesCount();
            System.out.println("Magikarp attacked you:" + game.getPlayer().getLives());
        }
        if (player.getLives() == 0 ) {
            game.RestartLevel();
            game.getPlayer().resetLives();
        }
    }

    public void collide(CollisionEvent e) {
        if (e.getOtherBody().equals(game.getPlayer())) {
        Player player = game.getPlayer();
        if (e.getOtherBody() == player) {
            attack(player);
            destroy();
        }
    }
        if (e.getOtherBody() instanceof Bullet){
        destroy();
    }
    }   
    }


