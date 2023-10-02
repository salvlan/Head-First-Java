public class goTestDrive {
    public static void main(String[] args) {

        go t = new go();
        t.foo = 7;
        t.bar = 3;

        go h = new go();
        h.foo = 12;
        h.bar = 34;

        t.takeTwo(t.foo, t.bar);
        h.takeTwo(h.foo, h.bar);
    }
}
