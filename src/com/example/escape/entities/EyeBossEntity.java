package com.example.escape.entities;

import com.example.escape.Art;
import com.example.escape.Sound;

public class EyeBossEntity extends EnemyEntity {
  public EyeBossEntity(double x, double z) {
    super(x, z, 4 * 8 + 4, Art.getCol(0xffff00));
    this.x = x;
    this.z = z;
    health = 10;
    r = 0.3;
    runSpeed = 4;
    spinSpeed *= 1.5;

    flying = true;
  }

  protected void die() {
    Sound.bosskill.play();
    level.addEntity(new KeyEntity(x, z));
  }
}
