package com.example.practicearchi

import io.reactivex.Observer
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.DisposableHelper
import io.reactivex.internal.util.EndConsumerHelper
import java.util.concurrent.atomic.AtomicReference

abstract class DisposableObserver<T> : Observer<T>, Disposable {

    internal val upstream = AtomicReference<Disposable>()

    override fun onSubscribe(@NonNull d: Disposable) {
        if (EndConsumerHelper.setOnce(this.upstream, d, javaClass)) {
            onStart()
        }
    }

    /**
     * Called once the single upstream Disposable is set via onSubscribe.
     */
    protected fun onStart() {}

    override fun isDisposed(): Boolean {
        return upstream.get() === DisposableHelper.DISPOSED
    }

    override fun dispose() {
        DisposableHelper.dispose(upstream)
    }
}
