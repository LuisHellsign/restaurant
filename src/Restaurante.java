/*
 * Clase que representa el restaurante de la universidad del valle
 */
import java.util.Objects;
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
        int position = BuscarPorCodigo();
        int porcentaje=0;
        
        if(position != -1){
            String primLetra = listaEstudiantes[position].sacarPrimeraLetradeNombre();
            String ultimoD = listaEstudiantes[position].sacarUltimodigitoCodigo();
            int cant1 = listaEstudiantes[position].contarNoUno();
            int cant5 = listaEstudiantes[position].contarNoCinco();
            String dia = listaEstudiantes[position].enviarDia();
            String plan = listaEstudiantes[position].enviarPlan();
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
        } else {
            return porcentaje;
        }
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
    
    // devuelve la posición del estudiante dentro del arreglo de estudiantes
    public int BuscarPorCodigo()      
    {
        String code = JOptionPane.showInputDialog("Ingrese el Codigo a buscar");
        int position = 0;
        
        for(int i=0; i<=listaEstudiantes.length; i++){
            String id = listaEstudiantes[i].enviarCodigo();
            if(Objects.equals(id, code) == true)
            {
                position = i;
                return position;
            } else {
                position = -1;
            }
        }
        
         return position;
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
