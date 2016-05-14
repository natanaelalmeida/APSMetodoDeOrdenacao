package Controller.MetodoDeOrdenacao;

import Model.Pessoa;
import java.util.List;

public class BinaryInsertionSort {

    private float x;
    private String y;
    private int L;
    private int R;
    private int m;
    private int tam;
    private int j;

    public List<Pessoa> Ordenar(List<Pessoa> lstPessoa) {
        tam = lstPessoa.size();
        for (int i = 1; i < tam; i++) {
            y = lstPessoa.get(i).getNome();
            x = lstPessoa.get(i).getPeso();
            L = 0;
            R = i;

            while (L < R) {
                m = (L + R) / 2;
                if (lstPessoa.get(m).getPeso() <= x) {
                    L = m + 1;
                } else {
                    R = m;
                }
            }
            j = i;

            while (j > R) {
                lstPessoa.get(j).setPeso(lstPessoa.get(j - 1).getPeso());
                lstPessoa.get(j).setNome(lstPessoa.get(j - 1).getNome());
                j = j - 1;
            }
            lstPessoa.get(R).setPeso(x);
            lstPessoa.get(R).setNome(y);
        }

        return lstPessoa;
    }
}
