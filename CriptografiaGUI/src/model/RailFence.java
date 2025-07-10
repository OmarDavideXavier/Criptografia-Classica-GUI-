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

public class RailFence implements Criptografia {

    @Override
    public String cifrar(String texto, String chave) {
        int trilhos = Integer.parseInt(chave);
        if (trilhos <= 1) return texto;

        StringBuilder[] linhas = new StringBuilder[trilhos];
        for (int i = 0; i < trilhos; i++) linhas[i] = new StringBuilder();

        int linha = 0;
        boolean descendo = true;

        for (char c : texto.toCharArray()) {
            linhas[linha].append(c);
            if (descendo) {
                linha++;
                if (linha == trilhos - 1) descendo = false;
            } else {
                linha--;
                if (linha == 0) descendo = true;
            }
        }

        StringBuilder resultado = new StringBuilder();
        for (StringBuilder sb : linhas) resultado.append(sb);
        return resultado.toString();
    }

    @Override
    public String decifrar(String texto, String chave) {
        int trilhos = Integer.parseInt(chave);
        if (trilhos <= 1) return texto;

        int[] contagem = new int[trilhos];
        int linha = 0;
        boolean descendo = true;

        for (int i = 0; i < texto.length(); i++) {
            contagem[linha]++;
            if (descendo) {
                linha++;
                if (linha == trilhos - 1) descendo = false;
            } else {
                linha--;
                if (linha == 0) descendo = true;
            }
        }

        String[] linhas = new String[trilhos];
        int pos = 0;
        for (int i = 0; i < trilhos; i++) {
            linhas[i] = texto.substring(pos, pos + contagem[i]);
            pos += contagem[i];
        }

        StringBuilder resultado = new StringBuilder();
        int[] indices = new int[trilhos];
        linha = 0;
        descendo = true;

        for (int i = 0; i < texto.length(); i++) {
            resultado.append(linhas[linha].charAt(indices[linha]++));
            if (descendo) {
                linha++;
                if (linha == trilhos - 1) descendo = false;
            } else {
                linha--;
                if (linha == 0) descendo = true;
            }
        }

        return resultado.toString();
    }
}
