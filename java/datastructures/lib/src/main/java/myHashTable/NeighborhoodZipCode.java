package myHashTable;

public class NeighborhoodZipCode{
  private String _neighborhood;
  private int _zipCode;

  public NeighborhoodZipCode(String _neighborhood, int _zipCode) {
    this._neighborhood = _neighborhood;
    this._zipCode = _zipCode;
  }

  public String get_neighborhood() {
    return _neighborhood;
  }

  public void set_neighborhood(String _neighborhood) {
    this._neighborhood = _neighborhood;
  }

  public int get_zipCode() {
    return _zipCode;
  }

  public void set_zipCode(int _zipCode) {
    this._zipCode = _zipCode;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null) {

      if (obj.getClass().toString().equals(this.getClass().toString())) {
        NeighborhoodZipCode other = (NeighborhoodZipCode) obj;
        return
          this.get_zipCode() == other.get_zipCode() &&
            this.get_neighborhood().equals(other.get_neighborhood());
      }
    }

    return false;
  }

  @Override
  public String toString() {
    return this.get_neighborhood() + ", " + this.get_zipCode();
  }

}
