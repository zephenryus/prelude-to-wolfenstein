package com.example.escape.entities;

import com.example.escape.Art;

public class ZombieGuardEntity extends EnemyEntity {
  private int shootDelay;

  public ZombieGuardEntity(double x, double z) {
    super(x, z, 4 * 8, Art.getCol(0xaaaaaa));
    this.x = x;
    this.z = z;
    health = 2;
    r = 0.4;
    spinSpeed = 0.05;
  }

  public void tick() {
    super.tick();
    if (shootDelay > 0) shootDelay--;
    else if (random.nextInt(40) == 0) {
      shootDelay = 5 * 60;
      level.addEntity(new Bullet(this, x, z, Math.atan2(level.player.x - x, level.player.z - z), 0.3, 1, defaultColor));
    }
  }
}
