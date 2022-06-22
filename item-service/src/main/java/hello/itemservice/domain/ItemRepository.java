package hello.itemservice.domain;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository // ComponentScan의 대상
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>(); // static 사용 주의
    // 실무에서는 ConcurrentHashMap
    private static long sequence = 0L;
    // 실무에서는 AtomicLong

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = store.get(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
