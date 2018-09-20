import java.util.Scanner;

public class Principal {
    
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Sala cine = new Sala();
        System.out.println("==============================CINEMA==============================");
	String comando, help, c[];
	help = "========================================COMANDOS========================================\n" + 
	       "show: Mostra a sala de cinema existente\n" + 
	       "init: Inicia uma sala de cinema (Informe quantos acentos a sala terá\n" +
	       "reservar: Reserva acento para um cliente (Informe nome, telefone e número do acento)\n" + 
	       "cancelar: Cancela reserva (Informe nome do cliente)\n" + 
	       "end: Fecha o cinema\n";
        System.out.println("Digite um comando (-help- para ver os comandos.)");
        
        while (true) {
            comando = input.nextLine();
            
            if (comando.equals("end")) {
                System.out.println("Fechando cinema...");
                break;
            } else if (comando.equals("help")){
                System.out.println(help);
            } else {
                c = comando.split(" ");
                switch(c[0]){
                    case "show":
                        if (c.length!=1){
                            System.out.println("Comando inválido, tente novamente!");
                        } else {
                            cine.show();
                        }
                        break;
                    case "init":
                        if (c.length!=2){
                            System.out.println("Comando inválido, tente novamente!");
                        } else {
                            cine.init(Integer.parseInt(c[1]));
                            System.out.println("success");
                        }
                        break;
                    case "reservar":
                        if (c.length!=4) {
                            System.out.println("Comando inválido, tente novamente!");
                        } else if (cine.reservar(c[1], c[2], Integer.parseInt(c[3]))){
                            System.out.println("success");
                        }
                        break;
                    case "cancelar":
                        if (c.length!=2) {
                            System.out.println("Comando inválido, tente novamente!");
                        } else if (cine.cancelar(c[1])) {
                            System.out.println("success");
                        }
                        break;
                    default:
                        System.out.println("Comando inválido, tente novamente!");
                }
            }
        }
    }
}
