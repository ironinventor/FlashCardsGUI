package simpleflashcards;


import javax.swing.*;
import java.awt.*;

public class FlashPanel extends JPanel
{
    int firstNumber;
    int secondNumber;
    int answer;

    boolean answerSet;

    String operand;

    public FlashPanel(int firstNumber, int secondNumber, String operand)
    {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;

        if (operand == "+" || operand == "-" || operand == "*" || operand == "/")
            this.operand = operand;
        this.answerSet = false;
    }

    public void setAnswer(int answer)
    {
        this.answer = answer;
        answerSet = true;
    }

    public int calcOffset(int number)
    {
        int digitOffset = 0;

        for(int i = 0; i < (number + "").length(); i++)
            digitOffset += 24;

        return digitOffset;
    }

    public void paintComponent(Graphics comp)
    {
        Graphics2D comp2D = (Graphics2D)comp;
        comp2D.setFont(new Font("Raleway", Font.PLAIN, 36));
        comp2D.drawString(firstNumber + "", this.getBounds().width - calcOffset(firstNumber), 50);
        comp2D.drawString(secondNumber + "", this.getBounds().width - calcOffset(secondNumber), 100);
        comp2D.drawString(operand, 15, 100);

        if (answerSet)
            comp2D.drawString(answer + "", this.getBounds().width - calcOffset(answer), 150);
    }
}