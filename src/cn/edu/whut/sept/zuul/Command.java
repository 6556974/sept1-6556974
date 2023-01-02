/**
 * 该类是“World-of-Zuul”应用程序的指令类。.
 *
 * 一个Commard对象代表了用户输人的命令，它有一些方法可以很容易地判断是否是有效的命令，还
 * 可以将命令中的第一个和第二个单词分离出来。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;

public class Command
{
    private String commandWord;
    private String secondWord;

    /**
     * Command对象定义为用户输入的两个英文单词.
     * @param firstWord 用户输入的第一个词，由解析器从用户输入内容生成.
     * @param secondWord 用户输入的第二个词，由解析器从用户输入内容生成.
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * 获取指令词.
     * @return 返回指令词.
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * 获取用户输入的第二个词.
     * @return 返回用户输入的第二个词.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * 判断用户的输入是否未知.
     * @return 如果未知，则返回true，否则返回false.
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * 判断用户的输入是否有第二个单词.
     * @return 如果有第二个单词，则返回true，否则返回false.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}
