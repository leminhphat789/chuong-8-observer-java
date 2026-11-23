package ex81;

public class SizeStatus implements SizeObserver {
    @Override
    public void onSizeChanged(int size) {
        System.out.println("so la con lai: " + size);
    }
}
