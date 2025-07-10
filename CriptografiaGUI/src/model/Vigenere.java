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

public class Vigenere implements Criptografia {

    private String repetirChave(String texto, String chave) {
        StringBuilder novaChave = new StringBuilder();
        int chaveIndex = 0;
        for (char c : texto.toCharArray()) {
            if (Character.isLetter(c)) {
                novaChave.append(chave.charAt(chaveIndex % chave.length()));
                chaveIndex++;
            } else {
                novaChave.append(c);
            }
        }
        return novaChave.toString();
    }

    @Override
    public String cifrar(String texto, String chave) {
        StringBuilder resultado = new StringBuilder();
        texto = texto.toUpperCase();
        chave = repetirChave(texto, chave.toUpperCase());

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isLetter(c)) {
                char ch = (char) (((c + chave.charAt(i)) % 26) + 'A');
                resultado.append(ch);
            } else {
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

    @Override
    public String decifrar(String texto, String chave) {
        StringBuilder resultado = new StringBuilder();
        texto = texto.toUpperCase();
        chave = repetirChave(texto, chave.toUpperCase());

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isLetter(c)) {
                char ch = (char) (((c - chave.charAt(i) + 26) % 26) + 'A');
                resultado.append(ch);
            } else {
                resultado.append(c);
            }
        }
        return resultado.toString();
    }
}
