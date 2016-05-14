package Controller;

import Model.Pessoa;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InserirDados {
    
    private List<Pessoa> lstPessoa = new ArrayList<Pessoa>();
    
    public List<Pessoa> insereListaManual(Pessoa pessoa){
        
        if (pessoa != null){
            this.lstPessoa.add(pessoa);                   
        }        
        return lstPessoa;
    }
    
    public List<Pessoa> insereListaRec(String path) throws IOException{
        
        FileReader flista = new FileReader(path);
        BufferedReader brlista = new BufferedReader(flista);
        String linha;
        lstPessoa = new ArrayList<Pessoa>();
               
        while((linha = brlista.readLine()) != null){
            String[] vet = linha.split(";");
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(vet[0]);
            pessoa.setPeso(Float.parseFloat(vet[1]));
            lstPessoa.add(pessoa);           
        }
        
        return lstPessoa;
    }        
}
