/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author omard
 */
import model.interfaces.Criptografia;

public class Cesar implements Criptografia {

    @Override
    public String cifrar(String texto, String chave) {
        int deslocamento = Integer.parseInt(chave);
        StringBuilder resultado = new StringBuilder();

        for (char c : texto.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + deslocamento) % 26 + base);
            }
            resultado.append(c);
        }
        return resultado.toString();
    }

    @Override
    public String decifrar(String texto, String chave) {
        int deslocamento = Integer.parseInt(chave);
        return cifrar(texto, String.valueOf(26 - (deslocamento % 26)));
    }
}
