package ex84;

import common.Card;
import common.Rank;
import common.Suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        shuffle();
    }

    // tao lai du bo bai roi moi xao
    public void shuffle() {
        cards.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(cards);
    }

    public void push(Card card) {
        assert card != null;
        cards.add(card);
    }

    public Card draw() {
        assert !isEmpty();
        return cards.removeLast();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public List<Card> cards() {
        return Collections.unmodifiableList(cards);
    }
}
