package Tests;

import BlackJack.Card;
import President.*;
import static org.junit.Assert.*;

public class PresidentHandTest
{
    PresidentHand h = new PresidentHand();

    @org.junit.Test
    public void testNumCards() throws Exception
    {
        for(int i = 0; i < 10; i++)
        {
            h.add(new Card());
            assertEquals(i + 1, h.numCards());
            assertEquals(i + 1, h.numCards("Joker"));
        }
        
        h.add(new Card("Ace", "Spades", 11));
        assertFalse(h.numCards("Five") > 0);
        assertEquals(1, h.numCards("Ace"));
    }

    @org.junit.Test
    public void testHasCard() throws Exception
    {
        assertFalse(h.hasCard("Ace"));
        assertFalse(h.hasCard(11));
        h.add(new Card("Ace", "Spades", 11));
        assertTrue(h.hasCard("Ace"));
        assertTrue(h.hasCard(11));
        h.add(new Card("Five", "Clubs", 5));
        assertTrue(h.hasCard("Five"));
        assertTrue(h.hasCard(5));

    }

    @org.junit.Test
    public void testNumMultiples() throws Exception
    {
        assertEquals(0, h.numMultiples(1));
        h.add(new Card("Ace", "Spades", 11));
        assertEquals(1, h.numMultiples(1));
        h.add(new Card("Five", "Clubs", 5));
        assertEquals(2, h.numMultiples(1));
        h.add(new Card("Five", "Spades", 5));
        assertEquals(1, h.numMultiples(2));
        h.add(new Card("Five", "Diamonds", 5));
        assertEquals(1, h.numMultiples(3));
        h.add(new Card("Five", "Hearts", 5));
        assertEquals(1, h.numMultiples(4));
    }
}
