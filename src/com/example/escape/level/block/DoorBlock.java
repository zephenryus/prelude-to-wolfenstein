package com.example.escape.level.block;

import com.example.escape.Sound;
import com.example.escape.entities.*;
import com.example.escape.level.Level;

public class DoorBlock extends SolidBlock {
  public boolean open = false;
  public double openness = 0;
  public boolean moving = false;
  private int doorCooldown = 0;

  public DoorBlock() {
    tex = 4;
    solidRender = false;
  }

  public boolean use(Level level, Item item) {
    if (!moving && doorCooldown == 0) {
      open = !open;
      moving = true;
      doorCooldown = 20;

      if (open)
        Sound.click1.play();
      else
        Sound.click2.play();
      return true;
    }

    return false;
  }

  public void tick() {
    super.tick();

    if (doorCooldown > 0) doorCooldown--;

    if (open) openness += 0.2;
    else openness -= 0.2;
    if (openness < 0) openness = 0;
    if (openness > 1) openness = 1;

    double openLimit = 7 / 8.0;
    if (openness < openLimit && !open && !blocksMotion) {
      if (level.containsBlockingEntity(x - 0.5, y - 0.5, x + 0.5, y + 0.5)) {
        openness = openLimit;
        return;
      }
    }

    blocksMotion = openness < openLimit;
    moving = (openness < openLimit && openness > 0);
  }

  public boolean blocks(Entity entity) {
    double openLimit = 7 / 8.0;
    if (openness >= openLimit && entity instanceof Player) return blocksMotion;
    if (openness >= openLimit && entity instanceof Bullet) return blocksMotion;
    if (openness >= openLimit && entity instanceof OgreEntity) return blocksMotion;
    return true;
  }
}
