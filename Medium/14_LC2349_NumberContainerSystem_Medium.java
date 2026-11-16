import java.util.*;

class NumberContainers {
    private Map<Integer, Integer> indexToNumber = new HashMap<>();
    private Map<Integer, TreeSet<Integer>> numberToIndices = new HashMap<>();

    public NumberContainers() {
        
    }

    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            numberToIndices.get(oldNumber).remove(index);
        }

        indexToNumber.put(index, number);
        numberToIndices.putIfAbsent(number, new TreeSet<>());
        numberToIndices.get(number).add(index);
    }

    public int find(int number) {
        if (!numberToIndices.containsKey(number) || numberToIndices.get(number).isEmpty()) {
            return -1;
        }
        return numberToIndices.get(number).first();
    }
}

