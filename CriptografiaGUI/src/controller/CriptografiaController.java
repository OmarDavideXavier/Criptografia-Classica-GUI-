/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author omard
 */
import model.Cesar;
import model.Vigenere;
import model.Playfair;
import model.RailFence;
import model.interfaces.Criptografia;

public class CriptografiaController {
    public String processar(String tipo, String texto, String chave, boolean cifrar) {
        Criptografia algoritmo;

        switch (tipo.toLowerCase()) {
            case "cesar":
                algoritmo = new Cesar();
                break;
            case "vigenere":
                algoritmo = new Vigenere();
                break;
            case "playfair":
                algoritmo = new Playfair();
                break;
            case "rail fence":
                algoritmo = new RailFence();
                break;
            default:
                return "Algoritmo não suportado ainda.";
        }

        return cifrar ? algoritmo.cifrar(texto, chave) : algoritmo.decifrar(texto, chave);
    }
}
