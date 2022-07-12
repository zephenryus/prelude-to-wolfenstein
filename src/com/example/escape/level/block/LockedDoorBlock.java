package com.example.escape.level.block;

import com.example.escape.entities.Item;
import com.example.escape.level.Level;

public class LockedDoorBlock extends DoorBlock {
  public LockedDoorBlock() {
    tex = 5;
  }

  public boolean use(Level level, Item item) {
    System.out.println(level.player.keys);
    if (level.player.keys > 0) {
      level.player.keys--;
      open = true;
      return true;
    }

    return false;
  }

  public void trigger(boolean pressed) {
    open = pressed;
  }

}
