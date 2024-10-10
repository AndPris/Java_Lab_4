public class StringParser {
    Text text;
    Word word;
    Sentence sentence;

    /**
     * Converts string <code>input</code> into Text object. Removes punctuation marks duplicates,
     * replaces tabulation with space.
     * @param input string text to convert
     * @return Text
     */
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

    /**
     * Checks if punctuation mart can be skipped. Returns true if this punctuation mark is already in last place in sentence.
     * Returns true if sentence is empty and punctuation mark isn't space, else return false.
     * Returns false if sentence isn't empty amd there is no such punctuation mark in last place.
     * @param c punctuation mark to check
     * @return boolean
     * @see Sentence#isEmpty()
     */
    private boolean canSkipPunctuation(PunctuationMark c) {
        if(sentence.isEmpty())
            return !c.getValue().equals(" ");

        return sentence.getLastPart().equals(c.getValue());
    }

    /**
     * Checks if <code>c</code> is letter of English alphabet.
     * @param c character to check
     * @return boolean
     */
    public boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    /**
     * Check if <code>c</code> is sentence end (symbols '.', '?' or '!').
     * @param c character to check
     * @return boolean
     */
    public boolean isSentenceEnd(char c) {
        return c=='.' || c=='!' || c=='?';
    }
}
