package View;

import Controller.InserirDados;
import Controller.MetodoDeOrdenacao.BinaryInsertionSort;
import Controller.MetodoDeOrdenacao.BubbleSort;
import Controller.MetodoDeOrdenacao.QuickSort;
import Controller.MetodoDeOrdenacao.SelectionSort;
import Model.Pessoa;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CadastroPessoaPeso {
    
    private InserirDados insert = new InserirDados();
    private List<Pessoa> lstPessoa;
    
    public void cadastrar() throws IOException{
        
        String num = "";
        String op = JOptionPane.showInputDialog("1 - Para inserir manualmente; \n 2 - Para inserir através de um arquivo;");
        if (Integer.valueOf(op) == 1){
            JOptionPane.showMessageDialog(null, "Para cancelar adição de elemntos, digite 0: ");
            int control = 1;
                        
            while(control != 0){
                Pessoa pessoa = new Pessoa();               
                pessoa.setNome(JOptionPane.showInputDialog("Nome:"));
                pessoa.setPeso(Float.parseFloat(JOptionPane.showInputDialog("Peso:")));
                lstPessoa = insert.insereListaManual(pessoa);
                control = Integer.valueOf(JOptionPane.showInputDialog("Deseja continuar? (1 para continuar, 0 para sair) "));    
            }
            for (Pessoa pessoa : lstPessoa) {
                num += "Nome: " + pessoa.getNome() + " Peso: " + pessoa.getPeso() + " \n";
            }
            JOptionPane.showMessageDialog(null, num);
                                    
        }else {
            JFileChooser path = new JFileChooser();
            path.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int var = path.showSaveDialog(null);
            File arq = path.getSelectedFile();
            lstPessoa = insert.insereListaRec(arq.getPath());
            num = "";
            for (Pessoa pessoa : lstPessoa) {
                num += "Nome: " + pessoa.getNome() + " Peso: " + pessoa.getPeso() + " \n";
            }
            JOptionPane.showMessageDialog(null, num);
        }
        
        List<Pessoa> lstPessoaOrdenada;
                
        QuickSort qs = new QuickSort();
        BinaryInsertionSort bis = new BinaryInsertionSort();
        SelectionSort ss = new SelectionSort();
        BubbleSort bs = new BubbleSort();
        
        
        
        System.out.println("BinaryInsertion: \n");
        
        lstPessoaOrdenada = bis.Ordenar(lstPessoa);
        for (Pessoa pessoa : lstPessoaOrdenada) {
            System.out.println("Nome: "  + pessoa.getNome()+ " Peso: " + pessoa.getPeso());
        }
        
        System.out.println("Selection: \n");
        
        lstPessoaOrdenada = ss.Ordenar(lstPessoa);
        for (Pessoa pessoa : lstPessoaOrdenada) {
            System.out.println("Nome: "  + pessoa.getNome()+ " Peso: " + pessoa.getPeso());
            
        }
                
        System.out.println("QuickSort: \n");
        
        lstPessoaOrdenada = qs.Ordenar(lstPessoa);
        for (Pessoa pessoa : lstPessoaOrdenada) {
            System.out.println("Nome: "  + pessoa.getNome()+ " Peso: " + pessoa.getPeso());
            
        }
        
        System.out.println("BubbleSort: \n");
        lstPessoaOrdenada = bs.Ordenar(lstPessoa);
        for (Pessoa pessoa : lstPessoaOrdenada) {
            System.out.println("Nome: "  + pessoa.getNome()+ " Peso: " + pessoa.getPeso());
            
        }
    }
}
