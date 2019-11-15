package mobi.cangol.mobile


import android.os.Handler
import android.os.Message
import java.lang.ref.SoftReference

/**
 * Created by xuewu.wei on 2018/5/3.
 */
abstract class Task<R> : Runnable {
    private val handler: InnerHandler<R>

    init {
        this.handler = InnerHandler(this)
    }

    override fun run() {
        val r = call()
        Message.obtain(handler, 1, r).sendToTarget()
    }

    abstract fun call(): R

    abstract fun result(r:R)

    class InnerHandler<R>(task: Task<R>) : Handler() {
        private val taskReference: SoftReference<Task<R>> = SoftReference(task)

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 1 && taskReference.get() != null) {
                taskReference.get()!!.result(msg.obj as R)
                taskReference.clear()
            }
        }
    }
}
