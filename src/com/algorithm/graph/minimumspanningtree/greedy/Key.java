package com.algorithm.graph.minimumspanningtree.greedy;

import java.util.Objects;

public class Key<K1, K2> {
  public K1 key1;
  public K2 key2;

  public Key(K1 key1, K2 key2) {
    this.key1 = key1;
    this.key2 = key2;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Key<?, ?> key)) return false;
    return Objects.equals(key1, key.key1) && Objects.equals(key2, key.key2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key1, key2);
  }

  @Override
  public String toString() {
    return "[" + key1 + ", " + key2 + "]";
  }
}
