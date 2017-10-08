package simpleflashcards;

import java.util.*;

public class FlashEngine
{
    int numberCorrect;
    int totalNumber;

    int randNumber1;
    int randNumber2;

    int[][] multTable = new int[12][12];

    int answer;

    public FlashEngine()
    {
        numberCorrect = 0;
        totalNumber = 0;

        for(int j = 0; j <= 11; j++)
            for(int i = 0; i <= 11; i++)
                multTable[j][i] = (j+1) * (i+1);
    }

    public void newProblem(String operand)
    {
        if (operand.equals("+") || operand.equals("-") || operand.equals("*"))
        {
            randNumber1 = (int)(Math.random() * 12) + 1;
            randNumber2 = (int)(Math.random() * 12) + 1;
        } 
	else if (operand.equals("/"))
        {
            randNumber2 = (int)(Math.random() * 12) + 1;
            randNumber1 = multTable[randNumber2-1][(int)(Math.random() *12)];
        }

        if (operand.equals("+"))
            answer = randNumber1 + randNumber2;
        else if (operand.equals("-"))
            answer = randNumber1 - randNumber2;
        else if (operand.equals("*"))
            answer = randNumber1 * randNumber2;
        else if (operand.equals("/"))
            answer = randNumber1 / randNumber2;
    }

    public int[] getNumbers()
    {
        return new int[]{randNumber1, randNumber2};
    }

    public int getAnswer()
    {
        return answer;
    }

    public boolean problemRight(int answer)
    {
        if (this.answer == answer)
        {
            numberCorrect++;
            totalNumber++;
            return true;
        }

        totalNumber++;
        return false;
    }

    public int getCorrect()
    {
        return numberCorrect;
    }

    public int getTotal()
    {
        return totalNumber;
    }

    public void reset()
    {
        numberCorrect = 0;
        totalNumber = 0;

    }
}