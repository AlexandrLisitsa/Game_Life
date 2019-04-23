package handler;

import game.Game;
import handler.impl.ConfigFiled;

public interface DataExportProvider {
    void toFile(String directory, Game game);
}
