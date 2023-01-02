/**
 * 该类是“World-of-Zuul”应用程序的指令词类。.
 *
 * 用户通过输入合法的指令词与电脑持续互动，并导致游戏的进行。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;

import java.util.Scanner;

public class Parser
{
    private CommandWords commands;
    private Scanner reader;

    /**
     * 初始化指令词和取词器.
     */
    public Parser()
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * 通过取词器按行读取用户输入.
     * @return 返回用户输入的单词指令，如果用户输入一个单词则返回一个单词，如果用户输入两个单词则返回两个单词.
     */
    public Command getCommand()
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();   
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2);
        }
    }

    /**
     * 显示所有指令.
     */
    public void showCommands()
    {
        commands.showAll();
    }
}
