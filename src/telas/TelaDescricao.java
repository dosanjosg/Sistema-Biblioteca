package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDescricao extends JFrame {
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextArea txtSinopse;
    private Livro livro;

    public TelaDescricao(Livro livro) {
        this.livro = livro;
        setTitle("Detalhes do Livro");
        setSize(600, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(50, 50, 100, 25);
        getContentPane().add(lblTitulo);

        txtTitulo = new JTextField(livro.getTitulo());
        txtTitulo.setBounds(150, 50, 400, 25);
        getContentPane().add(txtTitulo);

        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setBounds(50, 100, 100, 25);
        getContentPane().add(lblAutor);

        txtAutor = new JTextField(livro.getAutor());
        txtAutor.setBounds(150, 100, 400, 25);
        getContentPane().add(txtAutor);

        JLabel lblSinopse = new JLabel("Sinopse:");
        lblSinopse.setBounds(50, 150, 100, 25);
        getContentPane().add(lblSinopse);

        txtSinopse = new JTextArea(livro.getSinopse());
        txtSinopse.setBounds(150, 150, 400, 300);
        txtSinopse.setLineWrap(true);
        txtSinopse.setWrapStyleWord(true);
        JScrollPane scrollSinopse = new JScrollPane(txtSinopse);
        scrollSinopse.setBounds(150, 150, 400, 300);
        getContentPane().add(scrollSinopse);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(150, 470, 100, 30);
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                livro.setTitulo(txtTitulo.getText());
                livro.setAutor(txtAutor.getText());
                livro.setSinopse(txtSinopse.getText());
                JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!");
                dispose();
            }
        });
        getContentPane().add(btnAtualizar);

        JButton btnApagar = new JButton("Apagar");
        btnApagar.setBounds(270, 470, 100, 30);
        btnApagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroDeLivros.livros.remove(livro);
                JOptionPane.showMessageDialog(null, "Livro apagado com sucesso!");
                dispose();
            }
        });
        getContentPane().add(btnApagar);
    }
}
