package ex82;

import common.Card;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
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
