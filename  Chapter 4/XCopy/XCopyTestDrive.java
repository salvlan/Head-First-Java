public class XCopyTestDrive {
    public static void main(String[] args) {

        XCopy x = new XCopy();
        x.setOrig(42);

        int y = x.go(x.getOrig());

        System.out.println(x.getOrig() + " " + y);

    }
}
