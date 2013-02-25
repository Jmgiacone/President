package President;

import BlackJack.Card;
import BlackJack.Player;

public class PresidentPlayer extends Player
{
    private Rank rank;
    public PresidentPlayer(String n)
    {
        super(n, 0);
        hand = new PresidentHand();
        rank = Rank.UNASSIGNED;
    }

    public void addCard(Card c)
    {
        hand.add(c);
    }
    public boolean hasCard(int val)
    {
        return ((PresidentHand)hand).hasCard(val);
    }

    public boolean hasCard(String rank)
    {
        return ((PresidentHand)hand).hasCard(rank);
    }

    public int numCards(int val)
    {
        return ((PresidentHand)hand).numCards(val);
    }

    public int numCards(String rank)
    {
        return ((PresidentHand)hand).numCards(rank);
    }

    public int numCards()
    {
        return ((PresidentHand)hand).numCards();
    }

    public int numMultiples(int m)
    {
        return ((PresidentHand)hand).numMultiples(m);
    }
}


