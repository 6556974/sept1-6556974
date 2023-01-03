package room;

import java.util.HashMap;

public class CommonRoom extends GeneralRoom{
    private int number;
    public CommonRoom(HashMap<String, Integer> item, int num,String description){
        super();
        this.setTransfer(false);
        this.exits = new HashMap<>();
        this.items=item;
        this.number=num;
        this.setDescription(description);
    }

}

