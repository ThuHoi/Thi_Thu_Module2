package io;

import models.Student;

import java.io.*;
import java.util.ArrayList;

public class ReadANdWriteFile {

    File file = new File("/Users/johntoan98gmail.com/Desktop/ThiThu/src/data/student.csv");

    public ArrayList<Student> readFile() {

        ArrayList<Student> students = new ArrayList<>();
        try {

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                int age = Integer.parseInt(arr[2]);
                String gender = arr[3];
                String address = arr[4];
                double avgScore = Double.parseDouble(arr[5]);

                students.add(new Student(id, name, age, gender, address, avgScore));

            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void writeFile(ArrayList<Student> students) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("id,name,gender,address,avgScore");
            bufferedWriter.newLine();

            for (Student s : students) {
                bufferedWriter.write(s.write());
                bufferedWriter.newLine();


            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
