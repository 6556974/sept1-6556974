package operation;

import cn.edu.whut.sept.zuul.*;

public class Eat extends Operation{
    private final Command command = getCommand();
    private final Game game = getGame();

    public Eat(Command command, Game game) {
        super(command, game);
    }

    @Override
    public Object copeWithCommand() {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("What do you want to eat? ");
            return "Unknown what to Eat...";
        }
        String description = command.getSecondWord();
        if(!description.equals("cookie")){
            System.out.println("You can't eat it. ");
            return "Wrong description! ";
        }
        //先看房间中有没有cookie
        Integer weight=game.getPlayer().getCurrentRoom().getItem(description);
        if(weight!=null){
            //房间删除饼干
            game.getPlayer().getCurrentRoom().dropItem(description);
            //玩家承重增加
            game.getPlayer().setMaxLoadNum(game.getPlayer().getMaxLoadNum()+2);
            System.out.println("Congratulations! You can take more things now.");
            return "Success!";
        }else{
            //查询玩家行李中是否有饼干
            weight=game.getPlayer().getItem(description);
            //有饼干时
            if(weight!=null) {
                //背包删除饼干
                game.getPlayer().dropItem(description);
                //玩家承重增加
                game.getPlayer().setMaxLoadNum(game.getPlayer().getMaxLoadNum() + 2);
                System.out.println("Congratulations! You can take more things now.");
                return "Success!";
            }else{
                System.out.println("Sorry, there is no cookie.");
                return "No cookie!";
            }
        }


    }
}
