package src.main.SkillFactory.Telemessage;

public class Main {


    public static void main(String[] args) {
/*
Make class Typer which will type it's Message
symbol by symbol every 500ms
*/

/* This code has to print
Message first. Message second.
in 15 seconds
*/
        new Typer("Message first. ").start();
        new Typer("Message second.").start();

    }

}
