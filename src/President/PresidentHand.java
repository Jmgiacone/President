package President;

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

    /**
     * Returns the number of Cards in the hand with the given value
     * @param val The value to be counted
     * @return The number of Cards found
     */
    public int numCards(int val)
    {
        int num = 0;
        for(Card c : hand)
        {
            if(c.getValue() == val)
            {
                num++;
            }
        }

        return num;
    }

    /**
     * Returns the number of Cards in the hand with the given Rank
     * @param rank The Rank to be counted
     * @return The number of Cards found
     */
    public int numCards(String rank)
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

    /**
     * A helper method that returns whether or not a card with the specified value is in the hand
     * @param val The value to be searched for
     * @return True or False dependent
     */
    public boolean hasCard(int val)
    {
        for(Card c : hand)
        {
            if(c.getValue() == val)
            {
                return true;
            }
        }

        return false;
    }

    /**
     * A helper method that returns whether or not a card with the specified Rank is in the hand
     * @param rank The Rank to be searched for
     * @return True or False dependent on if it's in the Hand
     */
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
    public int numMultiples(int mult)
    {
        sort();
        int numCards = 1, numMult = 0;

        if(mult > 4 || mult <= 0)
        {
            return -1;
        }
        else if(mult == 1)
        {
            return hand.size() - (numMultiples(2) + numMultiples(3) + numMultiples(4));
        }
        else if(hand.size() == 1)
        {
            return mult == 1 ? 1 : 0;
        }


        for(int i  = 0; i < hand.size(); i++)
        {
            if(i < (hand.size() - 1))
            {
                //Same Valued Card
                if((hand.get(i).compareTo(hand.get(i + 1)) == 0))
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
