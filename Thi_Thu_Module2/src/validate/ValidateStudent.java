package validate;

import models.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidateStudent {
    Scanner scanner = new Scanner(System.in);

    public int getIndexId(int id, ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                //id này trùng với id trong mảng thì return ra vị trí của i đó.
                return i;
            }

        }
        //id này không nằm trong mảng nên return ra -1.
        return -1;

    }

    public int validateId(ArrayList<Student> students) {
        while (true) {
            try {
                System.out.println("Nhập id");
                int id = Integer.parseInt(scanner.nextLine());
                if (getIndexId(id, students) != -1) {
                    throw new Exception();
                }
                return id;
            } catch (Exception e) {
                System.err.println("Nhập sai mã sinh viên, xin mời nhập lại! ");
            }
        }
    }

    public String validateString(String name) {
        while (true) {
            System.out.println("Nhập " + name);
            String str = scanner.nextLine();
            if ((str.equals(""))) {
                System.err.println("Không để trống! ");
                continue;
            } else {
                return str;
            }
        }
    }

    public int validateAge() {
        while (true){
            try {
                System.out.println("Nhập tuổi: ");
                int age = Integer.parseInt(scanner.nextLine());
                return age;
            }catch (Exception e) {
                System.err.println("Nhập sai tuổi, mời nhập lại! ");
            }
        }
    }

    public double validateScore() {
        while (true) {
            try{
                System.out.println("Nhập điểm trung bình: ");
                double score = Integer.parseInt(scanner.nextLine());
                return score;
            }catch (Exception e){
                System.err.println("Nhập điểm trung bình, mời nhập lại! ");
            }
        }
    }
}
