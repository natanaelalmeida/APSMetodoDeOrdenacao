package View;

import Controller.InserirDados;
import Controller.MetodoDeOrdenacao.BinaryInsertionSort;
import Controller.MetodoDeOrdenacao.BubbleSort;
import Controller.MetodoDeOrdenacao.QuickSort;
import Controller.MetodoDeOrdenacao.SelectionSort;
import Model.Pessoa;
import UI.UIComponentesViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Principal extends UIComponentesViewPrincipal {

    private final InserirDados inserir = new InserirDados();
    private final QuickSort qs = new QuickSort();
    private final BinaryInsertionSort bis = new BinaryInsertionSort();
    private final SelectionSort ss = new SelectionSort();
    private final BubbleSort bs = new BubbleSort();
    private Pessoa pessoa;
    private List<Pessoa> lstPessoa;

    public Principal() {
        setVisible(true);        
        StatusButton(false);
        
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdicionarNaLista(e);
            }
        });

        btnDiretorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelecionarArquivo(e);
            }
        });
        
        btnImportar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdicionarImportacaoNaLista(e);
            }            
        });
        
        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrdenarDados(e);
            }
        });
    }

    private void AdicionarNaLista(ActionEvent e) {
        if (!txtNome.getText().equals("") && !txtPeso.getText().equals("")) {
            pessoa = new Pessoa();
            pessoa.setNome(txtNome.getText());
            pessoa.setPeso(Float.parseFloat(txtPeso.getText()));
            
            lstPessoa = new ArrayList<>();
            lstPessoa =  inserir.insereListaManual(pessoa);
            AtualizaDados(lstPessoa);
            LimparCampos();
            
            btnOrdenar.setEnabled(true);
        } 
        else {
            MensagemAlerta("Campo nome ou peso está vazio, favor preencher.");
        }
    }

    private void AdicionarImportacaoNaLista(ActionEvent e) {
        
        String path = txtCaminho.getText();
        if(!path.equals("")) {
            try {                
                lstPessoa = new ArrayList<>();
                lstPessoa = inserir.insereListaRec(path);
                AtualizaDados(lstPessoa);
                LimparCampos();
                btnOrdenar.setEnabled(true);
            }
            catch (IOException ex) {
                MensagemErro("Erro ao ler o arquivo! " + ex.getMessage());
            }
            catch (ArrayIndexOutOfBoundsException ex) {
                MensagemErro("Layout do arquivo é invalido.");
            }
         }
    }

    private void SelecionarArquivo(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int status = fc.showSaveDialog(null);

        File arq;
        arq = fc.getSelectedFile();
        String nome = arq.getName().toLowerCase();
        String ex = nome.substring(nome.lastIndexOf('.') + 1);

        if (ex.equals("txt")) {
            txtCaminho.setText(arq.getPath());
            btnImportar.setEnabled(true);
        } 
        else {
            MensagemAlerta("Extensão do arquivo é invalida. Favor selecionar um arquivo .txt");
        }

    }
    
    private void OrdenarDados(ActionEvent e) {
        String value = String.valueOf(cmbTipoOrdenacao.getSelectedItem());
        switch(value)
        {
            case "BinaryInsertionSort" :
                AtualizaDados(bis.Ordenar(lstPessoa));
                break;
            case "BubbleSort" :
                AtualizaDados(bs.Ordenar(lstPessoa));
                break;
            case "QuickSort" :
                AtualizaDados(qs.Ordenar(lstPessoa));
                break;
            case "SelectionSort" :
                AtualizaDados(ss.Ordenar(lstPessoa));
                break;
        }
        
        MensagemSucesso("Ordenação efetuada com sucesso.");
    }

    private void LimparCampos() {
        txtNome.setText("");
        txtPeso.setText("");
        txtCaminho.setText("");
        btnImportar.setEnabled(false);
    }

    private void AtualizaDados(List<Pessoa> _lstPessoa) {
        String colunas[] = {"Nome", "Peso"};
        DefaultTableModel d = new DefaultTableModel(colunas, 0);

        for (Pessoa _pessoa : _lstPessoa) {
            d.addRow(new String[]{_pessoa.getNome(), String.valueOf(_pessoa.getPeso())});
        }

        gridPessoas.setModel(d);
    }

    private void MensagemErro(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Erro!", JOptionPane.ERROR_MESSAGE);
    }

    public void MensagemAlerta(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Alerta!", JOptionPane.WARNING_MESSAGE);
    }

    private void MensagemSucesso(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void StatusButton(Boolean status) {
        btnImportar.setEnabled(status);
        btnOrdenar.setEnabled(status);
    }
}
