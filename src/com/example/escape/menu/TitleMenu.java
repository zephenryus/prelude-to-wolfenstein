package com.example.escape.menu;

import com.example.escape.Art;
import com.example.escape.Game;
import com.example.escape.Sound;
import com.example.escape.gui.Bitmap;

public class TitleMenu extends Menu {
  private String[] options = {"New game", "Instructions"};
  private int selected = 0;
  private boolean firstTick = true;

  public void render(Bitmap target) {
    target.fill(0, 0, 160, 120, 0);
    target.draw(Art.logo, 0, 16, 0, 0, 160, 36, Art.getCol(0xffffff));

    for (int i = 0; i < options.length; i++) {
      String msg = options[i];
      int col = 0x909090;
      if (selected == i) {
        msg = "-> " + msg;
        col = 0xffff80;
      }
      target.draw(msg, 40, 72 + i * 10, Art.getCol(col));
    }
  }

  public void tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean use) {
    if (firstTick) {
      firstTick = false;
      Sound.altar.play();
    }
    if (up || down) Sound.click2.play();
    if (up) selected--;
    if (down) selected++;
    if (selected < 0) selected = 0;
    if (selected >= options.length) selected = options.length - 1;
    if (use) {
      Sound.click1.play();
      if (selected == 0) {
        game.setMenu(null);
        game.newGame();
      }
      if (selected == 1) {
        game.setMenu(new InstructionsMenu());
      }
    }
  }
}