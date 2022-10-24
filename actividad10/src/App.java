import java.util.*;
import java.io.*;

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
        int cartasRestantes = 5;
        Card cartaRemovida = new Card();
        if (cartas.size() < 5){
            cartasRestantes = cartas.size();
        }
        for (int i = 0; i < cartasRestantes; i++){
            cartaRemovida = cartas.remove(0);
            System.out.println(cartaRemovida.palo+", "+cartaRemovida.color+", "+cartaRemovida.valor);
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
        System.out.println("Programa de barajas");
        showMenu();
    }
    //Mostrar el menu
    public static void showMenu() throws Exception{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String opcion = "hola";
        Deck Mano = new Deck();
        Random numeroRandom = new Random();
        //Menu de opciones, hay un bucle para que regrese cuando sea
        do{
            //Si ya no quedan cartas, entonces romper este bucle
            if (Mano.cartas.isEmpty()){
                System.out.print("Ya no hay mas cartas, pulse ENTER para continuar");
                entrada.readLine();
                break;
            }
            System.out.println("Menu de opciones");
            System.out.println("1) Mezclar el deck");
            System.out.println("2) Sacar una carta");
            System.out.println("3) Sacar una carta al azar");
            System.out.println("4) Generar una mano de 5 cartas");
            System.out.println("0) Salir");
            //Introducir una opcion
            System.out.print("Introdusca un comando: ");
            opcion = entrada.readLine();
            //En caso de vacio
            if (opcion.isEmpty()){
                System.out.println("Introdusca un comando");
                opcion = "NO";
                //En caso de cualquier otro comando
            }else{
                switch(opcion.charAt(0)){
                    //Mezclar el deck
                    case '1':{
                        Mano.shuffle();
                        System.out.print("Presione Enter para continuar");
                        entrada.readLine();
                        break;
                    }
                    //Sacar una carta
                    case '2':{
                        Mano.head();
                        System.out.print("Presione Enter para continuar");
                        entrada.readLine();
                        break;
                    }
                    //Sacar una carta al azar
                    case '3':{
                        Mano.pick(numeroRandom.nextInt(Mano.cartas.size()));
                        System.out.print("Presione Enter para continuar");
                        entrada.readLine();
                        break;
                    }
                    //Generar una mano de 5 cartas
                    case '4':{
                        Mano.hand();
                        System.out.print("Presione Enter para continuar");
                        entrada.readLine();
                        break;
                    }
                    //Salir
                    case '0':{
                        System.out.println("Gracias por usar el programa");
                        break;
                    }
                    //Comando invalido
                    default:{
                        System.out.println("Opcion no valida, presione ENTER para introducir otro comando");
                        entrada.readLine();
                    }
                }
            }
        }while(opcion.charAt(0) != '0');
        System.out.print("Gracias por usar el programa, presione ENTER para terminar");
        entrada.readLine();
    }
}
