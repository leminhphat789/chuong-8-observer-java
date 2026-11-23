package ex82;

import common.Card;
import common.Rank;
import common.Suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>();
    private final List<DrawObserver> drawObservers = new ArrayList<>();
    private final List<SizeObserver> sizeObservers = new ArrayList<>();
    private Card lastDrawn;

    // moi observer chi duoc xem phan du lieu minh can
    private final DrawView drawView = () -> lastDrawn;
    private final SizeView sizeView = () -> cards.size();

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
            notifySize();
        }
    }

    public void push(Card card) {
        assert card != null;
        cards.add(card);
        notifySize();
    }

    public Card draw() {
        assert !isEmpty();
        Card card = cards.removeLast();
        lastDrawn = card;
        notifyDraw();
        notifySize();
        return card;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public List<Card> cards() {
        return Collections.unmodifiableList(cards);
    }

    public void addDrawObserver(DrawObserver observer) {
        drawObservers.add(observer);
    }

    public void removeDrawObserver(DrawObserver observer) {
        drawObservers.remove(observer);
    }

    public void addSizeObserver(SizeObserver observer) {
        sizeObservers.add(observer);
    }

    public void removeSizeObserver(SizeObserver observer) {
        sizeObservers.remove(observer);
    }

    private void notifyDraw() {
        for (DrawObserver observer : List.copyOf(drawObservers)) {
            observer.onDraw(drawView);
        }
    }

    private void notifySize() {
        for (SizeObserver observer : List.copyOf(sizeObservers)) {
            observer.onSizeChanged(sizeView);
        }
    }
}
