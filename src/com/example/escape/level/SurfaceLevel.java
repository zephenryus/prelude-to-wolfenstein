package com.example.escape.level;

import com.example.escape.entities.Item;

public class SurfaceLevel extends Level {
  public SurfaceLevel() {
    ceilTex = -1;
    floorCol = 0x508253;
    floorTex = 8 * 3;
    wallCol = 0xa0a0a0;
    name = "Outside";
  }

  public void switchLevel(int id) {
    if (id == 1) game.switchLevel("floor1", 1);
  }

  public void getLoot(int id) {
    super.getLoot(id);
    if (id == 1) game.getLoot(Item.cutters);
  }
}