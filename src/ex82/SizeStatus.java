package ex82;

public class SizeStatus implements SizeObserver {
    @Override
    public void onSizeChanged(SizeView view) {
        System.out.println("so la con lai: " + view.size());
    }
}
