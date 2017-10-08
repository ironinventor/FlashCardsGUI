package simpleflashcards;

import javax.swing.*;
import java.awt.*;

public class SimpleFlashCardsGUI extends JFrame
{
    SimpleFlashCardsEvent evtListener = new SimpleFlashCardsEvent(this);

    JMenuBar flashCardsBar = new JMenuBar();
    JMenu helpMenu = new JMenu("Help");
    JMenuItem help = new JMenuItem("Help");
    JMenuItem about = new JMenuItem("About");

    JPanel checkPanel = new JPanel();
    ButtonGroup cardType = new ButtonGroup();
    JCheckBox add = new JCheckBox("Addition", true);
    JCheckBox sub = new JCheckBox("Subtraction", false);
    JCheckBox mult = new JCheckBox("Multiplication", false);
    JCheckBox div = new JCheckBox("Division", false);

    JPanel inputPanel = new JPanel();
    JLabel probNumbers = new JLabel("Input number of problems: ");
    JTextField probInput = new JTextField("10", 10);
    JButton start = new JButton("Start");

    public SimpleFlashCardsGUI()
    {
        super("SimpleFlashCards");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        help.addActionListener(evtListener);
        about.addActionListener(evtListener);
        add.addItemListener(evtListener);
        sub.addItemListener(evtListener);
        mult.addItemListener(evtListener);
        div.addItemListener(evtListener);
        start.addActionListener(evtListener);

        setLayout(new BorderLayout());

        helpMenu.add(help);
        helpMenu.add(about);

        flashCardsBar.add(helpMenu);

        cardType.add(add);
        cardType.add(sub);
        cardType.add(mult);
        cardType.add(div);

        checkPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        checkPanel.add(add);
        checkPanel.add(sub);
        checkPanel.add(mult);
        checkPanel.add(div);

        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(probNumbers);
        inputPanel.add(probInput);
        inputPanel.add(start);

        setJMenuBar(flashCardsBar);

        add(checkPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] arguments)
    {
        SimpleFlashCardsGUI groovyJukebox = new SimpleFlashCardsGUI();
    }
}