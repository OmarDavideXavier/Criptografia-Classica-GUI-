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

import java.util.*;

public class Playfair implements Criptografia {

    private char[][] matriz = new char[5][5];
    private Map<Character, int[]> posicoes = new HashMap<>();

    private void gerarMatriz(String chave) {
        Set<Character> usados = new LinkedHashSet<>();
        chave = chave.toUpperCase().replaceAll("J", "I").replaceAll("[^A-Z]", "");

        for (char c : chave.toCharArray()) usados.add(c);
        for (char c = 'A'; c <= 'Z'; c++) if (c != 'J') usados.add(c);

        Iterator<Character> it = usados.iterator();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                char c = it.next();
                matriz[i][j] = c;
                posicoes.put(c, new int[]{i, j});
            }
        }
    }

    private String prepararTexto(String texto) {
        texto = texto.toUpperCase().replaceAll("J", "I").replaceAll("[^A-Z]", "");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char a = texto.charAt(i);
            char b = (i + 1 < texto.length()) ? texto.charAt(i + 1) : 'X';
            sb.append(a);
            if (a == b) sb.append('X');
            else {
                sb.append(b);
                i++;
            }
        }
        if (sb.length() % 2 != 0) sb.append('X');
        return sb.toString();
    }

    private String processar(String texto, boolean cifrar) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i += 2) {
            char a = texto.charAt(i);
            char b = texto.charAt(i + 1);
            int[] pa = posicoes.get(a);
            int[] pb = posicoes.get(b);

            if (pa[0] == pb[0]) {
                resultado.append(matriz[pa[0]][(pa[1] + (cifrar ? 1 : 4)) % 5]);
                resultado.append(matriz[pb[0]][(pb[1] + (cifrar ? 1 : 4)) % 5]);
            } else if (pa[1] == pb[1]) {
                resultado.append(matriz[(pa[0] + (cifrar ? 1 : 4)) % 5][pa[1]]);
                resultado.append(matriz[(pb[0] + (cifrar ? 1 : 4)) % 5][pb[1]]);
            } else {
                resultado.append(matriz[pa[0]][pb[1]]);
                resultado.append(matriz[pb[0]][pa[1]]);
            }
        }
        return resultado.toString();
    }

    @Override
    public String cifrar(String texto, String chave) {
        gerarMatriz(chave);
        return processar(prepararTexto(texto), true);
    }

    @Override
    public String decifrar(String texto, String chave) {
        gerarMatriz(chave);
        return processar(prepararTexto(texto), false);
    }
}
