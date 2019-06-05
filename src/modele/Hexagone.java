package modele;
public class Hexagone {
    private int i;
    private int j;

    public Hexagone(int i, int j){
        this.i=i;
        this.j=j;
    }
    //Methodes permetant de renvoyer les hexagone voisin
    public Hexagone voisinHaut(){
        Hexagone hexagone=new Hexagone(this.i,this.j);
        hexagone.j--;

        return hexagone;
    }
    public Hexagone voisinHautGauche(){
        Hexagone hexagone=new Hexagone(this.i,this.j);
        if(hexagone.i%2==1){
            hexagone.j--;
            hexagone.i--;
        }
        else {

            hexagone.i--;
        }
        return hexagone;
    }
    public Hexagone voisinHautdroit(){
                Hexagone hexagone=new Hexagone(this.i,this.j);
        if(hexagone.i%2==1){
            hexagone.j--;
            hexagone.i++;
        }
        else {
            hexagone.i++;
        }

        return hexagone;
    }
    public Hexagone voisinBah(){
        Hexagone hexagone=new Hexagone(this.i,this.j);
        hexagone.j++;

        return hexagone;
    }
    public Hexagone voisinBahGauche(){
        Hexagone hexagone=new Hexagone(this.i,this.j);
        if(hexagone.i%2==1){

            hexagone.i--;
        }
        else {
            hexagone.j++;
            hexagone.i--;
        }

        return hexagone;
    }
    public Hexagone voisinBahDroit(){
        Hexagone hexagone=new Hexagone(this.i,this.j);

        if(hexagone.i%2==1){

            hexagone.i++;
        }
        else {
            hexagone.j++;
            hexagone.i++;
        }
        return hexagone;
    }





    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}