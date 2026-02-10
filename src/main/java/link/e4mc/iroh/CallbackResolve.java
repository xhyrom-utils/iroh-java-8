package link.e4mc.iroh;

public class CallbackResolve<T> implements Runnable {

    private final Resolvable<T> future;
    private final DeferredInitializer<T> value;

    public CallbackResolve(Resolvable<T> future, DeferredInitializer<T> value) {
        this.future = future;
        this.value = value;
    }

    @Override
    public void run() {
        T resolved;
        try {
            resolved = value.resolve();
        } catch (Throwable ex) {
            future.reject(ex);
            return;
        }
        future.resolve(resolved);
    }
}
