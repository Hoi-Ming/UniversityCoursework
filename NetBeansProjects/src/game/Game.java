package game;

import city.soi.platform.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import org.jbox2d.common.Vec2;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 * A very basic platform game.
 */
public class Game {

    /** The player (a specialised Actor). */
    private Player player;
    /** Game over flag. */
    private boolean isOver;
    /** The World in which the game bodies move and interact.*/
    private World world;
    /** A graphical display of the world (a specialised JPanel). */
    private WorldView view;
    /** A debug display. */
    private DebugViewer debugViewer;
    /** New game Level.*/
    private GameLevel level;
    /** Level count.*/
    private int nextLevel;
    /** Status Panel.*/
    private StatusPanel statusPanel;
    /** Bullet.*/
    private Bullet shooting;
    /** Player Direction.*/
    private String actorDirection;
    /** Player Direction Left.*/
    private int playerFacingDirection;
    /** Player Direction Right.*/
    private int playerFacingDirection2;
    /** Sound.*/
    private Sound sound;

    /** Initialise a new Game. */
    public Game() {
        
        sound = new Sound();
               
        isOver = false;

       // make the world
        world = new World();
             
      // make a player
        player = new Player(this);
        level = new Level1(this);
        level.populate();
        level.putPlayerAtStart();

        nextLevel = 1;
        
             
       // make a view
        view = new WorldView(world, 900, 900);
        view.setDrawStats(true); // uncomment this line to show simulation stats in game display

       // display the view in a frame
        final JFrame frame = new JFrame("Game");

       // add some keyboard handling
        frame.addKeyListener(new java.awt.event.KeyAdapter() {

            /** Handle key press events for walking and jumping. */
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (isOver) {
                    return;
                }
                int code = e.getKeyCode();
                // SPACE = jump
                if (code == java.awt.event.KeyEvent.VK_UP) {
                    // only jump if player is not already jumping
                    if (!player.isJumping()) {
                        player.jump(240);
                    }
                    // LEFT ARROW = walk left
                } else if (code == java.awt.event.KeyEvent.VK_LEFT) {
                    player.walkLeft(100);
                    playerFacingDirection = 1;
                    playerFacingDirection2 = 1;
                    player.setImage(new BodyImage("images/f4.gif"));
                    // RIGHT ARROW = walk right
                } else if (code == java.awt.event.KeyEvent.VK_RIGHT) {
                    player.walkRight(100);
                    playerFacingDirection = 2;
                    playerFacingDirection2 = 2;
                    player.setImage(new BodyImage("images/f3.gif"));
                    // F1 key toggles display of debug view
                } else if (code == java.awt.event.KeyEvent.VK_F1) {
                    if (debugViewer == null) {
                        debugViewer = new DebugViewer(new DebugSettings(world));
                    }
                    if (debugViewer.isRunning()) {
                        debugViewer.stopViewer();
                    } else {
                        debugViewer.startViewer();
                    }
                } else if (code == java.awt.event.KeyEvent.VK_SPACE) {
                    if (nextLevel == 1) {
                    //Shooting is available in level 1
                    throwShooting();
                    }
                    if (nextLevel== 2) {
                    //Shooting is available in level 2
                    throwShooting(); 
                    }
                    if (nextLevel == 3) {
                    //Shooting is available in level 3
                    throwShooting(); 
                    }
                    
                    
                    else if (code == java.awt.event.KeyEvent.VK_1){
                        world.pause();
                    }
                    else if (code == java.awt.event.KeyEvent.VK_2){
                        world.unpause();
                    }        
                 }                   
            }

            /** Handle key release events (stop walking). */
            public void keyReleased(java.awt.event.KeyEvent e) {
                if (isOver) {
                    return;
                }
                int code = e.getKeyCode();
                if (code == java.awt.event.KeyEvent.VK_LEFT) {
                    player.stopWalking();
                     player.setImage(new BodyImage("images/f6.gif"));
                } else if (code == java.awt.event.KeyEvent.VK_RIGHT) {
                    player.stopWalking();
                     player.setImage(new BodyImage("images/f5.gif"));
                }
            }
        });

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // creates the status panel
        statusPanel = new StatusPanel(this);
        frame.add(BorderLayout.EAST, statusPanel);
        // size the game window to fit the world view
        frame.pack();
        statusPanel.fixSizes();
        // make the window visible
        frame.setVisible(true);

