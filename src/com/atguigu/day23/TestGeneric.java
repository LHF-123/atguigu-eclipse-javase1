package com.atguigu.day23;

/*
 * 	一、泛型的概念：参数化的类型
 * 	泛型形参：T, E, U, K, V, R...
 * 	泛型实参：必须是引用数据类型，不能是基本数据类型
 * 	
 * 	二、泛型的形式有两种：
 * 	1、泛型类，泛型接口：
 * 	【修饰符】 class/interface 类型名<泛型形参列表 【extends 上限】>{
 * 	}
 * 
 * 	什么时候指定泛型实参？（1）创建实例对象（2）继承该类或实现该接口也可以指定
 * 	泛型类或泛型接口上的泛型形参是不能用于“静态成员”上的。
 * 
 * 	2、泛型方法
 * 	【修饰符】 <泛型形参列表 【extends 上限】>  返回值类型  方法名(【形参列表】) 【throws 异常列表】{
 * 	}
 * 
 * 	什么时候确定泛型形参的实际类型？调用该方法时。
 * 
 * 	三、通配符
 * 	1、<?> ：代表任意类型
 * 	2、<? extends 上限>
 * 	3、<? super 下限>
 * 	通配符只能用于方法的(形参列表)或局部变量类型
 * 	
 */
public class TestGeneric {

}
