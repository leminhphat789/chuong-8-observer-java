package ex84;

import common.Card;
import ex81.DrawLogger;
import ex81.SizeStatus;

public class Main {
    public static void main(String[] args) {
        ObservableDeck deck = new ObservableDeck();
        deck.addDrawObserver(new DrawLogger());
        deck.addSizeObserver(new SizeStatus());

        // rut mot la roi dat lai de thay hai observer phan ung khac nhau
        Card card = deck.draw();
        deck.push(card);

        // lan xao thu hai van con du bai nen khong bao lai so la
        deck.draw();
        deck.shuffle();
        deck.shuffle();
    }
}
