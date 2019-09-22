import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class HashMultiset<E> implements Multiset<E> {

    private Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E elem) {
        if (map.containsKey(elem)) {
            map.put(elem, map.get(elem) + 1);
        } else {
            map.put(elem, 1);
        }
    }

    @Override
    public Set<Map.Entry<E, Integer>> entrySet() {
        return map.entrySet();
    }

    @Override
    public void remove(E elem) {
        if (map.containsKey(elem)) {
            if (map.get(elem) > 1) {
                map.replace(elem, map.get(elem) - 1);
            } else {
                map.remove(elem);
            }
        }
    }

    @Override
    public void union(Multiset<E> other) {
        for (Map.Entry<E, Integer> m : map.entrySet()) {
            E mapKey = m.getKey();
            Integer mapValue = m.getValue();

            if (other.contains(mapKey)) {
                int otherValue = other.getMultiplicity(mapKey);
                int maxMultiplicity = Math.max(mapValue, otherValue);
                map.replace(mapKey, maxMultiplicity);
            }
        }

        for (Map.Entry<E, Integer> o : other.entrySet()) {
            E otherKey = o.getKey();
            Integer otherValue = o.getValue();
            if (!map.containsKey(otherKey)) {
                map.put(otherKey, otherValue);
            }
        }
    }

    @Override
    public void intersect(Multiset<E> other) {
        Map<E, Integer> intersectMap = new HashMap<>();
        for (Map.Entry<E, Integer> m : map.entrySet()) {
            E mapKey = m.getKey();
            Integer mapValue = m.getValue();

            if (other.contains(mapKey)) {
                int otherValue = other.getMultiplicity(mapKey);
                int minMultiplicity = Math.min(mapValue, otherValue);
                intersectMap.put(mapKey, minMultiplicity);
            }
        }
        map.clear();
        map.putAll(intersectMap);
    }

    @Override
    public int getMultiplicity(E elem) {
        if (map.containsKey(elem)) {
            return map.get(elem);
        }
        return 0;
    }

    @Override
    public boolean contains(E elem) {
        return getMultiplicity(elem) > 0;
    }

    @Override
    public int numberOfUniqueElements() {
        return map.keySet().size();
    }

    @Override
    public int size() {
        int count = 0;
        for (Integer v : map.values()) {
            count += v;
        }
        return count;
    }

    @Override
    public Set<E> toSet() {
        // implement the method
        return map.keySet();
    }
}