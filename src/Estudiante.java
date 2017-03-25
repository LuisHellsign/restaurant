/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Estudiante {
    
    private String nombre, codigo, plan, dia;
    
    //constructor que permite crear objetos de tipo Estudiante
    public Estudiante(String nomb, String codi, String pla, String di)
    {
        nombre = nomb;
        codigo = codi;
        plan = pla;
        dia = di;
        
    }
    
    public String enviarNombre()
    {
        return nombre;
    }
    
     public String enviarCodigo()
    {
        return codigo;
    }
      public String enviarPlan()
    {
        return plan;
    }
       public String enviarDia()
    {
        return dia;
    }
       
    public String sacarPrimeraLetradeNombre()
    {
        String primera;
        
        primera = nombre.substring(0, 1);
        return primera;        
    }
    
    public String sacarUltimodigitoCodigo()
    {
        String ultimo;
        int longitud =codigo.length();
        ultimo = codigo.substring((longitud-1),longitud);
        return ultimo;
    }
    
    public int contarNoUno()
    {
        int contUnos=0;
        
        for(int i=0; i<codigo.length();i++)
        {
            if(codigo.substring(i, i+1).equals("1"))
            {
                contUnos = contUnos+1;
            }
        }
        return contUnos;
    }
    
    public int contarNoCinco()
    {
        int contCincos=0;
        
        for(int i=0; i<codigo.length();i++)
        {
            if(codigo.substring(i, i+1).equals("5"))
            {
                contCincos = contCincos+1;
            }
        }
        return contCincos;
    }
    
    
}
