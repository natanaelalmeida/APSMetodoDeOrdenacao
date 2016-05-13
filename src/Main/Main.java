package Main;

import View.CadastroPessoaPeso;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        
        CadastroPessoaPeso cad = new CadastroPessoaPeso();
        try {
            cad.cadastrar();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        
    }
    
}
