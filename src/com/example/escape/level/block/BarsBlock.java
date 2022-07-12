package com.example.escape.level.block;

import com.example.escape.entities.Bullet;
import com.example.escape.entities.Entity;
import com.example.escape.entities.Item;
import com.example.escape.Sound;
import com.example.escape.entities.Player;
import com.example.escape.gui.Sprite;
import com.example.escape.level.Level;

public class BarsBlock extends Block {
  private Sprite sprite;
  private boolean open = false;

  public BarsBlock() {
    sprite = new Sprite(0, 0, 0, 0, 0x202020);
    addSprite(sprite);
    blocksMotion = true;
  }

  public boolean use(Level level, Item item) {
    if (open) return false;

    if (item == Item.cutters) {
      Sound.cut.play();
      sprite.tex = 1;
      open = true;
    }

    return true;
  }

  public boolean blocks(Entity entity) {
    if (open && entity instanceof Player) return false;
    if (open && entity instanceof Bullet) return false;
    return blocksMotion;
  }
}
