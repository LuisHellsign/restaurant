/*
 * Clase que representa el restaurante de la universidad del valle
 */
import javax.swing.*;
/**
 * @author Leoviviana Moreno
 * @date 11 de marzo de 2017
 * Curso programación interactiva.  Ejemplo arreglos de objetos
 */
public class Restaurante {

    int valorFijo;
    Estudiante listaEstudiantes[];
    int estu;
    int descuento;
    int ValorTotal;
    int ImpriRecibo;
    int codig;
    
    
    //creación de contructor para darle valores iniciales a la clase
    public Restaurante()
    {
        valorFijo = 4500;
        listaEstudiantes = new Estudiante[100];
        estu = 0;
        codig = 0;
        
    }
    
    
    public void recibirEstudiante()
    {
        String nom, cod, pl, d;
        nom = JOptionPane.showInputDialog("digite el nombre del estudiante "+estu);
        cod = JOptionPane.showInputDialog("digite el codigo del estudiante "+estu);
        pl = JOptionPane.showInputDialog("digite el plan del estudiante "+estu);
        d = JOptionPane.showInputDialog("digite el día de la semana ");
        
        Estudiante unEstudiante = new Estudiante(nom,cod,pl,d);
        listaEstudiantes[estu] = unEstudiante;
        estu = estu + 1;
        
        
        
    }
    
    public int calcularPorcentaje()
    {
        String primLetra = listaEstudiantes[estu-1].sacarPrimeraLetradeNombre();
        String ultimoD = listaEstudiantes[estu-1].sacarUltimodigitoCodigo();
        int cant1 = listaEstudiantes[estu-1].contarNoUno();
        int cant5 = listaEstudiantes[estu-1].contarNoCinco();
        String dia = listaEstudiantes[estu-1].enviarDia();
        String plan = listaEstudiantes[estu-1].enviarPlan();
        int porcentaje=0;
        
        if(dia.equalsIgnoreCase("miercoles") && primLetra.equalsIgnoreCase("l")&& plan.equals("2711"))
        {
            porcentaje = 20;
        }  
        if((dia.equalsIgnoreCase("lunes") ||dia.equalsIgnoreCase("viernes")) && (cant1>=2 || cant5 >=2))
        {
            porcentaje = 25;
        } 
        if(dia.equalsIgnoreCase("jueves") && ultimoD.equals("0")&&(plan.equals("3743")||plan.equals("3742")||plan.equals("2712")||plan.equals("3744")))
        {
            porcentaje = 50;
        } 
        return porcentaje;
    }
    
    public int CalcularDescuento()
    {
        descuento = (valorFijo * calcularPorcentaje())/100;
        return descuento;
    }
    
    public int CalcularValorTotal()
    {
        ValorTotal = valorFijo - CalcularDescuento();
        return ValorTotal;
    }
    
    public int ImprimirRecibo()
    {
        ImpriRecibo = Integer.parseInt(JOptionPane.showInputDialog(null,"Estudiante: "+listaEstudiantes[estu-1].enviarNombre()+"\n Codigo: "+listaEstudiantes[estu-1].enviarCodigo()+"\n Plan: "+listaEstudiantes[estu-1].enviarPlan()+"\n Dia: "+listaEstudiantes[estu-1].enviarDia()));
        return ImpriRecibo;
    }
    
    public String BuscarPorCodigo()
            
    {
    String x;
           x = JOptionPane.showInputDialog("Ingrese el Codigo a buscar");
        //   codig = listaEstudiante[estu-1].enviarCodigo();
       //for( x = 0; x = listaEstudiantes[estu-1]; x++){
         //  if( x == listaEstudiantes[estu-1].enviarCodigo().length()) {
           
      //}    
       
     // }
        
        
        
         return x;
        
      
    }
    
   
    public static void main(String[] args) {
        Restaurante objeto = new Restaurante();
        int seguir;
        
        do
        {
            seguir = Integer.parseInt(JOptionPane.showInputDialog("******MENU *******"
                    + "\n1 - RECIBIR ESTUDIANTE"
                    + "\n 2 - CALCULAR PORCENTAJE"
                    + "\n 3 - CALCULAR DESCUENTO"
                    + "\n 4 - MOSTRAR VALOR TOTAL"
                    + "\n 5 - IMPRIMIR RECIBO"
                    + "\n 6 - Buscar por Codigo"
                    + "\n 7 - SALIR"));
            
            if (seguir == 1){
                objeto.recibirEstudiante();
            }
            if(seguir == 2){
                JOptionPane.showMessageDialog(null,objeto.calcularPorcentaje());
            }
            
           if(seguir == 3){
               JOptionPane.showMessageDialog(null,objeto.CalcularDescuento());
           }
           if(seguir == 4){
               JOptionPane.showMessageDialog(null,objeto.CalcularValorTotal());
           }
           if(seguir == 5){
               JOptionPane.showMessageDialog(null,objeto.ImprimirRecibo() );
           }
           if(seguir ==6){
               JOptionPane.showMessageDialog(null,objeto.BuscarPorCodigo() );
           }
            
        }while(seguir != 7);
        JOptionPane.showMessageDialog(null, "Adios!!");
        
        
       
    }
    
}
