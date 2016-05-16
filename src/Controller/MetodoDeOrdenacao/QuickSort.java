package Controller.MetodoDeOrdenacao;

import Model.Pessoa;
import java.util.List;

public class QuickSort {

    private int i , j, aux;
    private float piv, auxTroca;
    private String auxNome;
    
    public void qsort(List<Pessoa> lstPessoa, int L, int R){        
        i = L;
        j = R;
        aux = (L + R) / 2;
        piv = lstPessoa.get(aux).getPeso();
   
        do{
            while(lstPessoa.get(i).getPeso() < piv) {
                i = i + 1;
            }
            while(piv < lstPessoa.get(j).getPeso()){
                j = j - 1;
            }
            if(i <= j){
                auxTroca = lstPessoa.get(i).getPeso();
                auxNome = lstPessoa.get(i).getNome();
                lstPessoa.get(i).setPeso(lstPessoa.get(j).getPeso());
                lstPessoa.get(i).setNome(lstPessoa.get(j).getNome());
                lstPessoa.get(j).setPeso(auxTroca);
                lstPessoa.get(j).setNome(auxNome);
                i = i + 1;
                j = j - 1;
            }
            
        } while(i <= j);
        
        if(L < j){
            qsort(lstPessoa, L, j);
        }
        if(i < R){
            qsort(lstPessoa, i, R);
        }
                            
    }
     public List<Pessoa> Ordenar(List<Pessoa> lstPessoa){            
         qsort(lstPessoa, 0, lstPessoa.size() - 1);         
         return lstPessoa;
     }
    
}
