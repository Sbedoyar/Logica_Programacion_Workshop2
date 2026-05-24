package com.packages.strings;

public class StringChar 
{
    String text;

    public StringChar()
    {
        text = "";
    }

    public StringChar(String text)
    {
        this.text = text;
    }

    public String getText() 
    {
        return text;
    }

    public void setText(String text) 
    {
        this.text = text;
    }

    public int lengthString()
    {
        return this.text.length();
    }

    public String upperString()
    {
        return this.text.toUpperCase();
    }
    
    public String lowerString()
    {
        return this.text.toLowerCase();
    }
    
    public void palindrome()
    {
        String phrase = this.text;
        phrase = phrase.toLowerCase();
        phrase = this.deleteSpaces(phrase);
        System.out.println(phrase);
        if (this.compareCharacters(phrase)) {
            System.out.println(this.text + " es palíndromo");
        } else {
            System.out.println(this.text + " no es palíndromo");
        }
    }

    private String deleteSpaces(String phrase)
    {
        phrase = phrase.trim();
        int i = 0;
        while (i < phrase.length()) {
            if (phrase.substring(i, i + 1).equals(" ")) {
                phrase = phrase.substring(0, i) + 
                    phrase.substring(i + 1, phrase.length());
            } else {
                i++; //i = i + 1 => i += 1
            }
        }
        return phrase;
    }

    private boolean compareCharacters(String phrase)
    {
        boolean sw = true; // Supuesto: frase es palíndromo
        int i = 0;
        while (i <= phrase.length() / 2 && sw) {
            if (phrase.substring(i, i + 1).equals(phrase.substring(phrase.length() - i - 1, phrase.length() - i ))) {
                i++;
            } else {
                sw = false;
            }
        }
        return sw;
    }

    public int countChar(char charUser)
    {
        int c = 0;
        for (int i = 0; i < this.text.length(); i++) {
            if (this.text.charAt(i) == charUser) {
                c++;
            }
        }
        return c;
    }

    public String stringASCII()
    {
        String strNum = "";
        for (int i = 0; i < text.length(); i++) {
            strNum += (int)text.charAt(i);
        }
        return strNum;
    }
    
}
