import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache<K,V> {
    final Map<K,V> m = new HashMap<>();
    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    final Lock r = readWriteLock.readLock();
    final Lock w = readWriteLock.writeLock();

    V get(K key){
        r.lock();
        try {
            return m.get(key);
        }finally {
            r.unlock();
        }
    }

}
