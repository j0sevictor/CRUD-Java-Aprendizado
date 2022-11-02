
package ProjetosIniciaisJava;

import javax.swing.JOptionPane;


public class SistemaVT {
    static String[] nomes = new String[10];
    static String senha[] = new String[10];
    static int idade[] = new int[10];
    static int i;
    static boolean d;
    
    public static void main(String[] args){
        String op1;
        JOptionPane.showMessageDialog(null,"____________________________\n"
                                          +"|                                                               |\n"
                                         + "|  Bem Vindo ao Sistema Da EEEP  |\n"
                                          +"|                                                                |\n"
                                          +"|___________________________|\n"+
                                           "Criadores: Victor e Talles.");
        
        do{
            op1 = JOptionPane.showInputDialog("Digite:\n |1|-Cadastrar-se\n |2|-Login\n |0|-Sair do Sistema");
            switch(op1){
                case "1": cadastro(); break;
                case "2": login(); break;
                case "0": JOptionPane.showMessageDialog(null,"Volte Sempre!!");
            }
        }while(!"0".equals(op1));
    }
    
    public static void cadastro(){
        int b = nomes.length;
        boolean x;

        for(int po = nomes.length - 1; po >= 0; po--){
            if(nomes[po] == null){
                b = po;
            }
        }

        if(b < nomes.length){    
            do{
                String nome = JOptionPane.showInputDialog("Digite seu nome para Cadastro:");
                x = false;
                for(int i=0;i<=9;i++){
                    if(nome.equals(nomes[i])){
                        x = true;
                    }   
                }
                if (x==false){
                    nomes[b] = nome;
                }else{
                    JOptionPane.showMessageDialog(null,"Desculpe "+nome+", Mas já existe um Usuário com esse Nome\nRefaça seu Cadastro");                 }
            }while(x!=false);
                
            do{
                senha[b] = JOptionPane.showInputDialog("Agora digite uma senha para sua Conta:");
                String senha2 = JOptionPane.showInputDialog("Confirme sua senha Digitando-a Novamente");    
                if(senha[b].equals(senha2)){
                    x = false;
                }else{
                    x = true;
                    JOptionPane.showMessageDialog(null,"Deve ter ocorrido um erro em algum momento da\nDigitação da senha Tente Novamente");
                }
            }while(x!=false);
                
            do{
                idade[b]= Integer.parseInt(JOptionPane.showInputDialog("Digite sua Idade:"));
                if(idade[b]>125){
                    JOptionPane.showMessageDialog(null,"No mundo não existe nenhum humano vivo a tanto Tempo\nRepita o Procedimento.");
                }else if(idade[b]<=0){
                    JOptionPane.showMessageDialog(null,"Se você tivesse essa idade não estaria aqui.");
                }
            }while(idade[b]<=0 || idade[b] > 125);
            
            JOptionPane.showMessageDialog(null,"PARABÉNS, se chegou até aqui significa que\nseu Cadastro foi Realizado com sucesso!!!");
        }else{
            JOptionPane.showMessageDialog(null,"O banco de dados está cheio");
        }
       
    }
    
    public static void login(){
        
        int res = JOptionPane.showConfirmDialog(null,"Já é Cadastrado?");
        switch (res) {
            case 1:
                JOptionPane.showMessageDialog(null,"Então Cadastre-se para acessar essa área");
                break;
            case 0:
                boolean o = false;
                int resp = 3;
                String op2;
                String usuario = JOptionPane.showInputDialog("Então digite o seu nome de usuário:");
                String senhau = JOptionPane.showInputDialog("Agora digite sua senha:");
                for(i=0;i<nomes.length;i++){
                    if(usuario.equals(nomes[i]) && senhau.equals(senha[i])){
                        o = true;
                        JOptionPane.showMessageDialog(null,"Você foi Logado com Sucesso\nAproveite o sistema");
                        do{
                            op2 = JOptionPane.showInputDialog("Digite:\n |1|-Pesquisar por alguem\n |2|-Atualizar\n |3|-Deletar minha conta\n |4|-Conferior todos os Cadastrados\n |5|-Ver dados pessoais\n |0|-Home");
                            switch(op2){
                                case "1": pesq(); break;
                                case "2": atualizar();break;
                                case "3": deletar();break;
                                case "4": mostrar();break;
                                case "5": conferir();
                            }
                        }while(d != true && !op2.equals("0"));
                    }
                }
                if(o == false){
                    JOptionPane.showMessageDialog(null,"As informações digitadas não são coerentes\ncom nenhum usuário cadastrado");
                }   
            break;
            default:;
                
        }
    }
    
    public static void mostrar(){
        System.out.println("Os cadastrados são:");
        for(int y=0;y<nomes.length;y++){
            if(y == i){
                System.out.println("-Você Na posição ["+i+"]");
            }else if(nomes[y]!= null){
                System.out.println("-"+nomes[y]+"  Na posição ["+y+"]");
            }else{
                System.out.println("-");
            }
        }
        System.out.println("");
        JOptionPane.showMessageDialog(null,"Olhe Para Baixo");
    }
    
