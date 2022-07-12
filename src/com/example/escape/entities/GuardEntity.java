package com.example.escape.entities;

import com.example.escape.Art;

public class GuardEntity extends EnemyEntity {
  private int shootDelay;

  public GuardEntity(double x, double z) {
    super(x, z, 4 * 8, Art.getCol(0xab984c));
    this.x = x;
    this.z = z;
    health = 4;
    r = 0.4;
    spinSpeed = 0.05;
  }

  @Override
  protected void hurt(double xd, double zd, int dmg) {
    super.hurt(xd, zd, dmg);
    shootDelay = 50;
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
