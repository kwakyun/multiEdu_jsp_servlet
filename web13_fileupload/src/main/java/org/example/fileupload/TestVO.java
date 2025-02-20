package org.example.fileupload;

public class TestVO {
    private int num;
    private String name;
    private int age;
    private String imgName;

    public TestVO() {
    }

    public TestVO(int num, String name, int age, String imgName) {
        this.num = num;
        this.name = name;
        this.age = age;
        this.imgName = imgName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    @Override
    public String toString() {
        return "TestVO{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", imgName='" + imgName + '\'' +
                '}';
    }
}
