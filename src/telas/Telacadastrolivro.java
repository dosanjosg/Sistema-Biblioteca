package telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Telacadastrolivro {
    private JFrame frame;
    private JTextField txtTitulo;
    private JTextField txtAutorLivro;
    private JTextField txtSinopse;
    private CadastroDeLivros cadastro;
    private TelaLista telaLista;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Telacadastrolivro window = new Telacadastrolivro();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Telacadastrolivro() {
        cadastro = new CadastroDeLivros();
        telaLista = new TelaLista();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 600); // Ajustar tamanho da tela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null); // Centralizar a tela

        JLabel lblTituloLivro = new JLabel("Título do Livro:");
        lblTituloLivro.setBounds(75, 34, 130, 16);
        frame.getContentPane().add(lblTituloLivro);

        txtTitulo = new JTextField();
        txtTitulo.setBounds(75, 54, 450, 26); // Ajustar largura do campo de texto
        frame.getContentPane().add(txtTitulo);
        txtTitulo.setColumns(10);

        JLabel lblAutorLivro = new JLabel("Autor:");
        lblAutorLivro.setBounds(75, 92, 61, 16);
        frame.getContentPane().add(lblAutorLivro);

        txtAutorLivro = new JTextField();
        txtAutorLivro.setBounds(75, 120, 450, 26); // Ajustar largura do campo de texto
        frame.getContentPane().add(txtAutorLivro);
        txtAutorLivro.setColumns(10);

        JLabel lblSinopse = new JLabel("Sinopse:");
        lblSinopse.setBounds(75, 158, 61, 16);
        frame.getContentPane().add(lblSinopse);

        txtSinopse = new JTextField();
        txtSinopse.setBounds(75, 180, 450, 30); // Ajustar largura e altura do campo de texto
        frame.getContentPane().add(txtSinopse);
        txtSinopse.setColumns(10);

        JButton btnCadastrarLivro = new JButton("Cadastrar");
        btnCadastrarLivro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = txtTitulo.getText();
                String autor = txtAutorLivro.getText();
                String sinopse = txtSinopse.getText();
                Livro livro = new Livro(titulo, autor, sinopse);
                cadastro.adicionaLivro(livro);

                String sinopseQuebrada = quebrarTextoEmLinhas(sinopse, 50);
                JOptionPane.showMessageDialog(null,
                        "Título: " + titulo + "\nAutor: " + autor + "\nSinopse: " + sinopseQuebrada + "\n\nLivro cadastrado com sucesso!");

                telaLista.atualizarLista(cadastro.getLivros());
                
                txtTitulo.setText("");
                txtAutorLivro.setText("");
                txtSinopse.setText("");
            }
        });
        btnCadastrarLivro.setBounds(100, 500, 100, 30); // Ajustar posição para mais inferior
        frame.getContentPane().add(btnCadastrarLivro);

        JButton btnMostrarLista = new JButton("Mostrar Lista");
        btnMostrarLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                telaLista.atualizarLista(cadastro.getLivros());
                telaLista.mostrar();
            }
        });
        btnMostrarLista.setBounds(380, 500, 115, 30); // Ajustar posição para mais inferior
        frame.getContentPane().add(btnMostrarLista);

        JLabel lblCadastroLivro = new JLabel("CADASTRO DE LIVROS");
        lblCadastroLivro.setBounds(200, 6, 200, 16); // Centralizar o título
        frame.getContentPane().add(lblCadastroLivro);
    }

    private String quebrarTextoEmLinhas(String texto, int comprimentoMaximo) {
        StringBuilder sb = new StringBuilder();
        int inicio = 0;
        while (inicio < texto.length()) {
            int fim = Math.min(inicio + comprimentoMaximo, texto.length());
            sb.append(texto.substring(inicio, fim));
            if (fim < texto.length()) {
                sb.append("\n");
            }
            inicio = fim;
        }
        return sb.toString();
    }
}


