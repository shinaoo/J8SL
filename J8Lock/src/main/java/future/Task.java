package future;

@FunctionalInterface
public interface Task<IN,OUT> {
    OUT get(IN input);
}
