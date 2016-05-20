package UI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class UIComponentesViewPrincipal extends JFrame {
    
    public JPanel contentPane;
    public JTextField txtNome;
    public JTextField txtPeso;
    public JTable gridPessoas;
    public JTextField txtCaminho;
    public JButton btnAdicionar = new JButton("");
    public JButton btnImportar = new JButton("");
    public JButton btnOrdenar = new JButton("");
    public JButton btnCancelar = new JButton("");
    public JButton btnDiretorio = new JButton("");
    public JComboBox cmbTipoOrdenacao = new JComboBox();
    public static JLabel lblNewLabel;
    
    public UIComponentesViewPrincipal(){
        setTitle("Organiza\u00E7\u00E3o de pessoas por peso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 598, 542);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 582, 442);
        contentPane.add(panel);
        panel.setLayout(null);
		
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 582, 3);
        panel.add(panel_1);
        panel_1.setBackground(new Color(34, 139, 34));
		
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        panel_2.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es da Pessoa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBounds(10, 14, 562, 80);
        panel.add(panel_2);
        panel_2.setLayout(null);
		
        btnAdicionar.setBackground(Color.WHITE);
        btnAdicionar.setIcon(new ImageIcon("..\\APSMetodoDeOrdenacao\\Layout\\Plus-15.png"));
        btnAdicionar.setBounds(526, 24, 26, 20);
        panel_2.add(btnAdicionar);
		
        txtPeso = new JTextField();
        txtPeso.setBounds(430, 24, 86, 20);
        panel_2.add(txtPeso);
        txtPeso.setColumns(10);
		
        JLabel lblPeso = new JLabel("Peso:");
        lblPeso.setBounds(385, 26, 46, 14);
        panel_2.add(lblPeso);
        lblPeso.setFont(new Font("Arial", Font.BOLD, 13));
		
        txtNome = new JTextField();
        txtNome.setBounds(57, 24, 318, 20);
        panel_2.add(txtNome);
        txtNome.setColumns(10);
		
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 26, 46, 14);
        panel_2.add(lblNome);
        lblNome.setFont(new Font("Arial", Font.BOLD, 13));
		
        txtCaminho = new JTextField();
        txtCaminho.setColumns(10);
        txtCaminho.setBounds(10, 51, 470, 20);
        panel_2.add(txtCaminho);
		
        btnDiretorio.setBackground(Color.WHITE);
        btnDiretorio.setIcon(new ImageIcon("..\\APSMetodoDeOrdenacao\\Layout\\Folder-15.png"));
        btnDiretorio.setSelectedIcon(new ImageIcon("..\\APSMetodoDeOrdenacao\\Layout\\Open Folder-15.png"));
        btnDiretorio.setBounds(490, 48, 26, 23);
        panel_2.add(btnDiretorio);
		
        btnImportar.setIcon(new ImageIcon("..\\APSMetodoDeOrdenacao\\Layout\\Downloading Updates-15 (1).png"));
        btnImportar.setBackground(Color.WHITE);
        btnImportar.setBounds(526, 48, 26, 23);
        panel_2.add(btnImportar);
		
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.WHITE);
        panel_3.setBounds(10, 130, 562, 265);
        panel.add(panel_3);
		
        JScrollPane scrollPane = new JScrollPane();
        GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3.setHorizontalGroup(
        gl_panel_3.createParallelGroup(Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );
        gl_panel_3.setVerticalGroup(
            gl_panel_3.createParallelGroup(Alignment.TRAILING)
                .addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        );
		
        gridPessoas = new JTable();
        gridPessoas.setModel(new DefaultTableModel(
            new Object[][] {
            },
                new String[] {
                    "Nome", "Peso"
                }
        ));
        scrollPane.setViewportView(gridPessoas);
        panel_3.setLayout(gl_panel_3);
		
        JLabel lblTipoDeOrdenao = new JLabel("Tipo de Ordena\u00E7\u00E3o:");
        lblTipoDeOrdenao.setFont(new Font("Arial", Font.BOLD, 12));
        lblTipoDeOrdenao.setBounds(20, 105, 110, 14);
        panel.add(lblTipoDeOrdenao);
		        
        cmbTipoOrdenacao.setModel(new DefaultComboBoxModel(new String[] {"BinaryInsertionSort", "BubbleSort", "QuickSort", "SelectionSort"}));
        cmbTipoOrdenacao.setBounds(133, 103, 143, 20);
        panel.add(cmbTipoOrdenacao);
		
        JLabel lblTempoDeDurao = new JLabel("Tempo de dura\u00E7\u00E3o na ordena\u00E7\u00E3o:");
        lblTempoDeDurao.setFont(new Font("Arial", Font.BOLD, 12));
        lblTempoDeDurao.setBounds(282, 105, 197, 14);
        panel.add(lblTempoDeDurao);
		
        lblNewLabel = new JLabel("00 ms");
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        lblNewLabel.setBackground(Color.WHITE);
        lblNewLabel.setBounds(478, 105, 46, 14);
        panel.add(lblNewLabel);
		
        JProgressBar pbrProgresso = new JProgressBar();
        pbrProgresso.setBounds(10, 406, 562, 25);
        panel.add(pbrProgresso);
				
        btnOrdenar.setIcon(new ImageIcon("..\\APSMetodoDeOrdenacao\\Layout\\Replace-30.png"));
        btnOrdenar.setBounds(509, 453, 63, 39);
        contentPane.add(btnOrdenar);
	    		
        btnCancelar.setIcon(new ImageIcon("..\\APSMetodoDeOrdenacao\\Layout\\Delete-30.png"));
        btnCancelar.setBounds(436, 453, 63, 39);
        contentPane.add(btnCancelar);
    }
    
}
