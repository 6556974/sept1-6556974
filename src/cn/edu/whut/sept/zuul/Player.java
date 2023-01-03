/**
 * 该类是“World-of-Zuul”应用程序的玩家类。.
 *
 * @author Dian Tu
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;

import room.GeneralRoom;

import java.util.HashMap;
import java.util.Set;

public class Player {
    private GeneralRoom currentRoom;
    private GeneralRoom lastRoom;
    private  Integer maxLoadNum=3;
    private HashMap<String,Integer> bag=null;

    /**
     * 初始化玩家信息.
     */
    public Player() {
        this.bag=new HashMap<>();
    }

    /**
     * 获取最大负重量.
     */
    public Integer getMaxLoadNum() {
        return maxLoadNum;
    }

    /**
     * 设置最大负重量.
     */
    public void setMaxLoadNum(Integer maxLoadNum) {
        this.maxLoadNum = maxLoadNum;
    }

    /**
     * 获取玩家背包.
     */
    public HashMap<String, Integer> getBag() {
        return bag;
    }

    /**
     * 设置玩家背包.
     */
    public void setBag(HashMap<String, Integer> bag) {
        this.bag = bag;
    }

    /**
     * 获取当前所在房间.
     */
    public GeneralRoom getCurrentRoom() {
        return currentRoom;
    }

    /**
     * 设置当前所在房间.
     */
    public void setCurrentRoom(GeneralRoom currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * 获取玩家上一次所在的房间.
     */
    public GeneralRoom getLastRoom() {
        return lastRoom;
    }

    /**
     * 获取玩家上一次所在的房间.
     */
    public void setLastRoom(GeneralRoom lastRoom) {
        this.lastRoom = lastRoom;
    }

    /**
     * 获取玩家背包是否超重.
     */
    public boolean isOverWeight(Integer weight) {
        Set<String> keys=bag.keySet();
        Integer totalWeight=0;
        for(String item:keys){
            totalWeight+=bag.get(item);
        }
        totalWeight+=weight;
        if(this.maxLoadNum>=totalWeight){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 设置物品信息.
     */
    public void setItem(String description, Integer weight) {
        this.bag.put(description,weight);
    }

    /**
     * 获取物品信息.
     */
    public Integer getItem(String description) {
        return bag.get(description);
    }

    /**
     * 扔掉物品.
     */
    public void dropItem(String description) {
        this.bag.remove(description);
    }

    /**
     * 显示玩家背包中物品信息.
     */
    public Integer showBag() {
        Integer totalWeight=0;
        //判断有无物品
        if(this.bag == null || this.bag .isEmpty()){
            System.out.println("You have nothing...");
        } else {
            String returnString = "Bag: ";
            Set<String> keys = bag .keySet();
            for(String item : keys) {
                totalWeight+=bag .get(item);
                returnString += " " + item;
            }
            System.out.println(returnString);
        }
        return totalWeight;
    }
}
