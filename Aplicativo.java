import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Aplicativo {
    public static void App() {
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setTitle("Linguiça do Netão");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel labelAddEstoque = new JLabel("Adicionar ao Estoque");
        JButton addEstoque = new JButton("Adicionar");
        JLabel labelRemEstoque = new JLabel("Retirado Estoque");
        JButton remEstoque = new JButton("Vendido");
        JLabel labelEstoqueAtual = new JLabel("Estoque Atual");
        JTextField fieldAddEstoque = new JTextField("ex: 40",5);
        JTextField fieldRemEstoque = new JTextField("ex: 10",5);

        frame.add(labelAddEstoque);
        frame.add(fieldAddEstoque);
        frame.add(addEstoque);
        frame.add(labelRemEstoque);
        frame.add(fieldRemEstoque);
        frame.add(remEstoque);
        frame.add(labelEstoqueAtual);

        frame.setVisible(true);
    }
}
