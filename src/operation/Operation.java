package operation;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;

public abstract class Operation {
    private Command command = null;
    private Game game = null;

    /**
     *
     * @param command 接收到的指令
     * @param game    Game实体
     */
    public Operation(Command command, Game game) {
        this.command = command;
        this.game = game;
    }

    /**
     * @return 返回一个指令
     */
    public Command getCommand() {

        return this.command;
    }

    /**
     *
     * @return 返回Game实体
     */
    public Game getGame() {

        return this.game;
    }

    public abstract Object copeWithCommand();
}
