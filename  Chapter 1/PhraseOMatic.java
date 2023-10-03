public class PhraseOMatic {
    public static void main(String[] args) {
        String[] wordListOne = {"24/7","multi-Tier","30,000 foot","B-to-B","win-win","pervasive","smart","six-sigma","critical-path","dynamic"};
        String[] wordListTwo = {"empowered","sticky","value-added","oriented","centric","distributed","clustered","branded","outside-the-box","positioned","networked","focused","leveraged","aligned","targeted","shared","cooperative","accelerated"};
        String[] wordListThree = {"process","tipping-point","solution","architecture","core competency","strategy","mindshare","portal","space","vision","paradigm","mission"};

        int oneLength = wordListOne.length;
        int twoLenght = wordListTwo.length;
        int threeLenght = wordListThree.length;

        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLenght);
        int rand3 = (int) (Math.random() * threeLenght);

        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];

        System.out.println("What we need is a " + phrase);
    }
}
