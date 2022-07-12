package com.example.escape.level;

import com.example.escape.entities.Item;
import com.example.escape.level.block.Block;

public class Floor1Level extends Level {
  public Floor1Level() {
    wallCol = 0x000093;
    floorCol = 0x616161;
    ceilCol = 0x31312f;
    name = "Floor1";
  }

  protected void decorateBlock(int x, int y, Block block, int col) {
    super.decorateBlock(x, y, block, col);
  }

  protected Block getBlock(int x, int y, int col) {
    return super.getBlock(x, y, col);
  }

  public void switchLevel(int id) {
    if (id == 1) game.switchLevel("surface", 1);
  }

  public void getLoot(int id) {
    super.getLoot(id);
    if (id == 1) game.getLoot(Item.pistol);
  }
}