        // start!
        world.start();
    }

    /** Restart the game. */    
    public void RestartLevel() {
        level.clearLevel();
        level = new Level1(this);
        level.populate();
        level.putPlayerAtStart();
        nextLevel = 1;
        getPlayer().setImage(new BodyImage("images/f5.gif"));
        getPlayer().resetCount();
        getPlayer().resetLives();
//        sound.stopAllMusic();
//        newGame();
    }
    
    /** Next Level. */                
    public void goToNextLevel() {
            level.clearLevel();
        if (nextLevel == 1){
            level = new Level2(this);
            nextLevel ++;
            level.populate();
            level.putPlayerAtStart();
            getPlayer().resetCount();
    }
        else if (nextLevel == 2){
            level= new Level3(this);
            nextLevel ++;
            level.populate();
            level.putPlayerAtStart();
            getPlayer().resetCount();
        }
       else if (nextLevel == 3){
           getPlayer().setImage(new BodyImage("images/win.gif"));
        Body ground = new Body(getWorld(), PolygonShape.makeBox(450, 50), Body.Type.STATIC);
        ground.setPosition(new Vec2(0, -400));
        ground.setImage(new BodyImage("images/"));
        Body backgroundImage = new Body(world);
        backgroundImage.setImage(new BodyImage("images/youwin.jpg"));
        backgroundImage.setRenderLayer(-1);
        Body ground2 = new Body(getWorld(), PolygonShape.makeBox(50, 450), Body.Type.STATIC);
        ground2.setPosition(new Vec2(-500, 0));
        Body ground3 = new Body(getWorld(), PolygonShape.makeBox(50, 450), Body.Type.STATIC);
        ground3.setPosition(new Vec2(500, 0));
        sound.stopBackgroundSound2();
        sound.playEnding();
           //gameOver();          
        }
    }
                
    /** Is the game over? */
    public boolean isOver() {
        return isOver;
    }

    /** End the game. */
    public void gameOver() {
        Body backgroundImage = new Body(world);
        backgroundImage.setImage(new BodyImage("images/youwin.jpg"));
        backgroundImage.setRenderLayer(-1);
        world.pause();
        isOver = true;
    }
    
    /** Bullet Position. */
    public void throwShooting(){
           if(playerFacingDirection2 == 1)
    {
        Vec2 vec = player.getPosition();
        vec.x = vec.x - 5 ;
        this.shooting = new Bullet(this);
        shooting.setPosition(vec);
        shooting.setLinearVelocity(new Vec2(-550,0));
        shooting.setImage(new BodyImage("images/bullet.png"));
        }
        else
        {
        Vec2 vec = player.getPosition();
        vec.x = vec.x + 5 ;
        this.shooting = new Bullet(this);
        shooting.setPosition(vec);
        shooting.setLinearVelocity(new Vec2(550,0));
        shooting.setImage(new BodyImage("images/bullet2.png"));
        }
    }  
 
    /** The world in which this game is played. */
    public World getWorld() {
        return world;
    }

    /** The world view. */
    public WorldView getView() {
        return view;
    }

    /** The player. */
    public Player getPlayer() {
        return player;
    }

    /** Play a game. */
    public static void main(String[] args) {
        new Game();
        String name = "";
        
        name = JOptionPane.showInputDialog(
        null, "Name : ");
        
        JOptionPane.showMessageDialog(null,
                "Collect 4 or Pokeballs to Collect Pikachu to Proceed to Next Level, Gotta Catch em All!! " + name + "");
    }

        /** The state of bullets */
     public Bullet getShooting() {
         return shooting;
     }
     
       /** The state of sounds */
    public Sound getSound() {
        return sound;
    }

}

