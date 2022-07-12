package com.example.escape.entities;

import com.example.escape.Art;

public class BatEntity extends EnemyEntity {
  public BatEntity(double x, double z) {
    super(x, z, 5 * 8 + 0, Art.getCol(0x82666E));
    this.x = x;
    this.z = z;
    health = 1;
    r = 0.3;

    flying = true;
  }

  @Override
  protected void hurt(double xd, double zd, int dmg) {
    super.hurt(xd, zd, dmg);
  }
}
