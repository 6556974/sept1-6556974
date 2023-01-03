package operation;

import cn.edu.whut.sept.zuul.*;
import room.GeneralRoom;


public class Look extends Operation{

    public Look(Command command, Game game) {
        super(command, game);
    }

    @Override
    public Object copeWithCommand() {

        GeneralRoom currentRoom=this.getGame().getPlayer().getCurrentRoom();
        System.out.println(currentRoom.getShortDescription());
        currentRoom.showItems();
        return null;
    }
}
