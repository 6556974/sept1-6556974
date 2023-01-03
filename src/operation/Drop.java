package operation;

import cn.edu.whut.sept.zuul.*;

public class Drop extends Operation{
    private final Command command = getCommand();
    private final Game game = getGame();

    public Drop(Command command, Game game) {
        super(command, game);
    }

    @Override
    public Object copeWithCommand() {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("What do you want to drop? ");
            return "Unknown what to Drop...";
        }
        String description = command.getSecondWord();
        Integer weight=game.getPlayer().getItem(description);
        if(weight==null){
            System.out.println("You have nothing like “"+description+"”.");
            return "Wrong description!";
        }else{
            //房间添加物品
            game.getPlayer().getCurrentRoom().setItem(description,weight);
            //玩家删除物品
            game.getPlayer().dropItem(description);
            System.out.println("You dropped the "+description+".");
        }
        return "Success!";
    }
}
