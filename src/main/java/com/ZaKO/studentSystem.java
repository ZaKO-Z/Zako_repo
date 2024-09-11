package com.ZaKO;

import java.util.ArrayList;
import java.util.Scanner;

public class studentSystem {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        loop:while (true) {
            System.out.println("------------------欢迎来到学生管理系统------------------------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询学生");
            System.out.println("5.退出");
            System.out.println("请输入您的选择：");

            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1":
                    addStudent(list);
                    break;
                case "2":
                    deleteStudent(list);
                    break;
                case "3":
                    updateStudent(list);
                    break;
                case "4":
                    queryStudent(list);
                    break;
                case "5":
                    System.out.println("感谢您的使用，欢迎再次光临！");
                    break loop;
                default:
                    System.out.println("您的输入有误，请重新输入！");
                    break;
            }
        }
    }

    // 1.添加学生
    private static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        Student stu = new Student();


        String  id = null;
        while (true) {
            System.out.println("请输入学生id：");
            id = sc.next();
            boolean flag = contains(list,id);
            if(flag){
                System.out.println("该学生已存在，请重新输入！");
            }else {
                stu.setId(id);
                break;
            }
        }


        System.out.println("请输入学生姓名：");
        String name = sc.next();
        stu.setName(name);

        System.out.println("请输入学生年龄:");
        int age = sc.nextInt();
        stu.setAge(age);

        System.out.println("请输入学生家庭住址:");
        String address = sc.next();
        stu.setAddress(address);


        //将学生对象添加到集合中
        list.add(stu);
        System.out.println("添加学生成功！");

    }

    //2.删除学生
    private static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生id：");
        String id = sc.next();
        int index = getIndex(list,id);
        if(index == -1){
            System.out.println("该学生不存在，请重新录入");
        }else {
            list.remove(index);
            System.out.println("删除学生成功。");
        }
    }

    //3. 修改学生
    private static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生id：");
        String id = sc.next();
        int index = getIndex(list,id);
        if(index == -1){
            System.out.println("该学生不存在。");
            return;
        }else {
            Student stu = list.get(index);
            System.out.println("请输入学生姓名：");
            String name = sc.next();
            stu.setName(name);
            System.out.println("请输入学生年龄：");
            int age = sc.nextInt();
            stu.setAge(age);
            System.out.println("请输入学生家庭住址：");
            String address = sc.next();
            stu.setAddress(address);
            System.out.println("修改学生成功。");
        }
    }

    //4. 查询学生
    private static void queryStudent(ArrayList<Student> list) {
        if(list.isEmpty()){
            System.out.println("无当前学生信息，请添加后重试");
            return;
        }

        System.out.println("id\t\t姓名\t\t年龄\t家庭住址");

        for (int i = 0; i < list.size(); i++) {
            Student stu  = list.get(i);
            System.out.println(stu.getId() +  "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getAddress());
        }
    }
    // 5. 退出

    //查询id是否存在
    public static boolean contains (ArrayList<Student> list, String id){
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if(stu.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    //根据id获取索引
    public static int getIndex(ArrayList<Student> list,String id) {
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (stu.getId().equals(id)) {
                return i;
            }

        }
        return -1;
    }

}
