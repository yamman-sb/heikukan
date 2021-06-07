public class ClosedRange implements Range {
  private final int min;
  private final int max;

  public ClosedRange(int min, int max) {
    if (min > max) throw new IllegalArgumentException();
    this.min = min;
    this.max = max;
  }


  @Override
  public String toString() {
    return "[" + min + "," + max + "]";
  }

  public boolean isIncluded(int num) {
    if ( min <= num && num <= max) return true;
    return false;
  }
}
