package link.e4mc.iroh;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureResolvable<T> implements Resolvable<T> {

    private final CompletableFuture<T> future;

    public CompletableFutureResolvable(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void resolve(T value) {
        future.complete(value);
    }

    @Override
    public void reject(Throwable cause) {
        future.completeExceptionally(cause);
    }
}
