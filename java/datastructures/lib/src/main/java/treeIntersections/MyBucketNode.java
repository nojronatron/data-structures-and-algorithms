package treeIntersections;

public class MyBucketNode {
  private final String key;
  private final int value;

  // MUST provide values to instantiate MyBucketNode
  public MyBucketNode(String key, int value) {
    this.key = key;
    this.value = value;
  }

  public boolean equals(MyBucketNode other) {
    if (other == null) {
      return false;
    }

    return this.key.equals(other.key) &&
      this.value == other.value;
  }

  public String getKey() {
    return key;
  }

  public int getValue() {
    return value;
  }

  @Override
  public int hashCode() {
    int keyHash = this.key.hashCode();
    return 17 * keyHash * value;
  }
}
