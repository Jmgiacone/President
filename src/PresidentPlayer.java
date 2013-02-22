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
}
