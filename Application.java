import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Application {
    public static void App() {
        System.out.println("Iniciando...");
        EstoqueControls estoqueControls = new EstoqueControls(0);

        JFrame frame = new JFrame();
        frame.setSize(400, 200);
        frame.setTitle("Linguiça do Netão");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3,10, 10)); // 3 linhas, 3 colunas, com espaçamento

        JButton addEstoqueBtn = new JButton("Adicionar");
        JButton remEstoqueBtn = new JButton("Retirar");
        JLabel labelAddEstoque = new JLabel("Colocar no Estoque");
        JLabel labelRemEstoque = new JLabel("Remover do Estoque");
        JLabel labelEstoqueAtual = new JLabel("Estoque Atual: " + estoqueControls.getEstoque());
        JTextField fieldAddEstoque = new JTextField(5);
        JTextField fieldRemEstoque = new JTextField(5);

        addEstoqueBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                int amount = Integer.parseInt(fieldAddEstoque.getText());
                estoqueControls.adicionarEstoque(amount);
                labelEstoqueAtual.setText("Estoque Atual: " + estoqueControls.getEstoque());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }
        });

        remEstoqueBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int amount = Integer.parseInt(fieldRemEstoque.getText());
                    estoqueControls.retirarEstoque(amount);
                    labelEstoqueAtual.setText("Estoque Atual: " + estoqueControls.getEstoque());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }
        });

        Dimension fieldSize = new Dimension(100, 20);
        fieldAddEstoque.setPreferredSize(fieldSize);
        fieldRemEstoque.setPreferredSize(fieldSize);
        addEstoqueBtn.setPreferredSize(new Dimension(100, 20));
        remEstoqueBtn.setPreferredSize(new Dimension(100, 20));

        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row1.add(labelAddEstoque);
        row1.add(fieldAddEstoque);
        row1.add(addEstoqueBtn);

        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row2.add(labelRemEstoque);
        row2.add(fieldRemEstoque);
        row2.add(remEstoqueBtn);

        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row3.add(labelEstoqueAtual);

        frame.add(row3);
        frame.add(row1);
        frame.add(row2);

        frame.setVisible(true);
    }
}