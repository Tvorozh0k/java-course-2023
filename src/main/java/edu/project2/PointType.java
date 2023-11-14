package edu.project2;

public enum PointType {
    Empty("  "),
    Wall("██"),
    Start("ST"),
    Finish("FN"),
    Path("..");

    private final String view;

    PointType(String view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return view;
    }
}
