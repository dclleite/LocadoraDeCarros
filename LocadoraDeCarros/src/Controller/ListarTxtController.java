/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Locadora;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author eduardo
 */
public class ListarTxtController implements Initializable {

    @FXML
    private Button btnConfirmar;

   
    @FXML
    private ListView<String> listSaidaTxt;
    
    @FXML
    void confirmaCaminho(ActionEvent event) {
        ler();
        populaList();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cadastraLocadora();
    }   
    
    private List<String> listSaidas = new ArrayList<String>();
    private ObservableList<String> obsListSaidas;
    private List<Locadora> listaLocadora = new ArrayList<>();
    
    public void cadastraLocadora(){
        
        Locadora l1 = new Locadora("SouthCar","Compacto",4,210,200,150,90);
        listaLocadora.add(l1);
        
        Locadora l2 = new Locadora("WestCar","Esportivo",2,530,200,150,90);
        listaLocadora.add(l2);
        
        Locadora l3 = new Locadora("NorthCar","SUV's",7,630,600,580,590);
        listaLocadora.add(l3);
;

}    
    
    String temp;
    public void ler(){
       
     String[] palavras = null;
     String tipoClienteTxt = null;
     Integer qtdPassageirosTxt = null;
     Integer meioSemanaTxt = 0 ;
     Integer fimSemanaTxt = 0;
        
    try{
        FileInputStream arquivo = new FileInputStream("entrada.txt");
        InputStreamReader input = new InputStreamReader(arquivo);
        BufferedReader br = new BufferedReader(input);
        
        String linha;
        
        do {            
            linha = br.readLine();
            if (linha != null) {
                palavras = (linha.split(":"));
                
                    tipoClienteTxt = palavras[0];
                    qtdPassageirosTxt = Integer.parseInt(palavras[1]);
      
                    String[] diasSemanaTxt = palavras[2].split(","); // separando os dias de semana
                    for (String diasSemanaTxt1 : diasSemanaTxt) {
                        if (diasSemanaTxt1.charAt(12) == 'g' || diasSemanaTxt1.charAt(12) == 'r' 
                        || diasSemanaTxt1.charAt(12) == 'a' || diasSemanaTxt1.charAt(12) == 'i'
                        ||diasSemanaTxt1.charAt(12) == 'x') { // conferindo se o ultimo caracter bate com o dia
                            
                            meioSemanaTxt ++;
                        }else{
                            fimSemanaTxt ++;
                        }
                    }
                
            }
        //-------------Multiplica dia ------------------------------------
            
            int cont = 0;
            double locadora1 = 0;
            double locadora2 = 0;
            double locadora3 = 0;

    
            
            if (qtdPassageirosTxt > 4 && qtdPassageirosTxt <= 7) {
                temp = listaLocadora.get(2).getTipoCarro()+":"+listaLocadora.get(2).getNome();
                listSaidas.add(temp);
            }else if (qtdPassageirosTxt >2 && qtdPassageirosTxt <= 4) {
                temp = listaLocadora.get(0).getTipoCarro()+":"+listaLocadora.get(0).getNome();
                listSaidas.add(temp);
            }else if(qtdPassageirosTxt <=2){
                cont = 1;
            if(tipoClienteTxt.equals("Normal")) {
                locadora1 = (meioSemanaTxt * listaLocadora.get(0).getPrecoDiaSemanaN()) + (fimSemanaTxt * listaLocadora.get(0).getPrecoFimSemanaN());
                locadora2 = (meioSemanaTxt * listaLocadora.get(1).getPrecoDiaSemanaN()) + (fimSemanaTxt * listaLocadora.get(1).getPrecoFimSemanaN());
                locadora3 = (meioSemanaTxt * listaLocadora.get(2).getPrecoDiaSemanaN()) + (fimSemanaTxt * listaLocadora.get(2).getPrecoFimSemanaN());
            }else {
                locadora1 = (meioSemanaTxt * listaLocadora.get(0).getPrecoDiaSemanaP()) + (fimSemanaTxt * listaLocadora.get(0).getPrecoFimSemanaP());
                locadora2 = (meioSemanaTxt * listaLocadora.get(1).getPrecoDiaSemanaP()) + (fimSemanaTxt * listaLocadora.get(1).getPrecoFimSemanaP());
                locadora3 = (meioSemanaTxt * listaLocadora.get(2).getPrecoDiaSemanaP()) + (fimSemanaTxt * listaLocadora.get(2).getPrecoFimSemanaP());        
            }
        }
        if (cont == 1) {
            if (locadora1 < locadora2 && locadora1 <= locadora3) {
                temp = listaLocadora.get(0).getTipoCarro()+":"+listaLocadora.get(0).getNome();
                listSaidas.add(temp);
            }else if (locadora2 <= locadora1 && locadora2 <= locadora3) {
                temp = listaLocadora.get(1).getTipoCarro()+":"+listaLocadora.get(1).getNome();
                listSaidas.add(temp);
            }else{
                temp = listaLocadora.get(2).getTipoCarro()+":"+listaLocadora.get(2).getNome();
                listSaidas.add(temp);
            }
            
        }
        meioSemanaTxt = 0;
        fimSemanaTxt = 0;
        } while (linha != null);
        
        }catch(Exception e){
            System.out.println("Confirme o local do Arquivo");
        }
    }
    
    public void populaList(){
        obsListSaidas = FXCollections.observableArrayList(listSaidas);
        
        listSaidaTxt.setItems(obsListSaidas);
        
    }
    
}

