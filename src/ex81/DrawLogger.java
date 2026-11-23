package ex81;

import common.Card;

public class DrawLogger implements DrawObserver {
    @Override
    public void onDraw(Card card) {
        System.out.println("la vua rut: " + card);
    }
}
