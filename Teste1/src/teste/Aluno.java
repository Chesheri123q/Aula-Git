/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;
import java.util.Scanner;
/**
 *
 * @author Alexsandra
 */
public class Aluno {
    
    
    //Variaveis
    private String nome;
    private String datadenascimento;
    private int cpf;
   //Variaveis
    
    
    //Construtor
    public Aluno(String nome, String datadenascimento, int cpf) {
        this.nome = nome;
        this.datadenascimento = datadenascimento;
        this.cpf = cpf;
    }

    
     public Aluno() {
        
    }
     //Construtor
    
    
     
     
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the datadenascimento
     */
    public String getDatadenascimento() {
        return datadenascimento;
    }

    /**
     * @param datadenascimento the datadenascimento to set
     */
    public void setDatadenascimento(String datadenascimento) {
        this.datadenascimento = datadenascimento;
    }

    /**
     * @return the cpf
     */
    public int getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
   
    
    
}
