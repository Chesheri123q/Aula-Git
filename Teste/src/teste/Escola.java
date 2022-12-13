/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;
import java.util.Scanner;
import teste.Aluno;
import teste.Professor;

/**
 *
 * @author josé Marcones 
 */



public class Escola {

    
    

    
 public static void main(String[]args){
     
     
     Scanner sc = new Scanner(System.in);
     
    Aluno aluno = new Aluno();
    
    
  Professor professor= new Professor("Ana","19/12/2004",3213213,4313312);
        
 

    
    System.out.println("Digite o nome do aluno : ");
    aluno.setNome(sc.next());
     
    System.out.println("Digite a data de nascimento do aluno : ");
    aluno.setDatadenascimento(sc.next());
    
    System.out.println("Digite o cpf do aluno : ");
    aluno.setCpf(sc.nextInt());
    
    
    System.out.println("O nome do aluno e : "+aluno.getNome());
    
    System.out.println("A data de nascimento do aluno e : "+aluno.getDatadenascimento());
    
    System.out.println("O cpf do aluno e : "+aluno.getCpf());
    
    
    
}
 
 
}
