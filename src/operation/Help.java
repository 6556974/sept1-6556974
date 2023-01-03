package operation;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;

public class Help extends Operation {

    public Help(Command command, Game game) {
        super(command, game);
    }


    @Override
    /**
     * 执行help指令，在终端打印游戏帮助信息.
     * 此处会输出游戏中用户可以输入的命令列表
     */
    public Object copeWithCommand() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        this.getGame().getParser().showCommands();
        return null;
    }
}

