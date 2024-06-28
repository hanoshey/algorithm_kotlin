class Person {
    void study() {
        System.out.print("인생공부");
    }
}

class Student extends Person {
    void study(String sub) {
        System.out.print(sub + "공부/");
    }
}

class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.study("수학");
        s.study();
    }
}
