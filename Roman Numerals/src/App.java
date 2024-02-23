public class App {
    public static void main(String[] args) {
        int numero = 2449;

        String romano = convert(numero);

        System.out.println("Romano: " + romano);
    }

    public static String convert(int numero) {
        int[] numeros = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int index = 0;

        if(numero <= 0) {
            return "";
        }
        
        while (numeros[index] > numero) {
            // System.out.println("DEBUG : " + "numero=" + numero + " numeros["+index+"]="+numeros[index] + " simbolos["+index+"]="+simbolos[index]);
            index++;
        }
        
        return simbolos[index] + convert(numero - numeros[index]);
    }

    
}
