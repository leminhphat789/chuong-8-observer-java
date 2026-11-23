package ex82;

public class DrawLogger implements DrawObserver {
    @Override
    public void onDraw(DrawView view) {
        System.out.println("la vua rut: " + view.lastDrawn());
    }
}
