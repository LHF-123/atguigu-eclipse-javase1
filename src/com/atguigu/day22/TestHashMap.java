package com.atguigu.day22;

import java.util.HashMap;

import org.junit.Test;

/*
 * JDK 1.8的HashMap：底层实现（数组+链表/红黑树）
 * 
 * 	1、为什么要从JDK 1.8之前的链表设计，修改为链表或红黑树的设计？
 * 	当某个链表比较长的时候查找效率还是会降低。
 * 	为了提高查询速率，那么把table[index]下面的链表做调整。
 * 	如果table[index]的链表的节点的个数比较少，（8个或以内），就保持链表。如果超过8个，那么就要考虑吧链表转为一棵红黑树
 * 	TREEIFY_THRESHOLD：树化阈值，从链表转为红黑树的临界值。
 * 
 * 	2、什么时候树化？
 * 	table[index]下的结点数一达到8个就树化吗？
 * 	如果table[index]的节点数量已经达到了8个了，还要判断table.length是否达到64，如果没有达到64，先扩容。
 * 	
 * 	演示：
 * 		8个-->9个 length从16-->32
 * 		9个-->10个 length从32-->64
 * 		10个-->11个 length已经达到了64，table[index]就从Node类型转为TreeNode类型，说明树化
 * 
 * 	MIN_TREEIFY_CAPACITY:最小树化容量64
 * 
 * 	3、什么时候从树-->链表
 * 	当你删除结点时，这棵树的节点少于6个，会反树化，变为链表
 * 	UNTREEIFY_THRESHOLD：6个
 * 
 * 	树的结构太复杂，当结点少了之后，用链表更好。
 * 
 * 	4、put的过程
 * 	（1）[index]的计算问题
 * 	第一步用key的hashCode值调用hash()函数，干扰hash值，使得(key, value)更加均匀的分布table数组中。
 * 		JDK 1.8中hash()算法更优。
 * 
 * 	第二步：hash值与table。length-1做&运算，保证index在[0, length-1]范围内
 * 
 * 	（2）扩容问题
 * 	第一种：当某个table[index]的链表的个数达到8个，并且table.length<64，那么会扩容
 * 	第二种：size >= table.length，并且table[index] ！=  null
 * 		threshold = table.length * loadFator（它的默认值DEFAULT_LOAD_FACTOR:0.75）
 * 
 * 	（3）当把(key, value)添加到链表中，JDK 1.8是在链表的尾部
 * 		成语：七上八下
 * 
 */
public class TestHashMap {
	
	@Test
	@SuppressWarnings("all")
	public void test1() {
		HashMap map = new HashMap();
		
		for (int i = 0; i < 20; i++) {
			map.put(new MyData(i), "xx" + i);
		}
		
	}
	
	@Test
	@SuppressWarnings("all")
	public void test2() {
		HashMap map = new HashMap();
		
		map.put("张三", "张三");
		map.put("李四", "李四");
		map.put("Aa", "Aa");
		map.put("BB", "BB");
		map.put("王五", "王五");
		
	}

}
class MyData{
	private int num;

	public MyData(int num) {
		super();
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "MyData [num=" + num + "]";
	}
	
	//特殊的设计
	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + num;
//		return result;
		return 1;//所有的MyData的对象，hashCode值都是1，这里故意这样，虽然不符合我们之前设计hashCode的元素
		//希望，以MyData对象为key的，都放在table[index]中
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyData other = (MyData) obj;
		if (num != other.num)
			return false;
		return true;
	}
	
	
	
}
