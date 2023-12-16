package IQns;

public class InheritanceQuestion {

    public static class Parent {
        int a;

        public Parent() {
            a = 10;
        }

        public void display()
        {
            System.out.println(a);
        }
    }

    public static class Child extends Parent{
        int a;

        public Child()
        {
            this.a = 5;
        }

        public void display()
        {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        Parent obj = new Child();
        obj.display();
        System.out.println(obj.a);

    }

}
