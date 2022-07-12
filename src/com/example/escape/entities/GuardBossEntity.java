package com.example.escape.entities;

import com.example.escape.Art;
import com.example.escape.Sound;

public class GuardBossEntity extends EnemyEntity {
  private int shootDelay;
  private boolean firing;
  private int rapidFire;
  private int rapidFireDelay;

  public GuardBossEntity(double x, double z) {
    super(x, z, 4 * 8 + 2, Art.getCol(0x930000));
    this.x = x;
    this.z = z;
    health = 40;
    r = 0.4;
    spinSpeed = 0.05;
    rapidFire = 5;
    rapidFireDelay = 15;
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
    if (rapidFireDelay > 0) rapidFireDelay--;
    if (shootDelay > 0) shootDelay--;

    if (!firing && rapidFireDelay == 0 && shootDelay == 0 && random.nextInt(40) == 0) {
      shootDelay = 2 * 60;
      rapidFire = 5;
      firing = true;
    }

    if (firing && rapidFireDelay == 0 && rapidFire > 0) {
      rapidFireDelay = 15;
      rapidFire--;

      level.addEntity(new Bullet(this, x, z, Math.atan2(level.player.x - x, level.player.z - z), 0.2, 1, defaultColor));

      if (rapidFire == 0) firing = false;
    }
  }
}
