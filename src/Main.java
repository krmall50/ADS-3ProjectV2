//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Krmall 50!");
        MyHashTable table = new MyHashTable();
        table.put(100, "Anya");
        table.put(123, "Loid");
        table.put(321, "Yor");
        System.out.println(table.get(100));
        System.out.println(table.get(321));
    }
}