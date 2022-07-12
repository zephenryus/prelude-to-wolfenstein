package com.example.escape.level.block;

import com.example.escape.Art;
import com.example.escape.Sound;
import com.example.escape.entities.Entity;
import com.example.escape.entities.Player;
import com.example.escape.gui.Sprite;

public class HealthBlock extends Block {
  private boolean taken = false;
  private Sprite sprite;

  public HealthBlock() {
    sprite = new Sprite(0, 0, 0, 2 * 8 + 6, Art.getCol(0xffeeee));
    addSprite(sprite);
    blocksMotion = true;
  }

  public void addEntity(Entity entity) {
    super.addEntity(entity);
    if (!taken && entity instanceof Player) {
      sprite.removed = true;
      taken = true;
      blocksMotion = false;
      ((Player) entity).health += 5;
      Sound.pickup.play();
    }
  }

  public boolean blocks(Entity entity) {
    if (entity instanceof Player) return false;
    return blocksMotion;
  }
}
