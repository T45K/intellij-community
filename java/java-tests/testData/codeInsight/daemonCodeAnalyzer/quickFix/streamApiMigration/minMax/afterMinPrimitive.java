// "Replace with min()" "true-preview"

import java.util.*;

public class Main {
  public void work(int[] ints) {
    int min = Arrays.stream(ints).filter(anInt -> anInt < 10).filter(anInt -> anInt <= 0).min().orElse(0);
  }
}