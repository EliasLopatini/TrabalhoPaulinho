package br.unipar.trabalhopaulinho;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuário
 */
public class trabalhopaulinho {
    public static void main(String[] args) {
        
        
       System.out.println("---------------------------Vetor___Desorganizado-----------------------------");
       
       
       //Aqui utilizamos um metodo de repetição para disponibilizar ao usiário que informe o tamanho desejado do Vetor;
        String input = JOptionPane.showInputDialog("Informe o Tamanho do vetor");
    
        int[] vetor = new int[Integer.parseInt(input)];
        
        
        //Laço utilizado para solicitar e salvar os números informados pelo usuário;
        for (int i = 0; i < vetor.length ; i++) {
          String input1 = JOptionPane.showInputDialog("Informe o valor para a "+(i+1)+"° Posição: ");
          vetor[i] = Integer.parseInt(input1);
          System.out.println("Veetor["+(i+1)+"] = "+vetor[i]);
          
        }
        System.out.println("---------------------------Vetor___Organizado-------------------------------");
        
        String metodo;
        
        
        //Aqui mostrados ao usuário quais os metodos de organização disponiveis no sistema;
        metodo = JOptionPane.showInputDialog("Qual o metodo que deseja usar: "
                                                 + "\n Inserçao(I);"
                                                    + "\n Seleção (S);"
                                                        + "\n Bolha (B).");

        
        
        //Metodo de seleção para a organização/ordenação, utilizando toUpperCase considerar o caracter sempre como maiusculo;
        if(metodo.toUpperCase().equals("I")){
            
//            long inicio = System.nanoTime();

            //Primeiro vetor de organização pelo metodo de Inserção;
            int chave , j;
            for (int i = 1; i < vetor.length; i++) {
            chave = vetor[i];
            for (j = i - 1;(j >= 0 && vetor[j] > chave);j--) {
                vetor[j + 1] = vetor[j];
            }
            vetor[j + 1] = chave;
        }
        
       
           
//        long fim = System.nanoTime();
//        long tempoExecucaoInser = fim -  inicio;
       

        //Mensagem Utilizada para imprimir o vetor na tela;
       for (int i = 0; i < vetor.length; i++){
            System.out.println("Veetor["+(i+1)+"] = "+vetor[i]);
        } 

        
        
        
        
        
        //Segundo metodo de seleção utilizado, assim como o primeiro utilizando o toUpperCase;
        }else if(metodo.toUpperCase().equals("S")){
//            long inicio = System.nanoTime();
            

            //Metodo de organização por Seleção;
            for(int i = 0; i < vetor.length - 1; i++){
            int posMenor = i;
            
            for(int j = i+1; j < vetor.length; j++){
                if(vetor[j] < vetor[posMenor]){
                    posMenor = j;
                }
            }
            
            if(posMenor != i){
                int aux = vetor[i];
                vetor[i] = vetor[posMenor];
                vetor[posMenor] = aux;
            }
        }
//            long fim = System.nanoTime();
//        long tempoExecucaoSelec = fim -  inicio;
        


    
        //Parte utilizada para imprimir o vetor na tela;
        for (int i = 0; i < vetor.length; i++){
            System.out.println("Veetor["+(i+1)+"] = "+vetor[i]);
        
        }

        
        //Terceiro e ultimo metodo utilizado para selecionar o tipo de organização;
        }else if(metodo.toUpperCase().equals("B")){
            boolean troca = true;
        
        while(troca){
            troca = false;
            for(int i = 0; i<vetor.length -1; i++){
                if(vetor[i] > vetor[i+1]){
                    int aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                    troca = true;
                }
            }
        }
        
        for (int i = 0; i < vetor.length; i++){
            System.out.println("Veetor["+(i+1)+"] = "+vetor[i]);
        
        }
    }
        
        
        //Parte utilizada para mostrar o tempo decorrido no vetor para o usuário
        tempo(vetor);
}
    
    //Segunda parte do código, onde utilizamos os metodos Long para trazer o tempo utilizado por cada organização;
    public static void tempo(int[] array){
        
        
        //Laço utilizado para o tempo da 1 organização, a de Inserção;
                long inicio = System.nanoTime();
                int n = array.length;
                
                
                for (int i = 0; i < n - 1; i++) {
                    
                    for (int j = 0; j < n - i - 1; j++){
                        
                        if (array[j] > array[j + 1]){
                            
                            int temp = array[j];
                            
                            array[j] = array[j + 1];
                            array[j + 1] = temp;
                        }
                    }
                }
                
                //Imprime o tempo levado;
                long fim = System.nanoTime();
                
                long tempoExecucaoInser = fim - inicio;
                
                System.out.println("-------------Tempo__em__Inserção-----------------");
                System.out.print("Tempo utilizado: " + tempoExecucaoInser+ " milésimos\n\n");

                
                
                
                //Inicio do cronometro para a 2 oraganização, a de Seleção;
                inicio = System.nanoTime();
                n = array.length;
                for (int i = 0; i < array.length - 1; i++) {
                    int posMenor = i;
                    for(int j = i+1; j < array.length; j++){
                        if(array[j] < array[posMenor]){
                            posMenor = j;
                        }
                    }
                    if(posMenor != i){
                        int aux = array[i];
                        array[i] = array[posMenor];
                        array[posMenor] = aux;
                    }
                }
                fim = System.nanoTime();
                
                //Mensagem utilizada para exibir o tempo;
                long tempoExecucaoSelec = fim - inicio;
                System.out.println("-------------Tempo__em__Seleção-----------------");
                System.out.print("Tempo utilizado: " + tempoExecucaoSelec + " milésimos\n\n");

                int chave, j;
                inicio = System.nanoTime();
                
                
                //Inicio do cronometro para o 3 meotdo, o de bubble(bolha);
                for(int i = 1; i < array.length; i++){
                    chave = array[i];
                    for(j = i - 1;  j >= 0 && array[j] > chave ; j-- ){
                        array[j+1] = array[j];
                    }
                    array[j+1] = chave;
                }
                fim = System.nanoTime();
                
                //Mensagem utilizada para imprimir o mesmo na tela;
                long tempoExecucaoBub = fim - inicio;
                System.out.println("-------------Tempo__em__Bubble-----------------");
                System.out.print("Tempo utilizado: " + tempoExecucaoBub + " milésimos\n\n");
    }
}


