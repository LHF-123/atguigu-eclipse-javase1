package com.atguigu.day26;

/*
 * 	单例设计模式（重点）
 * 
 * 	单例：唯一的实例，在整个Java系统中，某个类的对象只有唯一的一个。
 * 
 * 	形式：
 * 	1、饿（恶）汉式
 * 		无论使用者是否要用这个对象，都先创建这个对象。
 * 	2、懒汉式
 * 		只有在使用者来获取这个对象时，才会创建这个对象。
 * 
 * 	无论哪一种单例设计模式的写法：
 * 	（1）这个类的构造器是私有化		-->保证我们的使用者不能随意的创建第二个对象....
 * 	（2）这个唯一的实例必须在本类中创建，并且要用一个静态的变量来存储
 * 
 * 	一、饿汉式
 * 
 */
public class TestSingleton {

}
