package store;

public enum CategoryType {
   METAL("metal"),
    CLASSIC("classic"),
    OLD_PHONE("old_phone"),
    SMARTPHONE("smartphone");

    String val;

    CategoryType(String value) {
        this.val = value;
    }
}
