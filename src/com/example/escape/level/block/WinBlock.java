package com.example.escape.level.block;

import com.example.escape.entities.Entity;
import com.example.escape.entities.Player;

public class WinBlock extends Block {
  public void addEntity(Entity entity) {
    super.addEntity(entity);
    if (entity instanceof Player) {
      ((Player) entity).win();
    }
  }
}