    public static void pesq(){
        boolean x=false;
        
        String nome = JOptionPane.showInputDialog("Digite o nome a ser pesquisado:");
        for(int h=0;h<nomes.length;h++){
            if(nome.equals(nomes[h])){
                if(nome.equals(nomes[i])){
                    JOptionPane.showMessageDialog(null,nome + "  é Você.");
                    x = true;
                }else{
                    x = true;
                    JOptionPane.showMessageDialog(null,nome+" Já está Cadastrado");
                }
                
            }   
        }
        if (x==false){
            JOptionPane.showMessageDialog(null,nome+" Ainda não está Cadastrado");  
        }
    }
    
    public static void conferir(){
        JOptionPane.showMessageDialog(null,"Nome:  "+nomes[i]+"\nIdade:  "+idade[i]+"\nSenha:  "+senha[i]+"\nPosição:  "+i);
    }

    public static void atualizar(){
        String op;
        boolean x = false;
        do{
            op = JOptionPane.showInputDialog("Escolha qual Informação Deseja Alterar:\n |1|-Nome\n |2|-Senha\n |3|-Idade\n |4|-Posição\n |0|-Voltar");
            switch(op){
                case "1": 

                    do{

                        String natu = JOptionPane.showInputDialog("Digite seu Novo Nome:");
                        for(int i = 0;i<nomes.length;i++){
                            if(natu.equals(nomes[i])){
                                x = true;
                            }
                        }
                        if(x == true){
                            JOptionPane.showMessageDialog(null,"Já existe um usuário com esse nome\nTente Novamente");
                        }else{
                            nomes[i] = natu;
                            JOptionPane.showMessageDialog(null,"Seu nome de Usuário foi alterado com Sucesso");
                        }
                    }while(x == true);

                break;
                
                case "2": 
                    do{
                        String seguranca = JOptionPane.showInputDialog("Por segurança digite sua senha antiga:");
                        if(seguranca.equals(senha[i])){
                            x = true;
                        }      
                        if(x==true){
                            boolean y;
                            do{
                                y = true;
                                String teste = JOptionPane.showInputDialog("Agora digite sua Nova Senha:");
                                senha[i] = JOptionPane.showInputDialog("Comfirme sua senha redigitando-a");
                                if(teste.equals(senha[i])){
                                    y = false;
                                    JOptionPane.showMessageDialog(null,"Sua senha foi alterada com sucesso");
                                }else{
                                    JOptionPane.showMessageDialog(null,"Deve ter ocorrido um erro de digitação\n Repita o processo");
                                }
                            }while(y);
                        }else{
                            JOptionPane.showMessageDialog(null,"Deve ter ocorrido algum erro de digitação Para a senha antiga\nTente novamente");
                        }
                    }while(x==false);
                break;
                
                case "3":
                    do{
                        int nidade =  Integer.parseInt(JOptionPane.showInputDialog("Digite sua nova idade:"));
                        if(nidade == idade[i]){
                            JOptionPane.showMessageDialog(null,"Essa já é sua idade, mas OK");
                            x = true;
                        }else if(nidade <= 125 && nidade > 0){
                            x = true;
                            JOptionPane.showMessageDialog(null,"Sua idade foi alterada com sucesso");
                            idade[i] = nidade;
                        }else if(nidade > 125){
                            JOptionPane.showMessageDialog(null,"Nenhum ser humano vive ou já vivel tanto tempo.");
                        }else if(nidade <= 0){
                            JOptionPane.showMessageDialog(null,"Com essa idade não estaria aqui");
                        }
                        
                    }while(x == false);
                ;break;
                
                case "4":
                    int pov[]=new int[10];
                    int posi;
                    System.out.println("As posições livres são:");
                    for(int y=0;y<nomes.length;y++){
                        if(y == i
                                ){
                            System.out.println("Você ocupa a posição |"+y+"|");
                        }else if(nomes[y] == null){
                            System.out.println("A Posição |"+y+"| Esta LIVRE");
                            pov[y] = 1;
                        }else{
                            System.out.println(nomes[y]+" Já ocupa a Posição |"+y+"|");
                            pov[y] = 0;
                        }
                    }
                    System.out.println("");
                    
                    JOptionPane.showMessageDialog(null,"Olhe Para Baixo");
                    do{
                        do{
                            posi = Integer.parseInt(JOptionPane.showInputDialog("Qual posição você deseja assumir?\n(Apenas de 0 á 9)"));
                            if(posi < 0 | posi >9){
                                JOptionPane.showMessageDialog(null,"Essa posição é inválida");
                            }
                        }while(posi < 0 | posi > 9);
                        if(pov[posi] == 1){
                            nomes[posi] = nomes[i];
                            nomes[i] = null;
                            senha[posi] = senha[i];
                            senha[i] = null;
                            idade[posi] = idade[i];
                            i = posi;
                            JOptionPane.showMessageDialog(null,"Sua posição foi alterada com sucesso");
                            x = true;
                        }else{
                            if(posi == i){
                                JOptionPane.showMessageDialog(null,"Você já é o ocupante desta posição, mas OK");
                                x = true;
                            }else{
                                JOptionPane.showMessageDialog(null,"Deve ter ocorridodo um erro\nEssa posição já está ocupada");
                            }
                        }
                    }while(x == false); 
                   
                ;break;
                
                case "0":;
            
            }
        }while(!op.equals("0"));
    }
 
    public static int deletar(){
        d = false;
        int a = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja Deletar sua conta?");
        if(a == 0){
            nomes[i] = null;
            senha[i] = null;
            d = true;
            JOptionPane.showMessageDialog(null, "Você foi Descadastrado com sucesso");
        }else{
            
        }
        return a;
        
    } 
}
