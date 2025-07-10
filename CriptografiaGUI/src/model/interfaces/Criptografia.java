/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

/**
 *
 * @author omard
 */
public interface Criptografia {
    String cifrar(String texto, String chave);
    String decifrar(String texto, String chave);
}

