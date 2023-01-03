package operation;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;

public abstract class Operation {
    /**
     * 用于读入命令
     */
    private Command command = null;
    /**
     * 关联的Game类.
     */
    private Game game = null;

    /**
     *
     * @param command 接收到的命令
     * @param game    Game实体
     */
    public Operation(Command command, Game game) {
        this.command = command;
        this.game = game;
    }

    /**
     * @return 返回一个命令
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

    /**
     * @return 使用时利用强转改变
     */
    public abstract Object copeWithCommand();
}
