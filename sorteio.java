import javax.swing.JOptionPane;
import java.util.Random;

public class sorteio {
    public static void main(String[] args){

        StringBuilder n_e = new StringBuilder();//para inserir numeros do vetor e mostrar no optionpane
        StringBuilder n_a = new StringBuilder();//para inserir nuemros aleatorios do vetor e mostrar no optionpane
        Random sorteio = new Random(); //para gerar numeros aleatorios
        int quant=6;//para mudar quantidade de numeros no sorteio caso necessario
        int[] n_escolha = new int[quant]; //vetor para armazenar numeros digitados
        int[] n_aleatorio =  new int[quant]; //vetor para armazenar numeros aleatorios
        int i,x,z=0; //variaveis de contagem

        JOptionPane.showMessageDialog(null, "Escolha "+quant+" numeros entre 1 a 60\n ");//informativo
        for(i=0;i<quant;i++){
            do{
                n_escolha[i] = Integer.parseInt(JOptionPane.showInputDialog(n_e.toString()+"\nEscolha o "+(i+1)+"° numero: "));
                z=0;//zerando variavel de contagem

                //verificando se numero esta de acordo com regra informativa
                if((n_escolha[i]<=0) || (n_escolha[i]>=61)){
                    JOptionPane.showMessageDialog(null, "Escolha numeros entre 1 a 60\n ");
                    z++;//contagem de erros
                }
                for(x=0;x<i;x++){
                    //comparando com if para detectar repetições nos numeros digitados
                    if(n_escolha[x] == n_escolha[i]){
                        JOptionPane.showMessageDialog(null, "Não escolha numeros iguais \n ");
                        z++;//contagem de erros
                    }
                }
            }while(z!=0);//repetindo caso numeros iguais
            n_e.append("  ."+n_escolha[i]);//para armazer cada um
        }
        //iniciando o processo de numeros aleatorios
        for(i=0;i<quant;i++){
            do{
                n_aleatorio[i]= sorteio.nextInt(60)+1;//selecionando os numeros de 1 ao 60
                z=0;//zerando variavel de contagem
                for(x=0;x<i;x++){
                    //comparando com if para detectar repetições no random
                    if(n_aleatorio[x] == n_aleatorio[i]){
                        z++;//contagem de erros
                    }
                }
            }while(z!=0);//repetição para que os numeros sejam diferentes
        }

        //iniciando a comparação
        for(x=0;x<quant;x++){
            //passando cada numero aleatorio
            n_a.append("  ."+n_aleatorio[x]);
            for(i=0;i<quant;i++){
                if(n_aleatorio[i] == n_escolha[x]){
                    z++;//contagem de numeros iguais
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Acertou "+z+" de "+quant+" numeros");//informativo
        JOptionPane.showMessageDialog(null, "Numeros Sorteados:\n "+n_a.toString()+"\nNumeros Escolhidos:\n"+n_e.toString());//Resultado

    }
}
