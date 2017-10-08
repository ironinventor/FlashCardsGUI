package simpleflashcards;


import javax.swing.*;
import java.awt.*;

public class FlashCardGUI extends JFrame
{
    JPanel mainPanel = new JPanel();
    FlashPanel card;

    public FlashCardGUI(int firstNumber, int secondNumber, String operand)
    {
        super("Flash Card");
        setSize(100, 200);
        this.setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        card = new FlashPanel(firstNumber, secondNumber, operand);
        add(card);

        setVisible(true);
    }
    
    public void setAnswer(int answer)
    {
        card.setAnswer(answer);
        card.repaint();
    }
}