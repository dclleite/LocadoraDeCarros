/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.DiaSemana;
import Modelo.Locadora;
import Modelo.TipoCliente;
import locadoradecarros.Principal;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import locadoradecarros.ListarTxt;
import locadoradecarros.Principal;

/**
 *
 * @author eduardo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ComboBox<DiaSemana> cbDiasDaSemana;
    
    @FXML
    private Button btnVerificar;
    
    @FXML
    private Button btnArqText;
    
    @FXML
    private TextField txtDatas;
    
    @FXML
    private Label lblTipoCliente;
    
    @FXML
    private TextField txtTipoCliente;
    
    @FXML
    private TextField txtQtdPassageiros;
    
    @FXML
    private Button btnSelecionaDias;
    
    @FXML
    private ComboBox<TipoCliente> cbTipoCliente;
    
    @FXML
    private Label lblMensagem;
    

    @FXML
    private void pegaDias(ActionEvent event){
        DiaSemana diaSemana = cbDiasDaSemana.getSelectionModel().getSelectedItem();
        diaSelecionado.add(diaSemana.getId());
        verificaDia();
    }
    
    @FXML
    private void clicouVerificar(ActionEvent event){
        multiplicaDia();
    }
    
    @FXML
    void entrarComArqText(ActionEvent event) {
        ListarTxt l = new ListarTxt();
        
        try {
            l.start(new Stage());
        } catch (Exception ex) {
            
        }

    }
    //-----------------------------------------------
    
    private List<DiaSemana> diasSemana = new ArrayList<>();
    private List<Integer> diaSelecionado = new ArrayList<Integer>();

    ObservableList<DiaSemana> obsDiaSemana;
    
    private List<TipoCliente> tipoCliente = new ArrayList<>();
    ObservableList<TipoCliente> obsTipoCliente;
    
    private List<Locadora> listaLocadora = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregaDias();
        carregaTipo();
        cadastraLocadora();
    }    
    
    public void carregaDias(){
        DiaSemana dia1 = new DiaSemana("seg", 1);
        DiaSemana dia2 = new DiaSemana("ter", 1);
        DiaSemana dia3 = new DiaSemana("qua", 1);
        DiaSemana dia4 = new DiaSemana("qui", 1);
        DiaSemana dia5 = new DiaSemana("sex", 1);
        DiaSemana dia6 = new DiaSemana("sab", 2);
        DiaSemana dia7 = new DiaSemana("dom", 2);
        
        diasSemana.add(dia1);
        diasSemana.add(dia2);
        diasSemana.add(dia3);
        diasSemana.add(dia4);
        diasSemana.add(dia5);
        diasSemana.add(dia6);
        diasSemana.add(dia7);
        
        obsDiaSemana = FXCollections.observableArrayList(diasSemana);
        
        cbDiasDaSemana.setItems(obsDiaSemana);
        
    }

    
public void carregaTipo(){
    
    TipoCliente tipo1 = new TipoCliente("Normal", 1);
    TipoCliente tipo2 = new TipoCliente("Premium", 2);
    
    tipoCliente.add(tipo1);
    tipoCliente.add(tipo2);
    
    obsTipoCliente = FXCollections.observableArrayList(tipoCliente);
        
    cbTipoCliente.setItems(obsTipoCliente);
    
}
        
    Integer meioSemana = 0;
    Integer fimSemana = 0;
    int i=0;
    
public void verificaDia(){
    
    if (diaSelecionado.get(i)== 1) {
        meioSemana ++;
        System.out.println("meio de semana: "+meioSemana);
    }else{
        fimSemana ++;
        System.out.println("fim de semana :"+fimSemana);
    }
    i++; 
}

public void cadastraLocadora(){
        
    Locadora l1 = new Locadora("SouthCar","Compacto",4,210,200,150,90);
    listaLocadora.add(l1);
        
    Locadora l2 = new Locadora("WestCar","Esportivo",2,530,200,150,90);
    listaLocadora.add(l2);
        
    Locadora l3 = new Locadora("NorthCar","SUV's",7,630,600,580,590);
    listaLocadora.add(l3);


}

    
public void multiplicaDia(){
    int cont = 0;
    double locadora1 = 0;
    double locadora2 = 0;
    double locadora3 = 0;

    
    Integer valor = Integer.parseInt(txtQtdPassageiros.getText());
    if (valor > 4 && valor <= 7) {
        lblMensagem.setText(listaLocadora.get(2).getTipoCarro()+":"+listaLocadora.get(2).getNome());
    }else if (valor >2 && valor <= 4) {
        lblMensagem.setText(listaLocadora.get(0).getTipoCarro()+":"+listaLocadora.get(0).getNome());
    }else if(valor <=2){
        cont = 1;
        TipoCliente tipoC = cbTipoCliente.getSelectionModel().getSelectedItem();
        if(tipoC.getId()==1) {
            locadora1 = (meioSemana * listaLocadora.get(0).getPrecoDiaSemanaN()) + (fimSemana * listaLocadora.get(0).getPrecoFimSemanaN());
            locadora2 = (meioSemana * listaLocadora.get(1).getPrecoDiaSemanaN()) + (fimSemana * listaLocadora.get(1).getPrecoFimSemanaN());
            locadora3 = (meioSemana * listaLocadora.get(2).getPrecoDiaSemanaN()) + (fimSemana * listaLocadora.get(2).getPrecoFimSemanaN());
        }else {
            locadora1 = (meioSemana * listaLocadora.get(0).getPrecoDiaSemanaP()) + (fimSemana * listaLocadora.get(0).getPrecoFimSemanaP());
            locadora2 = (meioSemana * listaLocadora.get(1).getPrecoDiaSemanaP()) + (fimSemana * listaLocadora.get(1).getPrecoFimSemanaP());
            locadora3 = (meioSemana * listaLocadora.get(2).getPrecoDiaSemanaP()) + (fimSemana * listaLocadora.get(2).getPrecoFimSemanaP());        
        }
    }
    if (cont == 1) {
        if (locadora1 < locadora2 && locadora1 <= locadora3) {
            lblMensagem.setText(listaLocadora.get(0).getTipoCarro()+":"+listaLocadora.get(0).getNome());
        }else if (locadora2 <= locadora1 && locadora2 <= locadora3) {
            lblMensagem.setText(listaLocadora.get(1).getTipoCarro()+":"+listaLocadora.get(1).getNome());
        }else{
            lblMensagem.setText(listaLocadora.get(2).getTipoCarro()+":"+listaLocadora.get(2).getNome());
        }
    
    }
    meioSemana = 0;
    fimSemana = 0;
}
 
}
