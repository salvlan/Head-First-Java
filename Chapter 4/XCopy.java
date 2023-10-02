public class XCopyTestDrive {
    public static void main(String[] args) {

        XCopy x = new XCopy();
        x.setOrig(42);

        int y = x.go(x.getOrig());

        System.out.println(x.getOrig() + " " + y);

    }
}

public class XCopy {

    private int orig;

    public void setOrig(int o) {
        orig = o;
    }
    public int getOrig() {
        return orig;
    }

    int go(int arg) {
        arg = arg * 2;
        return arg;
    }
}
