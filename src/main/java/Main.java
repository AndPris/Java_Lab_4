public class Main {
    public static void main(String[] args) {
        String test = "This\t is \tsimple   text. It\t has some \t sentences and,, maybe, punctuation marks. Short sentence.";
        StringParser parser = new StringParser();
        Text text = parser.convertStringIntoText(test);

        System.out.println("Original text:");
        System.out.println(text.getValue());
        System.out.println("\n=======================================\n");

        text.sortSentencesByWordsAmount();

        System.out.println("Text, where sentences are sorted by amount of words:");
        System.out.println(text.getValue());
        System.out.println("\n=======================================\n");
    }
}
