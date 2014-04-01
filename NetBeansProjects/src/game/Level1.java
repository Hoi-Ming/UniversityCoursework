/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.soi.platform.*;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;
/**
 *
 * @author Hoi Ming
 */
public class Level1 extends GameLevel{
    private Body ground;
    
    
    public Level1(Game game){
        super (game);
    }
        
    public void populate() {
        // control which sound is playing
        game.getSound().stopEnding();
        game.getSound().stopBackgroundSound2();
        game.getSound().playBackgroundSound();
        
        // cretaes the background image
        Body backgroundImage = new Body(game.getWorld());
        backgroundImage.setImage(new BodyImage("images/level1.jpg"));
        backgroundImage.setRenderLayer(-1);
        
        // creates the ground and walls      
        ground = new Body(game.getWorld(), PolygonShape.makeBox(450, 50), Body.Type.STATIC);
        ground.setPosition(new Vec2(0, -400));
        ground.setImage(new BodyImage("images/"));
        
       Body ground2 = new Body(game.getWorld(), PolygonShape.makeBox(50, 450), Body.Type.STATIC);
       ground2.setPosition(new Vec2(-500, 0));
       Body ground3 = new Body(game.getWorld(), PolygonShape.makeBox(50, 450), Body.Type.STATIC);
       ground3.setPosition(new Vec2(500, 0));
         
       // creates static platforms            
       Body staticPlatform = new Body(game.getWorld(), PolygonShape.makeBox(50, 5), Body.Type.STATIC);
       staticPlatform.setPosition(new Vec2(0, 260));
       staticPlatform.setImage(new BodyImage("images/floor5.png"));
       Body staticPlatform2 = new Body(game.getWorld(), PolygonShape.makeBox(30, 10), Body.Type.STATIC);
       staticPlatform2.setPosition(new Vec2(0, 0));
       staticPlatform2.setImage(new BodyImage("images/movingfloor2.png"));
       
       // creates moving platforms       
       Body movingPlatform1 = new SlidingPlatform(game.getWorld(), PolygonShape.makeBox(50, 10), new Vec2(0, 240), 02.00f);
       movingPlatform1.setPosition(new Vec2(-250, -100));
       movingPlatform1.setImage(new BodyImage("images/movingfloor1.png"));
       Body movingPlatform2 = new SlidingPlatform(game.getWorld(), PolygonShape.makeBox(50, 10), new Vec2(0, 240), 02.00f);
       movingPlatform2.setPosition(new Vec2(250, -100));
       movingPlatform2.setImage(new BodyImage("images/movingfloor1.png"));
       Body movingPlatform3 = new SlidingPlatform(game.getWorld(), PolygonShape.makeBox(50, 10), new Vec2(-140, 0), 04.00f);
       movingPlatform3.setPosition(new Vec2(250, -200));
       movingPlatform3.setImage(new BodyImage("images/movingfloor1.png"));
       Body movingPlatform4 = new SlidingPlatform(game.getWorld(), PolygonShape.makeBox(50, 10), new Vec2(140, 0), 04.00f);
       movingPlatform4.setPosition(new Vec2(-250, -200));
       movingPlatform4.setImage(new BodyImage("images/movingfloor1.png"));
       Body movingPlatform5 = new SlidingPlatform(game.getWorld(), PolygonShape.makeBox(50, 10), new Vec2(-140, 0), 04.0f);
       movingPlatform5.setPosition(new Vec2(250, 200));
       movingPlatform5.setImage(new BodyImage("images/movingfloor1.png"));
       Body movingPlatform6 = new SlidingPlatform(game.getWorld(), PolygonShape.makeBox(50, 10), new Vec2(140, 0), 04.00f);
       movingPlatform6.setPosition(new Vec2(-250, 200));
       movingPlatform6.setImage(new BodyImage("images/movingfloor1.png"));
       
       

        // make some slabs
        Body slab1 = new Body(game.getWorld(), PolygonShape.makeBox(5, 50));
        Body slab2 = new Body(game.getWorld(), PolygonShape.makeBox(5, 50));
        Body slab3 = new Body(game.getWorld(), PolygonShape.makeBox(50, 5));
        // arrange slabs into an arch
        slab1.putOn(ground);
        slab1.move(new Vec2(-40, 0));
        slab1.setImage(new BodyImage("images/6.png"));

        slab2.putOn(ground);
        slab2.move(new Vec2(40, 0));
        slab2.setImage(new BodyImage("images/6.png"));

        slab3.putOn(slab1);
        slab3.move(new Vec2(40, 0));
        slab3.setImage(new BodyImage("images/floor5.png"));

        // make some pokeballs
        Pokeball ball1 = new Pokeball(game);
        ball1.putOn(staticPlatform);
        ball1.move(new Vec2(0, 0));
        Pokeball ball2 = new Pokeball(game);
        ball2.putOn(slab3);
        Pokeball ball3 = new Pokeball(game);
        ball3.putOn(ground);
        Pokeball ball4 = new Pokeball(game);
        ball4.putOn(movingPlatform1);
        ball4.move(new Vec2(0, 0));
        Pokeball ball5 = new Pokeball(game);
        ball5.putOn(movingPlatform2);
        ball5.move(new Vec2(0, 0));
        Pokeball ball6 = new Pokeball(game);
        ball6.putOn(staticPlatform2);
        ball6.move(new Vec2(0, 0));
        
        // make some energy
        Energy energy1 = new Energy(game);
        energy1.putOn(movingPlatform3);
        Energy energy2 = new Energy(game);
        energy2.putOn(movingPlatform4);
        
        // make some lives
        Lives lives1 = new Lives(game);
        lives1.putOn(movingPlatform5);
        
        // make some pikachus
        Pikachu pikachu1 = new Pikachu(game);
        pikachu1.putOn(staticPlatform);
        pikachu1.move(new Vec2(0, 0));
        
        // make some magikarps
        Magikarp karp3 = new Magikarp(game);
        karp3.putOn(ground);
        karp3.move(new Vec2(200,0));
        Magikarp karp5 = new Magikarp(game);
        karp5.putOn(ground);
        karp5.move(new Vec2(250,0));
        Magikarp karp6 = new Magikarp(game);
        karp6.putOn(ground);
        karp6.move(new Vec2(-300,0));
        Magikarp karp7 = new Magikarp(game);
        karp7.putOn(ground);
        karp7.move(new Vec2(300,0));
        Magikarp karp8 = new Magikarp(game);
        karp8.putOn(ground);
        karp8.move(new Vec2(-350,0));
        Magikarp karp9 = new Magikarp(game);
        karp9.putOn(ground);
        karp9.move(new Vec2(350,0));
        Magikarp karp10 = new Magikarp(game);
        karp10.putOn(ground);
        karp10.move(new Vec2(-400,0));
        Magikarp karp11 = new Magikarp(game);
        karp11.putOn(ground);
        karp11.move(new Vec2(400,0));
        Magikarp karp13 = new Magikarp(game);
        karp13.putOn(ground);
        karp13.move(new Vec2(150,0));
        Magikarp karp14 = new Magikarp(game);
        karp14.putOn(movingPlatform6);
    }



public boolean isCompleted() {
return false;
}

public void putPlayerAtStart() {
game.getPlayer().putOn(ground);
       game.getPlayer().move(new Vec2(-90, 0));
}
           
      
}
