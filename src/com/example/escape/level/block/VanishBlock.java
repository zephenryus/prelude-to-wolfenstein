package com.example.escape.level.block;

import com.example.escape.Sound;
import com.example.escape.entities.Item;
import com.example.escape.gui.RubbleSprite;
import com.example.escape.level.Level;

public class VanishBlock extends SolidBlock {
  private boolean gone = false;

  public VanishBlock() {
    tex = 1;
  }

  public boolean use(Level level, Item item) {
    if (gone) return false;

    gone = true;
    blocksMotion = false;
    solidRender = false;
    Sound.crumble.play();

    for (int i = 0; i < 32; i++) {
      RubbleSprite sprite = new RubbleSprite();
      sprite.col = col;
      addSprite(sprite);
    }

    return true;
  }
}
