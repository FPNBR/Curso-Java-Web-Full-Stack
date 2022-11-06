package org.cursojava.thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaTimeThread extends JDialog {

    private JPanel jPanel = new JPanel(new GridBagLayout());
    private JLabel descricaoHora = new JLabel("Nome");
    private JTextField mostraTempo = new JTextField();
    private JLabel descricaoHora2 = new JLabel("E-mail");
    private JTextField mostraTempo2 = new JTextField();
    private JButton jButton = new JButton("Gerar");
    private JButton jButton2 = new JButton("Sair");

    private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

    TelaTimeThread() {
        /*Controlador de posicionamento de componentes*/
        setTitle("Tela de Time com Thread");
        setSize(new Dimension(240, 240));
        setLocationRelativeTo(null);
        setResizable(false);

        /*Controlador de posicionamento de componentes*/
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 10, 5, 5);
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        descricaoHora.setPreferredSize(new Dimension(200, 25));
        jPanel.add(descricaoHora, gridBagConstraints);

        mostraTempo.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy ++;
        jPanel.add(mostraTempo, gridBagConstraints);

        descricaoHora2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy ++;
        jPanel.add(descricaoHora2, gridBagConstraints);

        mostraTempo2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy ++;
        jPanel.add(mostraTempo2, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;

        jButton.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridy ++;
        jPanel.add(jButton, gridBagConstraints);

        jButton2.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridx ++;
        jPanel.add(jButton2, gridBagConstraints);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fila == null) {
                    fila = new ImplementacaoFilaThread();
                    fila.start();
                }
                for (int i = 0; i < 100; i++) { // Simulando 100 envios em massa
                    ObjetoFilaThread filaThread = new ObjetoFilaThread();
                    filaThread.setNome(mostraTempo.getText());
                    filaThread.setEmail(mostraTempo2.getText() + " - " + (i+ 1));
                    fila.add(filaThread);
                }
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fila.stop();
                fila = null;
            }
        });

        fila.start();
        add(jPanel, BorderLayout.WEST);
        setVisible(true);
    }
}