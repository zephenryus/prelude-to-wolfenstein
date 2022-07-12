package com.example.escape.entities;

import com.example.escape.Art;
import com.example.escape.Sound;
import com.example.escape.gui.Sprite;

public class PistolEntity extends Entity {
  public static final int COLOR = Art.getCol(0x00ffff);
  private Sprite sprite;
  private double y, ya;

  public PistolEntity(double x, double z) {
    this.x = x;
    this.z = z;
    y = 0.5;
    ya = 0.025;
    sprite = new Sprite(0, 0, 0, 2 * 8 + 7, COLOR);
    sprites.add(sprite);
  }

  public void tick() {
    move();
    y += ya;
    if (y < 0) y = 0;
    ya -= 0.005;
    sprite.y = y;
  }

  protected void collide(Entity entity) {
    if (entity instanceof Player) {
      Sound.key.play();
      ((Player) entity).addLoot(Item.pistol);
      remove();
    }
  }
}
