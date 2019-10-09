package ru.spsuace.homework2.objects.october2;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class StringTasks {

    /**
     * Убрать все лишние символы из строки и вернуть получившееся число.
     * Разрешенные символы: цифры, '-', '.', 'e'
     * Если '.' и 'e' больше чем 1, возвращаем null
     * Правила на '-' является валидность числа. --3 не валидно. -3e-1 валдино
     * Любой класс-обертка над примитивами наследуется от Number
     * Можно использовать функции Double.valueOf() и другие такие же.
     *
     * Работайте со строкой, НЕ надо ее переводить в массив байт (это можно использовать только для цикла)
     * У класса Character есть полезные методы, например Character.isDigit()
     */
    public static Number simpleValueOf(String str) {

        if (str == null || str == "") {
            return null;
        }

        char[] strCopy = new char[str.length()];
        char[] strAnswerCopy = new char[str.length()];
        String strAnswer = "";
        char[] allowedSymbols = {'e', '.', '-'};
        int[] ammountOfAllowedSybols = new int[3];

        for (int i = 0; i < str.length(); i++) {
            strCopy[i] = str.charAt(i);
        }
        for (int i = 1; i < str.length(); i++) {
            if (strCopy[i-1] == allowedSymbols[2] && strCopy[i] == allowedSymbols[0]){
                return null;
            }
        }
        for (char element : strCopy) {
            for (int i = 0; i < 3; i++) {
                if (element == allowedSymbols[i]) {
                    ammountOfAllowedSybols[i]++;
                }
            }
            if (((ammountOfAllowedSybols[2] > 1) && (ammountOfAllowedSybols[0] == 0)) ||
                    ((ammountOfAllowedSybols[2] > 2) && (ammountOfAllowedSybols[0] == 1))) {
                return null;
            }
            if ((ammountOfAllowedSybols[2] > 1) && (ammountOfAllowedSybols[0] == 1) &&
                    (str.indexOf(allowedSymbols[0]) < str.indexOf(allowedSymbols[2]) ) ){
                
            }
        }
        for (int i = 0; i < 2; i++) {
            if (ammountOfAllowedSybols[i] > 1) {
                return null;
            }
        }
        for (int i = 0; i < str.length(); i++) {

            if (!(strCopy[i] >= '0' && strCopy[i] <= '9')) {
                for (char element : allowedSymbols) {
                    if (element == strCopy[i]) {
                        strAnswer += str.charAt(i);
                    }
                }
            } else {
                str.charAt(i);
                strAnswer += str.charAt(i);
            }
        }

        if ((ammountOfAllowedSybols[0] > 0) || (ammountOfAllowedSybols[1] > 0)) {
            return Double.valueOf(strAnswer);
        }
        if ((Long.valueOf(strAnswer) > Integer.MAX_VALUE) || (Long.valueOf(strAnswer) < Integer.MIN_VALUE)) {
            return Long.valueOf(strAnswer);
        }
        return Integer.valueOf(strAnswer);
    }


    /**
     * Дополнительно задание
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf() и new Integer и тд
     */
    public static Number valueOf(String str) {

        if (str == null || str == "") {
            return null;
        }
        char[] strCopy = new char[str.length()];
        char[] strAnswerCopy = new char[str.length()];
        String strAnswer = "";
        char[] allowedSymbols = {'e', '.', '-'};
        int[] ammountOfAllowedSybols = new int[3];

        for (int i = 0; i < str.length(); i++) {
            strCopy[i] = str.charAt(i);
        }
        for (char element : strCopy) {
            for (int i = 0; i < 3; i++) {
                if (element == allowedSymbols[i]) {
                    ammountOfAllowedSybols[i]++;
                }
            }
            if (((ammountOfAllowedSybols[2] > 1) && (ammountOfAllowedSybols[0] == 0)) ||
                    ((ammountOfAllowedSybols[2] > 2) && (ammountOfAllowedSybols[0] == 1))) {
                return null;
            }
        }
        for (int i = 0; i < 2; i++) {
            if (ammountOfAllowedSybols[i] > 1) {
                return null;
            }
        }
        for (int i = 0; i < str.length(); i++) {

            if (!(strCopy[i] >= '0' && strCopy[i] <= '9')) {
                for (char element : allowedSymbols) {
                    if (element == strCopy[i]) {
                        strAnswer += str.charAt(i);
                    }
                }
            } else {
                str.charAt(i);
                strAnswer += str.charAt(i);
            }
        }




        return null;
    }
}
