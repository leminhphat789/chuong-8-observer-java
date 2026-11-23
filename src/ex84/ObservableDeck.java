package ex84;

import common.Card;
import ex81.DrawObserver;
import ex81.SizeObserver;
import java.util.ArrayList;
import java.util.List;

public class ObservableDeck extends Deck {
    private final List<DrawObserver> drawObservers = new ArrayList<>();
    private final List<SizeObserver> sizeObservers = new ArrayList<>();

    @Override
    public void shuffle() {
        int oldSize = cards().size();
        super.shuffle();
        // khi lop cha khoi tao bo bai thi danh sach observer chua san sang
        if (sizeObservers != null && oldSize != cards().size()) {
            notifySize(cards().size());
        }
    }

    @Override
    public void push(Card card) {
        super.push(card);
        notifySize(cards().size());
    }

    @Override
    public Card draw() {
        Card card = super.draw();
        notifyDraw(card);
        notifySize(cards().size());
        return card;
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

    private void notifyDraw(Card card) {
        for (DrawObserver observer : List.copyOf(drawObservers)) {
            observer.onDraw(card);
        }
    }

    private void notifySize(int size) {
        for (SizeObserver observer : List.copyOf(sizeObservers)) {
            observer.onSizeChanged(size);
        }
    }
}
