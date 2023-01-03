package operation;

import cn.edu.whut.sept.zuul.*;
import room.GeneralRoom;

import java.util.Random;

public class Go extends Operation {
    private final Command command = getCommand();
    private final Game game = getGame();

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
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return "Unknow where to Go....";
        }

        String direction = command.getSecondWord();
        if(direction.equals("start")){
            game.getPlayer().setCurrentRoom(game.getStartRoom());
            game.getPlayer().setLastRoom(null);
            System.out.println(game.getPlayer().getCurrentRoom().getLongDescription());
        }else{
            // 尝试离开当前房间,前往新房间
            GeneralRoom nextRoom = game.getPlayer().getCurrentRoom().getExit(direction);
            if (nextRoom==null) {
                System.out.println("There is no door!");
            } else if (nextRoom.isTransfer()) {
                //下一个房间为传送房间
                //输出房间信息
                System.out.println(nextRoom.getShortDescription());
                //找到随即房间
                GeneralRoom newRoom = null;
                Random random=new Random();
                newRoom = game.getRoomList().get(random.nextInt(game.getRoomList().size()));
                //game.setLastRoom(null);
                //game.setCurrentRoom(newRoom);
                game.getPlayer().setCurrentRoom(newRoom);
                game.getPlayer().setLastRoom(null);
                System.out.println(game.getPlayer().getCurrentRoom().getLongDescription());
            } else {
                // 下一个房间为普通房间
                //保存上个房间
                //game.setLastRoom(game.getCurrentRoom());
                game.getPlayer().setLastRoom(game.getPlayer().getCurrentRoom());
                //进入下一个房间
                //game.setCurrentRoom(nextRoom);
                game.getPlayer().setCurrentRoom(nextRoom);

                System.out.println(game.getPlayer().getCurrentRoom().getLongDescription());
            }
        }

        return "Success moving !";
    }
}

