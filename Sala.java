public class Sala {
    public Cliente cadeiras[] = new Cliente[0];
    int indice = 0;
    
    public void show(){
        String saida = "";
        for (Cliente c : cadeiras) {
            if (c != null) {
                saida += " "+c.id+":"+c.fone+" ";
            } else {
                saida += " - ";
            }
        }
        System.out.println("[" + saida + "]");
    }
    
    public Cliente[] init(int tam){
        this.cadeiras = new Cliente[tam];
    return cadeiras;
    }
    
    public boolean reservar(String id, String fone, int indice){
        boolean r;
        if (this.cadeiras.length<=indice || indice<0){
            r = false;
            System.out.println("ERROR: cadeira inexistente");
        } else if (estaNoCinema(this.cadeiras,id)){
            System.out.println("failure: cliente já está no cinema");
            r = false;
        } else if (this.cadeiras[indice] == null){
            Cliente pessoa = new Cliente(id, fone);
            this.cadeiras[indice] = pessoa;
            r = true;
        } else {
            r = false;
            System.out.println("failure: a cadeira já está ocupada");
        }
        this.indice = indice;
        return r;
    }
    
    public boolean cancelar(String id){
        boolean r;
        if (this.cadeiras.length<=this.indice || this.indice<0){
            r = false;
            System.out.println("ERROR: cadeira inexistente");
        } else if (!estaNoCinema(this.cadeiras,id)){
            System.out.println("failure: cliente não está no cinema");
            r = false;
        } else {
            for (int c = 0; c<this.cadeiras.length; c++) {
                if (cadeiras[c] == null) {
                    continue;
                } else if (cadeiras[c].id.equals(id)) {
                    cadeiras[c] = null;
                } else {
                    continue;
                }
                break;
            }
            r = true;
        }
    return r;
    }
    
    public boolean estaNoCinema(Cliente cadeiras[], String id){
        boolean r = false;
        for (Cliente cadeira : cadeiras) {
            if (cadeira == null){
                continue;
            } else if (cadeira.id.equals(id)){
                r = true;
            }
        }
    return r;
    }
}
