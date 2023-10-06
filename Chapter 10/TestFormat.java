public class TestFormat {
    public static void main(String[] args) {
        String s = String.format("%,d",1000000000);
        String i = String.format("I have %,.2f bugs to fix", 135645468.535132516);
        System.out.println(s);
        System.out.println(i);
    }
}
