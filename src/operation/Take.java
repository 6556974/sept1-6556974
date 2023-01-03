package operation;

import cn.edu.whut.sept.zuul.*;

public class Take extends Operation{
    private final Command command = getCommand();
    private final Game game = getGame();

    public Take(Command command, Game game) {
        super(command, game);
    }

    @Override
    public Object copeWithCommand() {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("What do you want to take? ");
            return "Unknown what to Take...";
        }
        String description = command.getSecondWord();
        Integer weight=game.getPlayer().getCurrentRoom().getItem(description);
        if(weight==null){
            System.out.println("There is nothing like “"+description+"”.");
            return "Wrong description! ";
        }else if(game.getPlayer().isOverWeight(weight)){
            System.out.println("It is overweight! You can't take it.");
            return "Overweight!";
        }else{
            //玩家添加物品
            game.getPlayer().setItem(description,weight);
            //房间删除物品
            game.getPlayer().getCurrentRoom().dropItem(description);
            System.out.println("You got it! ");
        }
        return "Success! ";
    }

}

