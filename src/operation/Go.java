package operation;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Room;

public class Go extends Operation {
    private final Command command = getCommand();
    private final Game game = getGame();
    private Room currentRoom;

    /**
     * @param command 读入的命令
     * @param game    相关Game类
     */
    public Go(Command command, Game game) {
        super(command, game);
    }

    /**
     * 执行go指令，向房间的指定方向出口移动，如果该出口连接了另一个房间，则会进入该房间，
     * 否则打印输出错误提示信息.
     */
    @Override
    public Object copeWithCommand() {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return "Unknow where to Go....";
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = this.getGame().getcurrentRoom().getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            this.currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
        return "Success moving!";
    }
}

