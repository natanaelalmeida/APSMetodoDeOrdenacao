package Controller.MetodoDeOrdenacao;

import Model.Pessoa;
import java.util.List;

public class SelectionSort {
    
    public List<Pessoa> Ordenar(List<Pessoa> lstPessoa){
        
        int i , j , ind_menor;
        float aux;
        String auxNome;
        
        for (i = 0; i < lstPessoa.size() ; i++) {
            ind_menor = i;
            for (j = i + 1; j < lstPessoa.size(); j++) {
                
                if (lstPessoa.get(j).getPeso() < lstPessoa.get(ind_menor).getPeso()){
                    ind_menor = j;
                }
                
            }
            aux = lstPessoa.get(i).getPeso();
            auxNome = lstPessoa.get(i).getNome();
            lstPessoa.get(i).setPeso(lstPessoa.get(ind_menor).getPeso());
            lstPessoa.get(i).setNome(lstPessoa.get(ind_menor).getNome());
            lstPessoa.get(ind_menor).setPeso(aux);
            lstPessoa.get(ind_menor).setNome(auxNome);
            
            
           
            
        }
        
        
        
        return lstPessoa;
    }
    
}
