public class Main {
    public static void main(String[] args) {
        String test = "This\t is \tsimple   text. It\t has some \t sentences and,, maybe, punctuation marks. Short sentence.";
//        String test = "First  sentence.. Another \tone.\t This is the end.";
        StringParser parser = new StringParser();
        Text text = parser.convertStringIntoText(test);

        System.out.println("Original text:");
        System.out.println(test);
        System.out.println("\n=======================================\n");

        System.out.println("Parsed text:");
        System.out.println(text.getValue());
        System.out.println("\n=======================================\n");

        text.sortSentencesByWordsAmount();

        System.out.println("Text, where sentences are sorted by amount of words:");
        System.out.println(text.getValue());
        System.out.println("\n=======================================\n");
    }
}
