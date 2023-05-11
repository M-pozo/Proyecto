package Proyecto;

import java.io.*;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Problema {


    /*private static boolean validacion(String texto){
        String exReg = "[a-zA-Z]";
        Pattern pt = Pattern.compile(exReg);
        Matcher match = pt.matcher(texto);
    }*/

    private static int burbuja(int[] A) {
        int i, j, aux;
        for (i = 0; i < A.length - 1; i++) {
            for (j = 0; j < A.length - i - 1; j++) {
                if (A[j + 1] < A[j]) {
                    aux = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
        }
        return i;
    }

    private static Integer sacarEnter( String texto, String clave){
        int[] arrayInteger = new int[26];
        for (int i = 0; i < 26; i++) {
            arrayInteger[i] = i;
        }
        String[] arrayString = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        Map<Integer, String> cript = new HashMap<>();
        for (int i = 0; i < arrayString.length; i++) {
            cript.put(arrayInteger[i], arrayString[i].toUpperCase(Locale.ROOT));
        }

        int[] burbujaTexto = new int[texto.length()];
        int[] burbujaValor = new int[texto.length()];
        for (int i = 0; i < texto.length(); i++) {
            texto.toUpperCase(Locale.ROOT);
            burbujaTexto[i] = texto.charAt(i);
            burbujaValor[i] = texto.charAt(i);
        }
        return burbuja(burbujaTexto) + burbuja(burbujaValor);
    }

    public static void main(String[] args) {


        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader("mensaje.txt"));
            bw = new BufferedWriter(new FileWriter("mensaje_cifrado.txt"));

            String linea = null;

            Scanner sc = new Scanner(System.in);
            String clave = "";
            do {
                System.out.println("Clave: ");
                clave = sc.nextLine();
            } while(clave.length() > 12);


            while ((linea = br.readLine()) != null) {
                StringBuilder sb = new StringBuilder(linea.length());
                Map<Integer, String> cript = new HashMap<>();
                String r = br.readLine();
                sacarEnter( r, clave);



                bw.write(sacarEnter( r, clave)); /* Escribe la cadena de caracteres en el fichero*/
                bw.newLine(); /* escribe nueva línea en el fichero */

            }
            System.out.println("El mensaje ha sido cifrado correctamente");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

}


