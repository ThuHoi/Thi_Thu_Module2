package controllers;

import comparator.SortByScoreDown;
import comparator.SortByScoreUp;
import io.ReadANdWriteFile;
import models.Student;
import validate.ValidateStudent;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerStudent {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();
    ValidateStudent validateStudent = new ValidateStudent();
    ReadANdWriteFile readANdWriteFile = new ReadANdWriteFile();

    public void menu() {
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN----");
        System.out.println("Chọn chức năng theo số (để tiếp tục) ");
        System.out.println("1. Hiển thị danh sách sinh viên");
        System.out.println("2. Thêm sinh viên mới");
        System.out.println("3. Chỉnh sửa thông tin sinh viên");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Đọc file");
        System.out.println("7. Ghi file");
        System.out.println("8.Thoát");
        System.out.println("Chọn chức năng：");
        int choice1 = Integer.parseInt(scanner.nextLine());
        switch (choice1) {
            case 1:
                show();
                break;
            case 2:
                addStudent(creatStudent());
                break;
            case 3:
                editStudent();
                break;
            case 4:
                deleteStudent();
                break;
            case 5:
                sortByScore();
                break;
            case 6:
                students = readANdWriteFile.readFile();
                System.out.println("Đọc file thành công! ");
            case 7:
                readANdWriteFile.writeFile(students);
                System.out.println("Ghi file thành công! ");
            case 8:
                System.exit(0);
        }
    }

    public void show() {
        for (int i = 0; i < students.size(); i++) {
            if (i + 1 % 5 == 0) {
                scanner.nextLine();
            } else {
                System.out.println(students.get(i));
            }

        }
    }

    public Student creatStudent() {
        int id = validateStudent.validateId(students);
        String name = validateStudent.validateString("name: ");
        int age = validateStudent.validateAge();
        String gender = validateStudent.validateString("gender: ");
        String address = validateStudent.validateString("address: ");
        double avgScore = validateStudent.validateScore();

        Student student = new Student(id, name, age, gender, address, avgScore);
        return student;

    }

    public void addStudent(Student student) {

        students.add(student);
    }

    public void editStudent() {
        System.out.println("Nhập Id cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = validateStudent.getIndexId(id, students);
        if (index != -1) {
            students.set(index, creatStudent());
        } else {
            System.err.println("Id không tồn tại! ");
        }
    }

    public void deleteStudent() {
        System.out.println("Nhập Id cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = validateStudent.getIndexId(id, students);

        if (index != -1) {
            System.out.println("Nhập xác nhận: ");
            System.out.println("Y: Xóa");
            System.out.println("Ký tự khác：Thoát ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y" + "")) {
                students.remove(index);
                System.out.println("Xóa thành công! ");
            }
        } else {
            System.out.println("Id không tồn tại! ");
        }
    }

    public void sortByScore() {
        System.out.println("---- Sắp xếp sinh viên theo điểm trung bình ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Sắp xếp điểm trung bình tăng dần");
        System.out.println("2. Sắp xếp điểm trung bình giảm dần");
        System.out.println("Thoát");
        System.out.println("Chọn chức năng: ");
        int choice2 = Integer.parseInt(scanner.nextLine());
        switch (choice2) {
            case 1:
                students.sort(new SortByScoreUp());
                System.out.println("Sắp xếp tăng dần thành công! ");
                break;
            case 2:
                students.sort(new SortByScoreDown());
                System.out.println("Sắp xếp giảm dần thành công! ");
                break;
            case 3:
                System.exit(0);
        }
    }


}
