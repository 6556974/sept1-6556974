/**
 * 该类是“World-of-Zuul”应用程序的房间类。.
 *
 * 一个Rocm对象代表游戏中的一个位置。房间可以由出口通到其他房间。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;

public class Room
{
    private String description;
    private HashMap<String, Room> exits;
    protected HashMap<String,Integer> items=null;
    /**
     * Room对象主要有房间描述、出口两个属性.
     * @param description 对房间的相关描述.
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * 设置房间出口.
     * @param direction 出口的方向，可能的方向有east south west north.
     * @param neighbor 房间的邻居，描述的对象是从某个出口出房间后，下一个要进入的房间.
     */
    public void setExit(String direction, Room neighbor)
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
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    public Integer showItems() {
        Integer totalWeight=0;
        //判断有无物品
        if(this.items == null || this.items.isEmpty()){
            System.out.println("There is nothing...");
        } else {
            String returnString = "items: ";
            Set<String> keys = items.keySet();
            for(String object : keys) {
                totalWeight+=items.get(object);
                returnString += " " + object;
            }
            System.out.println(returnString);
        }
        return totalWeight;
    }

    public Integer getItems(String description){
        return items.get(description);
    }

    public void dropItems(String description) {
        this.items.remove(description);
    }

    public void setItems(String description, Integer weight) {
        this.items.put(description,weight);
    }
}


