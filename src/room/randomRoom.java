package room;

import java.util.HashMap;

public class randomRoom extends GeneralRoom{
    private int number;

    /**
     * 随机房间.
     */
    public randomRoom(int num, String description){
        super();
        this.setTransfer(true);
        this.exits = new HashMap<>();
        this.items=new HashMap<>();
        this.number=num;
        this.setDescription(description);
    }
}
