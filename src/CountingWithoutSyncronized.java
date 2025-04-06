public class CountingWithoutSyncronized {
    int increase_counter = 1;
    public int increase() {
        increase_counter = increase_counter + 1;
        return increase_counter;
    }
}
