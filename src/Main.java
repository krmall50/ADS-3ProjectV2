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
        System.out.println(table.getKey("Yor"));
        table.put(666, "Yuri");
        System.out.println(table.get(666));
        table.remove(666);
        System.out.println(table.get(666));
        System.out.println(table.contains("Yuri"));
        System.out.println("--------------------------------------");

        MyHashTable<MyTestingClass, Student> table1 = new MyHashTable<>();
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(i);
            Student value = new Student(i, "name" + i + "th");
            table1.put(key, value);
        }

        for(int i = 0; i < 11; i++){
            int count = 0;
            HashNode<MyTestingClass, Student> current = table1.chainArray[i];
            while(current != null){
                count++;
                current = current.next;
            }
            System.out.println("bucket " + i + ": " + count + " elements");
        }
    }
}