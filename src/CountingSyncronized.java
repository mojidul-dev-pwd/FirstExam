public class CountingSyncronized {
    int increase_counter = 1;
    public synchronized int increase() {
        increase_counter = increase_counter + 1;
        return increase_counter;
    }
}
