package cn.edu.whut.sept.zuul;

import room.GeneralRoom;

import java.util.HashMap;
import java.util.Set;

public class Player {
    private GeneralRoom currentRoom;
    private GeneralRoom lastRoom;
    private  Integer maxLoadNum=3;
    private HashMap<String,Integer> bag=null;

    public Player() {
        this.bag=new HashMap<>();
    }
    public Integer getMaxLoadNum() {
        return maxLoadNum;
    }
    public void setMaxLoadNum(Integer maxLoadNum) {
        this.maxLoadNum = maxLoadNum;
    }

    public HashMap<String, Integer> getBag() {
        return bag;
    }

    public void setBag(HashMap<String, Integer> bag) {
        this.bag = bag;
    }
    public GeneralRoom getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(GeneralRoom currentRoom) {
        this.currentRoom = currentRoom;
    }

    public GeneralRoom getLastRoom() {
        return lastRoom;
    }

    public void setLastRoom(GeneralRoom lastRoom) {
        this.lastRoom = lastRoom;
    }

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

    public void setItem(String description, Integer weight) {
        this.bag.put(description,weight);
    }

    public Integer getItem(String description) {
        return bag.get(description);
    }

    public void dropItem(String description) {
        this.bag.remove(description);
    }
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
