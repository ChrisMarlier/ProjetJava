public class Héxagone {
    private int i;
    private int j;

    public Héxagone(int i, int j){
        this.i=i;
        this.j=j;
    }

    public Héxagone voisinHaut(){
        Héxagone héxagone=new Héxagone(this.i,this.j);
        héxagone.i--;

        return héxagone;
    }
    public Héxagone voisinHautGauche(){
        Héxagone héxagone=new Héxagone(this.i,this.j);
        if(héxagone.j%2==1){
            héxagone.i--;
            héxagone.j--;
        }
        else {

            héxagone.j--;
        }
        return héxagone;
    }
    public Héxagone voisinHautdroit(){
                Héxagone héxagone=new Héxagone(this.i,this.j);
        if(héxagone.j%2==1){
            héxagone.i--;
            héxagone.j++;
        }
        else {
            héxagone.j++;
        }

        return héxagone;
    }
    public Héxagone voisinBah(){
        Héxagone héxagone=new Héxagone(this.i,this.j);
        héxagone.i++;

        return héxagone;
    }
    public Héxagone voisinBahGauche(){
        Héxagone héxagone=new Héxagone(this.i,this.j);
        if(héxagone.j%2==1){

            héxagone.j--;
        }
        else {
            héxagone.i++;
            héxagone.j--;
        }

        return héxagone;
    }
    public Héxagone voisinBahDroit(){
        Héxagone héxagone=new Héxagone(this.i,this.j);

        if(héxagone.j%2==1){

            héxagone.j++;
        }
        else {
            héxagone.i++;
            héxagone.j++;
        }
        return héxagone;
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
