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
public class Level2 extends GameLevel{
    private Body ground;
    
    
    public Level2(Game game){
        super (game);
    }

  public void populate() {
      // control which sound is playing
        game.getSound().stopBackgroundSound1();
        game.getSound().playBackgroundSound2();
        
        // creates background image
        Body backgroundImage = new Body(game.getWorld());
        backgroundImage.setImage(new BodyImage("images/level2.jpg"));
        backgroundImage.setRenderLayer(-1);
        
        // creates the ground and walls
        ground = new Body(game.getWorld(), PolygonShape.makeBox(450, 50), Body.Type.STATIC);
        ground.setPosition(new Vec2(0, -400));
        ground.setImage(new BodyImage("images/"));
        
       Body ground2 = new Body(game.getWorld(), PolygonShape.makeBox(50, 450), Body.Type.STATIC);
       ground2.setPosition(new Vec2(-500, 0));
       Body ground3 = new Body(game.getWorld(), PolygonShape.makeBox(50, 450), Body.Type.STATIC);
       ground3.setPosition(new Vec2(500, 0));
         
        
       // make some platforms
       Body staticPlatform = new Body(game.getWorld(), PolygonShape.makeBox(50, 5), Body.Type.STATIC);
       staticPlatform.setPosition(new Vec2(0, 300));
       staticPlatform.setImage(new BodyImage("images/floor5.png"));
       Body staticPlatform2 = new Body(game.getWorld(), PolygonShape.makeBox(30, 10), Body.Type.STATIC);
       staticPlatform2.setPosition(new Vec2(0, 0));
       staticPlatform2.setImage(new BodyImage("images/movingfloor2.png"));
       Body staticPlatform3 = new Body (game.getWorld(), PolygonShape.makeBox(50, 5), Body.Type.STATIC);
       staticPlatform3.setPosition (new Vec2 (-200, 200));
       staticPlatform3.setImage(new BodyImage ("images/floor5.png"));
       Body staticPlatform4 = new Body (game.getWorld(), PolygonShape.makeBox(50, 5), Body.Type.STATIC);
       staticPlatform4.setPosition (new Vec2 (200, 200));
       staticPlatform4.setImage(new BodyImage ("images/floor5.png"));
       Body staticPlatform5 = new Body (game.getWorld(), PolygonShape.makeBox(50, 5), Body.Type.STATIC);
       staticPlatform5.setPosition (new Vec2 (-200, -200));
       staticPlatform5.setImage(new BodyImage ("images/floor5.png"));
       Body staticPlatform6 = new Body (game.getWorld(), PolygonShape.makeBox(50, 5), Body.Type.STATIC);
       staticPlatform6.setPosition (new Vec2 (200, -200));
       staticPlatform6.setImage(new BodyImage ("images/floor5.png"));
       Body staticPlatform7 = new Body (game.getWorld(), PolygonShape.makeBox(50, 5), Body.Type.STATIC);
       staticPlatform7.setPosition (new Vec2 (-300, -250));
       staticPlatform7.setImage(new BodyImage ("images/floor5.png"));
       Body staticPlatform8 = new Body (game.getWorld(), PolygonShape.makeBox(50, 5), Body.Type.STATIC);
       staticPlatform8.setPosition (new Vec2 (300, -250));
       staticPlatform8.setImage(new BodyImage ("images/floor5.png"));
       Body staticPlatform9 = new Body (game.getWorld(), PolygonShape.makeBox(50, 5), Body.Type.STATIC);
       staticPlatform9.setPosition (new Vec2 (-350, -100));
       staticPlatform9.setImage(new BodyImage ("images/floor5.png"));
       Body staticPlatform10 = new Body (game.getWorld(), PolygonShape.makeBox(50, 5), Body.Type.STATIC);
       staticPlatform10.setPosition (new Vec2 (350, -100));
       staticPlatform10.setImage(new BodyImage ("images/floor5.png"));
       Body staticPlatform11 = new Body(game.getWorld(), PolygonShape.makeBox(30, 10), Body.Type.STATIC);
       staticPlatform11.setPosition(new Vec2(-150, 0));
       staticPlatform11.setImage(new BodyImage("images/movingfloor2.png"));
       Body staticPlatform12 = new Body(game.getWorld(), PolygonShape.makeBox(30, 10), Body.Type.STATIC);
       staticPlatform12.setPosition(new Vec2(150, 0));
       staticPlatform12.setImage(new BodyImage("images/movingfloor2.png"));
       Body staticPlatform13 = new Body(game.getWorld(), PolygonShape.makeBox(30, 10), Body.Type.STATIC);
       staticPlatform13.setPosition(new Vec2(0, 125));
       staticPlatform13.setImage(new BodyImage("images/movingfloor2.png"));
                 
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
        ball1.putOn(staticPlatform9);
        ball1.move(new Vec2(0, 0));
        Pokeball ball2 = new Pokeball(game);
        ball2.putOn(staticPlatform10);
        Pokeball ball3 = new Pokeball(game);
        ball3.putOn(ground);
        Pokeball ball4 = new Pokeball(game);
        ball4.putOn(staticPlatform5);
        ball4.move(new Vec2(0, 0));
        Pokeball ball5 = new Pokeball(game);
        ball5.putOn(staticPlatform6);
        ball5.move(new Vec2(0, 0));
        Pokeball ball6 = new Pokeball(game);
        ball6.putOn(staticPlatform13);
      
        // make some pikachus
        Pikachu pikachu1 = new Pikachu(game);
        pikachu1.putOn(staticPlatform);
        pikachu1.move(new Vec2(0, 0));
        
        //make some lives
        Lives lives1 = new Lives(game);
        lives1.putOn(staticPlatform7);
        Lives lives2 = new Lives(game);
        lives2.putOn(staticPlatform8);
        
        //make some energy
        Energy energy1 = new Energy(game);
        energy1.putOn(staticPlatform11);
        Energy energy2 = new Energy(game);
        energy2.putOn(staticPlatform12);
        Energy energy3 = new Energy(game);
        energy3.putOn(staticPlatform2);
        
        // make some magikarps
        Magikarp karp1 = new Magikarp(game);
        karp1.putOn(ground);
        Magikarp karp2 = new Magikarp(game);
        karp2.putOn(ground);
        karp2.move(new Vec2(-200,0));
        Magikarp karp3 = new Magikarp(game);
        karp3.putOn(ground);
        karp3.move(new Vec2(200,0));
        Magikarp karp4 = new Magikarp(game);
        karp4.putOn(ground);
        karp4.move(new Vec2(-250,0));
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
        Magikarp karp12 = new Magikarp(game);
        Magikarp karp10 = new Magikarp(game);
        karp10.putOn(ground);
        karp10.move(new Vec2(-400,0));
        Magikarp karp11 = new Magikarp(game);
        karp11.putOn(ground);
        karp11.move(new Vec2(400,0));
        karp12.putOn(ground);
        karp12.move(new Vec2(-150,0));
        Magikarp karp13 = new Magikarp(game);
        karp13.putOn(ground);
        karp13.move(new Vec2(150,0));
        Magikarp karp14 = new Magikarp(game);
        karp14.putOn(staticPlatform3);
        Magikarp karp15 = new Magikarp(game);
        karp15.putOn(staticPlatform4);
    }



public boolean isCompleted() {
return false;
}

public void putPlayerAtStart() {
game.getPlayer().putOn(ground);
       game.getPlayer().move(new Vec2(-90, 0));
}
           
      
}
