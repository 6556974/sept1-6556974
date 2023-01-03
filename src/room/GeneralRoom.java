/**
 * GeneralRoom为抽象类，.
 *
 * @author Dian Tu
 * @version 1.0
 */
package room;

import java.util.HashMap;
import java.util.Set;

public abstract class GeneralRoom {
    private boolean isTransfer;
    private String description;
    protected HashMap<String, GeneralRoom> exits;
    protected HashMap<String,Integer> items=null;

    public void setDescription(String name){
        this.description = name;
    }

    /**
     * 设置房间出口.
     * @param direction 出口的方向，可能的方向有east south west north.
     * @param neighbor 房间的邻居，描述的对象是从某个出口出房间后，下一个要进入的房间.
     */
    public void setExit(String direction, GeneralRoom neighbor)
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    /**
     * 获取长描述.
     * @return 返回的是玩家当前所处的位置.
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
    public boolean isTransfer() {
        return isTransfer;
    }
    public void setTransfer(boolean transfer) {
        isTransfer = transfer;
    }

    /**
     * 获取可供选择的出口信息.
     * @return 返回的是玩家当前所处的房间可供选择的出口.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * 选择出口.
     * @return 返回的是玩家选择的出口.
     */
    public GeneralRoom getExit(String direction)
    {
        return exits.get(direction);
    }

    public Integer showItems() {
        Integer totalWeight=0;
        //判断有无物品
        if(this.items == null || this.items.isEmpty()){
            System.out.println("There is nothing...");
        } else {
            String returnString = "Objects:";
            Set<String> keys = items.keySet();
            for(String object : keys) {
                totalWeight+=items.get(object);
                returnString += " " + object;
            }
            System.out.println(returnString);
        }
        return totalWeight;
    }
    public Integer getItem(String description){ return items.get(description); }

    public void dropItem(String description) {
        this.items.remove(description);
    }

    public void setItem(String description, Integer weight) {
        this.items.put(description,weight);
    }
}

