
public class Main {

    public static void main(String[] args) {

        System.out.println("");

        ArrayDictionary dic = new ArrayDictionary(5);
        dic.add(1, 10);
        dic.add(11, 20);
        dic.add(21, 30);
        dic.add(31, 40);

        dic.add(32, 33);

        boolean b;

        System.out.println(dic);

        dic.remove(0);
        System.out.println(dic);
        dic.remove(12);
        System.out.println(dic);
        
        dic.remove(31);
        System.out.println(dic);
        System.out.println();

    }

}
