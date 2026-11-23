package ex83;

import common.Card;
import common.Rank;
import common.Suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck extends AbstractObservableDeck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        shuffle();
    }

    // tao lai du bo bai roi moi xao
    public void shuffle() {
        int oldSize = cards.size();
        cards.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(cards);
        if (oldSize != cards.size()) {
            notifySize(cards.size());
        }
    }

    public void push(Card card) {
        assert card != null;
        cards.add(card);
        notifySize(cards.size());
    }

    public Card draw() {
        assert !isEmpty();
        Card card = cards.removeLast();
        notifyDraw(card);
        notifySize(cards.size());
        return card;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public List<Card> cards() {
        return Collections.unmodifiableList(cards);
    }
}
