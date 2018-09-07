package vectores;

public class Vectores {

    public static void main(String[] args) {
        int [] a = new int[20];
        char [] c = new char[2]; // '\0'
        String [] nombres = new String[5];
        System.out.println("a: " + a.length);
        System.out.println("c: " + c.length);
        for(int i=0; i<nombres.length; i++)
        {
            nombres[i]="Leonardo Hurtado ";
        }
        
        a[0] = 1;
        a[2] = 3;
        
        System.out.printf("a: ");
        for (int i=0; i<a.length; i++)
        {
            System.out.printf("%d ",a[i]);
        }
        System.out.println();
        
        try {
            c[0] = 'A';
            System.out.printf("c: ");
            for (int i=0; i<c.length; i++)
            {
                System.out.printf("%c " ,c[i]);
            }
            System.out.println();
        } catch (ArrayIndexOutOfBoundsException ex)
        {
            System.err.println("Aiuda");
        }
        
        
        System.out.print("nombres: ");
        for(String nombre : nombres)
        {
            System.out.printf("%s ",nombre);
        }
        System.out.println();
    }
}
