package com.Manage;

import java.util.ArrayList;
import java.util.Scanner;

public class studentM {
    //主方法
    public static void main(String[] args) {

        //创建总集合：
        ArrayList<student> array = new ArrayList<>();
        while (true) {
            System.out.println("------欢迎使用学生管理系统------");
            System.out.println("\t1.添加学生\n\t2.删除学生\n\t3." +
                    "修改学生\n\t4.查看所有学生\n\t5.退出系统");
            System.out.println("请输入您的的选择：");

            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            switch (line) {
                case "1":
                    //System.out.println("添加学生");
                    AddStudent(array);
                    break;
                case "2":
                    //System.out.println("删除学生");
                    RemoveStudent(array);
                    break;
                case "3":
                    //System.out.println("修改学生");
                    ReviseStudent(array);
                    break;
                case "4":
                    //System.out.println("查看所有学生");
                    FindStudent(array);
                    break;
                case "5":
                    System.out.println("退出系统");
                    System.exit(5);
                default:
                    System.out.println("输入错误！请重新输入");
            }
        }
    }
    //添加
    public static void AddStudent(ArrayList<student> array) {
        Scanner sc = new Scanner(System.in);

        //创建学生对象：
        student s1 = new student();
        //键盘录入数据： //录入数据赋给学生成员变量：
        System.out.println("请输入要添加的学生信息：");
        while(true) {
            System.out.println("请输入学生学号：");
            s1.setId(sc.nextLine());
            //判断学号是否已经被使用：（第一种：需要重新输入）
            int flag =0;
            for(int i=0;i<array.size();i++) {
               student s = array.get(i);
               if(s1.getId().equals(s.getId())){
                   System.out.println("此学号已存在，请检查后输入:");
                   flag = 1;
               }
            }
            //没有被使用，退出循环
            if(flag == 0){
                break;
            }
        }
//        //判断学号是否已经被使用：（第二种：不重新输入，直接退出）
//        int flag = 0;
//        for(int i=0;i<array.size();i++) {
//            student s = array.get(i);
//            if (s1.getId().equals(s.getId())) {
//                System.out.println("此学号已存在，请检查后输入！");
//                flag = 1;
//                return;
//            }
//        }
        System.out.println("请输入学生姓名：");
        s1.setName(sc.nextLine());
        System.out.println("请输入学生年龄：");
        s1.setAge(sc.nextLine());
        System.out.println("请输入所在班级：");
        s1.setCla(sc.nextLine());

        //创建学生集合：
        // ArrayList<student> array = new ArrayList<>();
        //把学生对象添加到集合中：
        //if(flag == 0) {
            array.add(s1);
            System.out.println("添加成功！");
        //}
    }
    //查看
    public static void FindStudent(ArrayList<student> array) {
        //判断集合中是否有数据
        if(array.size()==0){
            System.out.println("无信息！请添加数据后看查询！");
            return;
        }
        //显示表头：
        System.out.println("学号" + "\t\t姓名" + "\t\t年龄" + "\t\t班级");
        //显示学生信息：
        for (int i = 0; i < array.size(); i++) {
            student s = array.get(i);
            System.out.println(s.getId() + "\t" + s.getName() + "\t\t" + s.getAge() + "岁" + "\t" + s.getCla());
        }
    }
    //删除
    public static void RemoveStudent(ArrayList<student> array) {
        Scanner sc = new Scanner(System.in);
        //提示删除信息：
        System.out.println("请输入您要删除的学生学号：");
        String a = sc.nextLine();
        //判断学号是否存在：
        //遍历并逐个删除：
        int flag = 0;
        for (int i = 0; i < array.size(); i++) {
            student s = array.get(i);
            if (s.getId().equals(a)) {
                array.remove(i);
                System.out.println("删除成功！");
                flag= 1;
                break;
            }
        }
        //提高：删除失败给出提示信息（”您输入的学号有误！“）
        if (flag == 0) {
            System.out.println("删除失败！你输入的学号有误！");
        }
    }
    //修改
    public static void ReviseStudent(ArrayList<student> array) {
        Scanner sc = new Scanner(System.in);
        //显示修改提示：
        System.out.println("请输入您要修改的学生学号");
        String a = sc.nextLine();
        //遍历学生信息：
        int flag =0;
        for (int i = 0; i < array.size(); i++) {
            student s = array.get(i);
            //判断学号是否存在
            if (s.getId().equals(a)) {
                //修改第i个学生的信息
                System.out.println("请输入新学号：");
                s.setId(sc.nextLine());
                System.out.println("请输入新姓名：");
                s.setName(sc.nextLine());
                System.out.println("请输入新年龄：");
                s.setAge(sc.nextLine());
                System.out.println("请输入新班级：");
                s.setCla(sc.nextLine());
                //把新信息加入集合：
                //array.set(i, s);
                System.out.println("修改成功！");
                flag = 1;
                break;
            }
        }
        //提高：提示修改失败（”您输入的学号有误！“）
        if (flag == 0) {
            System.out.println("修改失败！您输入的学号有误！");
        }
    }
}