package operation;

import cn.edu.whut.sept.zuul.*;


public class Look extends Operation{

    public Look(Command command, Game game) {
        super(command, game);
    }

    @Override
    public Object copeWithCommand() {

        Room currentRoom=this.getGame().getPlayer().getCurrentRoom();
        System.out.println(currentRoom.getShortDescription());
        currentRoom.showItems();
        return null;
    }
}
