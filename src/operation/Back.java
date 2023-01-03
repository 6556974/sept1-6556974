package operation;

import cn.edu.whut.sept.zuul.*;
import room.GeneralRoom;


public class Back extends Operation{
    private final Command command = getCommand();
    private final Game game = getGame();

    public Back(Command command, Game game) {
        super(command, game);
    }

    @Override
    public Object copeWithCommand() {
        //判断是否有上个房间
        if(game.getPlayer().getLastRoom() == null){
            System.out.println("You haven't move yet! please choose an exit to go first. ");
            return "default moving !";
        }
        // 尝试离开当前房间,前往新房间
        GeneralRoom nextRoom = game.getPlayer().getLastRoom();

        if (nextRoom==null) {
            System.out.println("There is no door!");
        } else { // 切换房间
            //保存上个房间
            game.getPlayer().setLastRoom(game.getPlayer().getCurrentRoom());
            //进入下一个房间
            game.getPlayer().setCurrentRoom(nextRoom);
            System.out.println(game.getPlayer().getCurrentRoom().getLongDescription());
        }
        return "Success moving !";
    }
}

