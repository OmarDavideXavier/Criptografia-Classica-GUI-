/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author omard
 */
import controller.CriptografiaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame implements ActionListener {
    private JComboBox<String> comboAlgoritmo;
    private JTextField campoTexto, campoChave;
    private JButton botaoCifrar, botaoDecifrar;
    private JTextArea areaResultado;
    private CriptografiaController controller;

    public JanelaPrincipal() {
        super("Criptografia Clássica");
        controller = new CriptografiaController();
        instanciarComponentes();
        configurarJanela();
    }

    private void instanciarComponentes() {
        comboAlgoritmo = new JComboBox<>(new String[]{"Cesar", "Vigenere", "Playfair", "Rail Fence"});
        campoTexto = new JTextField();
        campoChave = new JTextField();
        botaoCifrar = new JButton("Cifrar");
        botaoDecifrar = new JButton("Decifrar");
        areaResultado = new JTextArea(5, 30);
        areaResultado.setEditable(false);

        botaoCifrar.addActionListener(this);
        botaoDecifrar.addActionListener(this);
    }

    private void configurarJanela() {
        setLayout(new BorderLayout());
        JPanel painelSuperior = new JPanel(new GridLayout(4, 2));

        painelSuperior.add(new JLabel("Algoritmo:"));
        painelSuperior.add(comboAlgoritmo);
        painelSuperior.add(new JLabel("Texto:"));
        painelSuperior.add(campoTexto);
        painelSuperior.add(new JLabel("Chave:"));
        painelSuperior.add(campoChave);
        painelSuperior.add(botaoCifrar);
        painelSuperior.add(botaoDecifrar);

        add(painelSuperior, BorderLayout.NORTH);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tipo = (String) comboAlgoritmo.getSelectedItem();
        String texto = campoTexto.getText();
        String chave = campoChave.getText();

        boolean cifrar = e.getSource() == botaoCifrar;
        String resultado = controller.processar(tipo, texto, chave, cifrar);
        areaResultado.setText(resultado);
    }
}
