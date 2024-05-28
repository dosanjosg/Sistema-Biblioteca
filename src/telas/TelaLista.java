package telas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaLista {
    private JFrame tela;
    private JPanel painel;
    private DefaultTableModel tableModel;
    private JTable tabelaLivros;
    private Telacadastrolivro telaCadastro;

    public TelaLista(Telacadastrolivro telaCadastro) {
        this.telaCadastro = telaCadastro;
        tela = new JFrame("Lista de Livros");
        painel = new JPanel();
        tableModel = new DefaultTableModel(new Object[]{"Livro", "Nome do Autor"}, 0);
        tabelaLivros = new JTable(tableModel);
        tabelaLivros.setFillsViewportHeight(true);

        tela.setSize(600, 600); // Ajustar tamanho da tela
        painel.setLayout(null);

        JScrollPane scrollpane = new JScrollPane(tabelaLivros);
        scrollpane.setBounds(50, 50, 500, 400);
        scrollpane.setPreferredSize(new Dimension(500, 400));
        painel.add(scrollpane);

        JButton btnDetalhes = new JButton("Detalhes");
        btnDetalhes.setBounds(250, 470, 100, 30);
        btnDetalhes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabelaLivros.getSelectedRow();
                if (selectedRow != -1) {
                    String titulo = (String) tableModel.getValueAt(selectedRow, 0);
                    String autor = (String) tableModel.getValueAt(selectedRow, 1);
                    Livro livro = buscarLivro(titulo, autor);
                    if (livro != null) {
                        TelaDescricao telaDescricao = new TelaDescricao(livro);
                        telaDescricao.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(tela, "Selecione um livro para ver os detalhes.", "Nenhum Livro Selecionado", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        painel.add(btnDetalhes);

        JButton btnRetornar = new JButton("Retornar");
        btnRetornar.setBounds(370, 470, 100, 30);
        btnRetornar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tela.dispose(); // Fecha a tela atual
                telaCadastro.getFrame().setVisible(true); // Voltar para a tela de cadastro
            }
        });
        painel.add(btnRetornar);

        tela.getContentPane().add(painel);
        tela.setLocationRelativeTo(null); // Centralizar a tela
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela da lista
    }

    public void atualizarLista(List<Livro> livros) {
        tableModel.setRowCount(0); // Limpar a tabela
        for (Livro livro : livros) {
            tableModel.addRow(new Object[]{livro.getTitulo(), livro.getAutor()});
        }
    }

    public void mostrar() {
        tela.setVisible(true);
    }

    private Livro buscarLivro(String titulo, String autor) {
        for (Livro livro : telaCadastro.getCadastro().getLivros()) {
            if (livro.getTitulo().equals(titulo) && livro.getAutor().equals(autor)) {
                return livro;
            }
        }
        return null;
    }
}
