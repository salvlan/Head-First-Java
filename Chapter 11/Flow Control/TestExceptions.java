public class TestExceptions {
    public static void main (String [] args){
         String test = "no";
          try {
              System.out.println("start try");
              dorisky(test);
              System.out.println("end try");
          } catch (ScaryException se) {
              System.out.println("Scary exception");
          } finally {
              System.out.println("finally");
          }
          System.out.println("end main");
    }
    static void dorisky (String test) throws ScaryException {
        System.out.println ("start risky");
        if ("yes".equals(test)) {
            throw new ScaryException ();
        }
        System.out.println("end risky");
        return;
    }
}
