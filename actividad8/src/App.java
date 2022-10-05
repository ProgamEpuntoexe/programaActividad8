import java.util.*;

//Aqui van las clases
class Deck{
    //Se declaran las variables de las clases
    //ArrayList con Object tambien no es valido, poner el nombre de la clase en <>
    public ArrayList<Card> cartas = new ArrayList<>();
    //Aqui se declaran los metodos, pero el principal es aquel que lo inicializa
    public Deck(){
        cartas = new ArrayList<>();
        for (int i = 0; i < 52; i++){
            cartas.add(new Card());
        }
    }
    public void shuffle(){
        System.out.println("Se mezclo el Deck");
    }
    public void head(){
        System.out.println(cartas.get(0).palo+", "+cartas.get(0).color+", "+cartas.get(0).valor);
        cartas.remove(0);
        System.out.println("Quedan "+cartas.size());
    }
    public void pick(int index){
        System.out.println(cartas.get(index).palo+", "+cartas.get(index).color+", "+cartas.get(index).valor);
        cartas.remove(index);
        System.out.println("Quedan "+cartas.size());
    }
    public void hand(){
        for (int i = 0; i < 5; i++){
            System.out.println(cartas.get(i).palo+", "+cartas.get(i).color+", "+cartas.get(i).valor);
            cartas.remove(i);
        }
        System.out.println("Quedan "+cartas.size());
    }
}
class Card{
    //Variables
    //Un consejo, si planeas que otra clase o el programa use una variable de la clase, es mejor hacerlas publicas
    public Object palo;
    public char color;
    public String valor;
    //Metodo para crear la carta y usar el randomizer
    public Card(){
        //Inicializador para randomizar
        Random numero = new Random();
        String[] palosDisponibles = {"trebol","corazon","pica","diamante"};
        char[] colores = {'R','N'};
        String[] valores = {"1","2","3","4","5","6","7","8","9","10","A","J","Q","K"};
        //Randomizar
        palo = palosDisponibles[numero.nextInt(3)];
        color = colores[numero.nextInt(2)];
        valor = valores[numero.nextInt(14)];
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Deck Mano = new Deck();
        Random numeroRandom = new Random();
        //Shuffle
        System.out.println("--- Shuffle/Mezclar");
        Mano.shuffle();
        //Escoger la primera carta
        System.out.println("--- Primera carta");
        Mano.head();
        //Escoger una carta al azar
        System.out.println("--- Escoger una carta random");
        Mano.pick(numeroRandom.nextInt(Mano.cartas.size()));
        //Para ver las 5 cartas en la mano
        System.out.println("--- Mostrar 5 cartas");
        Mano.hand();
    }
}
