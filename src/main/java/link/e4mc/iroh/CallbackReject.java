package link.e4mc.iroh;

public class CallbackReject implements Runnable {

    private final Resolvable<?> future;
    private final Throwable ex;

    public CallbackReject(Resolvable<?> future, Throwable ex) {
        this.future = future;
        this.ex = ex;
    }

    @Override
    public void run() {
        future.reject(ex);
    }
}
