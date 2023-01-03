package operation;

import cn.edu.whut.sept.zuul.*;

public class Item extends Operation {
    private final Command command = getCommand();
    private final Game game = getGame();

    public Item(Command command, Game game) {
        super(command, game);
    }
    @Override
    public Object copeWithCommand() {
        Integer item_totalWeight=game.getPlayer().getCurrentRoom().showItems();
        System.out.println("Items' total weight:"+item_totalWeight);
        System.out.println();
        Integer bag_totalWeight=game.getPlayer().showBag();
        System.out.println("My bag's total weight:"+bag_totalWeight);
        return null;
    }
}

