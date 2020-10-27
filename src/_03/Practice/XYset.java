package _03.Practice;

//  data Class
class XYset extends Object {
    private final int x;
    private final int y;

    public XYset( final int x, final int y ) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        XYset xYset = (XYset) o;
        return equals(xYset);
    }

    public boolean equals(XYset xYset) {
        return x == xYset.getX() && y == xYset.getY();
    }

    @Override
    public int hashCode() {
        return 31 + x + y;
    }

}