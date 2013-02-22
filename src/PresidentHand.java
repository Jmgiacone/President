import BlackJack.Card;
import BlackJack.Hand;

import javax.swing.*;

public class PresidentHand extends Hand
{
    @Override
    public JPanel updateCards()
    {
        JPanel p = new JPanel();

        sort();
        for(Card c : hand)
        {
            p.add(new JLabel(c.getImage()));
        }

        return p;
    }

    @Override
    public void add(Card card)
    {
        hand.add(card);
        sort();
    }

    @Override
    public int getValue()
    {
        return -1;
    }

    public int numCard(String rank)
    {
        int num = 0;
        for(Card c : hand)
        {
            if(c.getRank().equalsIgnoreCase(rank))
            {
                num++;
            }
        }

        return num;
    }
    public boolean hasCard(String rank)
    {
        for(Card c : hand)
        {
            if(c.getRank().equalsIgnoreCase(rank))
            {
                return true;
            }
        }

        return false;
    }
    /**
     * Returns the number of cards that appear in this multiple
     * @param mult
     * @return
     */
    public int numMultiple(int mult)
    {
        if(mult > 4 || mult <= 1)
        {
            return -1;
        }

        int numCards = 1, numMult = 0;

        for(int i  = 0; i < hand.size(); i++)
        {
            if(i < (hand.size() - 1))
            {
                //Same Valued Card
                if(hand.get(i).compareTo(hand.get(i + 1)) == 0)
                {
                    numCards++;
                }
                else
                {
                    if(numCards == mult)
                    {
                          numMult++;
                    }
                    numCards = 1;
                }
            }
        }

        return numMult;
    }
    /**
     * Sorts the hand by value
     */
    public void sort() 
    {
        boolean swapped = true;
        int j = 0;
        Card temp;
        while (swapped) 
        {
            swapped = false;
            j++;
            for (int i = 0; i < hand.size() - j; i++) 
            {
                if (hand.get(i).getValue() > hand.get(i + 1).getValue()) 
                {
                    temp = hand.get(i);
                    hand.set(i, hand.get(i + 1));
                    hand.set(i + 1, temp);
                    swapped = true;
                }
            }
        }
    }
}
