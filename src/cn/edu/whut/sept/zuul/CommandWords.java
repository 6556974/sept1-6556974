/**
 * 该类是“World-of-Zuul”应用程序的指令词类。.
 *
 * 该类通过存储一个命令词汇字符串数组来定义游戏中所有有效的命令。
 * 用户通过输入合法的指令词与电脑持续互动，并导致游戏的进行。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;

public class CommandWords
{
    /**
     * 定义合法的指令词.
     */
    private static final String[] validCommands = {
            "go", "quit", "help"
    };


    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * 判断用户输入的指令是否合法.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }

    /**
     * 显示所有合法指令.
     */
    public void showAll()
    {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
