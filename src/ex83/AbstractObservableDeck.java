package ex83;

import common.Card;
import ex81.DrawObserver;
import ex81.SizeObserver;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObservableDeck {
    private final List<DrawObserver> drawObservers = new ArrayList<>();
    private final List<SizeObserver> sizeObservers = new ArrayList<>();

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

    protected void notifyDraw(Card card) {
        for (DrawObserver observer : List.copyOf(drawObservers)) {
            observer.onDraw(card);
        }
    }

    protected void notifySize(int size) {
        for (SizeObserver observer : List.copyOf(sizeObservers)) {
            observer.onSizeChanged(size);
        }
    }
}
