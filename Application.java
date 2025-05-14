import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Application {
    private static final String CACHE_FILE = "estoque.dat";

    private static void saveEstoque(int value) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(CACHE_FILE))) {
            out.writeInt(value);
            System.out.println("Estoque salvo: " + value);
        } catch (IOException e) {
            System.err.println("Erro ao salvar estoque: " + e.getMessage());
        }
    }

    private static int loadEstoque() {
        int value = 0;
        File file = new File(CACHE_FILE);

        if (file.exists()) {
            try (DataInputStream in = new DataInputStream(new FileInputStream(CACHE_FILE))) {
                value = in.readInt();
                System.out.println("Estoque carregado: " + value);
            } catch (IOException e) {
                System.err.println("Erro ao carregar estoque: " + e.getMessage());
            }
        }

        return value;
    }

    public static void App() {
        System.out.println("Iniciando...");
        int initialEstoque = loadEstoque();
        EstoqueControls estoqueControls = new EstoqueControls(initialEstoque);

        JFrame frame = new JFrame();
        frame.setSize(400, 200);
        frame.setTitle("Linguiça do Netão");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3, 10, 10)); // 3 linhas, 3 colunas, com espaçamento

        // Add window listener to save estoque value when closing
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveEstoque(estoqueControls.getEstoque());
                System.exit(0);
            }
        });

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

        // Add action listeners to text fields to respond to Enter key
        fieldAddEstoque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEstoqueBtn.doClick(); // Simulate button click
            }
        });

        fieldRemEstoque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remEstoqueBtn.doClick(); // Simulate button click
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
