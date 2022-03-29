import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

/**
* Autor: Nicolle Escobar (20647) y Sofía Escobar (20489) 
* Descripcion: Main del programa encargado de correrlo y concatenar todas las clases
*/

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        //Arrays
        ArrayList<HashMap> espanol=new ArrayList<>();
        ArrayList<HashMap> ingles=new ArrayList<>();
        ArrayList<HashMap> frances=new ArrayList<>();
        ArrayList<ArrayList<HashMap>> fin1=new ArrayList<>();
        ArrayList<ArrayList<HashMap>> fin2=new ArrayList<>();
        ArrayList<ArrayList<HashMap>> fin3=new ArrayList<>();
        ArrayList<String> p1=new ArrayList<>();
        ArrayList<String> p2=new ArrayList<>();
        ArrayList<String> p3=new ArrayList<>();
        ArrayList<String> first=new ArrayList<String>();
        ArrayList<String[]> secd=new ArrayList<>();
        ArrayList<ArrayList> lp=new ArrayList<>();
        ArrayList<Association> set=new ArrayList<>();
        ArrayList<Association> finEsp=new ArrayList<>();
        ArrayList<Association> finFra=new ArrayList<>();
        ArrayList<Association> EI=new ArrayList<>();
        ArrayList<Association> EF=new ArrayList<>();
        ArrayList<Association> IE=new ArrayList<>();
        ArrayList<Association> IF=new ArrayList<>();
        ArrayList<Association> FE=new ArrayList<>();
        ArrayList<Association> FI=new ArrayList<>();
        //Leer los archivos de texto
        File file=new File("dict.txt");
        File file2=new File("texto.txt");
        //Scanners
        Scanner scan=new Scanner(file);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3=new Scanner(file2);
        String filecontent="";

        while(scan.hasNext()){
            filecontent=filecontent.concat(scan.nextLine()+"\n");
        }
        //Dividir en una lista cada linea
        String[] arr=filecontent.split("\n");
        for(int i=0;i<arr.length;i++){
            String a=arr[i];
            first.add(a);
        }
        //Dividir las palabaras
        for(int c=0;c<first.size();c++){
            String a=first.get(c);
            String[] arr2=a.split(",");
            secd.add(arr2);
        }
        //Crear una sublista
        for(int i=0;i<secd.size();i++){
            String sublista[]=secd.get(i);
            String uno=sublista[0];
            String dos=sublista[1];
            String tres=sublista[2];
            p1.add(uno);
            p2.add(dos);
            p3.add(tres);
            
            //Crear las difrentes combinaciones de palabras que pueden existir
            HashMap<String,String> mapa1=new HashMap<>();
            HashMap<String,String> mapa12=new HashMap<>();

            Association b=new Association(uno,dos);
            Association bc=new Association(uno,tres);
            Association espanoli=new Association(dos,uno);
            Association espanolf=new Association(dos,tres);
            Association franceespanol=new Association(tres,uno);
            Association franceesingles=new Association(tres,dos);


            mapa1.put(uno,dos);
            mapa12.put(uno,tres);
            ingles.add(mapa1);
            ingles.add(mapa12);
            HashMap<String,String> mapa2=new HashMap<>();
            HashMap<String,String> mapa22=new HashMap<>();
            mapa2.put(dos,uno);
            mapa22.put(dos,tres);
            espanol.add(mapa2);
            espanol.add(mapa22);
            HashMap<String,String> mapa3=new HashMap<>();
            HashMap<String,String> mapa32=new HashMap<>();
            mapa3.put(tres,uno);
            mapa32.put(tres,uno);
            frances.add(mapa3);
            frances.add(mapa32);
            IE.add(b);
            IF.add(bc);
            EI.add(espanoli);
            EF.add(espanolf);
            FE.add(franceespanol);
            FI.add(franceesingles);

        }for(int i=0;i<ingles.size();i=i+2){
           HashMap c =ingles.get(i);
           HashMap d=ingles.get(i+1);
           ArrayList<HashMap> listainterna=new ArrayList<>();
           listainterna.add(c);
           listainterna.add(d);
           fin1.add(listainterna);

        }for(int i=0;i<espanol.size();i=i+2){
            HashMap c =espanol.get(i);
            HashMap d=espanol.get(i+1);
            ArrayList<HashMap> listainterna=new ArrayList<>();
            listainterna.add(c);
            listainterna.add(d);
            fin2.add(listainterna);

        }for(int i=0;i<frances.size();i=i+2){
            HashMap c =frances.get(i);
            HashMap d=frances.get(i+1);
            ArrayList<HashMap> listainterna=new ArrayList<>();
            listainterna.add(c);
            listainterna.add(d);
            fin3.add(listainterna);
        }for(int i=0;i<p1.size();i++){
            String a=p1.get(i);
            ArrayList<HashMap> maj=fin1.get(i);
            Association b=new Association(a,maj);
            set.add(b);
        }for(int i=0;i<p2.size();i++){
            String a=p2.get(i);
            ArrayList<HashMap> maj=fin2.get(i);
            Association b=new Association(a,maj);
            finEsp.add(b);
        } for(int i=0;i<p3.size();i++){
            String a=p3.get(i);
            ArrayList<HashMap> maj=fin3.get(i);
            Association b=new Association(a,maj);
            finFra.add(b);
        }
        
        //Creae los arboles binarios para su uso
        BinaryTree<Association> arbolIngles=new BinaryTree<Association>(set.get(0));
        BinaryTree<Association> arbolespanol=new BinaryTree<Association>(finEsp.get(0));
        BinaryTree<Association> arbolfrances=new BinaryTree<Association>(finFra.get(0));
        //Agregar las difrentes palabras a los arboles binarios
        for (int n = 0; n < set.size(); n++) {
            if ((n+1) < set.size()) {
                BinaryTree<Association> btSiguiente = new BinaryTree<>(set.get(n+1));
                BinaryTree.add(arbolIngles, btSiguiente);
            }
        }
        System.out.print("\n Este es el arbol binario: "+arbolIngles.inOrder(arbolIngles));
        String contenido="";
        while(scan3.hasNext()){
            contenido=contenido.concat(scan3.nextLine()+"\n");
        }
        System.out.print(contenido);
        ArrayList<String> subdivision=new ArrayList<>();
        String[] arr2=contenido.split(" ");//Dividir el archivo 2 por cada espacio que exista
        for(int i=0;i<arr2.length;i++){
            String a=arr2[i];
            String b=a.toLowerCase();
            subdivision.add(b);
        }
        boolean rungeneral=true;

        while(rungeneral){//While para la traduccion
            //Menu de ingreso al programa
            System.out.print("\nEn que idioma esta la frase o archivo que quiere traducir");
            System.out.print("\n1.Espanol");
            System.out.print("\n2.Ingles");
            System.out.print("\n3.Frances");
            System.out.print("\n4.Terminar el programa");
            System.out.print("\nSeleccione su opcion: ");
            int a=scan2.nextInt();
            if(a==1){//OPCION 1
                boolean subrun=true;
                while(subrun){
                    //Si elige español
                    System.out.print("\n¿A que idioma quiere traducir su archivo");
                    System.out.print("\n1. Ingles");
                    System.out.print("\n2. Frances");
                    System.out.print("\nIngrese su opcion: ");
                    int h=scan2.nextInt();
                    if(h==1){
                        //Se crea el arbol binario y luego se busca las palabras individualmente para luego producir oracion traducida
                        BinaryTree<Association> Arbol1=new BinaryTree<Association>(EI.get(0));
                        for (int n = 0; n < EI.size(); n++) {
                            if ((n+1) < EI.size()) {
                                BinaryTree<Association> Ne = new BinaryTree<>(EI.get(n+1));
                                BinaryTree.add(Arbol1,Ne);
                            }
                        }
                        String unn="";
                        for( int i=0;i<subdivision.size();i++){
                            String b=subdivision.get(i);
                            String Wr=Arbol1.buscar(b);
                            if(Wr==null){
                                unn=unn+"* "+b+" *";
                            }else{
                                unn=unn+" * "+Wr+" * ";
                            }
                        }
                        System.out.print("\nLa oracion traducida es: "+unn);
                        subrun=false;
                    }if(h==2){
                        //Se crea el arbol binario y luego se busca las palabras individualmente para luego producir oracion traducida
                        BinaryTree<Association> Arbol1=new BinaryTree<Association>(EF.get(0));
                        for (int n = 0; n < EF.size(); n++) {
                            if ((n+1) < EF.size()) {
                                BinaryTree<Association> Ne = new BinaryTree<>(EF.get(n+1));
                                BinaryTree.add(Arbol1,Ne);
                            }
                        }
                        String unn="";
                        for( int i=0;i<subdivision.size();i++){
                            String b=subdivision.get(i);
                            String Wr=Arbol1.buscar(b);
                            if(Wr==null){
                                unn=unn+"* "+b+" *";
                            }else{
                                unn=unn+" * "+Wr+" * ";
                            }
                        }
                        System.out.print("\nLa oracion traducida es: "+unn);
                        subrun=false;
                    }else{
                    }
                }

            }
            if(a==2){
                boolean subrun=true;
                while(subrun){
                    //Si elige ingles
                    System.out.print("\nA que idioma quiere traducir su archivo");
                    System.out.print("\n1. Espanol");
                    System.out.print("\n2. Frances");
                    System.out.print("\nIngrese su opcion: ");
                    int h=scan2.nextInt();
                    if(h==1){
                        //Se crea el arbol binario y luego se busca las palabras individualmente para luego producir oracion traducida
                        BinaryTree<Association> Arbol1=new BinaryTree<Association>(IE.get(0));
                        for (int n = 0; n < IE.size(); n++) {
                            if ((n+1) < IE.size()) {
                                BinaryTree<Association> Ne = new BinaryTree<>(IE.get(n+1));
                                BinaryTree.add(Arbol1,Ne);
                            }
                        }
                        String unn="";
                        for( int i=0;i<subdivision.size();i++){
                            String b=subdivision.get(i);
                            String Wr=Arbol1.buscar(b);
                            if(Wr==null){
                                unn=unn+"* "+b+" *";
                            }
                            else{
                                unn=unn+" * "+Wr+" * ";
                            }
                        }
                        System.out.print("\nLa oracion traducida es: "+unn);
                        subrun=false;
                    }if(h==2){
                        //Se crea el arbol binario y luego se busca las palabras individualmente para luego producir oracion traducida
                        BinaryTree<Association> Arbol1=new BinaryTree<Association>(IF.get(0));
                        for (int n = 0; n < IF.size(); n++) {
                            if ((n+1) < IF.size()) {
                                BinaryTree<Association> Ne = new BinaryTree<>(IF.get(n+1));
                                BinaryTree.add(Arbol1,Ne);
                            }
                        }
                        String unn="";
                        for( int i=0;i<subdivision.size();i++){
                            String b=subdivision.get(i);
                            String Wr=Arbol1.buscar(b);
                            if(Wr==null){
                                unn=unn+"* "+b+" *";
                            }
                            else{
                                unn=unn+" * "+Wr+" * ";
                            }
                        }
                        System.out.print("\nLa oracion traducida es: "+unn);
                        subrun=false;
                    }else{
                    }
                }

            }if(a==3){
                boolean subrun=true;
                while(subrun){
                    //Si elige frances.
                    System.out.print("\nA que idioma quiere traducir su archivo");
                    System.out.print("\n1. Espanol");
                    System.out.print("\n2. Ingles");
                    System.out.print("\nIngrese su opcion: ");
                    int h=scan2.nextInt();
                    if(h==1){
                        //Se crea el arbol binario y luego se busca las palabras individualmente para luego producir oracion traducida
                        BinaryTree<Association> Arbol1=new BinaryTree<Association>(FE.get(0));
                        for (int n = 0; n < FE.size(); n++) {
                            if ((n+1) < FE.size()) {
                                BinaryTree<Association> Ne = new BinaryTree<>(FE.get(n+1));
                                BinaryTree.add(Arbol1,Ne);
                            }
                        }
                        String unn="";
                        for( int i=0;i<subdivision.size();i++){
                            String b=subdivision.get(i);
                            String Wr=Arbol1.buscar(b);
                            if(Wr==null){
                                unn=unn+"* "+b+" *";
                            }
                            else{
                                unn=unn+" * "+Wr+" * ";
                            }
                        }
                        System.out.print("\nLa oracion traducida es: "+unn);
                        subrun=false;
                    }if(h==2){
                        //Se crea el arbol binario y luego se busca las palabras individualmente para luego producir oracion traducida
                        BinaryTree<Association> Arbol1=new BinaryTree<Association>(FI.get(0));
                        for (int n = 0; n < FI.size(); n++) {
                            if ((n+1) < FI.size()) {
                                BinaryTree<Association> Ne = new BinaryTree<>(FI.get(n+1));
                                BinaryTree.add(Arbol1,Ne);
                            }
                        }
                        String unn="";
                        for( int i=0;i<subdivision.size();i++){
                            String b=subdivision.get(i);
                            String palabra=Arbol1.buscar(b);
                            if(palabra==null){
                                unn=unn+"* "+b+" *";
                            }
                            else{
                                unn=unn+" * "+palabra+" * ";
                            }
                        }
                        System.out.print("\nLa oracion traducida es: "+unn);
                        subrun=false;
                    }else{
                    }
                }

            }if(a==4){
                break;
            }else{
            }
        }
    }
}