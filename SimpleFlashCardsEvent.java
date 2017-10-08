package simpleflashcards;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleFlashCardsEvent implements ActionListener, ItemListener
{
    SimpleFlashCardsGUI currentGui;

    FlashEngine currentEngine = new FlashEngine();
    int problemNumber;
    String operand;

    public SimpleFlashCardsEvent(SimpleFlashCardsGUI currentGui)
    {
        this.currentGui = currentGui;
        operand = "+";
    }



    public void actionPerformed(ActionEvent evt)
    {
        if (evt.getSource() == currentGui.start)
        {
            currentEngine.reset();

            try
            {
                 problemNumber = Integer.parseInt(currentGui.probInput.getText());
            } catch (Exception e) {
                problemNumber = 10;
                JOptionPane.showMessageDialog(currentGui, "Bad entry... 10 questions will be asked");
            } finally {
                if (problemNumber <= 0)
                {
                    JOptionPane.showMessageDialog(currentGui, "Questions not greater than zero... \nNo questions will be asked");
                    return;
                }
            }

            currentGui.helpMenu.setEnabled(false);
            currentGui.add.setEnabled(false);
            currentGui.sub.setEnabled(false);
            currentGui.mult.setEnabled(false);
            currentGui.div.setEnabled(false);
            currentGui.start.setEnabled(false);

            for(int i = 0; i < problemNumber; i++)
            {
                currentEngine.newProblem(operand);
                int[] numbers = currentEngine.getNumbers();

                FlashCardGUI check = new FlashCardGUI(numbers[0], numbers[1], operand);
                try
                {
                    int answer = Integer.parseInt(JOptionPane.showInputDialog("Input answer for current card: "));
                    check.setAnswer(currentEngine.getAnswer());
                    if (currentEngine.problemRight(answer))
                        JOptionPane.showMessageDialog(currentGui, "Correct");
                    else
                        JOptionPane.showMessageDialog(currentGui, "Incorrect");
                } catch (Exception e)
                {
                    JOptionPane.showMessageDialog(currentGui, "Incorrect");
                }

                check.dispose();
            }

            JOptionPane.showMessageDialog(currentGui, "Questions Correct: " + currentEngine.getCorrect() + "\nTotal Questions: " + currentEngine.getTotal());

            currentGui.helpMenu.setEnabled(true);
            currentGui.add.setEnabled(true);
            currentGui.sub.setEnabled(true);
            currentGui.mult.setEnabled(true);
            currentGui.div.setEnabled(true);
            currentGui.start.setEnabled(true);
        }
        else if (evt.getSource() == currentGui.help)
        {
            try
            {
            	Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "help.pdf");
            } catch(Exception e){
                JOptionPane.showMessageDialog(currentGui, "Adobe Reader must be installed to read this document");
            }
        }

        else if (evt.getSource() == currentGui.about)
        {
            JOptionPane.showMessageDialog(currentGui, "Flash Cards System \n Basic \n Insert Link to github here \n By: Aaron De Menezes");
        }
    }

    public void itemStateChanged(ItemEvent evt)
    {
        if (evt.getSource() == currentGui.add)
            operand = "+";
        else if (evt.getSource() == currentGui.sub)
            operand = "-";
        else if (evt.getSource() == currentGui.mult)
            operand = "*";
        else if (evt.getSource() == currentGui.div)
            operand = "/";
    }
}