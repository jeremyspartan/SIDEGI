/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Usuario
 */
public class Calendario {
    private String[] listaMeses={"Enero","Febrero","Marzo","Abril","Mayo","Junio",
                                 "Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

    private GregorianCalendar calendarioGreg;
    private int diaActual;
    private int mesActual;
    private int annioActual;
    private CasillaCalendario[][] listaContenedores;
   
    public Calendario() {
        this.calendarioGreg = new GregorianCalendar();
        this.diaActual = calendarioGreg.get(Calendar.DAY_OF_WEEK);
        this.mesActual = calendarioGreg.get(Calendar.MONTH);
        this.annioActual = calendarioGreg.get(Calendar.YEAR);
     
    }

    public String getMesActualNombre() {
        return listaMeses[mesActual];
    }

    public int getAnnioActual() {
        return annioActual;
    }
    
    public void agregarListaContenedores(CasillaCalendario cc,int i,int j){
        this.listaContenedores[i][j]=cc;
    }
    
    public void escribirDias(GridPane gpCalendario){ 
       int dia=1;
       for(int i=0;i<=5;i++){  
           for(int j=0;j<=6;j++){
                if(dia>totalDiasMes()){
                    break;
                }
                else{      
                    gpCalendario.add(new Label(Integer.toString(dia)), j, i);
                    //listaContenedores[i][j].getLblFecha().setText(Integer.toString(dia));
                    System.out.print(dia+"-");
                    dia++;
                }         
            }      
       }
    }
    public int totalDiasMes(){                                          //**
        if(mesActual==-1){
            mesActual=11;
            System.out.println("NUMERO NEGATIVO");
        }       
        switch (mesActual) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            default:
                if(calendarioGreg.isLeapYear(annioActual)){
                    return 29;
                }
                else return 28;
        }
    }
    public boolean esAnnioBisiesto(){
        if(calendarioGreg.isLeapYear(annioActual)){
            return true;
        } 
        else return false;
        
    }
    public int primerDiaMes(){
        return calendarioGreg.getFirstDayOfWeek();
    }
    public void mesAnterior(){
        if(mesActual!=0){
            mesActual--;
        }
        else {
            mesActual=11;
            annioActual--;
        }
        setNuevaFecha();
    }
    public void mesSiguiente(){
        if(mesActual!=11){
            mesActual++;
        }
        else{
            mesActual=0;
            annioActual++;
        }
        setNuevaFecha();
        
    }
    public void setNuevaFecha(){
        calendarioGreg.set(annioActual, mesActual, diaActual);
    }
}
