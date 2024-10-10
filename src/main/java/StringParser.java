public class StringParser {
    Text text;
    Word word;
    Sentence sentence;

    public Text convertStringIntoText(String input) {
        text = new Text();
        word = new Word();
        sentence = new Sentence();

        for(char c : input.toCharArray()) {
            if(isLetter(c)) {
                word.addLetter(new Letter(c));
                continue;
            }

            if(!word.isEmpty()) {
                sentence.addSentencePart(word);
                word = new Word();
            }

            PunctuationMark punctuationMark = new PunctuationMark(c);

            if(canSkipPunctuation(punctuationMark))
                continue;

            sentence.addSentencePart(punctuationMark);

            if(isSentenceEnd(c)) {
                text.addSentence(sentence);
                sentence = new Sentence();
            }
        }

        if(!word.isEmpty())
            sentence.addSentencePart(word);

        if(!sentence.isEmpty()) {
            sentence.addSentencePart(new PunctuationMark('.'));
            text.addSentence(sentence);
        }

        return text;
    }

    private boolean canSkipPunctuation(PunctuationMark c) {
        if(sentence.isEmpty())
            return !c.getValue().equals(" ");

        return sentence.getLastPart().equals(c.getValue());
    }

    public boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public boolean isSentenceEnd(char c) {
        return c=='.' || c=='!' || c=='?';
    }
}
