package com.example.escape.level.block;

import com.example.escape.Art;
import com.example.escape.Sound;
import com.example.escape.entities.Entity;
import com.example.escape.entities.GhostBossEntity;
import com.example.escape.entities.GhostEntity;
import com.example.escape.entities.KeyEntity;
import com.example.escape.gui.RubbleSprite;
import com.example.escape.gui.Sprite;

public class AltarBlock extends Block {
  private boolean filled = false;
  private Sprite sprite;

  public AltarBlock() {
    blocksMotion = true;
    sprite = new Sprite(0, 0, 0, 16 + 4, Art.getCol(0xE2FFE4));
    addSprite(sprite);
  }

  public void addEntity(Entity entity) {
    super.addEntity(entity);
    if (!filled && (entity instanceof GhostEntity || entity instanceof GhostBossEntity)) {
      entity.remove();
      filled = true;
      blocksMotion = false;
      sprite.removed = true;

      for (int i = 0; i < 8; i++) {
        RubbleSprite sprite = new RubbleSprite();
        sprite.col = this.sprite.col;
        addSprite(sprite);
      }

      if (entity instanceof GhostBossEntity) {
        level.addEntity(new KeyEntity(x, y));
        Sound.bosskill.play();
      } else {
        Sound.altar.play();
      }
    }
  }

  public boolean blocks(Entity entity) {
    return blocksMotion;
  }
}
