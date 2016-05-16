package Controller.MetodoDeOrdenacao;

import Model.Pessoa;
import java.util.List;

public class BubbleSort {

    private int i, j;
    private float aux;
    private String auxNome;
    
    public List<Pessoa> Ordenar(List<Pessoa> lstPessoa){
        
        for(i = 1; i < lstPessoa.size(); i++){
            for(j = lstPessoa.size() - 1; j >= i; j--){
                if(lstPessoa.get(j - 1).getPeso() > lstPessoa.get(j).getPeso()){
                    aux = lstPessoa.get(j - 1).getPeso();
                    auxNome = lstPessoa.get(j - 1).getNome();
                    lstPessoa.get(j - 1).setPeso(lstPessoa.get(j).getPeso());
                    lstPessoa.get(j - 1).setNome(lstPessoa.get(j).getNome());
                    lstPessoa.get(j).setPeso(aux);
                    lstPessoa.get(j).setNome(auxNome);                    
                }
            }
        }
        
        return lstPessoa;
    }
    
}
