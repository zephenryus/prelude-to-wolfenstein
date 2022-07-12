package com.example.escape.entities;

import com.example.escape.Art;
import com.example.escape.Sound;

public class MiniBossGuardEntity extends EnemyEntity {
  private int shootDelay;

  public MiniBossGuardEntity(double x, double z) {
    super(x, z, 4 * 8 + 4, Art.getCol(0x84ecff));
    this.x = x;
    this.z = z;
    health = 8;
    r = 0.3;
    spinSpeed *= 1.5;
    flying = true;
  }

  @Override
  protected void hurt(double xd, double zd, int dmg) {
    super.hurt(xd, zd, dmg);
    shootDelay = 50;
  }

  protected void die() {
    Sound.bosskill.play();
    level.addEntity(new KeyEntity(x, z));
  }

  public void tick() {
    super.tick();
    if (shootDelay > 0) shootDelay--;
    else if (random.nextInt(40) == 0) {
      shootDelay = 2 * 60;
      level.addEntity(new Bullet(this, x, z, Math.atan2(level.player.x - x, level.player.z - z), 0.3, 1, defaultColor));
    }
  }
}
