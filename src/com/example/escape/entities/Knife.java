package com.example.escape.entities;

import com.example.escape.Art;
import com.example.escape.gui.Sprite;

public class Knife extends DamagingEntity {
  Entity owner;

  int duration = 10;

  public Knife(Entity owner, double x, double z, double rot, double pow, int sprite, int col) {
    this.r = 0.01;
    this.owner = owner;

    xa = Math.sin(rot) * 0.2 * pow;
    za = Math.cos(rot) * 0.2 * pow;
    this.x = x - za / 2;
    this.z = z + xa / 2;

    flying = true;

    dmg = 1;
  }

  public void tick() {
    if (duration > 0) duration--;
    else remove();
    double xao = xa;
    double zao = za;
    move();

    if ((xa == 0 && za == 0) || xa != xao || za != zao) {
      remove();
    }
  }

  public boolean blocks(Entity entity, double x2, double z2, double r2) {
    if (entity instanceof Knife) {
      return false;
    }
    if (entity == owner) return false;

    return super.blocks(entity, x2, z2, r2);
  }

  protected void collide(Entity entity) {
  }
}
